package futbol5.ui

import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import org.uqbar.commons.utils.ApplicationContext
import futbol5.domain.Partido
import futbol5.domain.Jugador
import futbol5.homes.HomePartidos
import futbol5.applicationModel.Futbol5

class RunnableVistaPrincipal extends Application {
	
	static def void main(String[] args) { 
		new RunnableVistaPrincipal().start()
	}

	override protected Window<?> createMainWindow() {
		
		ApplicationContext.instance.configureSingleton(typeof(Partido), new HomePartidos)
	//	var Partido partidoEjemplo = new Partido("San Miguel")
	//	partidoEjemplo.agregarJugador(new Jugador("Esteban"))
	//	partidoEjemplo.agregarJugador(new Jugador("Carolina"))
	var Futbol5 appModel = new Futbol5
		
		return new VistaPrincipal(this, new Futbol5)
	}
}
	