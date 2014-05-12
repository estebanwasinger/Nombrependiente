package futbol5;

import com.google.common.base.Objects;
import excepciones.BusinessException;
import futbol5.Administrador;
import futbol5.Jugador;
import inscripciones.TipoInscripcion;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import observers.PartidoObserver;
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
  
  private List<PartidoObserver> _altasObservers;
  
  public List<PartidoObserver> getAltasObservers() {
    return this._altasObservers;
  }
  
  public void setAltasObservers(final List<PartidoObserver> altasObservers) {
    this._altasObservers = altasObservers;
  }
  
  private List<PartidoObserver> _bajasObservers;
  
  public List<PartidoObserver> getBajasObservers() {
    return this._bajasObservers;
  }
  
  public void setBajasObservers(final List<PartidoObserver> bajasObservers) {
    this._bajasObservers = bajasObservers;
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
    LinkedList<PartidoObserver> _linkedList_1 = new LinkedList<PartidoObserver>();
    this.setAltasObservers(_linkedList_1);
    LinkedList<PartidoObserver> _linkedList_2 = new LinkedList<PartidoObserver>();
    this.setBajasObservers(_linkedList_2);
    Administrador _instance = Administrador.getInstance();
    this.setAdministrador(_instance);
    this.setPreviamenteCompleto(false);
  }
  
  public void notificarInscripcion(final Jugador jugador) {
    List<PartidoObserver> _altasObservers = this.getAltasObservers();
    boolean _isEmpty = _altasObservers.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      List<PartidoObserver> _altasObservers_1 = this.getAltasObservers();
      final Consumer<PartidoObserver> _function = new Consumer<PartidoObserver>() {
        public void accept(final PartidoObserver observador) {
          observador.hacerLoSuyo(Partido.this, jugador);
        }
      };
      _altasObservers_1.forEach(_function);
    }
  }
  
  public void notificarBaja(final Jugador jugador) {
    List<PartidoObserver> _bajasObservers = this.getBajasObservers();
    boolean _isEmpty = _bajasObservers.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      List<PartidoObserver> _bajasObservers_1 = this.getBajasObservers();
      final Consumer<PartidoObserver> _function = new Consumer<PartidoObserver>() {
        public void accept(final PartidoObserver observador) {
          observador.hacerLoSuyo(Partido.this, jugador);
        }
      };
      _bajasObservers_1.forEach(_function);
    }
  }
  
  public int cantJugadores() {
    LinkedList<Jugador> _jugadores = this.getJugadores();
    return _jugadores.size();
  }
  
  public void agregarJugador(final Jugador jugador) {
    LinkedList<Jugador> _jugadores = this.getJugadores();
    _jugadores.add(jugador);
    this.notificarInscripcion(jugador);
  }
  
  public void eliminarJugador(final Jugador jugador) {
    LinkedList<Jugador> _jugadores = this.getJugadores();
    _jugadores.remove(jugador);
    this.notificarBaja(jugador);
  }
  
  public boolean estaInscripto(final Jugador jugador) {
    LinkedList<Jugador> _jugadores = this.getJugadores();
    return _jugadores.contains(jugador);
  }
  
  public boolean agregarObserverAlta(final PartidoObserver observer) {
    List<PartidoObserver> _altasObservers = this.getAltasObservers();
    return _altasObservers.add(observer);
  }
  
  public boolean agregarObserverBaja(final PartidoObserver observer) {
    List<PartidoObserver> _bajasObservers = this.getBajasObservers();
    return _bajasObservers.add(observer);
  }
  
  public boolean quitarObserverAlta(final PartidoObserver observer) {
    List<PartidoObserver> _altasObservers = this.getAltasObservers();
    return _altasObservers.remove(observer);
  }
  
  public boolean quitarObserverBaja(final PartidoObserver observer) {
    List<PartidoObserver> _bajasObservers = this.getBajasObservers();
    return _bajasObservers.remove(observer);
  }
  
  public void agregarReemplazo(final Jugador jugador, final Jugador reemplazo) {
    jugador.setReemplazo(reemplazo);
  }
  
  public void baja(final Jugador jugador) {
    try {
      boolean _estaInscripto = this.estaInscripto(jugador);
      boolean _not = (!_estaInscripto);
      if (_not) {
        throw new BusinessException("El jugador no est� inscripto en este partido, no se puede dar de baja");
      }
      Jugador _reemplazo = jugador.getReemplazo();
      boolean _notEquals = (!Objects.equal(_reemplazo, null));
      if (_notEquals) {
        Jugador _reemplazo_1 = jugador.getReemplazo();
        boolean _estaInscripto_1 = this.estaInscripto(_reemplazo_1);
        if (_estaInscripto_1) {
          throw new BusinessException("El reemplazo ya est� inscripto en el partido");
        }
        this.eliminarJugador(jugador);
        Jugador _reemplazo_2 = jugador.getReemplazo();
        this.inscribir(_reemplazo_2);
      } else {
        this.eliminarJugador(jugador);
      }
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
      this.eliminarJugador(quien);
      this.agregarJugador(jugador);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
