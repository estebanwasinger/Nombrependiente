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
  
  public void enviarNotificacion(final String para, final String asunto, final String mensaje) {
    Notificacion notificacion = new Notificacion();
    notificacion.setFrom("info@organizacionpartido5.com.ar");
    notificacion.setTo(para);
    notificacion.setSubject(asunto);
    notificacion.setMessage(mensaje);
    this.messageSender.send(notificacion);
  }
  
  public void notificarBaja(final Partido partido, final Jugador jugador, final Jugador reemplazo) {
  }
  
  public void notificarInscripcion(final Partido partido, final Jugador jugador) {
  }
}
