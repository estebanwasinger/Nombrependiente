package futbol5.homes;

import com.google.common.base.Objects;
import futbol5.domain.Jugador;
import futbol5.domain.Partido;
import futbol5.homes.RepositorioJugadores;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;
import uqbar.arena.persistence.PersistentHome;

@Observable
@SuppressWarnings("all")
public class RepositorioPartidos extends PersistentHome<Partido> {
  public Class<Partido> getEntityType() {
    return Partido.class;
  }
  
  public Partido createExample() {
    return new Partido();
  }
  
  public RepositorioPartidos() {
    this.init();
  }
  
  public void init() {
    Partido _partido = new Partido("Quilmes");
    final Procedure1<Partido> _function = new Procedure1<Partido>() {
      public void apply(final Partido it) {
        Jugador _jugador = RepositorioPartidos.this.getJugador("Carolina");
        it.agregarJugador(_jugador);
        Jugador _jugador_1 = RepositorioPartidos.this.getJugador("Paula");
        it.agregarJugador(_jugador_1);
        Jugador _jugador_2 = RepositorioPartidos.this.getJugador("Esteban");
        it.agregarJugador(_jugador_2);
        Jugador _jugador_3 = RepositorioPartidos.this.getJugador("Juan");
        it.agregarJugador(_jugador_3);
        Jugador _jugador_4 = RepositorioPartidos.this.getJugador("Alejandro");
        it.agregarJugador(_jugador_4);
        Jugador _jugador_5 = RepositorioPartidos.this.getJugador("Pedro");
        it.agregarJugador(_jugador_5);
        Jugador _jugador_6 = RepositorioPartidos.this.getJugador("Maria");
        it.agregarJugador(_jugador_6);
        Jugador _jugador_7 = RepositorioPartidos.this.getJugador("Paula");
        it.agregarJugador(_jugador_7);
        Jugador _jugador_8 = RepositorioPartidos.this.getJugador("Carolina");
        it.agregarJugador(_jugador_8);
        Jugador _jugador_9 = RepositorioPartidos.this.getJugador("Alejandro");
        it.agregarJugador(_jugador_9);
      }
    };
    Partido _doubleArrow = ObjectExtensions.<Partido>operator_doubleArrow(_partido, _function);
    this.createIfNotExists(_doubleArrow);
    Partido _partido_1 = new Partido("Longchamps");
    final Procedure1<Partido> _function_1 = new Procedure1<Partido>() {
      public void apply(final Partido it) {
        Jugador _jugador = RepositorioPartidos.this.getJugador("Maria");
        it.agregarJugador(_jugador);
        Jugador _jugador_1 = RepositorioPartidos.this.getJugador("Esteban");
        it.agregarJugador(_jugador_1);
      }
    };
    Partido _doubleArrow_1 = ObjectExtensions.<Partido>operator_doubleArrow(_partido_1, _function_1);
    this.createIfNotExists(_doubleArrow_1);
    Partido _partido_2 = new Partido("San Miguel");
    final Procedure1<Partido> _function_2 = new Procedure1<Partido>() {
      public void apply(final Partido it) {
        Jugador _jugador = RepositorioPartidos.this.getJugador("Alejandro");
        it.agregarJugador(_jugador);
        Jugador _jugador_1 = RepositorioPartidos.this.getJugador("Pedro");
        it.agregarJugador(_jugador_1);
      }
    };
    Partido _doubleArrow_2 = ObjectExtensions.<Partido>operator_doubleArrow(_partido_2, _function_2);
    this.createIfNotExists(_doubleArrow_2);
    Partido _partido_3 = new Partido("CABA");
    final Procedure1<Partido> _function_3 = new Procedure1<Partido>() {
      public void apply(final Partido it) {
        Jugador _jugador = RepositorioPartidos.this.getJugador("Esteban");
        it.agregarJugador(_jugador);
        Jugador _jugador_1 = RepositorioPartidos.this.getJugador("Paula");
        it.agregarJugador(_jugador_1);
        Jugador _jugador_2 = RepositorioPartidos.this.getJugador("Carolina");
        it.agregarJugador(_jugador_2);
      }
    };
    Partido _doubleArrow_3 = ObjectExtensions.<Partido>operator_doubleArrow(_partido_3, _function_3);
    this.createIfNotExists(_doubleArrow_3);
    RepositorioJugadores _repoJugadores = this.repoJugadores();
    List<Jugador> jugadores = _repoJugadores.allInstances();
    for (final Jugador jugador : jugadores) {
      Integer _id = jugador.getId();
      String _nombre = jugador.getNombre();
      String _plus = (_id + _nombre);
      InputOutput.<String>println(_plus);
    }
    List<Partido> partidos = this.allInstances();
    for (final Partido partido : partidos) {
      this.update(partido);
    }
  }
  
  public Jugador getJugador(final int id) {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Jugador.class);
    return ((RepositorioJugadores) _singleton).get(id);
  }
  
  public RepositorioJugadores repoJugadores() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Jugador.class);
    return ((RepositorioJugadores) _singleton);
  }
  
  public Jugador getJugador(final String nombre) {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Jugador.class);
    return ((RepositorioJugadores) _singleton).get(nombre);
  }
  
  public void create(final String localidad) {
    Partido partido = new Partido();
    partido.setLocalidad(localidad);
    this.create(partido);
  }
  
  public Partido createIfNotExists(final String localidad) {
    Partido _xblockexpression = null;
    {
      InputOutput.<String>println(("Creando si no existe partido con localidad: " + localidad));
      Partido partido = new Partido(localidad);
      Partido partidoDB = this.get(localidad);
      boolean _equals = Objects.equal(partidoDB, null);
      if (_equals) {
        this.create(partido);
        partidoDB = partido;
        InputOutput.<String>println((("Partido en " + localidad) + " fue creado"));
      } else {
        InputOutput.<String>println("Partido ya existente");
      }
      _xblockexpression = partidoDB;
    }
    return _xblockexpression;
  }
  
  public Partido createIfNotExists(final Partido partido) {
    Partido _xblockexpression = null;
    {
      String _localidad = partido.getLocalidad();
      String _plus = ("Creando si no existe partido con localidad: " + _localidad);
      InputOutput.<String>println(_plus);
      String _localidad_1 = partido.getLocalidad();
      Partido partidoDB = this.get(_localidad_1);
      boolean _equals = Objects.equal(partidoDB, null);
      if (_equals) {
        this.create(partido);
        partidoDB = partido;
        String _localidad_2 = partido.getLocalidad();
        String _plus_1 = ("Partido en " + _localidad_2);
        String _plus_2 = (_plus_1 + " fue creado");
        InputOutput.<String>println(_plus_2);
      } else {
        InputOutput.<String>println("Partido ya existente");
      }
      _xblockexpression = partidoDB;
    }
    return _xblockexpression;
  }
  
  public Partido get(final String localidad) {
    List<Partido> _allInstances = this.allInstances();
    for (final Partido partidoDB : _allInstances) {
      String _localidad = partidoDB.getLocalidad();
      boolean _equals = _localidad.equals(localidad);
      if (_equals) {
        return partidoDB;
      }
    }
    return null;
  }
  
  public void updateMe(final Partido partido) {
    String _localidad = partido.getLocalidad();
    Partido _get = this.get(_localidad);
    this.update(_get);
  }
}
