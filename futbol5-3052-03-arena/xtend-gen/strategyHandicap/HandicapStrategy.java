package strategyHandicap;

import futbol5.domain.Jugador;

@SuppressWarnings("all")
public interface HandicapStrategy {
  public abstract boolean calcular(final Jugador jugadorEnLista, final Integer handicapHasta);
  
  public abstract String toString();
}
