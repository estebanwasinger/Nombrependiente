package futbol5;

import futbol5.Jugador;
import futbol5.Partido;
import futbol5.TipoInscripcion;

@SuppressWarnings("all")
public class Estandar implements TipoInscripcion {
  public void inscribir(final Partido partido, final Jugador jugador) {
    int _cantJugadores = partido.cantJugadores();
    boolean _lessThan = (_cantJugadores < 10);
    if (_lessThan) {
      partido.agregarJugador(jugador);
    } else {
      Jugador _unSolidario = partido.unSolidario();
      int _posicionEnLista = partido.posicionEnLista(_unSolidario);
      boolean _notEquals = (_posicionEnLista != (-1));
      if (_notEquals) {
        Jugador _unSolidario_1 = partido.unSolidario();
        int _posicionEnLista_1 = partido.posicionEnLista(_unSolidario_1);
        partido.cambiarJugador(Integer.valueOf(_posicionEnLista_1), jugador);
      }
    }
  }
}
