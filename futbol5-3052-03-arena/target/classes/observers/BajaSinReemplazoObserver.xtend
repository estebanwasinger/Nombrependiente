package observers

import futbol5.Jugador
import futbol5.Partido
import infracciones.Infraccion
import auxiliares.MessageSender

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
