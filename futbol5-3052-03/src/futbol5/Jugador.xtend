package futbol5

class Jugador {

	@Property TipoInscripcion tipoInscripcion
	@Property int edad
	
	new() {
		tipoInscripcion = new Estandar
	}
	
	def boolean menorA (int edad) {
		this.edad < edad
	}

	def tieneMasPrioridadQue(Jugador jugador) {
		this.prioridad < jugador.prioridad
	}

	def int prioridad() {
		tipoInscripcion.prioridad()
	}

}
