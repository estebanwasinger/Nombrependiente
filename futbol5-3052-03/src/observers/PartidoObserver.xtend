package observers

import futbol5.Jugador
import auxiliares.MessageSender
import futbol5.Partido

class PartidoObserver {
		MessageSender messageSender
		
		new (MessageSender unMessageSender){
			messageSender = unMessageSender
		}
	
	def enviarNotificacion(Notificacion notificacion){
		messageSender.send (notificacion)
	}	
	def void hacerLoSuyo(Partido partido, Jugador jugador) {}
	
}