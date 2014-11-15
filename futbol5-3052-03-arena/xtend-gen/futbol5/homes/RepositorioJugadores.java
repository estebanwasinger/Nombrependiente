package futbol5.homes;

import calificaciones.Calificacion;
import com.google.common.base.Objects;
import futbol5.applicationModel.BusquedaJugadoresAppModel;
import futbol5.domain.Jugador;
import futbol5.homes.RepositorioCalificaciones;
import futbol5.homes.RepositorioInfracciones;
import infracciones.Infraccion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.utils.ApplicationContext;
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
    ArrayList<Calificacion> _arrayList = new ArrayList<Calificacion>();
    Jugador _jugador = new Jugador("Paula", "Pau", 9, _arrayList);
    final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
      public void apply(final Jugador it) {
        List<Calificacion> _calificaciones = it.getCalificaciones();
        RepositorioCalificaciones _repoCal = RepositorioJugadores.this.repoCal();
        Calificacion _calificacion = new Calificacion(9);
        Calificacion _createCal = _repoCal.createCal(_calificacion);
        _calificaciones.add(_createCal);
        List<Infraccion> _infracciones = it.getInfracciones();
        RepositorioInfracciones _repoInf = RepositorioJugadores.this.repoInf();
        Infraccion _infraccion = new Infraccion("Llego tarde");
        Infraccion _createInfraccion = _repoInf.createInfraccion(_infraccion);
        _infracciones.add(_createInfraccion);
        it.setFechaNacimientoString("18/12/2013");
        List<Jugador> _amigos = it.getAmigos();
        ArrayList<Calificacion> _arrayList = new ArrayList<Calificacion>();
        Jugador _jugador = new Jugador("Amigo", "Amigote", 5, _arrayList);
        final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
          public void apply(final Jugador it) {
            List<Calificacion> _calificaciones = it.getCalificaciones();
            RepositorioCalificaciones _repoCal = RepositorioJugadores.this.repoCal();
            Calificacion _calificacion = new Calificacion(10);
            Calificacion _createCal = _repoCal.createCal(_calificacion);
            _calificaciones.add(_createCal);
            List<Infraccion> _infracciones = it.getInfracciones();
            RepositorioInfracciones _repoInf = RepositorioJugadores.this.repoInf();
            Infraccion _infraccion = new Infraccion("Faul");
            Infraccion _createInfraccion = _repoInf.createInfraccion(_infraccion);
            _infracciones.add(_createInfraccion);
            it.setFechaNacimientoString("18/12/2005");
          }
        };
        Jugador _doubleArrow = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador, _function);
        Jugador _createIfNotExists = RepositorioJugadores.this.createIfNotExists(_doubleArrow);
        _amigos.add(_createIfNotExists);
      }
    };
    Jugador _doubleArrow = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador, _function);
    this.createIfNotExists(_doubleArrow);
    ArrayList<Calificacion> _arrayList_1 = new ArrayList<Calificacion>();
    Jugador _jugador_1 = new Jugador("Esteban", "quito", 6, _arrayList_1);
    final Procedure1<Jugador> _function_1 = new Procedure1<Jugador>() {
      public void apply(final Jugador it) {
        List<Calificacion> _calificaciones = it.getCalificaciones();
        RepositorioCalificaciones _repoCal = RepositorioJugadores.this.repoCal();
        Calificacion _calificacion = new Calificacion(6);
        Calificacion _createCal = _repoCal.createCal(_calificacion);
        _calificaciones.add(_createCal);
        List<Infraccion> _infracciones = it.getInfracciones();
        RepositorioInfracciones _repoInf = RepositorioJugadores.this.repoInf();
        Infraccion _infraccion = new Infraccion("Insulto al arbitro");
        Infraccion _createInfraccion = _repoInf.createInfraccion(_infraccion);
        _infracciones.add(_createInfraccion);
        it.setFechaNacimientoString("18/12/2000");
        List<Jugador> _amigos = it.getAmigos();
        ArrayList<Calificacion> _arrayList = new ArrayList<Calificacion>();
        Jugador _jugador = new Jugador("Amigo2", "Amigote", 5, _arrayList);
        final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
          public void apply(final Jugador it) {
            List<Calificacion> _calificaciones = it.getCalificaciones();
            RepositorioCalificaciones _repoCal = RepositorioJugadores.this.repoCal();
            Calificacion _calificacion = new Calificacion(10);
            Calificacion _createCal = _repoCal.createCal(_calificacion);
            _calificaciones.add(_createCal);
            List<Infraccion> _infracciones = it.getInfracciones();
            RepositorioInfracciones _repoInf = RepositorioJugadores.this.repoInf();
            Infraccion _infraccion = new Infraccion("Faul");
            Infraccion _createInfraccion = _repoInf.createInfraccion(_infraccion);
            _infracciones.add(_createInfraccion);
            it.setFechaNacimientoString("18/12/2005");
          }
        };
        Jugador _doubleArrow = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador, _function);
        Jugador _createIfNotExists = RepositorioJugadores.this.createIfNotExists(_doubleArrow);
        _amigos.add(_createIfNotExists);
      }
    };
    Jugador _doubleArrow_1 = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador_1, _function_1);
    this.createIfNotExists(_doubleArrow_1);
    ArrayList<Calificacion> _arrayList_2 = new ArrayList<Calificacion>();
    Jugador _jugador_2 = new Jugador("Carolina", "Caro", 10, _arrayList_2);
    final Procedure1<Jugador> _function_2 = new Procedure1<Jugador>() {
      public void apply(final Jugador it) {
        List<Calificacion> _calificaciones = it.getCalificaciones();
        RepositorioCalificaciones _repoCal = RepositorioJugadores.this.repoCal();
        Calificacion _calificacion = new Calificacion(7);
        Calificacion _createCal = _repoCal.createCal(_calificacion);
        _calificaciones.add(_createCal);
        List<Infraccion> _infracciones = it.getInfracciones();
        RepositorioInfracciones _repoInf = RepositorioJugadores.this.repoInf();
        Infraccion _infraccion = new Infraccion("Faul");
        Infraccion _createInfraccion = _repoInf.createInfraccion(_infraccion);
        _infracciones.add(_createInfraccion);
        it.setFechaNacimientoString("18/12/1989");
      }
    };
    Jugador _doubleArrow_2 = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador_2, _function_2);
    this.createIfNotExists(_doubleArrow_2);
    ArrayList<Calificacion> _arrayList_3 = new ArrayList<Calificacion>();
    Jugador _jugador_3 = new Jugador("Juan", "Fantasma", 5, _arrayList_3);
    final Procedure1<Jugador> _function_3 = new Procedure1<Jugador>() {
      public void apply(final Jugador it) {
        List<Calificacion> _calificaciones = it.getCalificaciones();
        RepositorioCalificaciones _repoCal = RepositorioJugadores.this.repoCal();
        Calificacion _calificacion = new Calificacion(10);
        Calificacion _createCal = _repoCal.createCal(_calificacion);
        _calificaciones.add(_createCal);
        List<Infraccion> _infracciones = it.getInfracciones();
        RepositorioInfracciones _repoInf = RepositorioJugadores.this.repoInf();
        Infraccion _infraccion = new Infraccion("Faul");
        Infraccion _createInfraccion = _repoInf.createInfraccion(_infraccion);
        _infracciones.add(_createInfraccion);
        it.setFechaNacimientoString("18/12/2005");
      }
    };
    Jugador _doubleArrow_3 = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador_3, _function_3);
    this.createIfNotExists(_doubleArrow_3);
    ArrayList<Calificacion> _arrayList_4 = new ArrayList<Calificacion>();
    Jugador _jugador_4 = new Jugador("Alejandro", "Pepe", 2, _arrayList_4);
    final Procedure1<Jugador> _function_4 = new Procedure1<Jugador>() {
      public void apply(final Jugador it) {
        List<Calificacion> _calificaciones = it.getCalificaciones();
        RepositorioCalificaciones _repoCal = RepositorioJugadores.this.repoCal();
        Calificacion _calificacion = new Calificacion(9);
        Calificacion _createCal = _repoCal.createCal(_calificacion);
        _calificaciones.add(_createCal);
        List<Infraccion> _infracciones = it.getInfracciones();
        RepositorioInfracciones _repoInf = RepositorioJugadores.this.repoInf();
        Infraccion _infraccion = new Infraccion("Faul");
        Infraccion _createInfraccion = _repoInf.createInfraccion(_infraccion);
        _infracciones.add(_createInfraccion);
        it.setFechaNacimientoString("18/12/1992");
      }
    };
    Jugador _doubleArrow_4 = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador_4, _function_4);
    this.createIfNotExists(_doubleArrow_4);
    ArrayList<Calificacion> _arrayList_5 = new ArrayList<Calificacion>();
    Jugador _jugador_5 = new Jugador("Pedro", "El Loco", 5, _arrayList_5);
    final Procedure1<Jugador> _function_5 = new Procedure1<Jugador>() {
      public void apply(final Jugador it) {
        List<Calificacion> _calificaciones = it.getCalificaciones();
        RepositorioCalificaciones _repoCal = RepositorioJugadores.this.repoCal();
        Calificacion _calificacion = new Calificacion(4);
        Calificacion _createCal = _repoCal.createCal(_calificacion);
        _calificaciones.add(_createCal);
        List<Infraccion> _infracciones = it.getInfracciones();
        RepositorioInfracciones _repoInf = RepositorioJugadores.this.repoInf();
        Infraccion _infraccion = new Infraccion("Faul");
        Infraccion _createInfraccion = _repoInf.createInfraccion(_infraccion);
        _infracciones.add(_createInfraccion);
        it.setFechaNacimientoString("18/12/2001");
      }
    };
    Jugador _doubleArrow_5 = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador_5, _function_5);
    this.createIfNotExists(_doubleArrow_5);
    ArrayList<Calificacion> _arrayList_6 = new ArrayList<Calificacion>();
    Jugador _jugador_6 = new Jugador("Maria", "La Mary", 4, _arrayList_6);
    final Procedure1<Jugador> _function_6 = new Procedure1<Jugador>() {
      public void apply(final Jugador it) {
        List<Calificacion> _calificaciones = it.getCalificaciones();
        RepositorioCalificaciones _repoCal = RepositorioJugadores.this.repoCal();
        Calificacion _calificacion = new Calificacion(9);
        Calificacion _createCal = _repoCal.createCal(_calificacion);
        _calificaciones.add(_createCal);
        List<Infraccion> _infracciones = it.getInfracciones();
        RepositorioInfracciones _repoInf = RepositorioJugadores.this.repoInf();
        Infraccion _infraccion = new Infraccion("Falto y no aviso");
        Infraccion _createInfraccion = _repoInf.createInfraccion(_infraccion);
        _infracciones.add(_createInfraccion);
        it.setFechaNacimientoString("18/12/1980");
      }
    };
    Jugador _doubleArrow_6 = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador_6, _function_6);
    this.createIfNotExists(_doubleArrow_6);
    ArrayList<Calificacion> _arrayList_7 = new ArrayList<Calificacion>();
    Jugador _jugador_7 = new Jugador("Alberto", "Perro", 5, _arrayList_7);
    final Procedure1<Jugador> _function_7 = new Procedure1<Jugador>() {
      public void apply(final Jugador it) {
        List<Calificacion> _calificaciones = it.getCalificaciones();
        RepositorioCalificaciones _repoCal = RepositorioJugadores.this.repoCal();
        Calificacion _calificacion = new Calificacion(9);
        Calificacion _createCal = _repoCal.createCal(_calificacion);
        _calificaciones.add(_createCal);
        List<Infraccion> _infracciones = it.getInfracciones();
        RepositorioInfracciones _repoInf = RepositorioJugadores.this.repoInf();
        Infraccion _infraccion = new Infraccion("Tarjeta Roja");
        Infraccion _createInfraccion = _repoInf.createInfraccion(_infraccion);
        _infracciones.add(_createInfraccion);
        it.setFechaNacimientoString("18/12/1986");
      }
    };
    Jugador _doubleArrow_7 = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador_7, _function_7);
    this.createIfNotExists(_doubleArrow_7);
    ArrayList<Calificacion> _arrayList_8 = new ArrayList<Calificacion>();
    Jugador _jugador_8 = new Jugador("Santiago", "Santi", 3, _arrayList_8);
    final Procedure1<Jugador> _function_8 = new Procedure1<Jugador>() {
      public void apply(final Jugador it) {
        List<Calificacion> _calificaciones = it.getCalificaciones();
        RepositorioCalificaciones _repoCal = RepositorioJugadores.this.repoCal();
        Calificacion _calificacion = new Calificacion(9);
        Calificacion _createCal = _repoCal.createCal(_calificacion);
        _calificaciones.add(_createCal);
        List<Infraccion> _infracciones = it.getInfracciones();
        RepositorioInfracciones _repoInf = RepositorioJugadores.this.repoInf();
        Infraccion _infraccion = new Infraccion("Tarjeta Amarilla");
        Infraccion _createInfraccion = _repoInf.createInfraccion(_infraccion);
        _infracciones.add(_createInfraccion);
        it.setFechaNacimientoString("18/12/1999");
      }
    };
    Jugador _doubleArrow_8 = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador_8, _function_8);
    this.createIfNotExists(_doubleArrow_8);
    ArrayList<Calificacion> _arrayList_9 = new ArrayList<Calificacion>();
    Jugador _jugador_9 = new Jugador("Florencia", "Florcita", 5, _arrayList_9);
    final Procedure1<Jugador> _function_9 = new Procedure1<Jugador>() {
      public void apply(final Jugador it) {
        List<Calificacion> _calificaciones = it.getCalificaciones();
        RepositorioCalificaciones _repoCal = RepositorioJugadores.this.repoCal();
        Calificacion _calificacion = new Calificacion(2);
        Calificacion _createCal = _repoCal.createCal(_calificacion);
        _calificaciones.add(_createCal);
        List<Infraccion> _infracciones = it.getInfracciones();
        RepositorioInfracciones _repoInf = RepositorioJugadores.this.repoInf();
        Infraccion _infraccion = new Infraccion("Tarjeta Amarilla");
        Infraccion _createInfraccion = _repoInf.createInfraccion(_infraccion);
        _infracciones.add(_createInfraccion);
        it.setFechaNacimientoString("18/12/1960");
      }
    };
    Jugador _doubleArrow_9 = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador_9, _function_9);
    this.createIfNotExists(_doubleArrow_9);
    ArrayList<Calificacion> _arrayList_10 = new ArrayList<Calificacion>();
    Jugador _jugador_10 = new Jugador("Martin", "Tin", 5, _arrayList_10);
    final Procedure1<Jugador> _function_10 = new Procedure1<Jugador>() {
      public void apply(final Jugador it) {
        List<Calificacion> _calificaciones = it.getCalificaciones();
        RepositorioCalificaciones _repoCal = RepositorioJugadores.this.repoCal();
        Calificacion _calificacion = new Calificacion(1);
        Calificacion _createCal = _repoCal.createCal(_calificacion);
        _calificaciones.add(_createCal);
        List<Infraccion> _infracciones = it.getInfracciones();
        RepositorioInfracciones _repoInf = RepositorioJugadores.this.repoInf();
        Infraccion _infraccion = new Infraccion("Tarjeta Roja");
        Infraccion _createInfraccion = _repoInf.createInfraccion(_infraccion);
        _infracciones.add(_createInfraccion);
        it.setFechaNacimientoString("18/12/2000");
      }
    };
    Jugador _doubleArrow_10 = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador_10, _function_10);
    this.createIfNotExists(_doubleArrow_10);
    List<Jugador> jugadores = this.allInstances();
    for (final Jugador jugador : jugadores) {
      this.update(jugador);
    }
  }
  
  public RepositorioCalificaciones repoCal() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Calificacion.class);
    return ((RepositorioCalificaciones) _singleton);
  }
  
  public RepositorioInfracciones repoInf() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Infraccion.class);
    return ((RepositorioInfracciones) _singleton);
  }
  
  public Jugador createIfNotExists(final String nombreJ, final String apodoJ, final float nivelDeJuegoJ, final ArrayList<Calificacion> calificacionesJ) {
    Jugador _xblockexpression = null;
    {
      InputOutput.<String>println(("Creando si no existe jugador con id: " + nombreJ));
      Jugador jugador = new Jugador(nombreJ, apodoJ, nivelDeJuegoJ, calificacionesJ);
      Jugador jugadorDB = this.get(nombreJ);
      boolean _equals = Objects.equal(jugadorDB, null);
      if (_equals) {
        this.create(jugador);
        jugadorDB = jugador;
        InputOutput.<String>println((("Jugador con id " + nombreJ) + " fue creado"));
      } else {
        InputOutput.<String>println("Jugador ya existente");
      }
      _xblockexpression = jugadorDB;
    }
    return _xblockexpression;
  }
  
  public Jugador createIfNotExists(final Jugador jugador) {
    Jugador _xblockexpression = null;
    {
      String _nombre = jugador.getNombre();
      String _plus = ("Creando si no existe jugador con id: " + _nombre);
      InputOutput.<String>println(_plus);
      String _nombre_1 = jugador.getNombre();
      Jugador jugadorDB = this.get(_nombre_1);
      boolean _equals = Objects.equal(jugadorDB, null);
      if (_equals) {
        this.create(jugador);
        jugadorDB = jugador;
        String _nombre_2 = jugador.getNombre();
        String _plus_1 = ("Jugador con id " + _nombre_2);
        String _plus_2 = (_plus_1 + " fue creado");
        InputOutput.<String>println(_plus_2);
      } else {
        InputOutput.<String>println("Jugador ya existente");
      }
      _xblockexpression = jugadorDB;
    }
    return _xblockexpression;
  }
  
  public List<Jugador> getJugadores() {
    return this.allInstances();
  }
  
  public Jugador get(final String nombre) {
    List<Jugador> _allInstances = this.allInstances();
    for (final Jugador jugadorDB : _allInstances) {
      String _nombre = jugadorDB.getNombre();
      boolean _equals = _nombre.equals(nombre);
      if (_equals) {
        return jugadorDB;
      }
    }
    return null;
  }
  
  public Jugador get(final int id) {
    List<Jugador> _allInstances = this.allInstances();
    for (final Jugador jugadorDB : _allInstances) {
      String _nombre = jugadorDB.getNombre();
      boolean _equals = _nombre.equals(Integer.valueOf(id));
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
  
  public Class<Jugador> getEntityType() {
    return Jugador.class;
  }
  
  public Jugador createExample() {
    return new Jugador();
  }
}
