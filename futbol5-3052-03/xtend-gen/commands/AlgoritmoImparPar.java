package commands;

import commands.AlgoritmosCommand;
import futbol5.Jugador;
import java.util.List;

@SuppressWarnings("all")
public class AlgoritmoImparPar implements AlgoritmosCommand {
  public void dividir(final List<Jugador> jugadores, final List<Jugador> equipoA, final List<Jugador> equipoB) {
    int pos = 1;
    boolean _while = (pos <= 10);
    while (_while) {
      {
        if (((pos % 2) == 0)) {
          Jugador _get = jugadores.get(pos);
          equipoA.add(_get);
        } else {
          Jugador _get_1 = jugadores.get(pos);
          equipoB.add(_get_1);
        }
        pos = (pos + 1);
      }
      _while = (pos <= 10);
    }
  }
}
