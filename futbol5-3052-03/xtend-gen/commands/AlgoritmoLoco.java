package commands;

import commands.AlgoritmosCommand;
import futbol5.Jugador;
import java.util.List;

@SuppressWarnings("all")
public class AlgoritmoLoco extends AlgoritmosCommand {
  public void dividir(final List<Jugador> jugadores, final List<Jugador> equipoA, final List<Jugador> equipoB) {
    int posA = 0;
    int posB = 1;
    boolean _while = ((posA < 9) && (posB < 10));
    while (_while) {
      {
        Jugador _get = jugadores.get(posA);
        equipoA.add(_get);
        int _calculaPosicion = this.calculaPosicion(posA);
        posA = _calculaPosicion;
        Jugador _get_1 = jugadores.get(posB);
        equipoB.add(_get_1);
        int _calculaPosicion_1 = this.calculaPosicion(posB);
        posB = _calculaPosicion_1;
      }
      _while = ((posA < 9) && (posB < 10));
    }
  }
  
  public int calculaPosicion(final int pos) {
    boolean _esPar = super.esPar(pos);
    if (_esPar) {
      return (pos + 1);
    } else {
      return (pos + 3);
    }
  }
}
