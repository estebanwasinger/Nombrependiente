package decoradores;

import decoradores.PartidoDecorator;
import futbol5.InterfazPartido;
import futbol5.Jugador;
import java.util.List;

@SuppressWarnings("all")
public class NotificarAmigosDecorator extends PartidoDecorator {
  public NotificarAmigosDecorator(final InterfazPartido partido) {
    super(partido);
  }
  
  public void inscribir(final Jugador jugador) {
    InterfazPartido _decorado = this.getDecorado();
    _decorado.inscribir(jugador);
    List<Jugador> _amigos = jugador.getAmigos();
    this.notificarAmigos(_amigos);
  }
  
  public Object notificarAmigos(final List<Jugador> jugadors) {
    return null;
  }
}
