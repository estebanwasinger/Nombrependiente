
package futbol5.ui

import futbol5.domain.Jugador
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.utils.ApplicationContext
import futbol5.homes.HomeJugadores
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.widgets.tables.Column
import infracciones.Infraccion

class VerDatosJugadorWindow extends Dialog<Jugador>{
	
new(WindowOwner owner, Jugador model) {
		super(owner, model)
	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Datos del Jugador"
		val Panel columnPanel = new Panel(mainPanel)
		columnPanel.layout = new ColumnLayout(2)
		val Panel panelIzq = new Panel(columnPanel).layout = new ColumnLayout(2)
		val Panel panelDer = new Panel(columnPanel).layout = new VerticalLayout
		
		mostrarDatos(panelIzq)
		verTablas(panelDer)


	}
	def mostrarDatos(Panel panel){
		new Label(panel).text = "Nombre del Jugador"
		new Label(panel).bindValueToProperty("nombre")
		new Label(panel).text = "Apodo"
		new Label(panel).bindValueToProperty("apodo")
		new Label(panel).text = "Edad"
		new Label(panel).bindValueToProperty("edad")
		new Label(panel).text = "Cantidad De Partidos:"
		new Label(panel).bindValueToProperty("cantidadPartidos")
		new Label(panel).text = "Handicap:"
		new Label(panel).bindValueToProperty("nivelDeJuego")
		new Label(panel).text = "Nacicmiento:"
		new Label(panel).bindValueToProperty("fechaNacimientoString")
	
	}
	def verTablas(Panel panel){
	var Table tableListaAmigos = new Table<Jugador>(panel, typeof(Jugador))
	tableListaAmigos.heigth = 200
	tableListaAmigos.width = 285
	tableListaAmigos.bindItemsToProperty("amigos")
	new Column<Jugador>(tableListaAmigos).setTitle("Nombre").bindContentsToProperty("nombre")
	
	var Table tableListaInfracciones = new Table<Infraccion>(panel, typeof(Infraccion))
	tableListaInfracciones.heigth = 200
	tableListaInfracciones.width = 285
	tableListaInfracciones.bindItemsToProperty("infracciones")
	new Column<Jugador>(tableListaInfracciones).setTitle("Infracciones").bindContentsToProperty("motivo")
	
	}
override protected void addActions(Panel actions) {
		new Button(actions) 
			.setCaption("Volver")
			.onClick [|this.cancel]
	}

	def homeMaterias() {
		ApplicationContext::instance.getSingleton(typeof(Jugador)) as HomeJugadores
	}
	
}