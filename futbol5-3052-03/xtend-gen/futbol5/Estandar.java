package futbol5;

import com.google.common.base.Objects;
import futbol5.Jugador;
import futbol5.Partido;
import futbol5.TipoInscripcion;
import java.util.LinkedList;

@SuppressWarnings("all")
public class Estandar implements TipoInscripcion {
  public void desplazarJugadorCondicionalOSolidario(final Partido partido, final Jugador jugador) {
    int posicionADesplazar = 0;
    Jugador unJugador = null;
    LinkedList<Jugador> _jugadores = partido.getJugadores();
    TipoInscripcion _tipoInscripcion = unJugador.getTipoInscripcion();
    boolean _equals = Objects.equal(_tipoInscripcion, "Condicional");
    boolean _contains = _jugadores.contains(Boolean.valueOf(_equals));
    if (_contains) {
      LinkedList<Jugador> _jugadores_1 = partido.getJugadores();
      TipoInscripcion _tipoInscripcion_1 = unJugador.getTipoInscripcion();
      boolean _equals_1 = Objects.equal(_tipoInscripcion_1, "Condicional");
      int _indexOf = _jugadores_1.indexOf(Boolean.valueOf(_equals_1));
      posicionADesplazar = _indexOf;
      LinkedList<Jugador> _jugadores_2 = partido.getJugadores();
      _jugadores_2.set(posicionADesplazar, jugador);
    } else {
      LinkedList<Jugador> _jugadores_3 = partido.getJugadores();
      TipoInscripcion _tipoInscripcion_2 = unJugador.getTipoInscripcion();
      boolean _equals_2 = Objects.equal(_tipoInscripcion_2, "Solidario");
      int _indexOf_1 = _jugadores_3.indexOf(Boolean.valueOf(_equals_2));
      posicionADesplazar = _indexOf_1;
      LinkedList<Jugador> _jugadores_4 = partido.getJugadores();
      _jugadores_4.set(posicionADesplazar, jugador);
    }
  }
  
  public void inscribir(final Partido partido, final Jugador jugador) {
    LinkedList<Jugador> _jugadores = partido.getJugadores();
    int _size = _jugadores.size();
    boolean _lessThan = (_size < 10);
    if (_lessThan) {
      LinkedList<Jugador> _jugadores_1 = partido.getJugadores();
      _jugadores_1.add(jugador);
    } else {
      this.desplazarJugadorCondicionalOSolidario(partido, jugador);
    }
  }
}
