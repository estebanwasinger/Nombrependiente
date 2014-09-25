package futbol5.applicationModel

import futbol5.domain.Jugador
import futbol5.homes.HomeJugadores
import java.io.Serializable
import java.util.ArrayList
import java.util.List
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable

@Observable
class BusquedaJugadoresAppModel implements Serializable{

	@Property Jugador jugadorEjemplo
	@Property List <Jugador> jugadores
	@Property Jugador jugadorSeleccionado
	@Property String tipoHandicap
	
	new(){
		jugadores = new ArrayList<Jugador>
		jugadores =  getHomeJugadores().jugadoresAceptados
	}

	def void search() { 
		getHomeJugadores()tipoHandicap = this.tipoHandicap
		jugadores = new ArrayList<Jugador>
		jugadores = getHomeJugadores().search(jugadorEjemplo)
	}
	
	def void clear() {
		jugadorEjemplo = null
		jugadorSeleccionado = null
	}
	
	def HomeJugadores getHomeJugadores() {
		ApplicationContext.instance.getSingleton(typeof(Jugador))
	}

	}