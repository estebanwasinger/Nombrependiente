package observers

import auxiliares.MessageSender
import futbol5.Partido
import futbol5.Jugador

class EquipoCompletoObserver extends NotificacionObserver{
	MessageSender messageSender
	
	new(MessageSender unMessageSender) {
		messageSender = unMessageSender
	}
	
	override enviarNotificacion(Partido partido, Jugador jugador){
        if (partido.cantJugadores==10){
        	var Notificacion notificacion = new Notificacion
        	notificacion.from = "info@opf5.net"
        	notificacion.to = partido.administrador.email
        	notificacion.subject = "Partido confirmado"
        	notificacion.message = "El equipo tiene 10 jugadores a la fecha"
        	
        	messageSender.send (notificacion)
        }
        
        if (partido.	previamenteCompleto){
        	var Notificacion notificacion = new Notificacion
        	notificacion.from = "info@opf5.net"
        	notificacion.to = partido.administrador.email
        	notificacion.subject = "Partido incompleto"
        	notificacion.message = "Se dio de baja un jugador del partido y no dejo un reemplazo. El equipo esta incompleto (9 jugadores)"
        	
        	messageSender.send (notificacion)
        }
        
	}

}