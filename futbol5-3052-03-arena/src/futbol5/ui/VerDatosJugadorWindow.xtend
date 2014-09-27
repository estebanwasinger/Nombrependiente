
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
		var principal = new Panel(mainPanel).layout = new ColumnLayout(2)
		var panelIzq = new Panel(principal).layout = new ColumnLayout(2)
		var panelDer = new Panel(principal).layout = new VerticalLayout
		
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
		var tablaListaAmigos = new Table<Jugador>(panel, typeof(Jugador)) =>[
			heigth = 200
			width = 285
			bindItemsToProperty("amigos")]
			
		new Column<Jugador>(tablaListaAmigos).setTitle("Nombre").bindContentsToProperty("nombre")
	
		var tablaListaInfracciones = new Table<Infraccion>(panel, typeof(Infraccion)) => [
			heigth = 200
			width = 285
			bindItemsToProperty("infracciones")]
			
		new Column<Infraccion>(tablaListaInfracciones).setTitle("Infracciones").bindContentsToProperty("motivo")
	}
	
override protected void addActions(Panel actions) {
		new Button(actions) => [
			setCaption("Volver")
			onClick [|this.cancel] ]
	}

	def homeJugadores() {
		ApplicationContext::instance.getSingleton(typeof(Jugador)) as HomeJugadores
	}
	
}