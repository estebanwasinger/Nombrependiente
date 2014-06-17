package commands;

import commands.CriteriosCommand;
import futbol5.Jugador;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class CriterioHandicap extends CriteriosCommand {
  public void criterioComparacion() {
    final Function1<Jugador, Integer> _function = new Function1<Jugador, Integer>() {
      public Integer apply(final Jugador jugador) {
        return Integer.valueOf(jugador.getNivelDeJuego());
      }
    };
    this.setCriterio(_function);
  }
}
