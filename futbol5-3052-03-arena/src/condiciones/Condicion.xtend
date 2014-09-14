package condiciones

import futbol5.domain.Jugador
import futbol5.domain.Partido

interface  Condicion {
	
	def boolean seCumple(Jugador jugador, Partido partido)
	
}