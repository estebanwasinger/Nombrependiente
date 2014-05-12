package futbol5;

import futbol5.Jugador;

@SuppressWarnings("all")
public interface InterfazPartido {
  public abstract int cantJugadores();
  
  public abstract void bajaSinReemplazo(final Jugador jugador);
  
  public abstract void inscribir(final Jugador jugador);
}
