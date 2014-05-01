package futbol5;

import futbol5.Jugador;
import futbol5.Partido;
import futbol5.TipoInscripcion;

@SuppressWarnings("all")
public class Solidario implements TipoInscripcion {
  public int prioridad() {
    return 2;
  }
  
  public boolean cumpleCondicion(final Jugador jugador, final Partido partido) {
    return true;
  }
}
