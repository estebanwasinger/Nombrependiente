package futbol5

import auxiliares.RegistroRechazo
import excepciones.BusinessException

class Administrador {

	@Property String email
	@Property Sistema sistema

	new() {
		sistema = new Sistema
	}

	def tomarUnaDecision(Jugador jugador, boolean loAcepta, String motivo) {
		if (!sistema.jugadoresRecomendados.remove(jugador)) {
			throw new BusinessException("El jugador que se desea aceptar/rechazar no se encuentra en la lista de recomendados")
			}
		if (loAcepta){
				sistema.jugadoresAceptados.add(jugador)
			} else {
				sistema.jugadoresRechazados.add(new RegistroRechazo(jugador, motivo))
			}

	}
}
