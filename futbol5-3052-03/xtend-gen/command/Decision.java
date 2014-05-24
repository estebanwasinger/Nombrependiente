package command;

import futbol5.Jugador;
import futbol5.Partido;

@SuppressWarnings("all")
public interface Decision {
  public abstract void registrarDecision(final Jugador jugador, final Partido partido, final String motivo);
}
