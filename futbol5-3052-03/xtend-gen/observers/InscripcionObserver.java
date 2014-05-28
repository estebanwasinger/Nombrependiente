package observers;

import auxiliares.MessageSender;
import futbol5.Jugador;
import futbol5.Partido;
import java.util.List;
import java.util.function.Consumer;
import observers.PartidoObserver;

@SuppressWarnings("all")
public class InscripcionObserver extends PartidoObserver {
  public InscripcionObserver(final MessageSender unMessageSender) {
    super(unMessageSender);
  }
  
  public void avisarle(final Jugador emisor, final Jugador receptor) {
    final String asunto = "Inscripcion de un amigo";
    String _email = emisor.getEmail();
    final String mensaje = (_email + "se inscribio al partido");
    String _email_1 = receptor.getEmail();
    this.enviarNotificacion(_email_1, asunto, mensaje);
  }
  
  public void notificarInscripcion(final Partido partido, final Jugador jugador) {
    List<Jugador> _amigos = jugador.getAmigos();
    final Consumer<Jugador> _function = new Consumer<Jugador>() {
      public void accept(final Jugador amigo) {
        InscripcionObserver.this.avisarle(jugador, amigo);
      }
    };
    _amigos.forEach(_function);
  }
}
