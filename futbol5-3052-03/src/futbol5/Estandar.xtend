package futbol5

class Estandar implements TipoInscripcion {

	override prioridad() {
		1
	}
	
	override cumpleCondicion(Jugador jugador, Partido partido) {
		true
	}
	
}
