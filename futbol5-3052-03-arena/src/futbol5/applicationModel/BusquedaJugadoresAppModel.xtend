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
	@Property Float handicapDesde
	@Property Float handicapHasta
	
	new(){
		jugadorEjemplo = new Jugador
		jugadores = new ArrayList<Jugador>
		jugadores =  getHomeJugadores().jugadoresAceptados
		handicapDesde = new Float(0.0F)
		handicapHasta = new Float(0.0F)
	}

	def void search() { 
		getHomeJugadores().handicapDesde = this.handicapDesde
		getHomeJugadores().handicapHasta = this.handicapHasta
		jugadores = new ArrayList<Jugador>
		jugadores = getHomeJugadores().search(jugadorEjemplo)
	}
	
	def void clear() {
		jugadorEjemplo = new Jugador
		jugadorSeleccionado = null
		handicapDesde = 0.0F
		handicapHasta = 0.0F
		search()
	}
	
	def HomeJugadores getHomeJugadores() {
		ApplicationContext.instance.getSingleton(typeof(Jugador))
	}

	}