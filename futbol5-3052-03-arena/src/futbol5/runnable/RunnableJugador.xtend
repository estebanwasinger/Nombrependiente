package futbol5.runnable

import futbol5.domain.Jugador
import futbol5.ui.VerDatosJugadorWindow
import org.uqbar.arena.Application

class RunnableJugador extends Application {
	
	static def void main(String[] args) { 
		new RunnableJugador().start()
	}
	
	override protected createMainWindow() {
		
		return new VerDatosJugadorWindow(this, new Jugador)
	}
	
	}