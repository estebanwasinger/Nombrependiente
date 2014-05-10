package observers;

import auxiliares.MessageSender;
import futbol5.Jugador;
import futbol5.Partido;
import java.util.List;
import java.util.function.Consumer;
import observers.MailObserver;
import observers.Notificacion;

@SuppressWarnings("all")
public class InscripcionObserver extends MailObserver {
  private MessageSender messageSender;
  
  public InscripcionObserver(final MessageSender unMessageSender) {
    this.messageSender = unMessageSender;
  }
  
  public Notificacion armarNotificacion(final Jugador emisor, final Jugador receptor) {
    Notificacion notificacion = new Notificacion();
    String _email = emisor.getEmail();
    notificacion.setFrom(_email);
    String _email_1 = receptor.getEmail();
    notificacion.setTo(_email_1);
    notificacion.setTitle("Inscripción de un amigo");
    notificacion.setMessage("Me inscribi al partido");
    return notificacion;
  }
  
  public void enviarNotificacion(final Partido partido, final Jugador jugador) {
    boolean _estaInscripto = partido.estaInscripto(jugador);
    if (_estaInscripto) {
      List<Jugador> _amigos = jugador.getAmigos();
      final Consumer<Jugador> _function = new Consumer<Jugador>() {
        public void accept(final Jugador amigo) {
          Notificacion _armarNotificacion = InscripcionObserver.this.armarNotificacion(jugador, amigo);
          InscripcionObserver.this.messageSender.send(_armarNotificacion);
        }
      };
      _amigos.forEach(_function);
    }
  }
}
