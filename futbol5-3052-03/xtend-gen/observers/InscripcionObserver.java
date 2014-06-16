package observers;

import auxiliares.MessageSender;
import futbol5.Jugador;
import futbol5.Partido;
import java.util.List;
import observers.PartidoObserver;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
    final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
      public void apply(final Jugador amigo) {
        InscripcionObserver.this.avisarle(jugador, amigo);
      }
    };
    IterableExtensions.<Jugador>forEach(_amigos, _function);
  }
}
