package futbol5.ui

import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import org.uqbar.commons.utils.ApplicationContext
import futbol5.domain.Partido
import futbol5.domain.Jugador

class RunnableJugador extends Application {
	
	static def void main(String[] args) { 
		new RunnableJugador().start()
	}
	
	override protected createMainWindow() {
		
		return new VerDatosJugadorWindow(this, new Jugador)
	}
	
	}