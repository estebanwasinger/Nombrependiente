package futbol5.ui

import futbol5.applicationModel.Futbol5
import futbol5.domain.Partido
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
import org.uqbar.arena.bindings.NotNullObservable

@Observable
class VistaPrincipal extends Dialog<Futbol5> {
	
	new(WindowOwner parent, Futbol5 model) {
		super(parent, model)
	}

	
	override protected addActions(Panel panel) {
		panel.layout = new HorizontalLayout
		var generar = new Button(panel)
			.setCaption("Generar Equipo")
			.onClick [ | this.generarEquipo]
		var buscar = new Button(panel)
			.setCaption("Buscar Jugador")
		
		//var elementSelected = new NotNullObservable("partido")
		//generar.bindEnabled(elementSelected)

		}
	
	
	override protected createFormPanel(Panel mainPanel) {
	mainPanel.layout = new VerticalLayout
	val Panel columnPanel = new Panel(mainPanel)
	columnPanel.layout = new ColumnLayout(2)
	val Panel panelIzq = new Panel(columnPanel).layout = new VerticalLayout
	val Panel panelDer = new Panel(columnPanel).layout = new VerticalLayout
	val Label titulo = new Label(panelIzq).text = "Futbol 5"
	var Label ultimosPartidos = new Label(panelIzq).text = "Ultimos Partidos"
	var Table tableListaPartidos = new Table<Partido>(panelIzq, typeof(Partido))
	tableListaPartidos.heigth = 200
	tableListaPartidos.width = 285
	tableListaPartidos.bindItemsToProperty("partidos")
	tableListaPartidos.bindValueToProperty("partido")
	new Column<Partido>(tableListaPartidos).setTitle("Localidad").bindContentsToProperty("localidad")
	}
	
	def void generarEquipo() {
		this.openDialog(new GenerarEquiposWindow(this, modelObject.partido))
	}

	def openDialog(Dialog<?> dialog) {
		dialog.onAccept[|modelObject.searchPartido]
		dialog.open
	}
}