package futbol5.homes;

import calificaciones.Calificacion;
import com.google.common.base.Objects;
import futbol5.domain.Jugador;
import futbol5.domain.Partido;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;

@SuppressWarnings("all")
public class HomePartidos extends CollectionBasedHome<Partido> {
  private List<Partido> _partidos;
  
  public List<Partido> getPartidos() {
    return this._partidos;
  }
  
  public void setPartidos(final List<Partido> partidos) {
    this._partidos = partidos;
  }
  
  private List<Jugador> _jugadores;
  
  public List<Jugador> getJugadores() {
    return this._jugadores;
  }
  
  public void setJugadores(final List<Jugador> jugadores) {
    this._jugadores = jugadores;
  }
  
  public HomePartidos() {
    this.init();
  }
  
  public void init() {
    LinkedList<Partido> _linkedList = new LinkedList<Partido>();
    this.setPartidos(_linkedList);
    List<Jugador> _crearListaDejugadores = this.crearListaDejugadores(10);
    this.createCompleto("Burzaco", _crearListaDejugadores);
    List<Jugador> _crearListaDejugadores_1 = this.crearListaDejugadores(10);
    this.createCompleto("Adrogue", _crearListaDejugadores_1);
    List<Jugador> _crearListaDejugadores_2 = this.crearListaDejugadores(10);
    this.createCompleto("Bandfiel", _crearListaDejugadores_2);
    List<Jugador> _crearListaDejugadores_3 = this.crearListaDejugadores(10);
    this.createCompleto("Lomas de Zamora", _crearListaDejugadores_3);
    List<Jugador> _crearListaDejugadores_4 = this.crearListaDejugadores(10);
    this.createCompleto("Quilmes", _crearListaDejugadores_4);
    List<Jugador> _crearListaDejugadores_5 = this.crearListaDejugadores(10);
    this.createCompleto("Longchamps", _crearListaDejugadores_5);
    List<Jugador> _crearListaDejugadores_6 = this.crearListaDejugadores(10);
    this.createCompleto("San Miguel", _crearListaDejugadores_6);
  }
  
  public boolean create(final String localidad) {
    boolean _xblockexpression = false;
    {
      Partido partido = new Partido();
      partido.setLocalidad(localidad);
      List<Partido> _partidos = this.getPartidos();
      _xblockexpression = _partidos.add(partido);
    }
    return _xblockexpression;
  }
  
  public boolean createCompleto(final String localidad, final List<Jugador> jugadores) {
    boolean _xblockexpression = false;
    {
      Partido partido = new Partido();
      partido.setLocalidad(localidad);
      partido.setJugadores(jugadores);
      List<Partido> _partidos = this.getPartidos();
      _xblockexpression = _partidos.add(partido);
    }
    return _xblockexpression;
  }
  
  public List<Jugador> crearListaDejugadores(final int max) {
    int a = 0;
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadores(_arrayList);
    boolean _while = (a < max);
    while (_while) {
      {
        List<Jugador> _jugadores = this.getJugadores();
        ArrayList<Jugador> _listaAmigos = this.listaAmigos(8);
        ArrayList<Calificacion> _listaCalificaciones = this.listaCalificaciones(3);
        Jugador _jugador = new Jugador("Carolina", "caro", 21, "09-01-1993", 2, _listaAmigos, _listaCalificaciones, 5);
        _jugadores.add(_jugador);
        a = (a + 1);
      }
      _while = (a < max);
    }
    return this.getJugadores();
  }
  
  public ArrayList<Jugador> listaAmigos(final int max) {
    int a = 0;
    ArrayList<Jugador> amigos = new ArrayList<Jugador>();
    boolean _while = (a < max);
    while (_while) {
      {
        Jugador _jugador = new Jugador("Esteban");
        amigos.add(_jugador);
        a = (a + 1);
      }
      _while = (a < max);
    }
    return amigos;
  }
  
  public ArrayList<Calificacion> listaCalificaciones(final int max) {
    int a = 0;
    ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();
    boolean _while = (a < max);
    while (_while) {
      {
        Calificacion _calificacion = new Calificacion(5);
        calificaciones.add(_calificacion);
        a = (a + 1);
      }
      _while = (a < max);
    }
    return calificaciones;
  }
  
  public List<Partido> search(final Partido partidoBuscado) {
    List<Partido> _partidos = this.getPartidos();
    final Function1<Partido,Boolean> _function = new Function1<Partido,Boolean>() {
      public Boolean apply(final Partido partido) {
        return Boolean.valueOf(HomePartidos.this.match(partido, partidoBuscado));
      }
    };
    Iterable<Partido> _filter = IterableExtensions.<Partido>filter(_partidos, _function);
    return IterableExtensions.<Partido>toList(_filter);
  }
  
  public boolean match(final Partido partido, final Partido partidoBuscado) {
    boolean _xblockexpression = false;
    {
      String _localidad = partido.getLocalidad();
      boolean _equals = Objects.equal(_localidad, null);
      if (_equals) {
        return true;
      }
      String _localidad_1 = partidoBuscado.getLocalidad();
      boolean _equals_1 = Objects.equal(_localidad_1, null);
      if (_equals_1) {
        return false;
      }
      String _localidad_2 = partidoBuscado.getLocalidad();
      String _string = _localidad_2.toString();
      String _lowerCase = _string.toLowerCase();
      String _localidad_3 = partido.getLocalidad();
      String _string_1 = _localidad_3.toString();
      String _lowerCase_1 = _string_1.toLowerCase();
      _xblockexpression = _lowerCase.contains(_lowerCase_1);
    }
    return _xblockexpression;
  }
  
  protected Predicate getCriterio(final Partido example) {
    return null;
  }
  
  public Partido createExample() {
    return new Partido();
  }
  
  public Class<Partido> getEntityType() {
    return Partido.class;
  }
}
