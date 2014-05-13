package decoradores

import futbol5.InterfazPartido
import futbol5.Jugador
import futbol5.Administrador
import helper.NotificationSender
import helper.Notificacion

class YaNoSon10Decorator extends PartidoDecorator {

	new(InterfazPartido partido, NotificationSender nuevoNotificationSender) {
		super(partido, nuevoNotificationSender)
	}

	override bajaSinReemplazo(Jugador jugador) {
		decorado.bajaSinReemplazo(jugador)
		if (decorado.cantJugadores() == 9) {
			notificarAdministrador(jugador.administrador)
		}

	}

	def notificarAdministrador(Administrador administrador) {
		notificationSender.send(
			new Notificacion("Partido", "Admin", "Partido incompleto", "Se bajo un jugador, el partido no esta completo"))
	}
}
