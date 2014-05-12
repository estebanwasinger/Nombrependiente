package observers;

import auxiliares.MessageSender;
import futbol5.Jugador;
import futbol5.Partido;
import observers.Notificacion;

@SuppressWarnings("all")
public class PartidoObserver {
  private MessageSender messageSender;
  
  public PartidoObserver(final MessageSender unMessageSender) {
    this.messageSender = unMessageSender;
  }
  
  public void enviarNotificacion(final Notificacion notificacion) {
    this.messageSender.send(notificacion);
  }
  
  public void hacerLoSuyo(final Partido partido, final Jugador jugador) {
  }
}
