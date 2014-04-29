package futbol5;

import futbol5.Jugador;
import futbol5.Partido;
import futbol5.TipoInscripcion;

@SuppressWarnings("all")
public class Condicional implements TipoInscripcion {
  public void inscribir(final Partido partido, final Jugador jugador) {
    int _cantJugadores = partido.cantJugadores();
    boolean _lessThan = (_cantJugadores < 10);
    if (_lessThan) {
      partido.agregarJugador(jugador);
    }
  }
}
