package inscripciones;

import futbol5.Jugador;
import futbol5.Partido;
import inscripciones.TipoInscripcion;

@SuppressWarnings("all")
public class Estandar implements TipoInscripcion {
  public int prioridad() {
    return 1;
  }
  
  public boolean cumpleCondicion(final Jugador jugador, final Partido partido) {
    return true;
  }
}
