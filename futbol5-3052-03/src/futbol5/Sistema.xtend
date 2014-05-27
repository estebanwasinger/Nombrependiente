package futbol5

import auxiliares.RegistroRechazo
import java.util.List
import java.util.LinkedList
import excepciones.BusinessException

class Sistema {
	@Property var List<Jugador> jugadoresAceptados
	@Property var List<RegistroRechazo> jugadoresRechazados
	@Property var List<Jugador> jugadoresRecomendados

	//static Sistema unico = null
	private static Sistema INSTANCE = null;

	def static Sistema getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Sistema()
		}
		INSTANCE
	}

	new() {
		jugadoresAceptados = new LinkedList<Jugador>
		jugadoresRechazados = new LinkedList<RegistroRechazo>
		jugadoresRecomendados = new LinkedList<Jugador>
	}

	/********************************/
	/*CASO DE USO: NUEVOS JUGADORES */
	/********************************/
	def jugadorProponeA(Jugador jugador) {
		jugadoresRecomendados.add(jugador)
	}

	def tomarDecision(Boolean decision, Jugador jugador, String motivo) {
		if (jugadoresRecomendados.remove(jugador) == false) {
			throw new BusinessException("El jugador que se desea aceptar no se encuentra en la lista de recomendados")
		} else {
			if (decision) {
				jugadoresAceptados.add(jugador)
			} else {
				jugadoresRechazados.add(new RegistroRechazo(jugador, motivo))
			}
		}
	}
}
