package futbol5

import java.util.LinkedList

class Partido {

	@Property var String localidad
	@Property var LinkedList<Jugador> jugadores
	
	new(String localidad) {
		this.localidad = localidad
		jugadores = new LinkedList<Jugador>
	}

	def int cantJugadores() {
		jugadores.size
	}

	def void agregarJugador(Jugador jugador) {
		this.jugadores.add(jugador)
	}

	def estaInscripto(Jugador jugador) {
		this.jugadores.contains(jugador)
	}

	def inscribir(Jugador jugador) {
		if (this.estaInscripto(jugador)) {
			throw new BusinessException("El jugador ya se inscribió")
		}
		if(!jugador.tipoInscripcion.cumpleCondicion(jugador,this)){
			throw new BusinessException("El jugador no cumple con la condición, no se puede inscribir")
		}
		if (this.cantJugadores < 10){
			this.agregarJugador(jugador)
			return
		}
		if (!this.jugadores.exists[ inscripto | jugador.tieneMasPrioridadQue(inscripto) ]) {
			throw new BusinessException("No hay más cupo")
		}
		
		val quien = this.jugadores.filter [ unJugador | unJugador.prioridad > jugador.prioridad ].head
		this.jugadores.remove(quien)
		this.agregarJugador(jugador)
	}
}
