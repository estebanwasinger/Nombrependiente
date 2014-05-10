package inscripciones;

import futbol5.Jugador;
import futbol5.Partido;
import inscripciones.TipoInscripcion;

@SuppressWarnings("all")
public class Solidario implements TipoInscripcion {
  public int prioridad() {
    return 2;
  }
  
  public boolean cumpleCondicion(final Jugador jugador, final Partido partido) {
    return true;
  }
}
