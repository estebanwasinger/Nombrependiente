package ar.edu.futbol5.ordenamiento;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.Partido;
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class OrdenamientoPorHandicap implements CriterioOrdenamiento {
  public List<Jugador> ordenar(final Partido partido) {
    List<Jugador> _inscriptos = partido.getInscriptos();
    Function1<? super Jugador, ? extends Double> _calcularValor = this.calcularValor();
    List _sortBy = IterableExtensions.<Object, Comparable>sortBy(_inscriptos, _calcularValor);
    Object[] _clone = ((Object[])Conversions.unwrapArray(_sortBy, Object.class)).clone();
    return ListExtensions.<Object>reverse(((List)Conversions.doWrapArray(_clone)));
  }
  
  public Function1<? super Jugador, ? extends Double> calcularValor() {
    final Function1<Jugador, Double> _function = new Function1<Jugador, Double>() {
      public Double apply(final Jugador jugador) {
        return jugador.getCalificacion();
      }
    };
    return _function;
  }
}
