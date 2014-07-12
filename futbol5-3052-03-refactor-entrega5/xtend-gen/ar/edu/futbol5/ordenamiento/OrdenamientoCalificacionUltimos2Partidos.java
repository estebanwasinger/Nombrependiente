package ar.edu.futbol5.ordenamiento;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.Partido;
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class OrdenamientoCalificacionUltimos2Partidos implements CriterioOrdenamiento {
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
        double _xblockexpression = (double) 0;
        {
          List<Double> _puntajes = jugador.getPuntajes();
          Double[] _clone = ((Double[])Conversions.unwrapArray(_puntajes, Double.class)).clone();
          List _reverse = ListExtensions.<Object>reverse(((List)Conversions.doWrapArray(_clone)));
          Iterable _take = IterableExtensions.<Object>take(_reverse, 2);
          final List misPuntajes = IterableExtensions.<Object>toList(_take);
          final Function2<Object, String, String> _function = new Function2<Object, String, String>() {
            public String apply(final Object acum, final String puntaje) {
              return (acum + puntaje);
            }
          };
          Double _fold = IterableExtensions.<Object, Double>fold(misPuntajes, Double.valueOf(0d), _function);
          int _size = misPuntajes.size();
          final double promedio = ((_fold).doubleValue() / _size);
          _xblockexpression = promedio;
        }
        return Double.valueOf(_xblockexpression);
      }
    };
    return _function;
  }
}
