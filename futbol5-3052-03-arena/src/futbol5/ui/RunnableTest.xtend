package futbol5.ui

import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import org.uqbar.commons.utils.ApplicationContext
import futbol5.domain.Partido
import futbol5.domain.Jugador

class RunnableTest extends Application {
	
	static def void main(String[] args) { 
		new RunnableTest().start()
	}

	override protected Window<?> createMainWindow() {
		//ApplicationContext.instance.configureSingleton(typeof(Modelo), new HomeModelos)
		//ApplicationContext.instance.configureSingleton(typeof(Celular), new HomeCelulares)
		var Partido partidoEjemplo = new Partido
		partidoEjemplo.agregarJugador(new Jugador())
		
		
		
		return new GenerarEquiposWindow(this, new Partido)
	}
}
	
