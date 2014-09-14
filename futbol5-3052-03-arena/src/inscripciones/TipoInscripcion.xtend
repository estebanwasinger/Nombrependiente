package inscripciones

import futbol5.domain.Jugador
import futbol5.domain.Partido

interface TipoInscripcion {
	
	def int prioridad()
	
	def boolean cumpleCondicion(Jugador jugador, Partido partido)
	
}