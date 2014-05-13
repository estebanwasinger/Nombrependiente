package helper

import java.util.Map
import java.util.Set
import java.util.HashMap
import java.util.HashSet

class StubNotificationSender implements NotificationSender{
		
		Map<String, Set<String>> notificacionsEnviados

	new() {
		notificacionsEnviados = new HashMap<String, Set<String>>
	}

	override send(Notificacion notificacion) {
		simularEnvioNotificacion(notificacion.de, notificacion.contenido)
		println("Simulación envío de notificacion | From: " + notificacion.de + " | To: " + notificacion.a + " | Message: " + notificacion.contenido)
	}

	def simularEnvioNotificacion(String from, String message) {
		var mensajes = notificacionsDe(from)
		mensajes.add(message)
		notificacionsEnviados.put(from, mensajes)
	}

	def Set<String> notificacionsDe(String from) {
		var Set<String> mensajes = notificacionsEnviados.get(from)
		if (mensajes == null) {
			mensajes = new HashSet<String>
		}
		mensajes
	}

}
