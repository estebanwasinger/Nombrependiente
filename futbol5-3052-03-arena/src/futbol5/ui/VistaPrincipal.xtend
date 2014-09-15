package futbol5.ui

import futbol5.domain.Partido
import futbol5.applicationModel.Futbol5
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.MainWindow
import org.uqbar.commons.utils.Observable
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button

@Observable
class VistaPrincipal extends SimpleWindow<Futbol5> {
	
	new(WindowOwner parent, Futbol5 model) {
		super(parent, model)
	}
	
	def ccreateContents(Panel mainPanel) {
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
	new Column<Partido>(tableListaPartidos).setTitle("Localidad").bindContentsToProperty("localidad")
			
	}
	
	override protected addActions(Panel panel) {
		panel.layout = new HorizontalLayout
		new Button(panel).setCaption("Generar Equipo")
		new Button(panel).setCaption("Buscar Jugador")
		
		}
	
	
	override protected createFormPanel(Panel arg0) {
		ccreateContents(arg0)
	}
	
}