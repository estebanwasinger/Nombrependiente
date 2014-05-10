package condiciones

import futbol5.Partido
import futbol5.Jugador

interface  Condicion {
	
	def boolean seCumple(Jugador jugador, Partido partido)
	
}