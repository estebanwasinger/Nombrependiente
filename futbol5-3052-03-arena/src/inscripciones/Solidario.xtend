package inscripciones

import futbol5.domain.Jugador
import futbol5.domain.Partido

class Solidario implements TipoInscripcion {

	override prioridad() {
		2
	}
	
	override cumpleCondicion(Jugador jugador, Partido partido) {
		true
	}
	
}
