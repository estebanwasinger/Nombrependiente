package futbol5;

import futbol5.Jugador;
import futbol5.Partido;

@SuppressWarnings("all")
public interface TipoInscripcion {
  public abstract void inscribir(final Partido partido, final Jugador jugador);
}
