package observers

import auxiliares.MessageSender
import futbol5.domain.Jugador
import futbol5.domain.Partido
import infracciones.Infraccion

class BajaSinReemplazoObserver extends PartidoObserver {

	new(MessageSender unMessageSender) {
		super(unMessageSender)
	}

	override notificarBaja(Partido partido, Jugador jugador, Jugador reemplazo) {
		if (reemplazo == null) {
			generarInfraccion(jugador)
		}
	}

	def generarInfraccion(Jugador jugador) {
		jugador.infracciones.add(new Infraccion)
	}

}
