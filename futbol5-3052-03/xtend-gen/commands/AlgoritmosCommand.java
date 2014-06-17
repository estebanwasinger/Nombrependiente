package commands;

import futbol5.Jugador;
import java.util.List;

@SuppressWarnings("all")
public interface AlgoritmosCommand {
  public abstract void dividir(final List<Jugador> jugadores, final List<Jugador> equipoA, final List<Jugador> equipoB);
}
