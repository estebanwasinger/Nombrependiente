package command

import futbol5.Jugador
import futbol5.Partido

class Aceptar implements Decision{
	
	override registrarDecision(Jugador jugador, Partido partido, String motivo) {
		partido.jugadoresAceptados.add(jugador)
		partido.inscribir(jugador)
	}
	
}