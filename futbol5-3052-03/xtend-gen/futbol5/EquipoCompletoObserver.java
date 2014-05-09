package futbol5;

import futbol5.Administrador;
import futbol5.Jugador;
import futbol5.MailObserver;
import futbol5.MessageSender;
import futbol5.Notificacion;
import futbol5.Partido;

@SuppressWarnings("all")
public class EquipoCompletoObserver extends MailObserver {
  private MessageSender messageSender;
  
  public EquipoCompletoObserver(final MessageSender unMessageSender) {
    this.messageSender = unMessageSender;
  }
  
  public void enviarNotificacion(final Partido partido, final Jugador jugador) {
    int _cantJugadores = partido.cantJugadores();
    boolean _equals = (_cantJugadores == 10);
    if (_equals) {
      Notificacion notificacion = new Notificacion();
      notificacion.setFrom("info@opf5.com.ar");
      Administrador _administrador = partido.getAdministrador();
      String _email = _administrador.getEmail();
      notificacion.setTo(_email);
      notificacion.setTitle("Partido confirmado");
      notificacion.setMessage("El equipo tiene 10 jugadores a la fecha");
      this.messageSender.send(notificacion);
    }
    boolean _isPreviamenteCompleto = partido.isPreviamenteCompleto();
    if (_isPreviamenteCompleto) {
      Notificacion notificacion_1 = new Notificacion();
      notificacion_1.setFrom("info@opf5.com.ar");
      Administrador _administrador_1 = partido.getAdministrador();
      String _email_1 = _administrador_1.getEmail();
      notificacion_1.setTo(_email_1);
      notificacion_1.setTitle("Partido incompleto");
      notificacion_1.setMessage("Se dio de baja un jugador del partido y no dejo un reemplazo. El equipo esta incompleto (9 jugadores)");
      this.messageSender.send(notificacion_1);
    }
  }
}
