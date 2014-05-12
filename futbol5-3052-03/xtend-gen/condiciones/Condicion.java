package condiciones;

import futbol5.Jugador;
import futbol5.Partido;

@SuppressWarnings("all")
public interface Condicion {
  public abstract boolean seCumple(final Jugador jugador, final Partido partido);
}
