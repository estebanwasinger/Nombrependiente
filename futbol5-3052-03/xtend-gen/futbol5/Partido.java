package futbol5;

import futbol5.BusinessException;
import futbol5.Jugador;
import futbol5.TipoInscripcion;
import java.util.LinkedList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Partido {
  private String _localidad;
  
  public String getLocalidad() {
    return this._localidad;
  }
  
  public void setLocalidad(final String localidad) {
    this._localidad = localidad;
  }
  
  private LinkedList<Jugador> _jugadores;
  
  public LinkedList<Jugador> getJugadores() {
    return this._jugadores;
  }
  
  public void setJugadores(final LinkedList<Jugador> jugadores) {
    this._jugadores = jugadores;
  }
  
  public Partido(final String localidad) {
    this.setLocalidad(localidad);
    LinkedList<Jugador> _linkedList = new LinkedList<Jugador>();
    this.setJugadores(_linkedList);
  }
  
  public int cantJugadores() {
    LinkedList<Jugador> _jugadores = this.getJugadores();
    return _jugadores.size();
  }
  
  public void agregarJugador(final Jugador jugador) {
    LinkedList<Jugador> _jugadores = this.getJugadores();
    _jugadores.add(jugador);
  }
  
  public boolean estaInscripto(final Jugador jugador) {
    LinkedList<Jugador> _jugadores = this.getJugadores();
    return _jugadores.contains(jugador);
  }
  
  public void inscribir(final Jugador jugador) {
    try {
      boolean _estaInscripto = this.estaInscripto(jugador);
      if (_estaInscripto) {
        throw new BusinessException("El jugador ya se inscribi�");
      }
      TipoInscripcion _tipoInscripcion = jugador.getTipoInscripcion();
      boolean _cumpleCondicion = _tipoInscripcion.cumpleCondicion(jugador, this);
      boolean _not = (!_cumpleCondicion);
      if (_not) {
        throw new BusinessException("El jugador no cumple con la condici�n, no se puede inscribir");
      }
      int _cantJugadores = this.cantJugadores();
      boolean _lessThan = (_cantJugadores < 10);
      if (_lessThan) {
        this.agregarJugador(jugador);
        return;
      }
      LinkedList<Jugador> _jugadores = this.getJugadores();
      final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
        public Boolean apply(final Jugador inscripto) {
          return Boolean.valueOf(jugador.tieneMasPrioridadQue(inscripto));
        }
      };
      boolean _exists = IterableExtensions.<Jugador>exists(_jugadores, _function);
      boolean _not_1 = (!_exists);
      if (_not_1) {
        throw new BusinessException("No hay m�s cupo");
      }
      LinkedList<Jugador> _jugadores_1 = this.getJugadores();
      final Function1<Jugador,Boolean> _function_1 = new Function1<Jugador,Boolean>() {
        public Boolean apply(final Jugador unJugador) {
          int _prioridad = unJugador.prioridad();
          int _prioridad_1 = jugador.prioridad();
          return Boolean.valueOf((_prioridad > _prioridad_1));
        }
      };
      Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(_jugadores_1, _function_1);
      final Jugador quien = IterableExtensions.<Jugador>head(_filter);
      LinkedList<Jugador> _jugadores_2 = this.getJugadores();
      _jugadores_2.remove(quien);
      this.agregarJugador(jugador);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
