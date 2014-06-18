package commands;

import futbol5.Jugador;
import java.util.List;

@SuppressWarnings("all")
public abstract class AlgoritmosCommand {
  public abstract void dividir(final List<Jugador> jugadores, final List<Jugador> equipoA, final List<Jugador> equipoB);
  
  public boolean esPar(final int pos) {
    return ((pos % 2) == 0);
  }
}
