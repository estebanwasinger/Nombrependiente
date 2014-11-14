package futbol5.homes;

import calificaciones.Calificacion;
import com.google.common.base.Objects;
import futbol5.applicationModel.BusquedaJugadoresAppModel;
import futbol5.auxUtils.InicializadorJugador;
import futbol5.domain.Jugador;
import infracciones.Infraccion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.utils.Observable;
import strategyHandicap.HandicapStrategy;
import uqbar.arena.persistence.PersistentHome;

@Observable
@SuppressWarnings("all")
public class RepositorioJugadores extends PersistentHome<Jugador> {
  public RepositorioJugadores() {
    this.init();
  }
  
  public void init() {
    this.createIfNotExists(Integer.valueOf(1));
    this.createIfNotExists(Integer.valueOf(2));
    this.createIfNotExists(Integer.valueOf(3));
    this.createIfNotExists(Integer.valueOf(4));
    this.createIfNotExists(Integer.valueOf(5));
    this.createIfNotExists(Integer.valueOf(6));
    this.createIfNotExists(Integer.valueOf(7));
    this.createIfNotExists(Integer.valueOf(8));
    this.createIfNotExists(Integer.valueOf(9));
    this.createIfNotExists(Integer.valueOf(10));
    this.createIfNotExists(Integer.valueOf(11));
    this.createIfNotExists(Integer.valueOf(12));
    this.createIfNotExists(Integer.valueOf(13));
  }
  
  public Jugador createIfNotExists(final Integer id) {
    Jugador _xblockexpression = null;
    {
      InputOutput.<String>println(("Creando si no existe jugador con id: " + id));
      String _nombreRandom = InicializadorJugador.nombreRandom();
      String _apodoRandom = InicializadorJugador.apodoRandom();
      String _fechaRandom = InicializadorJugador.fechaRandom();
      int _handicapRandom = InicializadorJugador.handicapRandom();
      ArrayList<Jugador> _listaAmigos = InicializadorJugador.listaAmigos(10);
      int _nRan = InicializadorJugador.nRan(2, 9);
      ArrayList<Calificacion> _listaCalificaciones = InicializadorJugador.listaCalificaciones(_nRan);
      int _nRan_1 = InicializadorJugador.nRan(2, 6);
      Jugador jugador = new Jugador(_nombreRandom, _apodoRandom, 21, _fechaRandom, _handicapRandom, _listaAmigos, _listaCalificaciones, _nRan_1);
      jugador.setId(id);
      InicializadorJugador.crearListaNotificacioens(jugador);
      Jugador jugadorDB = this.get(id);
      boolean _equals = Objects.equal(jugadorDB, null);
      if (_equals) {
        this.create(jugador);
        jugadorDB = jugador;
        InputOutput.<String>println((("Jugador con id " + id) + " fue creado"));
      } else {
        InputOutput.<String>println("Jugador ya existente");
      }
      _xblockexpression = jugadorDB;
    }
    return _xblockexpression;
  }
  
