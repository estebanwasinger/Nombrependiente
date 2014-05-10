package inscripciones

import inscripciones.TipoInscripcion
import futbol5.Partido
import futbol5.Jugador

class Estandar implements TipoInscripcion {

	override prioridad() {
		1
	}
	
	override cumpleCondicion(Jugador jugador, Partido partido) {
		true
	}
	
}
