package inscripciones

import futbol5.Jugador
import futbol5.Partido

interface TipoInscripcion {
	
	def int prioridad()
	
	def boolean cumpleCondicion(Jugador jugador, Partido partido)
	
}