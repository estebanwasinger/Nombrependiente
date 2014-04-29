package futbol5;

import futbol5.Jugador;
import futbol5.Partido;
import futbol5.TipoInscripcion;

@SuppressWarnings("all")
public class Solidario implements TipoInscripcion {
  /**
   * def void desplazarJugadorCondicional(Partido partido, Jugador jugador){
   * var int posicionADesplazar = 0
   * var Jugador unJugador = null
   * 
   * posicionADesplazar = partido.jugadores.indexOf(unJugador.tipoInscripcion=="Condicional")
   * partido.jugadores.set(posicionADesplazar, jugador)
   * }
   */
  public void inscribir(final Partido partido, final Jugador jugador) {
    int _cantJugadores = partido.cantJugadores();
    boolean _lessThan = (_cantJugadores < 10);
    if (_lessThan) {
      partido.agregarJugador(jugador);
    }
  }
}
