package observers;

import auxiliares.MessageSender;
import futbol5.Administrador;
import futbol5.Jugador;
import futbol5.Partido;
import observers.Notificacion;
import observers.PartidoObserver;

@SuppressWarnings("all")
public class EquipoIncompletoObserver extends PartidoObserver {
  public EquipoIncompletoObserver(final MessageSender unMessageSender) {
    super(unMessageSender);
  }
  
  public void hacerLoSuyo(final Partido partido, final Jugador jugador) {
    int _cantJugadores = partido.cantJugadores();
    boolean _equals = (_cantJugadores == 9);
    if (_equals) {
      Notificacion notificacion = new Notificacion();
      String _email = jugador.getEmail();
      notificacion.setFrom(_email);
      Administrador _administrador = jugador.getAdministrador();
      String _email_1 = _administrador.getEmail();
      notificacion.setTo(_email_1);
      notificacion.setSubject("Partido incompleto");
      notificacion.setMessage("Se dio de baja un jugador del partido y no dejo un reemplazo. El equipo esta incompleto (9 jugadores)");
      super.enviarNotificacion(notificacion);
    }
  }
}
