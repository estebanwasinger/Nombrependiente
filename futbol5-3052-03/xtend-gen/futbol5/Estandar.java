package futbol5;

import futbol5.Jugador;
import futbol5.Partido;
import futbol5.TipoInscripcion;

@SuppressWarnings("all")
public class Estandar implements TipoInscripcion {
  public int prioridad() {
    return 1;
  }
  
  public boolean cumpleCondicion(final Jugador jugador, final Partido partido) {
    return true;
  }
}
