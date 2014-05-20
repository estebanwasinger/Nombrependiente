package inscripciones;

import futbol5.Jugador;
import futbol5.Partido;

@SuppressWarnings("all")
public interface TipoInscripcion {
  public abstract int prioridad();
  
  public abstract boolean cumpleCondicion(final Jugador jugador, final Partido partido);
}
