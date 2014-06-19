package commands;

import commands.CriteriosCommand;
import excepciones.BusinessException;
import futbol5.Jugador;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class CriterioHandicap extends CriteriosCommand {
  public Function1<? super Jugador,? extends Float> criterioComparacion() {
    final Function1<Jugador,Float> _function = new Function1<Jugador,Float>() {
      public Float apply(final Jugador jugador) {
        return Float.valueOf(jugador.getNivelDeJuego());
      }
    };
    return _function;
  }
  
  public List<Jugador> ordenar(final List<Jugador> jugadores) {
    try {
      List<Jugador> _xblockexpression = null;
      {
        final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
          public Boolean apply(final Jugador jugador) {
            float _nivelDeJuego = jugador.getNivelDeJuego();
            return Boolean.valueOf((_nivelDeJuego == 0));
          }
        };
        boolean _exists = IterableExtensions.<Jugador>exists(jugadores, _function);
        if (_exists) {
          throw new BusinessException("No todos los jugadores tienen un nivel de juego asignado");
        }
        _xblockexpression = super.ordenar(jugadores);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
