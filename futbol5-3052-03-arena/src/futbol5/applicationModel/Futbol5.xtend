package futbol5.applicationModel

import java.io.Serializable
import java.util.ArrayList
import java.util.List
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable
import futbol5.domain.Jugador
import futbol5.homes.HomeJugadores
import java.util.Date
import futbol5.domain.Partido

@Observable
class Futbol5 implements Serializable {

	@Property Jugador jugador
	@Property Integer numero
	@Property String apodo
	@Property String nombre
	@Property Date fechaNacimiento
	@Property int nivelDeJuego
	@Property Jugador seleccionJugador
	@Property List<Jugador> resultados
	@Property BusquedaJugador busquedaJugadores
	@Property List<Partido> partidos

	def void search(Jugador jugador) { 
		resultados = new ArrayList<Jugador>
		resultados = getHomeJugadores().search(jugador)
	}
	
	def void clear() {
		nombre = null
	}
			
	def HomeJugadores getHomeJugadores() {
		ApplicationContext.instance.getSingleton(typeof(Jugador))
	}
}