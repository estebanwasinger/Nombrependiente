
package futbol5.ui

import futbol5.domain.Jugador
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.utils.ApplicationContext
import futbol5.homes.HomeJugadores
import org.uqbar.arena.widgets.Button

class VerDatosJugadorWindow extends Dialog<Jugador>{
	
new(WindowOwner owner, Jugador model) {
		super(owner, model)
	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Datos del Jugador"

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