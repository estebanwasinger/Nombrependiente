package observers

import auxiliares.MessageSender
import futbol5.domain.Jugador
import futbol5.domain.Partido

class PartidoObserver {
	MessageSender messageSender

	new(MessageSender unMessageSender) {
		messageSender = unMessageSender
	}

	def enviarNotificacion(String para, String asunto, String mensaje) {
		var notificacion = new Notificacion
		notificacion.from = "info@organizacionpartido5.com.ar"
		notificacion.to = para
		notificacion.subject = asunto
		notificacion.message = mensaje
		messageSender.send(notificacion)
	}

	def void notificarBaja(Partido partido, Jugador jugador, Jugador reemplazo) {
	}

	def void notificarInscripcion(Partido partido, Jugador jugador) {
	}
	
}
