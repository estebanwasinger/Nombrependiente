package commands;

import commands.CriteriosCommand;
import futbol5.Jugador;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class CriterioCalifiUltimoPartido extends CriteriosCommand {
  public CriterioCalifiUltimoPartido(final int n) {
    super(n);
  }
  
  public CriterioCalifiUltimoPartido() {
  }
  
  public Function1<? super Jugador, ? extends Float> criterioComparacion(final int n) {
    final Function1<Jugador, Float> _function = new Function1<Jugador, Float>() {
      public Float apply(final Jugador jugador) {
        return Float.valueOf(jugador.promedioCalificacionesUltimoPartido());
      }
    };
    return _function;
  }
}
