package futbol5.applicationModel

import futbol5.domain.Jugador
import futbol5.homes.HomeJugadores
import java.io.Serializable
import java.util.ArrayList
import java.util.List
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable
import strategyHandicap.HandicapDesde
import strategyHandicap.HandicapHasta
import strategyHandicap.HandicapStrategy
import futbol5.homes.RepositorioJugadores
import futbol5.homes.RepositorioPartidos

@Observable
class BusquedaJugadoresAppModel implements Serializable {

	@Property Jugador jugadorEjemplo
	@Property List<Jugador> jugadores
	@Property Jugador jugadorSeleccionado
	@Property Integer handicap
	@Property Integer promedioDesde
	@Property Integer promedioHasta
	@Property String infracciones
	@Property HandicapStrategy metodoHandicap

	new() {
		iniciar()
		jugadores = new ArrayList<Jugador>
		jugadores = getHomeJugadores().allInstances
	}

	def void search() {
		jugadorSeleccionado = null
		jugadores = new ArrayList<Jugador>
		//jugadores = homeJugadores.allInstances
		jugadores = getHomeJugadores().search(this)
	}

	def void clear() {
		iniciar()
		jugadorSeleccionado = null
		search()
	}

	def void iniciar() {
		jugadorEjemplo = new Jugador
		handicap = null
		promedioDesde = null
		promedioHasta = null
		infracciones = "Todos"
		metodoHandicap = handicaps.get(0)
	}
	
	def RepositorioJugadores getHomeJugadores() {
		ApplicationContext.instance.getSingleton(typeof(Jugador))
	}

	def getHandicaps() {
		#[new HandicapHasta, new HandicapDesde]
	}
	
}
