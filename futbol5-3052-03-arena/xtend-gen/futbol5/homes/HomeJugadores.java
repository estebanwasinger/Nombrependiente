package futbol5.homes;

import com.google.common.base.Objects;
import futbol5.auxUtils.InicializadorJugador;
import futbol5.domain.Jugador;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class HomeJugadores extends CollectionBasedHome<Jugador> {
  private String _tipoHandicap;
  
  public String getTipoHandicap() {
    return this._tipoHandicap;
  }
  
  public void setTipoHandicap(final String tipoHandicap) {
    this._tipoHandicap = tipoHandicap;
  }
  
  private ArrayList<Jugador> _jugadoresAceptados;
  
  public ArrayList<Jugador> getJugadoresAceptados() {
    return this._jugadoresAceptados;
  }
  
  public void setJugadoresAceptados(final ArrayList<Jugador> jugadoresAceptados) {
    this._jugadoresAceptados = jugadoresAceptados;
  }
  
  /**
   * @Property var List<RegistroRechazo> jugadoresRechazados
   * @Property var LinkedList<Jugador> jugadoresRecomendados
   */
  private SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
  
  public HomeJugadores() {
    this.init();
  }
  
  public void init() {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadoresAceptados(_arrayList);
    ArrayList<Jugador> _crearListaDejugadores = InicializadorJugador.crearListaDejugadores(10);
    this.setJugadoresAceptados(_crearListaDejugadores);
  }
  
  /**
   * def void agregarAceptado(Jugador jugador){
   * jugadoresAceptados.add(jugador)
   * }
   * 
   * def List<Jugador> getJugadores(){
   * jugadoresAceptados
   * }
   */
  public List<Jugador> search(final Jugador jugadorBuscado) {
    List<Jugador> _xifexpression = null;
    boolean _notEquals = (!Objects.equal(jugadorBuscado, null));
    if (_notEquals) {
      List<Jugador> _allInstances = this.allInstances();
      final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
        public Boolean apply(final Jugador jugador) {
          return Boolean.valueOf(HomeJugadores.this.match(jugador, jugadorBuscado));
        }
      };
      Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(_allInstances, _function);
      _xifexpression = IterableExtensions.<Jugador>toList(_filter);
    } else {
      this.init();
    }
    return _xifexpression;
  }
  
  public boolean match(final Jugador jugadorEnLista, final Jugador jugadorBuscado) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    boolean _matcheaNombre = this.matcheaNombre(jugadorEnLista, jugadorBuscado);
    if (!_matcheaNombre) {
      _and_2 = false;
    } else {
      boolean _matcheaApodo = this.matcheaApodo(jugadorEnLista, jugadorBuscado);
      _and_2 = _matcheaApodo;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      boolean _matcheaFecha = this.matcheaFecha(jugadorEnLista, jugadorBuscado);
      _and_1 = _matcheaFecha;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _matcheaHandicap = this.matcheaHandicap(jugadorEnLista, jugadorBuscado);
      _and = _matcheaHandicap;
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
      boolean _greaterThan = (_fechaNacimiento_1.compareTo(_fechaNacimiento_2) > 0);
      _or = _greaterThan;
    }
    return _or;
  }
  
  public boolean matcheaHandicap(final Jugador jugadorEnLista, final Jugador jugadorBuscado) {
    boolean _xblockexpression = false;
    {
      float _nivelDeJuego = jugadorBuscado.getNivelDeJuego();
      int nivel = Math.round(_nivelDeJuego);
      boolean _xifexpression = false;
      String _tipoHandicap = this.getTipoHandicap();
      boolean _equals = Objects.equal(_tipoHandicap, "Desde");
      if (_equals) {
        boolean _or = false;
        String _string = Integer.valueOf(nivel).toString();
        boolean _equals_1 = Objects.equal(_string, null);
        if (_equals_1) {
          _or = true;
        } else {
          float _nivelDeJuego_1 = jugadorEnLista.getNivelDeJuego();
          float _nivelDeJuego_2 = jugadorBuscado.getNivelDeJuego();
          boolean _greaterThan = (_nivelDeJuego_1 > _nivelDeJuego_2);
          _or = _greaterThan;
        }
        _xifexpression = _or;
      } else {
        boolean _or_1 = false;
        String _string_1 = Integer.valueOf(nivel).toString();
        boolean _equals_2 = Objects.equal(_string_1, null);
        if (_equals_2) {
          _or_1 = true;
        } else {
          float _nivelDeJuego_3 = jugadorEnLista.getNivelDeJuego();
          float _nivelDeJuego_4 = jugadorBuscado.getNivelDeJuego();
          boolean _lessThan = (_nivelDeJuego_3 < _nivelDeJuego_4);
          _or_1 = _lessThan;
        }
        _xifexpression = _or_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public List<Jugador> getJugadores() {
    return this.allInstances();
  }
  
  public Class<Jugador> getEntityType() {
    return Jugador.class;
  }
  
  public Jugador createExample() {
    return new Jugador();
  }
  
  public Predicate getCriterio(final Jugador example) {
    return null;
  }
}
