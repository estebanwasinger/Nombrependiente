package futbol5.runnable

import futbol5.domain.Jugador
import futbol5.domain.Partido
import futbol5.homes.HomeJugadores
import futbol5.homes.HomePartidos
import futbol5.ui.PartidosView
import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import org.uqbar.commons.utils.ApplicationContext
import uqbar.arena.persistence.Configuration
import futbol5.homes.RepositorioPartidos

class TPFutbolApplication extends Application {
	
	static def void main(String[] args) { 
		new TPFutbolApplication().start()
	}

	override protected Window<?> createMainWindow() {
		Configuration.configure()
		ApplicationContext.instance.configureSingleton(typeof(Partido), new RepositorioPartidos)
		//ApplicationContext.instance.configureSingleton(typeof(Partido), new HomePartidos)
		ApplicationContext.instance.configureSingleton(typeof(Jugador), new HomeJugadores)
		return new PartidosView(this)
	}
}
	