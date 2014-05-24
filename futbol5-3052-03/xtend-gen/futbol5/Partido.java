package futbol5;

import auxiliares.RegistroRechazo;
import com.google.common.base.Objects;
import command.Decision;
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
  
  private List<Jugador> _jugadoresAceptados;
  
  public List<Jugador> getJugadoresAceptados() {
    return this._jugadoresAceptados;
  }
  
  public void setJugadoresAceptados(final List<Jugador> jugadoresAceptados) {
    this._jugadoresAceptados = jugadoresAceptados;
  }
  
  private List<RegistroRechazo> _jugadoresRechazados;
  
  public List<RegistroRechazo> getJugadoresRechazados() {
    return this._jugadoresRechazados;
  }
  
  public void setJugadoresRechazados(final List<RegistroRechazo> jugadoresRechazados) {
    this._jugadoresRechazados = jugadoresRechazados;
  }
  
  public Partido(final String localidad) {
    this.setLocalidad(localidad);
    LinkedList<Jugador> _linkedList = new LinkedList<Jugador>();
    this.setJugadores(_linkedList);
    LinkedList<PartidoObserver> _linkedList_1 = new LinkedList<PartidoObserver>();
    this.setAltasObservers(_linkedList_1);
    LinkedList<PartidoObserver> _linkedList_2 = new LinkedList<PartidoObserver>();
    this.setBajasObservers(_linkedList_2);
    LinkedList<Jugador> _linkedList_3 = new LinkedList<Jugador>();
    this.setJugadoresAceptados(_linkedList_3);
    LinkedList<RegistroRechazo> _linkedList_4 = new LinkedList<RegistroRechazo>();
    this.setJugadoresRechazados(_linkedList_4);
    Administrador _instance = Administrador.getInstance();
    this.setAdministrador(_instance);
  }
  
  public void notificarInscripcion(final Jugador jugador) {
    List<PartidoObserver> _altasObservers = this.getAltasObservers();
    final Consumer<PartidoObserver> _function = new Consumer<PartidoObserver>() {
      public void accept(final PartidoObserver observador) {
        observador.notificarInscripcion(Partido.this, jugador);
      }
    };
    _altasObservers.forEach(_function);
  }
  
  public void notificarBaja(final Jugador jugador, final Jugador reemplazo) {
    List<PartidoObserver> _bajasObservers = this.getBajasObservers();
    final Consumer<PartidoObserver> _function = new Consumer<PartidoObserver>() {
      public void accept(final PartidoObserver observador) {
        observador.notificarBaja(Partido.this, jugador, reemplazo);
      }
    };
    _bajasObservers.forEach(_function);
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
  
  public void jugadorProponeA(final Jugador jugador, final Decision decision, final String motivo) {
    decision.registrarDecision(jugador, this, motivo);
  }
  
  public void baja(final Jugador jugador, final Jugador reemplazo) {
    try {
      boolean _estaInscripto = this.estaInscripto(jugador);
      boolean _not = (!_estaInscripto);
      if (_not) {
        throw new BusinessException("El jugador no esta inscripto en este partido, no se puede dar de baja");
      }
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(reemplazo, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _estaInscripto_1 = this.estaInscripto(reemplazo);
        _and = _estaInscripto_1;
      }
      if (_and) {
        throw new BusinessException("El reemplazo ya esta inscripto en el partido");
      }
      this.eliminarJugador(jugador);
      boolean _notEquals_1 = (!Objects.equal(reemplazo, null));
      if (_notEquals_1) {
        LinkedList<Jugador> _jugadores = this.getJugadores();
        _jugadores.add(reemplazo);
      }
      this.notificarBaja(jugador, reemplazo);
      this.notificarInscripcion(reemplazo);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void bajaSinReemplazo(final Jugador jugador) {
    this.baja(jugador, null);
  }
  
  public void inscribir(final Jugador jugador) {
    try {
      boolean _estaInscripto = this.estaInscripto(jugador);
      if (_estaInscripto) {
        throw new BusinessException("El jugador ya se inscribio");
      }
      TipoInscripcion _tipoInscripcion = jugador.getTipoInscripcion();
      boolean _cumpleCondicion = _tipoInscripcion.cumpleCondicion(jugador, this);
      boolean _not = (!_cumpleCondicion);
      if (_not) {
        throw new BusinessException("El jugador no cumple con la condicion, no se puede inscribir");
      }
      int _cantJugadores = this.cantJugadores();
      boolean _lessThan = (_cantJugadores < 10);
      if (_lessThan) {
        this.agregarJugador(jugador);
        this.notificarInscripcion(jugador);
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
        throw new BusinessException("No hay mas cupo");
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
      this.notificarInscripcion(jugador);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
