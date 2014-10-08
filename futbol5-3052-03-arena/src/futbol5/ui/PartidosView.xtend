package futbol5.ui

import futbol5.applicationModel.BusquedaJugadoresAppModel
import futbol5.applicationModel.PartidosAppModel
import futbol5.domain.Partido
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.utils.Observable
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.MainWindow

@Observable
class PartidosView extends SimpleWindow<PartidosAppModel> {

	new(WindowOwner parent) {
		super(parent, new PartidosAppModel)
		//modelObject.search()
	}

	override protected addActions(Panel panel) {
		panel.layout = new HorizontalLayout
		var generar = new Button(panel).setCaption("Generar Equipo").onClick[|this.generarEquipo]
		new Button(panel).setCaption("Buscar Jugador").onClick[|this.buscarJugador]

		var elementSelected = new NotNullObservable("partidoSeleccionado")
		generar.bindEnabled(elementSelected)

	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Organizador de Futbol5"
		mainPanel.layout = new VerticalLayout
		new Label(mainPanel) => [
			text = "Futbol 5"
			fontSize = 20
			]
		new Label(mainPanel).text = "Ultimos Partidos"
		new Table<Partido>(mainPanel, typeof(Partido)) => [
			heigth = 200
			bindItemsToProperty("partidos")
			bindValueToProperty("partidoSeleccionado")
			new Column<Partido>(it).setTitle("Localidad").bindContentsToProperty("localidad")
		]
	}

	def void generarEquipo() {
		this.openWindow(new GenerarEquiposWindow(this, modelObject.partidoSeleccionado))
	}

	def openWindow(SimpleWindow<?> ventana) {
		//dialog.onAccept[|modelObject.searchPartido]
		ventana.open
	}

	def void buscarJugador() {
		this.openWindow(new BusquedaJugadoresWindow(this, new BusquedaJugadoresAppModel))
	}

}
