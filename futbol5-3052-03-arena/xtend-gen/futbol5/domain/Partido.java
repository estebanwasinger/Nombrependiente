package futbol5.domain;

import com.google.common.base.Objects;
import commands.CriteriosCommand;
import commands.DivisionDeEquiposCommand;
import excepciones.BusinessException;
import futbol5.domain.Administrador;
import futbol5.domain.Jugador;
import inscripciones.TipoInscripcion;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import observers.PartidoObserver;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Partido extends Entity {
  private String _localidad;
  
  public String getLocalidad() {
    return this._localidad;
  }
  
  public void setLocalidad(final String localidad) {
    this._localidad = localidad;
  }
  
  private List<Jugador> _jugadores;
  
  public List<Jugador> getJugadores() {
    return this._jugadores;
  }
  
  public void setJugadores(final List<Jugador> jugadores) {
    this._jugadores = jugadores;
  }
  
  private List<Jugador> _jugadoresOrdenados;
  
  public List<Jugador> getJugadoresOrdenados() {
    return this._jugadoresOrdenados;
  }
  
  public void setJugadoresOrdenados(final List<Jugador> jugadoresOrdenados) {
    this._jugadoresOrdenados = jugadoresOrdenados;
  }
  
  private List<Jugador> _equipoA;
  
  public List<Jugador> getEquipoA() {
    return this._equipoA;
  }
  
  public void setEquipoA(final List<Jugador> equipoA) {
    this._equipoA = equipoA;
  }
  
  private List<Jugador> _equipoB;
  
  public List<Jugador> getEquipoB() {
    return this._equipoB;
  }
  
  public void setEquipoB(final List<Jugador> equipoB) {
    this._equipoB = equipoB;
  }
  
  private List<Jugador> _equipoC;
  
  public List<Jugador> getEquipoC() {
    return this._equipoC;
  }
  
  public void setEquipoC(final List<Jugador> equipoC) {
    this._equipoC = equipoC;
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
  
  private int _cantEquipoA;
  
  public int getCantEquipoA() {
    return this._cantEquipoA;
  }
  
  public void setCantEquipoA(final int cantEquipoA) {
    this._cantEquipoA = cantEquipoA;
  }
  
  private Boolean _estaConfirmado = Boolean.valueOf(false);
  
  public Boolean getEstaConfirmado() {
    return this._estaConfirmado;
  }
  
  public void setEstaConfirmado(final Boolean estaConfirmado) {
    this._estaConfirmado = estaConfirmado;
  }
  
  private Administrador _administrador;
  
  public Administrador getAdministrador() {
    return this._administrador;
  }
  
  public void setAdministrador(final Administrador administrador) {
    this._administrador = administrador;
  }
  
  private DivisionDeEquiposCommand _AlgoritmoDivision;
  
  public DivisionDeEquiposCommand getAlgoritmoDivision() {
    return this._AlgoritmoDivision;
  }
  
  public void setAlgoritmoDivision(final DivisionDeEquiposCommand AlgoritmoDivision) {
    this._AlgoritmoDivision = AlgoritmoDivision;
  }
  
  private CriteriosCommand _AlgoritmoOrdenamiento;
  
  public CriteriosCommand getAlgoritmoOrdenamiento() {
    return this._AlgoritmoOrdenamiento;
  }
  
  public void setAlgoritmoOrdenamiento(final CriteriosCommand AlgoritmoOrdenamiento) {
    this._AlgoritmoOrdenamiento = AlgoritmoOrdenamiento;
  }
  
  public Partido(final String localidad) {
    this.setLocalidad(localidad);
    this.init();
  }
  
  public Partido() {
    this.init();
  }
  
  public void init() {
    LinkedList<Jugador> _linkedList = new LinkedList<Jugador>();
    this.setJugadores(_linkedList);
    LinkedList<Jugador> _linkedList_1 = new LinkedList<Jugador>();
    this.setJugadoresOrdenados(_linkedList_1);
    LinkedList<PartidoObserver> _linkedList_2 = new LinkedList<PartidoObserver>();
    this.setAltasObservers(_linkedList_2);
    LinkedList<PartidoObserver> _linkedList_3 = new LinkedList<PartidoObserver>();
    this.setBajasObservers(_linkedList_3);
    Administrador _administrador = new Administrador();
    this.setAdministrador(_administrador);
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setEquipoA(_arrayList);
    ArrayList<Jugador> _arrayList_1 = new ArrayList<Jugador>();
    this.setEquipoB(_arrayList_1);
  }
  
  public void notificarInscripcion(final Jugador jugador) {
    List<PartidoObserver> _altasObservers = this.getAltasObservers();
    final Procedure1<PartidoObserver> _function = new Procedure1<PartidoObserver>() {
      public void apply(final PartidoObserver observador) {
        observador.notificarInscripcion(Partido.this, jugador);
      }
    };
    IterableExtensions.<PartidoObserver>forEach(_altasObservers, _function);
  }
  
  public void notificarBaja(final Jugador jugador, final Jugador reemplazo) {
    List<PartidoObserver> _bajasObservers = this.getBajasObservers();
    final Procedure1<PartidoObserver> _function = new Procedure1<PartidoObserver>() {
      public void apply(final PartidoObserver observador) {
        observador.notificarBaja(Partido.this, jugador, reemplazo);
      }
    };
    IterableExtensions.<PartidoObserver>forEach(_bajasObservers, _function);
  }
  
  public int cantJugadores() {
    List<Jugador> _jugadores = this.getJugadores();
    return _jugadores.size();
  }
  
  public void agregarJugador(final Jugador jugador) {
    List<Jugador> _jugadores = this.getJugadores();
    _jugadores.add(jugador);
  }
  
  public void eliminarJugador(final Jugador jugador) {
    List<Jugador> _jugadores = this.getJugadores();
    _jugadores.remove(jugador);
  }
  
  public boolean estaInscripto(final Jugador jugador) {
    List<Jugador> _jugadores = this.getJugadores();
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
  
  public void baja(final Jugador jugador, final Jugador reemplazo) {
    try {
      Boolean _estaConfirmado = this.getEstaConfirmado();
      if ((_estaConfirmado).booleanValue()) {
        throw new BusinessException("Los equipos estan confirmados, no se puede dar de baja");
      }
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
        List<Jugador> _jugadores = this.getJugadores();
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
      Boolean _estaConfirmado = this.getEstaConfirmado();
      if ((_estaConfirmado).booleanValue()) {
        throw new BusinessException("Los equipos estan confirmados, no se puede inscribir");
      }
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
      List<Jugador> _jugadores = this.getJugadores();
      final Function1<Jugador, Boolean> _function = new Function1<Jugador, Boolean>() {
        public Boolean apply(final Jugador inscripto) {
          return Boolean.valueOf(jugador.tieneMasPrioridadQue(inscripto));
        }
      };
      boolean _exists = IterableExtensions.<Jugador>exists(_jugadores, _function);
      boolean _not_1 = (!_exists);
      if (_not_1) {
        throw new BusinessException("No hay mas cupo");
      }
      List<Jugador> _jugadores_1 = this.getJugadores();
      final Function1<Jugador, Boolean> _function_1 = new Function1<Jugador, Boolean>() {
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
  
  @Observable
  public void ordenarJugadores(final CriteriosCommand criterioOrdenamiento) {
    try {
      Boolean _estaConfirmado = this.getEstaConfirmado();
      if ((_estaConfirmado).booleanValue()) {
        throw new BusinessException("Los equipos estan confirmados, no se puede ordenar");
      }
      int _cantJugadores = this.cantJugadores();
      boolean _lessThan = (_cantJugadores < 10);
      if (_lessThan) {
        throw new BusinessException("No se puede ordenar la lista porque no hay 10 jugadores inscriptos aun.");
      }
      List<Jugador> _jugadores = this.getJugadores();
      List<Jugador> _ordenar = criterioOrdenamiento.ordenar(_jugadores);
      this.setJugadoresOrdenados(_ordenar);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Observable
  public void dividirEquipos(final DivisionDeEquiposCommand algoritmoDivision) {
    try {
      Boolean _estaConfirmado = this.getEstaConfirmado();
      if ((_estaConfirmado).booleanValue()) {
        throw new BusinessException("Los equipos estan confirmados, no se puede dividir");
      }
      List<Jugador> _jugadoresOrdenados = this.getJugadoresOrdenados();
      int _size = _jugadoresOrdenados.size();
      boolean _lessThan = (_size < 10);
      if (_lessThan) {
        throw new BusinessException("No se pueden armar los dos equipos porque no hay 10 jugadores ordenados aun.");
      }
      ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
      this.setEquipoB(_arrayList);
      List<Jugador> _jugadoresOrdenados_1 = this.getJugadoresOrdenados();
      List<Jugador> _equipoA = this.getEquipoA();
      List<Jugador> _equipoB = this.getEquipoB();
      algoritmoDivision.dividir(_jugadoresOrdenados_1, _equipoA, _equipoB);
      List<Jugador> _equipoA_1 = this.getEquipoA();
      int _size_1 = _equipoA_1.size();
      this.setCantEquipoA(_size_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void confirmarEquipos(final boolean confirmacion) {
    this.setEstaConfirmado(Boolean.valueOf(confirmacion));
  }
}
