package observers;

import auxiliares.MessageSender;
import futbol5.Administrador;
import futbol5.Jugador;
import futbol5.Partido;
import observers.PartidoObserver;

@SuppressWarnings("all")
public class EquipoIncompletoObserver extends PartidoObserver {
  public EquipoIncompletoObserver(final MessageSender unMessageSender) {
    super(unMessageSender);
  }
  
  public void notificarBaja(final Partido partido, final Jugador jugador, final Jugador reemplazo) {
    int _cantJugadores = partido.cantJugadores();
    boolean _equals = (_cantJugadores == 9);
    if (_equals) {
      Administrador _administrador = jugador.getAdministrador();
      final String adminMail = _administrador.getEmail();
      final String asunto = "Partido incompleto";
      final String mensaje = "Se dio de baja un jugador del partido y no dejo un reemplazo. El equipo esta incompleto (9 jugadores)";
      super.enviarNotificacion(adminMail, asunto, mensaje);
    }
  }
}
