package commands;

import futbol5.Jugador;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class CriteriosCommand {
  public Function1<? super Jugador,? extends Float> criterioComparacion() {
    return null;
  }
  
  public List<Jugador> ordenar(final List<Jugador> jugadores) {
    Function1<? super Jugador,? extends Float> _criterioComparacion = this.criterioComparacion();
    return IterableExtensions.sortBy(jugadores, _criterioComparacion);
  }
  
  public CriteriosCommand() {
  }
}
