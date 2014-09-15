package futbol5.ui

import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import org.uqbar.commons.utils.ApplicationContext
import futbol5.domain.Partido
import futbol5.domain.Jugador
import futbol5.homes.HomeJugadores
import futbol5.applicationModel.Futbol5

class RunnableVistaPrincipal extends Application {
	
	static def void main(String[] args) { 
		new RunnableVistaPrincipal().start()
	}

	override protected Window<?> createMainWindow() {
		ApplicationContext.instance.configureSingleton(typeof(Jugador), new HomeJugadores)
		//ApplicationContext.instance.configureSingleton(typeof(Celular), new HomeCelulares)
	//	var Partido partidoEjemplo = new Partido("San Miguel")
	//	partidoEjemplo.agregarJugador(new Jugador("Esteban"))
	//	partidoEjemplo.agregarJugador(new Jugador("Carolina"))
		
		
		
		return new VistaPrincipal(this, new Futbol5)
	}
}
	