  public List<Jugador> search(final BusquedaJugadoresAppModel modelo) {
    List<Jugador> _allInstances = this.allInstances();
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador jugador) {
        return Boolean.valueOf(RepositorioJugadores.this.match(jugador, modelo));
      }
    };
    Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(_allInstances, _function);
    return IterableExtensions.<Jugador>toList(_filter);
  }
  
  public boolean match(final Jugador jugadorEnLista, final BusquedaJugadoresAppModel modelo) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    boolean _and_3 = false;
    boolean _and_4 = false;
    boolean _and_5 = false;
    Jugador _jugadorEjemplo = modelo.getJugadorEjemplo();
    boolean _matcheaNombre = this.matcheaNombre(jugadorEnLista, _jugadorEjemplo);
    if (!_matcheaNombre) {
      _and_5 = false;
    } else {
      Jugador _jugadorEjemplo_1 = modelo.getJugadorEjemplo();
      boolean _matcheaApodo = this.matcheaApodo(jugadorEnLista, _jugadorEjemplo_1);
      _and_5 = _matcheaApodo;
    }
    if (!_and_5) {
      _and_4 = false;
    } else {
      Jugador _jugadorEjemplo_2 = modelo.getJugadorEjemplo();
      boolean _matcheaFecha = this.matcheaFecha(jugadorEnLista, _jugadorEjemplo_2);
      _and_4 = _matcheaFecha;
    }
    if (!_and_4) {
      _and_3 = false;
    } else {
      HandicapStrategy _metodoHandicap = modelo.getMetodoHandicap();
      Integer _handicap = modelo.getHandicap();
      boolean _calcular = _metodoHandicap.calcular(jugadorEnLista, _handicap);
      _and_3 = _calcular;
    }
    if (!_and_3) {
      _and_2 = false;
    } else {
      Integer _promedioDesde = modelo.getPromedioDesde();
      boolean _matcheaPromedioMin = this.matcheaPromedioMin(jugadorEnLista, _promedioDesde);
      _and_2 = _matcheaPromedioMin;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      Integer _promedioHasta = modelo.getPromedioHasta();
      boolean _matcheaPromedioMax = this.matcheaPromedioMax(jugadorEnLista, _promedioHasta);
      _and_1 = _matcheaPromedioMax;
    }
    if (!_and_1) {
      _and = false;
    } else {
      String _infracciones = modelo.getInfracciones();
      boolean _matcheaInfracciones = this.matcheaInfracciones(jugadorEnLista, _infracciones);
      _and = _matcheaInfracciones;
    }
    return _and;
  }
  
  public boolean matcheaNombre(final Jugador jugadorEnLista, final Jugador jugadorBuscado) {
    boolean _or = false;
    String _nombre = jugadorBuscado.getNombre();
    boolean _equals = Objects.equal(_nombre, null);
    if (_equals) {
      _or = true;
    } else {
      String _nombre_1 = jugadorEnLista.getNombre();
      String _lowerCase = _nombre_1.toLowerCase();
      String _nombre_2 = jugadorBuscado.getNombre();
      String _lowerCase_1 = _nombre_2.toLowerCase();
      boolean _startsWith = _lowerCase.startsWith(_lowerCase_1);
      _or = _startsWith;
    }
    return _or;
  }
  
  public boolean matcheaApodo(final Jugador jugadorEnLista, final Jugador jugadorBuscado) {
    boolean _or = false;
    String _apodo = jugadorBuscado.getApodo();
    boolean _equals = Objects.equal(_apodo, null);
    if (_equals) {
      _or = true;
    } else {
      String _apodo_1 = jugadorEnLista.getApodo();
      String _lowerCase = _apodo_1.toLowerCase();
      String _apodo_2 = jugadorBuscado.getApodo();
      String _lowerCase_1 = _apodo_2.toLowerCase();
      boolean _contains = _lowerCase.contains(_lowerCase_1);
      _or = _contains;
    }
    return _or;
  }
  
  public boolean matcheaFecha(final Jugador jugadorEnLista, final Jugador jugadorBuscado) {
    boolean _or = false;
    Date _fechaNacimiento = jugadorBuscado.getFechaNacimiento();
    boolean _equals = Objects.equal(_fechaNacimiento, null);
    if (_equals) {
      _or = true;
    } else {
      Date _fechaNacimiento_1 = jugadorBuscado.getFechaNacimiento();
      Date _fechaNacimiento_2 = jugadorEnLista.getFechaNacimiento();
      boolean _greaterEqualsThan = (_fechaNacimiento_1.compareTo(_fechaNacimiento_2) >= 0);
      _or = _greaterEqualsThan;
    }
    return _or;
  }
  
  public boolean matcheaPromedioMin(final Jugador jugadorEnLista, final Integer promedioDesde) {
    boolean _xifexpression = false;
    boolean _notEquals = (!Objects.equal(promedioDesde, null));
    if (_notEquals) {
      int _promedio = jugadorEnLista.getPromedio();
      int _round = Math.round(_promedio);
      _xifexpression = (_round >= (promedioDesde).intValue());
    } else {
      _xifexpression = true;
    }
    return _xifexpression;
  }
  
  public boolean matcheaPromedioMax(final Jugador jugadorEnLista, final Integer promedioHasta) {
    boolean _xifexpression = false;
    boolean _notEquals = (!Objects.equal(promedioHasta, null));
    if (_notEquals) {
      int _promedio = jugadorEnLista.getPromedio();
      int _round = Math.round(_promedio);
      _xifexpression = (_round <= (promedioHasta).intValue());
    } else {
      _xifexpression = true;
    }
    return _xifexpression;
  }
  
  public boolean matcheaInfracciones(final Jugador jugadorEnLista, final String infracciones) {
    boolean _xifexpression = false;
    boolean _equals = Objects.equal(infracciones, "Todos");
    if (_equals) {
      return true;
    } else {
      boolean _xifexpression_1 = false;
      boolean _equals_1 = Objects.equal(infracciones, "Con Infracciones");
      if (_equals_1) {
        List<Infraccion> _infracciones = jugadorEnLista.getInfracciones();
        boolean _isEmpty = _infracciones.isEmpty();
        _xifexpression_1 = (!_isEmpty);
      } else {
        List<Infraccion> _infracciones_1 = jugadorEnLista.getInfracciones();
        _xifexpression_1 = _infracciones_1.isEmpty();
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public List<Jugador> getJugadores() {
    return this.allInstances();
  }
  
  public Jugador get(final Integer id) {
    List<Jugador> _allInstances = this.allInstances();
    for (final Jugador jugadorDB : _allInstances) {
      Integer _id = jugadorDB.getId();
      boolean _equals = _id.equals(id);
      if (_equals) {
        return jugadorDB;
      }
    }
    return null;
  }
  
  public List<Jugador> search(final Integer unId) {
    Jugador _jugador = new Jugador();
    final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
      public void apply(final Jugador it) {
        it.setId(unId);
      }
    };
    Jugador _doubleArrow = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador, _function);
    return this.searchByExample(_doubleArrow);
  }
  
  public Class<Jugador> getEntityType() {
    return Jugador.class;
  }
  
  public Jugador createExample() {
    return new Jugador();
  }
}
