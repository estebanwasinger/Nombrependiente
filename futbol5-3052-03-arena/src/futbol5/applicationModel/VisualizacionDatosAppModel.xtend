package futbol5.applicationModel

import futbol5.domain.Jugador
import futbol5.homes.HomeJugadores
import java.io.Serializable
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable

@Observable
class VisualizacionDatosAppModel  implements Serializable{
		@Property Jugador jugadorModelo
		@Property int promedioUltimoPartido
		@Property int promedioTotal
		
		
	new(){
		jugadorModelo = new Jugador
		promedioUltimoPartido = Math.round(jugadorModelo.promedioNPartidos(jugadorModelo.cantidadPartidos))
		promedioTotal = Math.round(jugadorModelo.promedio)
	}
	
	def HomeJugadores getHomeJugadores() {
		ApplicationContext.instance.getSingleton(typeof(Jugador))
	}
}
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
//// POR EL MOMENTO NO SE USA ////
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
