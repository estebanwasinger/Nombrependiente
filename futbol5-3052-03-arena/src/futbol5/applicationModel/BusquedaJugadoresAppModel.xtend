package futbol5.applicationModel

import futbol5.domain.Jugador
import futbol5.homes.HomeJugadores
import java.io.Serializable
import java.util.ArrayList
import java.util.List
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable

@Observable
class BusquedaJugadoresAppModel implements Serializable {

	@Property Jugador jugadorEjemplo
	@Property ArrayList <Jugador> jugadores
/*	@Property Integer numero
	@Property String apodo
	@Property String nombre 
	@Property int nivelDeJuego*/
	@Property List<Jugador> resultados /*
	@Property List<Partido> partidos
	@Property Partido partido	 */
	@Property Jugador jugadorSeleccionado
	/*@Property List<Infraccion> infracciones
	@Property HomeJugadores homeJugadores*/
	@Property String tipoHandicap 

	new(){
		//homeJugadores = new HomeJugadores
		// jugadorEjemplo = new Jugador
		jugadores = new ArrayList<Jugador>
		jugadores =  homeJugadores().jugadoresAceptados
	}

	def void search(Jugador jugador) { 
		homeJugadores()tipoHandicap = this.tipoHandicap
		resultados = new ArrayList<Jugador>
		resultados = homeJugadores().search(jugadorEjemplo)
	}
	
	/*def void searchPartido(){
		partidos = new ArrayList<Partido>
		partidos = getHomePartidos().search(partido)
		
	}*/
	
	/*def cumple(Jugador jugador) {
		(!ingresoHandicapDesde || jugador.nivelDeJuego >= handicapDesde) &&
			(!ingresoHandicapHasta || jugador.nivelDeJuego <= handicapDesde) // aca se agregan las distintas validaciones de las busquedas para los puntos siguientes
	}

	def ingresoHandicapDesde() {
		!handicapDesde.equals(0)
	}

	def ingresoHandicapHasta() {
		 !handicapHasta.equals(10000)
	}*/
	
	def void clear() {
		jugadorEjemplo = new Jugador
	}
			
		def homeJugadores() {
		ApplicationContext::instance.getSingleton(typeof(Jugador)) as HomeJugadores
	}
	
	/*def HomePartidos getHomePartidos() {
		ApplicationContext.instance.getSingleton(typeof(Partido))
	}*/
	}