package decoradores

import futbol5.InterfazPartido
import futbol5.Jugador
import helper.NotificationSender

class PartidoDecorator implements InterfazPartido {
	
	@Property InterfazPartido decorado
	@Property NotificationSender notificationSender
	
	new(InterfazPartido partido) {
		decorado = partido
	}
	
	new(InterfazPartido partido, NotificationSender nuevoNotificationSender) {
		notificationSender = nuevoNotificationSender
	}
	
	override cantJugadores() {
		decorado.cantJugadores()
	}
	
	override bajaSinReemplazo(Jugador jugador) {
		decorado.bajaSinReemplazo(jugador)
	}
	
	override inscribir(Jugador jugador) {
		decorado.inscribir(jugador)
	}
	
}