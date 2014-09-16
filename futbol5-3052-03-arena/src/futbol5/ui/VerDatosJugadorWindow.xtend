
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

class VerDatosJugadorWindow extends Dialog<Jugador>{
	
new(WindowOwner owner, Jugador model) {
		super(owner, model)
	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Datos del Jugador"
		new Label(mainPanel).text = "Nombre del Jugador"
		new Label(mainPanel).bindValueToProperty("nombre")

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