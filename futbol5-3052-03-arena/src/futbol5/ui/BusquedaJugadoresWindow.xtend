package futbol5.ui

import com.uqbar.commons.StringUtils
import futbol5.applicationModel.BusquedaJugadoresAppModel
import futbol5.auxUtils.DateTextFilter
import futbol5.auxUtils.Grilla
import futbol5.domain.Jugador
import java.awt.Color
import java.util.List
import org.uqbar.arena.bindings.DateAdapter
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.RadioSelector
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.utils.Observable
import strategyHandicap.HandicapDesde
import strategyHandicap.HandicapHasta
import org.uqbar.arena.windows.SimpleWindow

@Observable
class BusquedaJugadoresWindow extends SimpleWindow<BusquedaJugadoresAppModel> {

	@Property Grilla grilla

	new(WindowOwner parent, BusquedaJugadoresAppModel modelObject) {
		super(parent, modelObject)
		//this.delegate.setErrorViewer(this)
		grilla = new Grilla
	}

	override createMainTemplate(Panel mainPanel) {
		title = "Busqueda de Jugadores"
		taskDescription ="Ingrese los parámetros de búsqueda"
		new Panel(mainPanel).setLayout(new ColumnLayout(2))

		var panelIzquierda = new Panel(mainPanel)
		var panelDerecha = new Panel(mainPanel)

		new Label(panelIzquierda) => [text = "Busqueda" fontSize = 25 setForeground(Color.MAGENTA)]

		new Label(panelIzquierda).text = "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_"

		new Label(panelDerecha) => [text = "Resultados" fontSize = 25 setForeground(Color.RED)]

		addActions(mainPanel)
		createFormPanel(panelIzquierda)
		grillaBasicaJugadores(panelDerecha, modelObject.jugadorSeleccionado, modelObject.jugadores)
	}

	override protected addActions(Panel actionPanel) {
		actionPanel.layout = new HorizontalLayout
		new Button(actionPanel) => [setCaption("Regresar") onClick[|this.close] setFontSize(11)]
	}

	def getHandicaps() {
		#[new HandicapHasta, new HandicapDesde]
	}

	override void createFormPanel(Panel panelIzquierda) {
		title = "Busqueda Jugador"

		var panelBusqueda = new Panel(panelIzquierda).setLayout(new ColumnLayout(2))

		// Por nombre “comienza con” 
		createLabel("Nombre comienza con:", panelBusqueda)
		createTextBoxForNames(panelBusqueda, "jugadorEjemplo.nombre")

		new Label(panelIzquierda).text = "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_"

		//Por apodo “contiene” //	
		createLabel("Apodo contiene:", panelBusqueda)
		createTextBoxForNames(panelBusqueda, "jugadorEjemplo.apodo")

		// Búsqueda por fecha de nacimiento “anterior a” //
		createLabel("Fecha de nacimiento menor a:", panelBusqueda)

		new TextBox(panelBusqueda) => [
			withFilter(new DateTextFilter)
			width = 250
			bindValueToProperty("jugadorEjemplo.fechaNacimiento").setTransformer(new DateAdapter)
		]

		//Por rango desde/hasta del hándicap (puede ingresarse sólo desde, o sólo hasta) //		
		new RadioSelector(panelBusqueda) => [
			bindItemsToProperty("handicaps")
			bindValueToProperty("metodoHandicap")
			allowNull(true)
		]
		createTextBoxForNumerics(panelBusqueda, "handicap");

		//Por rango desde/hasta del promedio de último partido //
		createLabel("Promedio desde:", panelBusqueda)
		createTextBoxForNumerics(panelBusqueda, "promedioDesde");

		createLabel("Promedio hasta:", panelBusqueda)
		createTextBoxForNumerics(panelBusqueda, "promedioHasta");

		//Filtrar sólo los que tuvieron infracciones, sólo los que no tuvieron infracciones, todos //
		createLabel("Infracciones:", panelBusqueda)

		new Selector(panelBusqueda) => [bindItems(new ObservableProperty(this, "eligeInfracciones"))
			bindValueToProperty("infracciones")]

		new Button(panelBusqueda) => [setCaption("Buscar")
			onClick [ |
				modelObject.search()
			] setFontSize(12) setWidth = 200 setAsDefault]

		new Button(panelBusqueda) => [setCaption("Limpiar") onClick [|modelObject.clear] setFontSize(12)
			setWidth = 200]
	}

	def createTextBoxForNumerics(Panel panel, String propertyName) {
		createTextBox(panel, propertyName) => [
			withFilter[event|StringUtils.isNumeric(event.potentialTextResult)]
		]
	}

	def createTextBoxForNames(Panel panel, String propertyName) {
		createTextBox(panel, propertyName) => [
			withFilter[event|StringUtils.isAlpha(event.potentialTextResult)]
		]
	}

	def createTextBox(Panel panel, String propertyName) {
		return new TextBox(panel) => [
			bindValueToProperty(propertyName)
			width = 250
		]
	}

	def void createLabel(String labelText, Panel panel) {
		new Label(panel) => [text = labelText fontSize = 13 setForeground(Color.DARK_GRAY)]
	}

	def void grillaBasicaJugadores(Panel panelResultados, Jugador jugadorSeleccionado, List<Jugador> jugadores) {

		grilla.generar(panelResultados, jugadorSeleccionado, jugadores, "jugadorSeleccionado", "jugadores")

		new Button(panelResultados) => [setCaption("Ver Datos Completos") onClick [|this.grillaCompletaJugador]
			setAsDefault disableOnError setFontSize(14) setWidth = 200
			bindEnabled(new NotNullObservable("jugadorSeleccionado"))]
	}

	def openDialog(Dialog<?> dialog) {
		dialog.onAccept[|]
		dialog.open
	}

	def void grillaCompletaJugador() {
		this.openDialog(new VerDatosJugadorWindow(this, modelObject.jugadorSeleccionado))
	}

	def getEligeInfracciones() {
		#["Con Infracciones", "Sin Infracciones", "Todos"]
	}
}

class DateBox extends TextBox {
	new(Panel container) {
		super(container)
	}

	override bindValueToProperty(String propertyName) {
		val binding = super.bindValueToProperty(propertyName)
		this.withFilter(new DateTextFilter)
		binding
	}
}
