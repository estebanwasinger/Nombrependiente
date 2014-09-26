package futbol5.applicationModel

import futbol5.auxUtils.ModeloBusquedaHyP
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
	@Property ModeloBusquedaHyP modelo
	/*@Property Float handicapDesde 
	@Property Float handicapHasta
	@Property int promedioDesde 
	@Property int promedioHasta */
	
	new(){
		jugadorEjemplo = new Jugador
		jugadores = new ArrayList<Jugador>
		jugadores =  getHomeJugadores().jugadoresAceptados
		/*handicapDesde = new Float(1.0F)
		handicapHasta = new Float(10.0F)
		promedioDesde = 0
		promedioHasta = 10*/
		modelo = new ModeloBusquedaHyP
	}

	def void search() { 
		jugadorSeleccionado = null
		jugadores = new ArrayList<Jugador>
		jugadores = getHomeJugadores().search(jugadorEjemplo,modelo)//, handicapDesde, handicapHasta, promedioDesde, promedioHasta)
	}
	
	def void clear() {
		jugadorEjemplo = new Jugador
		jugadorSeleccionado = null
		/*handicapDesde = new Float(1.0F)
		handicapHasta = new Float(10.0F)
		promedioDesde = 0
		promedioHasta = 10*/
		modelo = new ModeloBusquedaHyP
		search()
	}
	
	def HomeJugadores getHomeJugadores() {
		ApplicationContext.instance.getSingleton(typeof(Jugador))
	}

	}