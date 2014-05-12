package observers

import futbol5.Jugador
import futbol5.Partido
import auxiliares.MessageSender

class InscripcionObserver extends PartidoObserver{
	
	new(MessageSender unMessageSender) {
		super(unMessageSender)
	}
	
	def  avisarle(Jugador emisor, Jugador receptor){
		var notificacion = new Notificacion
		notificacion.from = emisor.email
		notificacion.to = receptor.email
		notificacion.subject=	"Inscripción de un amigo"
		notificacion.message="Me inscribi al partido"
		super.enviarNotificacion(notificacion)
	}
	
	override hacerLoSuyo(Partido partido, Jugador jugador) {
        	jugador.amigos.forEach[ amigo | (this.avisarle(jugador, amigo)) ]
		}
	}
