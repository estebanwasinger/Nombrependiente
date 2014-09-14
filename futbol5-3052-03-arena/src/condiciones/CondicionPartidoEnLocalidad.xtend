package condiciones

import futbol5.domain.Jugador
import futbol5.domain.Partido

class CondicionPartidoEnLocalidad implements Condicion {
		@Property var String localidad 
		
new (String localidad){
		this.localidad = localidad
}

	override boolean seCumple(Jugador jugador, Partido partido){
		 partido.localidad == localidad
	}
}