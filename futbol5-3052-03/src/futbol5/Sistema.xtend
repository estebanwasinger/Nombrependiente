package futbol5

import auxiliares.RegistroRechazo
import excepciones.BusinessException
import java.util.LinkedList
import java.util.List

class Sistema {
	@Property var List<Jugador> jugadoresAceptados
	@Property var List<RegistroRechazo> jugadoresRechazados
	@Property var LinkedList<Jugador> jugadoresRecomendados

	new() {
		jugadoresAceptados = new LinkedList<Jugador>
		jugadoresRechazados = new LinkedList<RegistroRechazo>
		jugadoresRecomendados = new LinkedList<Jugador>
	}

	def tomarUnaDecision(Jugador jugador, boolean loAcepta, String motivo) {
		if (!jugadoresRecomendados.remove(jugador)) {
			throw new BusinessException(
				"El jugador que se desea aceptar/rechazar no se encuentra en la lista de recomendados")
		}
		if (loAcepta) {
			jugadoresAceptados.add(jugador)
		} else {
			jugadoresRechazados.add(new RegistroRechazo(jugador, motivo))
		}

	}

}
