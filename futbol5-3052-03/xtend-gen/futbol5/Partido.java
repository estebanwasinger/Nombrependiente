package futbol5;

import futbol5.BusinessException;
import futbol5.Jugador;
import java.util.LinkedList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Partido {
  private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
  
  public int cantJugadores() {
    return this.jugadores.size();
  }
  
  public void agregarJugador(final Jugador jugadorAInscribir) {
    this.jugadores.add(jugadorAInscribir);
  }
  
  public void cambiarJugador(final Integer posicionAGuardar, final Jugador jugador) {
    this.jugadores.set((posicionAGuardar).intValue(), jugador);
  }
  
  public int posicionEnLista(final Jugador jugador) {
    return this.jugadores.indexOf(jugador);
  }
  
  public boolean estaInscripto(final Jugador jugador) {
    return this.jugadores.contains(jugador);
  }
  
  public void inscribir(final Jugador jugador) {
    try {
      boolean _estaInscripto = this.estaInscripto(jugador);
      if (_estaInscripto) {
        throw new BusinessException("El jugador ya se inscribió");
      }
      int _cantJugadores = this.cantJugadores();
      boolean _lessThan = (_cantJugadores < 10);
      if (_lessThan) {
        this.agregarJugador(jugador);
        return;
      }
      final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
        public Boolean apply(final Jugador inscripto) {
          return Boolean.valueOf(jugador.tieneMasPrioridadQue(inscripto));
        }
      };
      boolean _exists = IterableExtensions.<Jugador>exists(this.jugadores, _function);
      boolean _not = (!_exists);
      if (_not) {
        throw new BusinessException("No hay más cupo");
      }
      final Function1<Jugador,Boolean> _function_1 = new Function1<Jugador,Boolean>() {
        public Boolean apply(final Jugador unJugador) {
          int _prioridad = unJugador.prioridad();
          int _prioridad_1 = jugador.prioridad();
          return Boolean.valueOf((_prioridad > _prioridad_1));
        }
      };
      Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(this.jugadores, _function_1);
      final Jugador quien = IterableExtensions.<Jugador>head(_filter);
      this.jugadores.remove(quien);
      this.agregarJugador(jugador);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
