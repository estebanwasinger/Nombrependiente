package inscripciones

import inscripciones.TipoInscripcion
import futbol5.Partido
import futbol5.Jugador

class Solidario implements TipoInscripcion {

	override prioridad() {
		2
	}
	
	override cumpleCondicion(Jugador jugador, Partido partido) {
		true
	}
	
}
