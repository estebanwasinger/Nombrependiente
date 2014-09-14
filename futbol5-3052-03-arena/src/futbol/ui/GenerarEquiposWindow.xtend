package futbol.ui

import futbol5.Partido
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner

import java.util.List
import materias.applicationModel.SeguidorCarrera
import materias.domain.Materia
import materias.domain.Nota
import materias.home.HomeMaterias
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable
import futbol5.Jugador

@Observable
class GenerarEquiposWindow extends SimpleWindow<Partido> {
	
	new(WindowOwner parent, Partido model) {
		super(parent, model)
	}
	
	new(RunnableTest parent) {
		super(parent, new Partido)
	}
	
	override protected addActions(Panel actionPanel) {
		actionPanel.layout = new HorizontalLayout
		new Button(actionPanel)
			.setCaption("Cancelar")
			
		new Button(actionPanel)
			.setCaption("Aceptar")
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Generar Equipo"

		/* Creacion panel GENERAR EQUIPOS */
		mainPanel.layout = new VerticalLayout
		val botoneraSuperior = new Panel(mainPanel)
		botoneraSuperior.layout = new HorizontalLayout
		val panelListaJugadores = new Panel(mainPanel)
		panelListaJugadores.layout = new ColumnLayout(2)
		val selector1 = new Panel(botoneraSuperior)
		selector1.layout = new VerticalLayout
		val selector2 = new Panel(botoneraSuperior)
		selector2.layout = new VerticalLayout
		val selector3 = new Panel(botoneraSuperior)
		selector3.layout = new VerticalLayout
		
		new Label(selector1).text = "Criterio de Selección"
		val selectorOrdenamiento = new Selector(selector1)=>[width = 200
			title ="Generar equipos tentativos"
		]
		
		new Label(selector2).text = "Criterio de Ordenamiento"
		val selectorOrdenamiento2 = new Selector(selector2).width = 200
		
		new Label(selector3).text = " "
		val botonGenerar = new Button(selector3) => [
			width = 200
			caption = "Generar Equipos"
		]
		
		createListaJugadores(panelListaJugadores)
	}
	
	
	def void createListaJugadores(Panel panelJugadores){
		var table = new Table<Jugador>(panelJugadores, typeof(Jugador))
		table.heigth = 200
		table.width = 450
		new Column<Jugador>(table) //
			.setTitle("Nombre")
			.setFixedSize(150)
		//	.bindContentsToProperty("nombre")
		new Column<Jugador>(table) //
			.setTitle("Nombre")
			.setFixedSize(150)
		//	.bindContentsToProperty("nombre")
	}
}
