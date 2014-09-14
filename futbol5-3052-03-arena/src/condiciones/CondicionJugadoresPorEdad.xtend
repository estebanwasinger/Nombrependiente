package condiciones

import futbol5.domain.Jugador
import futbol5.domain.Partido

class CondicionJugadoresPorEdad implements Condicion {

	@Property var int edadLimite
	@Property var int jugadoresLimite

	new(int jugadoresLimite, int edadLimite) {
		this.jugadoresLimite = jugadoresLimite
		this.edadLimite = edadLimite
	}

	override boolean seCumple(Jugador jugador, Partido partido) {
		this.cantInscriptosConEdadLimite(partido, this.edadLimite) <= this.jugadoresLimite
	}

	def int cantInscriptosConEdadLimite(Partido partido, int edadLimite) {
		(partido.jugadores.filter[Jugador jugador|jugador.menorA(edadLimite)]).size
	}

}
