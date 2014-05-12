package observers;

import auxiliares.MessageSender;
import futbol5.Jugador;
import futbol5.Partido;
import java.util.List;
import java.util.function.Consumer;
import observers.Notificacion;
import observers.PartidoObserver;

@SuppressWarnings("all")
public class InscripcionObserver extends PartidoObserver {
  public InscripcionObserver(final MessageSender unMessageSender) {
    super(unMessageSender);
  }
  
  public void avisarle(final Jugador emisor, final Jugador receptor) {
    Notificacion notificacion = new Notificacion();
    String _email = emisor.getEmail();
    notificacion.setFrom(_email);
    String _email_1 = receptor.getEmail();
    notificacion.setTo(_email_1);
    notificacion.setSubject("Inscripción de un amigo");
    notificacion.setMessage("Me inscribi al partido");
    super.enviarNotificacion(notificacion);
  }
  
  public void hacerLoSuyo(final Partido partido, final Jugador jugador) {
    List<Jugador> _amigos = jugador.getAmigos();
    final Consumer<Jugador> _function = new Consumer<Jugador>() {
      public void accept(final Jugador amigo) {
        InscripcionObserver.this.avisarle(jugador, amigo);
      }
    };
    _amigos.forEach(_function);
  }
}
