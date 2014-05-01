package futbol5

class Jugador {

	@Property TipoInscripcion tipoInscripcion

	new() {
		tipoInscripcion = new Estandar
	}

	def tieneMasPrioridadQue(Jugador jugador) {
		this.prioridad < jugador.prioridad
	}

	def int prioridad() {
		tipoInscripcion.prioridad()
	}

}
