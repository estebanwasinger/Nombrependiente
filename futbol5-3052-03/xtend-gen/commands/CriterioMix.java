package commands;

import commands.CriteriosCommand;
import futbol5.Jugador;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class CriterioMix extends CriteriosCommand {
  public float evaluarCriterios(final Jugador jugador, final List<CriteriosCommand> criterios, final int n) {
    float sum = 0;
    for (final CriteriosCommand criterio : criterios) {
      Function1<? super Jugador, ? extends Float> _criterioComparacion = criterio.criterioComparacion(n);
      Float _apply = _criterioComparacion.apply(jugador);
      float _plus = (sum + (_apply).floatValue());
      sum = _plus;
    }
    int _size = criterios.size();
    return (sum / _size);
  }
  
  public List<Jugador> multiOrdenar(final List<Jugador> jugadores, final List<CriteriosCommand> criterios, final int n) {
    final Function1<Jugador, Float> _function = new Function1<Jugador, Float>() {
      public Float apply(final Jugador jugador) {
        return Float.valueOf(CriterioMix.this.evaluarCriterios(jugador, criterios, n));
      }
    };
    return IterableExtensions.<Jugador, Float>sortBy(jugadores, _function);
  }
}
