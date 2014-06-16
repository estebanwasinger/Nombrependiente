package commands;

import futbol5.Jugador;
import java.util.LinkedList;

@SuppressWarnings("all")
public interface AlgoritmosCommand {
  public abstract void dividir(final LinkedList<Jugador> jugadors);
}
