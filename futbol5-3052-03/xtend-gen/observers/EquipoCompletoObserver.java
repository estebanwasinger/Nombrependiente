package observers;

import auxiliares.MessageSender;
import futbol5.Administrador;
import futbol5.Jugador;
import futbol5.Partido;
import observers.Notificacion;
import observers.PartidoObserver;

@SuppressWarnings("all")
public class EquipoCompletoObserver extends PartidoObserver {
  public EquipoCompletoObserver(final MessageSender unMessageSender) {
    super(unMessageSender);
  }
  
  public void hacerLoSuyo(final Partido partido, final Jugador jugador) {
    int _cantJugadores = partido.cantJugadores();
    boolean _equals = (_cantJugadores == 10);
    if (_equals) {
      Notificacion notificacion = new Notificacion();
      String _email = jugador.getEmail();
      notificacion.setFrom(_email);
      Administrador _administrador = jugador.getAdministrador();
      String _email_1 = _administrador.getEmail();
      notificacion.setTo(_email_1);
      notificacion.setSubject("Partido confirmado");
      notificacion.setMessage("El equipo tiene 10 jugadores a la fecha");
      super.enviarNotificacion(notificacion);
    }
  }
}
