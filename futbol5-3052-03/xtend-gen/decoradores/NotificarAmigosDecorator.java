package decoradores;

import decoradores.PartidoDecorator;
import futbol5.InterfazPartido;
import futbol5.Jugador;
import helper.Notificacion;
import helper.NotificationSender;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class NotificarAmigosDecorator extends PartidoDecorator {
  public NotificarAmigosDecorator(final InterfazPartido partido, final NotificationSender nuevoNotificationSender) {
    super(partido, nuevoNotificationSender);
  }
  
  public void inscribir(final Jugador jugador) {
    InterfazPartido _decorado = this.getDecorado();
    _decorado.inscribir(jugador);
    this.notificarAmigos(jugador);
  }
  
  public void notificarAmigos(final Jugador jugador) {
    List<Jugador> _amigos = jugador.getAmigos();
    final Consumer<Jugador> _function = new Consumer<Jugador>() {
      public void accept(final Jugador jugadorAmigo) {
        NotificationSender _notificationSender = NotificarAmigosDecorator.this.getNotificationSender();
        String _nombre = jugador.getNombre();
        String _nombre_1 = jugadorAmigo.getNombre();
        String _nombre_2 = jugadorAmigo.getNombre();
        String _plus = ("Hola " + _nombre_2);
        String _plus_1 = (_plus + ",les queremos notificar que su amigo ");
        String _nombre_3 = jugador.getNombre();
        String _plus_2 = (_plus_1 + _nombre_3);
        String _plus_3 = (_plus_2 + " se ha inscripto a un partido");
        Notificacion _notificacion = new Notificacion(_nombre, _nombre_1, "Un amigo tuyo se inscribio a un partido", _plus_3);
        _notificationSender.send(_notificacion);
      }
    };
    _amigos.forEach(_function);
  }
}
