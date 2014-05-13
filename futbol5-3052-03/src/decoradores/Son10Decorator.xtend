package decoradores

import futbol5.InterfazPartido
import futbol5.Jugador
import futbol5.Administrador
import helper.NotificationSender
import helper.Notificacion

class Son10Decorator extends PartidoDecorator {

	new(InterfazPartido partido, NotificationSender nuevoNotificationSender) {
		super(partido, nuevoNotificationSender)
	}

	override inscribir(Jugador jugador) {
		decorado.inscribir(jugador)
		if (decorado.cantJugadores() == 10) {
			notificarAdministradorPartidoLleno()
		}
	}

	def notificarAdministradorPartidoLleno() {
		notificationSender.send(
			new Notificacion("Partido", "Admin", "Partido completo", "Ya se incribieron los 10 jugadores al partido"))
	}
}
