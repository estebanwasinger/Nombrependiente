package observers

import futbol5.Jugador
import futbol5.Partido
import auxiliares.MessageSender

class InscripcionObserver extends PartidoObserver{
	
	new(MessageSender unMessageSender) {
		super(unMessageSender)
	}
	
	def  avisarle(Jugador emisor, Jugador receptor){
		val asunto=	"Inscripci�n de un amigo"
		val mensaje= emisor.email + "se inscribi� al partido"
		enviarNotificacion(receptor.email, asunto, mensaje)
	}
	
	override notificarInscripcion(Partido partido, Jugador jugador) {
        	jugador.amigos.forEach[ amigo | (avisarle(jugador, amigo)) ]
		}
	}
