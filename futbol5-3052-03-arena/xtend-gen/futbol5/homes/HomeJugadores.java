package futbol5.homes;

import com.google.common.base.Objects;
import futbol5.auxUtils.InicializadorJugador;
import futbol5.domain.Jugador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;

@SuppressWarnings("all")
public class HomeJugadores extends CollectionBasedHome<Jugador> {
  private Float _handicapDesde;
  
  public Float getHandicapDesde() {
    return this._handicapDesde;
  }
  
  public void setHandicapDesde(final Float handicapDesde) {
    this._handicapDesde = handicapDesde;
  }
  
  private Float _handicapHasta;
  
  public Float getHandicapHasta() {
    return this._handicapHasta;
  }
  
  public void setHandicapHasta(final Float handicapHasta) {
    this._handicapHasta = handicapHasta;
  }
  
  private List<Jugador> _jugadoresAceptados;
  
  public List<Jugador> getJugadoresAceptados() {
    return this._jugadoresAceptados;
  }
  
  public void setJugadoresAceptados(final List<Jugador> jugadoresAceptados) {
    this._jugadoresAceptados = jugadoresAceptados;
  }
  
  public HomeJugadores() {
    this.init();
  }
  
  public void init() {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadoresAceptados(_arrayList);
    ArrayList<Jugador> _crearListaDejugadores = InicializadorJugador.crearListaDejugadores(10);
    this.setJugadoresAceptados(_crearListaDejugadores);
    Float _float = new Float(0.0F);
    this.setHandicapDesde(_float);
    Float _float_1 = new Float(0.0F);
    this.setHandicapHasta(_float_1);
  }
  
  public List<Jugador> search(final Jugador jugadorBuscado) {
    List<Jugador> _jugadoresAceptados = this.getJugadoresAceptados();
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador jugador) {
        return Boolean.valueOf(HomeJugadores.this.match(jugador, jugadorBuscado));
      }
    };
    Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(_jugadoresAceptados, _function);
    return IterableExtensions.<Jugador>toList(_filter);
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
      boolean _matcheaHandicap = this.matcheaHandicap(jugadorEnLista);
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
  
  public boolean matcheaHandicap(final Jugador jugadorEnLista) {
    boolean _or = false;
    boolean _or_1 = false;
    boolean _or_2 = false;
    float _nivelDeJuego = jugadorEnLista.getNivelDeJuego();
    Float _handicapDesde = this.getHandicapDesde();
    boolean _greaterThan = (_nivelDeJuego > (_handicapDesde).floatValue());
    if (_greaterThan) {
      _or_2 = true;
    } else {
      float _nivelDeJuego_1 = jugadorEnLista.getNivelDeJuego();
      Float _handicapHasta = this.getHandicapHasta();
      boolean _lessThan = (_nivelDeJuego_1 < (_handicapHasta).floatValue());
      _or_2 = _lessThan;
    }
    if (_or_2) {
      _or_1 = true;
    } else {
      boolean _and = false;
      float _nivelDeJuego_2 = jugadorEnLista.getNivelDeJuego();
      Float _handicapDesde_1 = this.getHandicapDesde();
      boolean _greaterThan_1 = (_nivelDeJuego_2 > (_handicapDesde_1).floatValue());
      if (!_greaterThan_1) {
        _and = false;
      } else {
        Float _handicapHasta_1 = this.getHandicapHasta();
        boolean _equals = ((_handicapHasta_1).floatValue() == 0.0F);
        _and = _equals;
      }
      _or_1 = _and;
    }
    if (_or_1) {
      _or = true;
    } else {
      boolean _and_1 = false;
      float _nivelDeJuego_3 = jugadorEnLista.getNivelDeJuego();
      Float _handicapHasta_2 = this.getHandicapHasta();
      boolean _lessThan_1 = (_nivelDeJuego_3 < (_handicapHasta_2).floatValue());
      if (!_lessThan_1) {
        _and_1 = false;
      } else {
        Float _handicapDesde_2 = this.getHandicapDesde();
        boolean _equals_1 = ((_handicapDesde_2).floatValue() == 0.0F);
        _and_1 = _equals_1;
      }
      _or = _and_1;
    }
    return _or;
  }
  
  public List<Jugador> getJugadores() {
    return this.getJugadoresAceptados();
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
