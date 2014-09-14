package observers

import auxiliares.MessageSender
import futbol5.domain.Jugador
import futbol5.domain.Partido

class EquipoIncompletoObserver extends PartidoObserver{
	
	new(MessageSender unMessageSender) {
		super(unMessageSender)
	}
	
	override notificarBaja(Partido partido, Jugador jugador, Jugador reemplazo){
       if (partido.cantJugadores==9){
        	val adminMail = partido.administrador.email
        	val asunto =  "Partido incompleto"
        	val mensaje = "Se dio de baja un jugador del partido y no dejo un reemplazo. El equipo esta incompleto (9 jugadores)"
        	super.enviarNotificacion(adminMail, asunto, mensaje)
        }
     }
}