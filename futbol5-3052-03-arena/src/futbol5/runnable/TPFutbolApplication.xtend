package futbol5.runnable

import calificaciones.Calificacion
import futbol5.domain.Jugador
import futbol5.domain.Partido
import futbol5.homes.RepositorioCalificaciones
import futbol5.homes.RepositorioInfracciones
import futbol5.homes.RepositorioJugadores
import futbol5.homes.RepositorioPartidos
import futbol5.ui.PartidosView
import infracciones.Infraccion
import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import org.uqbar.commons.utils.ApplicationContext
import uqbar.arena.persistence.Configuration

class TPFutbolApplication extends Application {
	
	static def void main(String[] args) { 
		new TPFutbolApplication().start()
	}

	override protected Window<?> createMainWindow() {
		Configuration.configure()
		ApplicationContext.instance.configureSingleton(typeof(Infraccion), new RepositorioInfracciones)
		ApplicationContext.instance.configureSingleton(typeof(Calificacion), new RepositorioCalificaciones)
		ApplicationContext.instance.configureSingleton(typeof(Jugador), new RepositorioJugadores)
		ApplicationContext.instance.configureSingleton(typeof(Partido), new RepositorioPartidos)
		//ApplicationContext.instance.configureSingleton(typeof(Partido), new HomePartidos)
		//ApplicationContext.instance.configureSingleton(typeof(Jugador), new HomeJugadores)
		return new PartidosView(this)
	}
}
	