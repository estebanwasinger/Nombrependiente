package observers

import futbol5.Partido
import futbol5.Jugador
import auxiliares.MessageSender

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