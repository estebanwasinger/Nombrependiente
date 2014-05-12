package observers

import futbol5.Jugador
import futbol5.Partido
import auxiliares.MessageSender

class InscripcionObserver extends PartidoObserver{
	
	new(MessageSender unMessageSender) {
		super(unMessageSender)
	}
	
	def  avisarle(Jugador emisor, Jugador receptor){
		val asunto=	"Inscripción de un amigo"
		val mensaje= emisor.email + "se inscribió al partido"
		super.enviarNotificacion(receptor.email, asunto, mensaje)
	}
	
	override hacerLoSuyo(Partido partido, Jugador jugador) {
        	jugador.amigos.forEach[ amigo | (this.avisarle(jugador, amigo)) ]
		}
	}
