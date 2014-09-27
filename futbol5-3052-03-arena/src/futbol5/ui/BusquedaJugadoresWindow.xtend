package futbol5.ui

import futbol5.applicationModel.BusquedaJugadoresAppModel
import futbol5.auxUtils.DateTextFilter
import futbol5.domain.Jugador
import org.uqbar.arena.bindings.DateAdapter
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.utils.Observable
import java.awt.Color

@Observable
class BusquedaJugadoresWindow extends Dialog<BusquedaJugadoresAppModel>{
		
	new(WindowOwner parent, BusquedaJugadoresAppModel modelObject) {
		super(parent, modelObject)
	}
		
	override createContents(Panel mainPanel) {		
		title = "Busqueda de Jugadores"
		new Panel(mainPanel).setLayout(new ColumnLayout(2))
		
		var panelIzquierda = new Panel(mainPanel)
		var panelDerecha = new Panel(mainPanel)
		
		new Label(panelIzquierda) => [
			text = "Busqueda" 
			fontSize = 25
			setForeground(Color.MAGENTA)]
			
		new Label (panelIzquierda).text = "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_" 
		
		new Label(panelDerecha) => [
			text = "Resultados" 
			fontSize = 25
			setForeground(Color.RED)]
		
		addActions(mainPanel) 
		createFormPanel(panelIzquierda)
		grillaBasicaJugadores(panelDerecha)
	}
	
	override protected addActions(Panel actionPanel) {
		actionPanel.layout = new HorizontalLayout
		new Button(actionPanel) => [
			setCaption("Regresar")
			onClick[|this.close]
			setFontSize(11)]
	}	
	
	override void createFormPanel(Panel panelIzquierda) {
		title = "Busqueda Jugador"
	
		var panelBusqueda = new Panel(panelIzquierda).setLayout(new ColumnLayout(2))
		var izquierda = new Panel(panelBusqueda) 
		var derecha = new Panel(panelBusqueda)

		// Por nombre “comienza con” 
		new Label(izquierda) => [
			text = "Nombre comienza con.."
			fontSize = 10
			setForeground(Color.DARK_GRAY)] 
		
		new TextBox(derecha)=>[
			bindValueToProperty("jugadorEjemplo.nombre")
			width = 200]
			
		new Label (panelIzquierda).text = "_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_" 
		
		//Por apodo “contiene” //	
		new Label(izquierda) =>[
			text = "Apodo contiene..."
			fontSize = 10
			setForeground(Color.DARK_GRAY)]

		new TextBox(derecha) =>[
			bindValueToProperty("jugadorEjemplo.apodo")
			width = 200]	
			
		// Búsqueda por fecha de nacimiento “anterior a” //
		new Label(izquierda) => [
			text = "Fecha de nacimiento menor a:" 
			fontSize = 10
			setForeground(Color.DARK_GRAY)]
		
		 new TextBox(derecha).withFilter(new DateTextFilter).bindValueToProperty("jugadorEjemplo.fechaNacimiento")
		 .setTransformer(new DateAdapter)
			
		//Por rango desde/hasta del hándicap (puede ingresarse sólo desde, o sólo hasta) //		
		new Label(izquierda) =>[
			setText = "Handicap desde:" 	
			fontSize = 10
			setForeground(Color.DARK_GRAY) ]
			
		new Label(derecha) =>[
			text = "Handicap hasta:" 
			fontSize = 10
			setForeground(Color.DARK_GRAY) ]
		
		new TextBox(izquierda)=>[
			bindValueToProperty("modelo.handicapDesde")
			width = 100]	
		
		new TextBox(derecha)=>[
			bindValueToProperty("modelo.handicapHasta")
			width = 100]	
		
		//Por rango desde/hasta del promedio de último partido //		
		new Label(izquierda) =>[
			text = "Promedio desde:" 	
			fontSize = 10	
			setForeground(Color.DARK_GRAY) ]
		
		new Label(derecha) =>[
			text = "Promedio hasta:" 
			fontSize = 10
			setForeground(Color.DARK_GRAY) ]
		
		new TextBox(izquierda)=>[
			bindValueToProperty("modelo.promedioDesde")
			width = 100]	
		
		new TextBox(derecha)=>[
			bindValueToProperty("modelo.promedioHasta")
			width = 100]			

		//Filtrar sólo los que tuvieron infracciones, sólo los que no tuvieron infracciones, todos //
		new Label(izquierda) => [
		text = "Infracciones" 
		fontSize = 10
		setForeground(Color.DARK_GRAY) ]

		new Selector(derecha) =>[
			bindItems(new ObservableProperty(this, "eligeInfracciones"))
			bindValueToProperty("modelo.infracciones")
		]
			
		new Button(panelBusqueda) => [
			setCaption("Buscar")
			onClick [ | modelObject.search() ]
			setFontSize(12)
			setWidth = 200]		
			
		new Button(panelBusqueda)  =>[
			setCaption("Limpiar")
			onClick [ | modelObject.clear ]
			setFontSize(12)
			setWidth = 200]		
	}
			
	def crearTextBox(Panel searchFormPanel, String label, String binding) {
		new Label(searchFormPanel).text = label
		new TextBox(searchFormPanel).bindValueToProperty(binding)
	}
	
	def void grillaBasicaJugadores(Panel panelResultados){
		var grilla = new Table<Jugador>(panelResultados, typeof(Jugador)) =>[
			heigth = 220
			width = 590
			bindValueToProperty("jugadorSeleccionado")
			bindItemsToProperty("jugadores")]
		
		new Column<Jugador>(grilla) =>[
			setTitle("Nombre")
			setFixedSize(150)
			bindContentsToProperty("nombre")]
		new Column<Jugador>(grilla) =>[
			setTitle("Apodo")
			setFixedSize(150)
			bindContentsToProperty("apodo")]
		new Column<Jugador>(grilla) =>[
			setTitle("Handicap")
			setFixedSize(150)
			bindContentsToProperty("nivelDeJuego")]
		new Column<Jugador>(grilla) =>[
			setTitle("Promedio")
			setFixedSize(150)
			bindContentsToProperty("promedio")]
		
		new Button(panelResultados) =>[
			setCaption("Ver Datos Completos")
			onClick [ | this.grillaCompletaJugador] 
			setAsDefault
			disableOnError
			setFontSize(14)
			setWidth = 200
			bindEnabled( new NotNullObservable("jugadorSeleccionado"))]
	}
	
	def openDialog(Dialog<?> dialog) {
		dialog.onAccept[|]
		dialog.open
	}
	
	 def void grillaCompletaJugador(){
		this.openDialog(new VerDatosJugadorWindow(this, modelObject.jugadorSeleccionado))
	}

	def getEligeInfracciones() {
			#["Con Infracciones","Sin Infracciones","Todos"]
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
