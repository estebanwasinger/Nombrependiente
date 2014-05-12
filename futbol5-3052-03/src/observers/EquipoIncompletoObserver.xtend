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
  	    	var Notificacion notificacion = new Notificacion
 	     	notificacion.from = jugador.email
  	    	notificacion.to = jugador.administrador.email
  	    	notificacion.subject = "Partido incompleto"
   		   	notificacion.message = "Se dio de baja un jugador del partido y no dejo un reemplazo. El equipo esta incompleto (9 jugadores)"
       	
        super.enviarNotificacion(notificacion)
        }
     }
}