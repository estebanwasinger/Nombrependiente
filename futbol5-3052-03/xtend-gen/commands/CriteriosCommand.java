package commands;

import futbol5.Jugador;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class CriteriosCommand {
  private Function1<? super Jugador, ? extends Integer> _criterio;
  
  public Function1<? super Jugador, ? extends Integer> getCriterio() {
    return this._criterio;
  }
  
  public void setCriterio(final Function1<? super Jugador, ? extends Integer> criterio) {
    this._criterio = criterio;
  }
  
  public void criterioComparacion() {
  }
  
  public List<Jugador> ordenar(final List<Jugador> jugadores) {
    this.criterioComparacion();
    Function1<? super Jugador, ? extends Integer> _criterio = this.getCriterio();
    return IterableExtensions.sortBy(jugadores, _criterio);
  }
}
