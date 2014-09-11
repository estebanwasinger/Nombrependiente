package auxiliares

import observers.Notificacion

interface MessageSender {
	def void send(Notificacion notificacion)

}