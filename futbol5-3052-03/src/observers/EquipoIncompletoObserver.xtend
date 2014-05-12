package observers

import futbol5.Partido
import futbol5.Jugador
import auxiliares.MessageSender

class EquipoIncompletoObserver extends PartidoObserver{
	
	new(MessageSender unMessageSender) {
		super(unMessageSender)
	}
	
	override hacerLoSuyo(Partido partido, Jugador jugador){
       if (partido.cantJugadores==9){
        	val adminMail = jugador.administrador.email
        	val asunto =  "Partido incompleto"
        	val mensaje = "Se dio de baja un jugador del partido y no dejo un reemplazo. El equipo esta incompleto (9 jugadores)"
        	super.enviarNotificacion(adminMail, asunto, mensaje)
        }
     }
}