package observers;

import auxiliares.MessageSender;
import futbol5.Administrador;
import futbol5.Jugador;
import futbol5.Partido;
import observers.PartidoObserver;

@SuppressWarnings("all")
public class EquipoCompletoObserver extends PartidoObserver {
  public EquipoCompletoObserver(final MessageSender unMessageSender) {
    super(unMessageSender);
  }
  
  public void notificarInscripcion(final Partido partido, final Jugador jugador) {
    int _cantJugadores = partido.cantJugadores();
    boolean _equals = (_cantJugadores == 10);
    if (_equals) {
      Administrador _administrador = jugador.getAdministrador();
      final String adminMail = _administrador.getEmail();
      final String asunto = "Partido confirmado";
      final String mensaje = "El equipo tiene 10 jugadores a la fecha";
      super.enviarNotificacion(adminMail, asunto, mensaje);
    }
  }
}
