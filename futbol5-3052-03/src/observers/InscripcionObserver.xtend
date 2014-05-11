package observers

import auxiliares.MessageSender
import futbol5.Jugador
import futbol5.Partido

class InscripcionObserver extends NotificacionObserver{
	 MessageSender messageSender
	
	new(MessageSender unMessageSender) {
		messageSender = unMessageSender
	}
	
	def Notificacion armarNotificacion(Jugador emisor, Jugador receptor){
		var notificacion = new Notificacion
		notificacion.from = emisor.email
		notificacion.to = receptor.email
		notificacion.subject=	"Inscripción de un amigo"
		notificacion.message="Me inscribi al partido"
		return notificacion
	}
	
	override enviarNotificacion(Partido partido, Jugador jugador) {
        if (partido.estaInscripto(jugador)){
        	jugador.amigos.forEach[ amigo | messageSender.send(this.armarNotificacion(jugador, amigo)) ]
		}
	}
	

	
}