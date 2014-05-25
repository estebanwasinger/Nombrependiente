package command

import futbol5.Jugador
import futbol5.Partido
import auxiliares.RegistroRechazo

class Rechazar implements Decision {
	var RegistroRechazo registro
	
	override registrarDecision(Jugador jugador, Partido partido, String motivo) {
		registro = new RegistroRechazo(motivo)
		partido.jugadoresRechazados.add(registro)
	}
	
}