package futbol5.ui

import futbol5.domain.Jugador
import futbol5.domain.Partido
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.utils.Observable

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
		new Button(actionPanel).setCaption("Cancelar")

		new Button(actionPanel).setCaption("Aceptar")
	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Generar Equipo"

		/* Creacion panel GENERAR EQUIPOS */
		mainPanel.layout = new VerticalLayout
		val botoneraSuperior = new Panel(mainPanel)
		botoneraSuperior.layout = new HorizontalLayout
		val panelListaJugadores = new Panel(mainPanel)
		panelListaJugadores.layout = new ColumnLayout(3)
		val selector1 = new Panel(botoneraSuperior)
		selector1.layout = new VerticalLayout
		val selector2 = new Panel(botoneraSuperior)
		selector2.layout = new VerticalLayout
		val selector3 = new Panel(botoneraSuperior)
		selector3.layout = new VerticalLayout

		new Label(selector1).text = "Criterio de Selección"
		val selectorOrdenamiento = new Selector(selector1) => [
			width = 200
			title = "Generar equipos tentativos"
		]

		new Label(selector2).text = "Criterio de Ordenamiento"
		val selectorOrdenamiento2 = new Selector(selector2).width = 200

		//new Label(selector3).text = " "
		val botonGenerar = new Button(selector3) => [
			width = 200
			heigth = 45
			caption = "Generar Equipos"
		]

		createListaJugadores(panelListaJugadores)
	}

	def void createListaJugadores(Panel panelJugadores) {

		var labelJugadores = new Label(panelJugadores) => [
			text = "Jugadores"
			fontSize = 20
		]

		var labelEquipo1 = new Label(panelJugadores) => [
			text = "Equipo A"
			fontSize = 20
		]

		var labelEquipo2 = new Label(panelJugadores) => [
			text = "Equipo B"
			fontSize = 20
		]

		var table3 = new Table<Jugador>(panelJugadores, typeof(Jugador))
		table3.heigth = 200
		table3.width = 285
		table3.bindItemsToProperty("jugadores")
		new Column<Jugador>(table3) //
		.setTitle("Nombre").bindContentsToProperty("nombre")

		var table = new Table<Jugador>(panelJugadores, typeof(Jugador))
		table.heigth = 200
		table.width = 285
		table.bindItemsToProperty("equipoA")
		new Column<Jugador>(table) //
		.setTitle("Nombre").bindContentsToProperty("nombre")

		var table2 = new Table<Jugador>(panelJugadores, typeof(Jugador))
		table2.heigth = 200
		table2.width = 285
		table.bindItemsToProperty("equipoB")
		new Column<Jugador>(table2) //
		.setTitle("Nombre").bindContentsToProperty("nombre")
	}
}
