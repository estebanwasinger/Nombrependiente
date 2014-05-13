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
    List<Jugador> _amigos = jugador.getAmigos();
    this.notificarAmigos(jugador, _amigos);
  }
  
  public void notificarAmigos(final Jugador jugador, final List<Jugador> jugadores) {
    final Consumer<Jugador> _function = new Consumer<Jugador>() {
      public void accept(final Jugador jugadorAmigo) {
        NotificationSender _notificationSender = NotificarAmigosDecorator.this.getNotificationSender();
        Notificacion _notificacion = new Notificacion("Amigo", "Jugador", "Asunto", "Contenido");
        _notificationSender.send(_notificacion);
      }
    };
    jugadores.forEach(_function);
  }
}
