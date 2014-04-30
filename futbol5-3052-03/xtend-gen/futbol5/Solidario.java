package futbol5;

import futbol5.Jugador;
import futbol5.Partido;
import futbol5.TipoInscripcion;

@SuppressWarnings("all")
public class Solidario implements TipoInscripcion {
  public void inscribir(final Partido partido, final Jugador jugador) {
    int _cantJugadores = partido.cantJugadores();
    boolean _lessThan = (_cantJugadores < 10);
    if (_lessThan) {
      partido.agregarJugador(jugador);
    } else {
      Jugador _unCondicional = partido.unCondicional();
      int _posicionEnLista = partido.posicionEnLista(_unCondicional);
      boolean _notEquals = (_posicionEnLista != (-1));
      if (_notEquals) {
        Jugador _unCondicional_1 = partido.unCondicional();
        int _posicionEnLista_1 = partido.posicionEnLista(_unCondicional_1);
        partido.cambiarJugador(Integer.valueOf(_posicionEnLista_1), jugador);
      }
    }
  }
}
