package commands;

import commands.CriteriosCommand;
import futbol5.Jugador;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class CriterioMix extends CriteriosCommand {
  private List<CriteriosCommand> criterios;
  
  public CriterioMix(final List<CriteriosCommand> criterios) {
    this.criterios = criterios;
  }
  
  public Function1<? super Jugador,? extends Float> criterioComparacion() {
    final Function1<Jugador,Float> _function = new Function1<Jugador,Float>() {
      public Float apply(final Jugador jugador) {
        final Function2<Float,CriteriosCommand,Float> _function = new Function2<Float,CriteriosCommand,Float>() {
          public Float apply(final Float acum, final CriteriosCommand criterio) {
            Function1<? super Jugador,? extends Float> _criterioComparacion = criterio.criterioComparacion();
            Float _apply = _criterioComparacion.apply(jugador);
            return Float.valueOf(((acum).floatValue() + (_apply).floatValue()));
          }
        };
        Float _fold = IterableExtensions.<CriteriosCommand, Float>fold(CriterioMix.this.criterios, Float.valueOf(0f), _function);
        int _size = CriterioMix.this.criterios.size();
        return Float.valueOf(((_fold).floatValue() / _size));
      }
    };
    return _function;
  }
}
