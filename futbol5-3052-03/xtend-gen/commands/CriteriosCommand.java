package commands;

import futbol5.Jugador;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class CriteriosCommand {
  private int nPartidos;
  
  public Function1<? super Jugador,? extends Float> criterioComparacion(final int n) {
    return null;
  }
  
  public List<Jugador> ordenar(final List<Jugador> jugadores) {
    Function1<? super Jugador,? extends Float> _criterioComparacion = this.criterioComparacion(this.nPartidos);
    return IterableExtensions.sortBy(jugadores, _criterioComparacion);
  }
  
  public CriteriosCommand() {
  }
  
  public CriteriosCommand(final int n) {
    this.nPartidos = n;
  }
}
