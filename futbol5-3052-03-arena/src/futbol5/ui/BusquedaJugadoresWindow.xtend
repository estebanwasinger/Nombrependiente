package futbol5.ui

import futbol5.domain.Jugador
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner

class BusquedaJugadoresWindow extends SimpleWindow<Jugador>{
		new(WindowOwner parent,Jugador model) {
		super(parent, model)
	}
	
	new(RunnableTest parent) {
		super(parent, new Jugador)
	}
	
	override protected addActions(Panel actionPanel) {
		actionPanel.layout = new HorizontalLayout
		new Button(actionPanel)
			.setCaption("Cancelar")
			
		new Button(actionPanel)
			.setCaption("Aceptar")
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Busqueda Jugador"

		/* Creacion panel BUSCAR EQUIPO */
		mainPanel.layout = new VerticalLayout
		val busquedaSuperior = new Panel(mainPanel)
		busquedaSuperior.layout = new HorizontalLayout
		val panelListaJugadores = new Panel(mainPanel)
		panelListaJugadores.layout = new ColumnLayout(2)
		
		createMetodoBusqueda(busquedaSuperior)
		createListaJugadores(panelListaJugadores)
	}
	
	def void createMetodoBusqueda(Panel busquedaSuperior){
		val campoBusqueda = new TextBox(busquedaSuperior)=>[width = 200
			title ="Busqueda de Equipos"
		]
		val campoBusqueda2 = new TextBox(busquedaSuperior).width = 200
		val campoBusqueda3 = new TextBox(busquedaSuperior).width = 200
		val campoBusqueda4 = new TextBox(busquedaSuperior).width = 200
		val botonBuscar = new Button(busquedaSuperior) => [
			width = 200
			caption = "Buscar Jugadores"
		]
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
			.setTitle("Apodo")
			.setFixedSize(150)
		//	.bindContentsToProperty("nombre")
		new Column<Jugador>(table) //
			.setTitle("Handicap")
			.setFixedSize(150)
		//	.bindContentsToProperty("nombre")
		new Column<Jugador>(table) //
			.setTitle("Promedio")
			.setFixedSize(150)
		//	.bindContentsToProperty("nombre")
	}
		
}