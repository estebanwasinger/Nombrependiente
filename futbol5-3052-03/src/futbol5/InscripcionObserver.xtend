package futbol5

class InscripcionObserver extends MailObserver{
	MessageSender messageSender
	
	new(MessageSender unMessageSender) {
		messageSender = unMessageSender
	}
	
	def Notificacion armarNotificacion(Jugador emisor, Jugador receptor){
		var notificacion = new Notificacion
		notificacion.from = emisor.email
		notificacion.to = receptor.email
		notificacion.title=	"Inscripción de un amigo"
		notificacion.message="Me inscribi al partido"
		return notificacion
	}
	
	override enviarNotificacion(Partido partido, Jugador jugador) {
        if (partido.estaInscripto(jugador)){
        	jugador.amigos.forEach[ amigo | messageSender.send(this.armarNotificacion(jugador, amigo)) ]
		}
	}
	

	
}