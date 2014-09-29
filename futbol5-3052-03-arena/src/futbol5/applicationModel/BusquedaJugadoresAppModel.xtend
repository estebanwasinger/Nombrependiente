package futbol5.applicationModel

import futbol5.domain.Jugador
import futbol5.homes.HomeJugadores
import java.io.Serializable
import java.util.ArrayList
import java.util.List
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable
import strategyHandicap.HandicapStrategy
import strategyHandicap.HandicapHasta
import strategyHandicap.HandicapDesde

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
		jugadores = getHomeJugadores().jugadoresAceptados
	}

	def void search() {
		jugadorSeleccionado = null
		jugadores = new ArrayList<Jugador>
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

	def HomeJugadores getHomeJugadores() {
		ApplicationContext.instance.getSingleton(typeof(Jugador))
	}

	def getHandicaps() {
		#[new HandicapHasta, new HandicapDesde]
	}

}
