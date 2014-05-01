package futbol5

import java.util.LinkedList

class Partido {

	var jugadores = new LinkedList<Jugador>

	def int cantJugadores() {
		jugadores.size
	}

	def void agregarJugador(Jugador jugadorAInscribir) {
		jugadores.add(jugadorAInscribir)
	}

	def void cambiarJugador(Integer posicionAGuardar, Jugador jugador) {
		jugadores.set(posicionAGuardar, jugador)
	}

	def int posicionEnLista(Jugador jugador) {
		jugadores.indexOf(jugador)
	}

	def estaInscripto(Jugador jugador) {
		jugadores.contains(jugador)
	}

	def inscribir(Jugador jugador) {
		if (this.estaInscripto(jugador)) {
			throw new BusinessException("El jugador ya se inscribió")
		}
		if (this.cantJugadores < 10) {
			this.agregarJugador(jugador)
			return
		}
		if (!jugadores.exists[ inscripto | jugador.tieneMasPrioridadQue(inscripto) ]) {
			throw new BusinessException("No hay más cupo")
		}
		val quien = jugadores.filter [ unJugador | unJugador.prioridad > jugador.prioridad ].head
		jugadores.remove(quien)
		this.agregarJugador(jugador)
	}
}
