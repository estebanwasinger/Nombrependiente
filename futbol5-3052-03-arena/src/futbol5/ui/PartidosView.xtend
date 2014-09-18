package futbol5.ui

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
import futbol5.applicationModel.Futbol5

@Observable
class PartidosView extends Dialog<PartidosAppModel> {

	new(WindowOwner parent, PartidosAppModel model) {
		super(parent, model)
	}

	override protected addActions(Panel panel) {
		panel.layout = new HorizontalLayout
		var generar = new Button(panel).setCaption("Generar Equipo").onClick[|this.generarEquipo]
		var buscar = new Button(panel).setCaption("Buscar Jugador").onClick[|this.buscarEquipo]

		var elementSelected = new NotNullObservable("partidoSeleccionado")
		generar.bindEnabled(elementSelected)

	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Organizador de Futbol5"
		mainPanel.layout = new VerticalLayout
		val Panel columnPanel = new Panel(mainPanel)
		columnPanel.layout = new ColumnLayout(2)
		val Panel panelIzq = new Panel(columnPanel).layout = new VerticalLayout
		new Panel(columnPanel).layout = new VerticalLayout
		new Label(panelIzq).text = "Futbol 5"
		new Label(panelIzq).text = "Ultimos Partidos"
		new Table<Partido>(panelIzq, typeof(Partido)) => [
			heigth = 200
			width = 285
			bindItemsToProperty("partidos")
			bindValueToProperty("partidoSeleccionado")
			new Column<Partido>(it).setTitle("Localidad").bindContentsToProperty("localidad")
		]
	}

	def void generarEquipo() {
		this.openDialog(new GenerarEquiposWindow(this, modelObject.partidoSeleccionado))
	}

	def openDialog(Dialog<?> dialog) {
		dialog.onAccept[|modelObject.searchPartido]
		dialog.open
	}

	def void buscarEquipo() {
		this.openDialog(new BusquedaJugadoresWindow(this, new Futbol5))
	}

}
