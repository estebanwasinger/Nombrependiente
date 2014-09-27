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
	@Property int handicapDesde
	@Property int handicapHasta
	@Property int promedioDesde
	@Property int promedioHasta
	@Property String infracciones 	
	
	new(){
		iniciar()
		jugadores = new ArrayList<Jugador>
		jugadores =  getHomeJugadores().jugadoresAceptados
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
	
	def void iniciar(){
		jugadorEjemplo = new Jugador
		handicapDesde = 1
		handicapHasta = 10
		promedioDesde = 0
		promedioHasta = 10
		infracciones = "Todos"
	}
	
	def HomeJugadores getHomeJugadores() {
		ApplicationContext.instance.getSingleton(typeof(Jugador))
		}

	}