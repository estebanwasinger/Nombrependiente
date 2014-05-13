package decoradores

import futbol5.InterfazPartido
import futbol5.Jugador
import futbol5.Administrador

class YaNoSon10Decorator extends PartidoDecorator {

	new(InterfazPartido partido) {
		super(partido)
	}

	override bajaSinReemplazo(Jugador jugador) {
		decorado.bajaSinReemplazo(jugador)
		if (decorado.cantJugadores() == 9) {
			notificarAdministrador(jugador.administrador)
		}

	}

	def notificarAdministrador(Administrador administrador) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
}
