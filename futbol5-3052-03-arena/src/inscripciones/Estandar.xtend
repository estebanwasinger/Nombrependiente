package inscripciones

import futbol5.domain.Jugador
import futbol5.domain.Partido

class Estandar implements TipoInscripcion {

	override prioridad() {
		1
	}
	
	override cumpleCondicion(Jugador jugador, Partido partido) {
		true
	}
	
}
