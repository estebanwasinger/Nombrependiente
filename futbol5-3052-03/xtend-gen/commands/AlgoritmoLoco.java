package commands;

import com.google.common.collect.Lists;
import commands.DivisionDeEquiposCommand;
import futbol5.Jugador;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class AlgoritmoLoco extends DivisionDeEquiposCommand {
  private List<Integer> posicionesA = Collections.<Integer>unmodifiableList(Lists.<Integer>newArrayList(Integer.valueOf(0), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(7), Integer.valueOf(8)));
  
  private List<Integer> posicionesB = Collections.<Integer>unmodifiableList(Lists.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9)));
  
  public void dividir(final List<Jugador> jugadores, final List<Jugador> equipoA, final List<Jugador> equipoB) {
    final Consumer<Integer> _function = new Consumer<Integer>() {
      public void accept(final Integer i) {
        Jugador _get = jugadores.get((i).intValue());
        equipoA.add(_get);
      }
    };
    this.posicionesA.forEach(_function);
    final Consumer<Integer> _function_1 = new Consumer<Integer>() {
      public void accept(final Integer i) {
        Jugador _get = jugadores.get((i).intValue());
        equipoB.add(_get);
      }
    };
    this.posicionesB.forEach(_function_1);
  }
}
