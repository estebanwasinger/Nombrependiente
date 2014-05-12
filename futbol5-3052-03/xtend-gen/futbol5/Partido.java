package futbol5;

import excepciones.BusinessException;
import futbol5.Administrador;
import futbol5.InterfazPartido;
import futbol5.Jugador;
import inscripciones.TipoInscripcion;
import java.util.LinkedList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Partido implements InterfazPartido {
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
  
  private Administrador _administrador;
  
  public Administrador getAdministrador() {
    return this._administrador;
  }
  
  public void setAdministrador(final Administrador administrador) {
    this._administrador = administrador;
  }
  
  private boolean _previamenteCompleto;
  
  public boolean isPreviamenteCompleto() {
    return this._previamenteCompleto;
  }
  
  public void setPreviamenteCompleto(final boolean previamenteCompleto) {
    this._previamenteCompleto = previamenteCompleto;
  }
  
  public Partido(final String localidad) {
    this.setLocalidad(localidad);
    LinkedList<Jugador> _linkedList = new LinkedList<Jugador>();
    this.setJugadores(_linkedList);
    Administrador _instance = Administrador.getInstance();
    this.setAdministrador(_instance);
    this.setPreviamenteCompleto(false);
  }
  
  public int cantJugadores() {
    LinkedList<Jugador> _jugadores = this.getJugadores();
    return _jugadores.size();
  }
  
  public void agregarJugador(final Jugador jugador) {
    LinkedList<Jugador> _jugadores = this.getJugadores();
    _jugadores.add(jugador);
  }
  
  public void eliminarJugador(final Jugador jugador) {
    LinkedList<Jugador> _jugadores = this.getJugadores();
    _jugadores.remove(jugador);
  }
  
  public boolean estaInscripto(final Jugador jugador) {
    LinkedList<Jugador> _jugadores = this.getJugadores();
    return _jugadores.contains(jugador);
  }
  
  public void bajaConReemplazo(final Jugador jugador, final Jugador reemplazo) {
    try {
      boolean _estaInscripto = this.estaInscripto(jugador);
      boolean _not = (!_estaInscripto);
      if (_not) {
        throw new BusinessException("El jugador no est� inscripto en este partido, no se puede dar de baja");
      }
      boolean _estaInscripto_1 = this.estaInscripto(reemplazo);
      if (_estaInscripto_1) {
        throw new BusinessException("El reemplazo ya est� inscripto en el partido");
      }
      this.eliminarJugador(jugador);
      this.inscribir(reemplazo);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void bajaSinReemplazo(final Jugador jugador) {
    try {
      boolean _estaInscripto = this.estaInscripto(jugador);
      boolean _not = (!_estaInscripto);
      if (_not) {
        throw new BusinessException("El jugador no est� inscripto en este partido, no se puede dar de baja");
      }
      int _cantJugadores = this.cantJugadores();
      boolean _equals = (_cantJugadores == 10);
      if (_equals) {
        this.setPreviamenteCompleto(true);
      }
      LinkedList<Jugador> _jugadores = this.getJugadores();
      _jugadores.remove(jugador);
      jugador.nuevaInfraccion();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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
