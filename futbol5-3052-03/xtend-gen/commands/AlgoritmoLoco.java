package commands;

import commands.AlgoritmosCommand;
import futbol5.Jugador;
import java.util.List;

@SuppressWarnings("all")
public class AlgoritmoLoco extends AlgoritmosCommand {
  public void dividir(final List<Jugador> jugadores, final List<Jugador> equipoA, final List<Jugador> equipoB) {
    int posA = 1;
    int posB = 2;
    boolean _while = ((posA < 9) && (posB <= 10));
    while (_while) {
      {
        Jugador _get = jugadores.get(posA);
        equipoA.add(_get);
        this.calculaPosicion(posA);
        Jugador _get_1 = jugadores.get(posB);
        equipoB.add(_get_1);
        this.calculaPosicion(posB);
      }
      _while = ((posA < 9) && (posB <= 10));
    }
  }
  
  public boolean calculaPosicion(final int pos) {
    boolean _xifexpression = false;
    boolean _esPar = super.esPar(pos);
    if (_esPar) {
      _xifexpression = (pos == (pos + 1));
    } else {
      _xifexpression = (pos == (pos + 3));
    }
    return _xifexpression;
  }
}
