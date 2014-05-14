package helper

import java.util.Map
import java.util.Set
import java.util.HashMap
import java.util.HashSet

class StubNotificationSender implements NotificationSender {

	Map<String, Set<String>> notificacionsEnviados

	HashMap<String, Set<String>> notificacionsRecibidos

	new() {
		notificacionsEnviados = new HashMap<String, Set<String>>
		notificacionsRecibidos = new HashMap<String, Set<String>>
	}

	override send(Notificacion notificacion) {
		simularEnvioNotificacion(notificacion.de, notificacion.a, notificacion.contenido)
		println(
			"Notificación // Emisor: " + notificacion.de + " // Receptor: " + notificacion.a + "    // Mensaje: " +
				notificacion.contenido)
	}

	def simularEnvioNotificacion(String from, String to, String message) {
		var mensajes = notificacionsDe(from)
		mensajes.add(message)
		notificacionsEnviados.put(from, mensajes)
		notificacionsRecibidos.put(to, mensajes)
	}

	def Set<String> notificacionsDe(String from) {
		var Set<String> mensajes = notificacionsEnviados.get(from)
		if (mensajes == null) {
			mensajes = new HashSet<String>
		}
		mensajes
	}

	def Set<String> notificacionsPara(String to) {
		var Set<String> mensajes = notificacionsRecibidos.get(to)
		if (mensajes == null) {
			mensajes = new HashSet<String>
		}
		mensajes
	}
}
