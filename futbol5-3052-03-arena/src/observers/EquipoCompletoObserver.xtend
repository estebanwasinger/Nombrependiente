package observers

import auxiliares.MessageSender
import futbol5.domain.Jugador
import futbol5.domain.Partido

class EquipoCompletoObserver extends PartidoObserver{
	
	new(MessageSender unMessageSender) {
		super(unMessageSender)
	}
	
	override notificarInscripcion(Partido partido, Jugador jugador){
        if (partido.cantJugadores==10){
        	val adminMail = partido.administrador.email
        	val asunto = "Partido confirmado"
        	val mensaje = "El equipo tiene 10 jugadores a la fecha"
        	super.enviarNotificacion(adminMail, asunto, mensaje)
        }
       
	}

}