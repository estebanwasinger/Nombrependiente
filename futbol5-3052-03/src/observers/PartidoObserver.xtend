package observers

import futbol5.Jugador
import auxiliares.MessageSender
import futbol5.Partido

class PartidoObserver {
		MessageSender messageSender
		
		new (MessageSender unMessageSender){
			messageSender = unMessageSender
		}
	
	def enviarNotificacion(String para, String asunto, String mensaje){
		var notificacion = new Notificacion
		notificacion.from = "info@organizacionpartido5.com.ar"
		notificacion.to = para
		notificacion.subject=	asunto
		notificacion.message= mensaje
		messageSender.send (notificacion)
	}	
	
	def void hacerLoSuyo(Partido partido, Jugador jugador) {}
	
}