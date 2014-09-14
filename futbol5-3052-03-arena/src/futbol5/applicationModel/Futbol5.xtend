package futbol5.applicationModel

import java.io.Serializable
import java.util.ArrayList
import java.util.List
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable
import futbol5.domain.Jugador
import futbol5.homes.HomeJugadores

@Observable
class Futbol5 implements Serializable {

	@Property Integer numero
	@Property String nombre
	@Property List<Jugador> jugadores
	@Property Jugador jugadorSeleccionado
	@Property List<Jugador> resultados

	def void search() { 
		resultados = new ArrayList<Jugador>
		resultados = getHomeJugadores().search(nombre)
	}
	
	def void clear() {
		nombre = null
	}

	def HomeJugadores getHomeJugadores() {
		ApplicationContext.instance.getSingleton(typeof(Jugador))
	}
}