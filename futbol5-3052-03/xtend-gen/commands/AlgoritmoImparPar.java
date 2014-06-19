package commands;

import commands.DivisionDeEquiposCommand;
import futbol5.Jugador;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@SuppressWarnings("all")
public class AlgoritmoImparPar extends DivisionDeEquiposCommand {
  public void dividir(final List<Jugador> jugadores, final List<Jugador> equipoA, final List<Jugador> equipoB) {
    IntegerRange _upTo = new IntegerRange(0, 9);
    final Consumer<Integer> _function = new Consumer<Integer>() {
      public void accept(final Integer pos) {
        boolean _esPar = AlgoritmoImparPar.this.esPar(((pos).intValue() + 1));
        if (_esPar) {
          Jugador _get = jugadores.get((pos).intValue());
          equipoA.add(_get);
        } else {
          Jugador _get_1 = jugadores.get((pos).intValue());
          equipoB.add(_get_1);
        }
      }
    };
    _upTo.forEach(_function);
  }
}
