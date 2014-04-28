package futbol5;

import com.google.common.base.Objects;
import futbol5.Jugador;
import futbol5.Partido;
import futbol5.TipoInscripcion;
import java.util.LinkedList;

@SuppressWarnings("all")
public class Solidario implements TipoInscripcion {
  public void desplazarJugadorCondicional(final Partido partido, final Jugador jugador) {
    int posicionADesplazar = 0;
    Jugador unJugador = null;
    LinkedList<Jugador> _jugadores = partido.getJugadores();
    TipoInscripcion _tipoInscripcion = unJugador.getTipoInscripcion();
    boolean _equals = Objects.equal(_tipoInscripcion, "Condicional");
    int _indexOf = _jugadores.indexOf(Boolean.valueOf(_equals));
    posicionADesplazar = _indexOf;
    LinkedList<Jugador> _jugadores_1 = partido.getJugadores();
    _jugadores_1.set(posicionADesplazar, jugador);
  }
  
  public void inscribir(final Partido partido, final Jugador jugador) {
    LinkedList<Jugador> _jugadores = partido.getJugadores();
    int _size = _jugadores.size();
    boolean _lessThan = (_size < 10);
    if (_lessThan) {
      LinkedList<Jugador> _jugadores_1 = partido.getJugadores();
      _jugadores_1.add(jugador);
    } else {
      this.desplazarJugadorCondicional(partido, jugador);
    }
  }
}
