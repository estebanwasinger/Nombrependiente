package futbol5

class Solidario implements TipoInscripcion {

	override prioridad() {
		2
	}
	
	override cumpleCondicion(Jugador jugador, Partido partido) {
		true
	}
	
}
