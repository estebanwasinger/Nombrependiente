package futbol5.ui

import futbol5.Partido
import futbol5.applicationModel.Futbol5
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.MainWindow
import org.uqbar.commons.utils.Observable

@Observable
class VistaPrincipal extends MainWindow<Futbol5> {
	
	new(Futbol5 model) {
		super(model)
	}
	
	override createContents(Panel mainPanel) {
	mainPanel.layout = new ColumnLayout(2)
	val Panel panelIzq = new Panel(mainPanel).layout = new VerticalLayout
	val Panel panelDer = new Panel(mainPanel).layout = new VerticalLayout
	val Label titulo = new Label(panelIzq).text = "Futbol 5"
	var Label ultimosPartidos = new Label(panelIzq).text = "Ultimos Partidos"
	var Table listaPartidos = new Table<Partido>(panelIzq, typeof(Partido))
			
	}
}