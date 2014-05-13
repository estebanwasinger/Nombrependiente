package decoradores

import java.util.List
import futbol5.InterfazPartido
import futbol5.Jugador
import helper.Notificacion
import helper.NotificationSender

class NotificarAmigosDecorator extends PartidoDecorator {

	new(InterfazPartido partido, NotificationSender nuevoNotificationSender) {
		super(partido, nuevoNotificationSender)
	}

	override inscribir(Jugador jugador) {
		decorado.inscribir(jugador)
		notificarAmigos(jugador, jugador.amigos)
	}

	def notificarAmigos(Jugador jugador, List<Jugador> jugadores) {
		jugadores.forEach[jugadorAmigo |notificationSender.send(new Notificacion(jugador.nombre,jugadorAmigo.nombre,"Un amigo tuyo se inscribio a un partido","Hola " + jugadorAmigo.nombre + ",les queremos notificar que su amigo " + jugador.nombre + " se ha inscripto a un partido"))]
	}
	
}
