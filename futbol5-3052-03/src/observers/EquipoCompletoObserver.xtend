package observers

import futbol5.Partido
import futbol5.Jugador
import auxiliares.MessageSender

class EquipoCompletoObserver extends PartidoObserver{
	
	new(MessageSender unMessageSender) {
		super(unMessageSender)
	}
	
	override hacerLoSuyo(Partido partido, Jugador jugador){
        if (partido.cantJugadores==10){
        	var Notificacion notificacion = new Notificacion
        	notificacion.from = jugador.email
        	notificacion.to = jugador.administrador.email
        	notificacion.subject = "Partido confirmado"
        	notificacion.message = "El equipo tiene 10 jugadores a la fecha"
        	
        	super.enviarNotificacion(notificacion)
        }
       
	}

}