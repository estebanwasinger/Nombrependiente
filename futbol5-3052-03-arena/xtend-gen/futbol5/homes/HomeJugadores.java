package futbol5.homes;

import com.google.common.base.Objects;
import futbol5.applicationModel.BusquedaJugadoresAppModel;
import futbol5.auxUtils.InicializadorJugador;
import futbol5.domain.Jugador;
import infracciones.Infraccion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;

@SuppressWarnings("all")
public class HomeJugadores extends CollectionBasedHome<Jugador> {
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
    List<Jugador> _jugadoresAceptados = this.getJugadoresAceptados();
    Jugador _get = _jugadoresAceptados.get(3);
    List<Infraccion> _infracciones = _get.getInfracciones();
    _infracciones.clear();
    List<Jugador> _jugadoresAceptados_1 = this.getJugadoresAceptados();
    Jugador _get_1 = _jugadoresAceptados_1.get(5);
    List<Infraccion> _infracciones_1 = _get_1.getInfracciones();
    _infracciones_1.clear();
  }
  
  public List<Jugador> search(final BusquedaJugadoresAppModel modelo) {
    List<Jugador> _jugadoresAceptados = this.getJugadoresAceptados();
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador jugador) {
        return Boolean.valueOf(HomeJugadores.this.match(jugador, modelo));
      }
    };
    Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(_jugadoresAceptados, _function);
    return IterableExtensions.<Jugador>toList(_filter);
  }
  
  public boolean match(final Jugador jugadorEnLista, final BusquedaJugadoresAppModel modelo) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    boolean _and_3 = false;
    boolean _and_4 = false;
    boolean _and_5 = false;
    boolean _and_6 = false;
    Jugador _jugadorEjemplo = modelo.getJugadorEjemplo();
    boolean _matcheaNombre = this.matcheaNombre(jugadorEnLista, _jugadorEjemplo);
    if (!_matcheaNombre) {
      _and_6 = false;
    } else {
      Jugador _jugadorEjemplo_1 = modelo.getJugadorEjemplo();
      boolean _matcheaApodo = this.matcheaApodo(jugadorEnLista, _jugadorEjemplo_1);
      _and_6 = _matcheaApodo;
    }
    if (!_and_6) {
      _and_5 = false;
    } else {
      Jugador _jugadorEjemplo_2 = modelo.getJugadorEjemplo();
      boolean _matcheaFecha = this.matcheaFecha(jugadorEnLista, _jugadorEjemplo_2);
      _and_5 = _matcheaFecha;
    }
    if (!_and_5) {
      _and_4 = false;
    } else {
      int _handicapDesde = modelo.getHandicapDesde();
      boolean _matcheaHandicapMin = this.matcheaHandicapMin(jugadorEnLista, _handicapDesde);
      _and_4 = _matcheaHandicapMin;
    }
    if (!_and_4) {
      _and_3 = false;
    } else {
      int _handicapHasta = modelo.getHandicapHasta();
      boolean _matcheaHandicapMax = this.matcheaHandicapMax(jugadorEnLista, _handicapHasta);
      _and_3 = _matcheaHandicapMax;
    }
    if (!_and_3) {
      _and_2 = false;
    } else {
      int _promedioDesde = modelo.getPromedioDesde();
      boolean _matcheaPromedioMin = this.matcheaPromedioMin(jugadorEnLista, _promedioDesde);
      _and_2 = _matcheaPromedioMin;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      int _promedioHasta = modelo.getPromedioHasta();
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
  
  public boolean matcheaHandicapMin(final Jugador jugadorEnLista, final int handicapDesde) {
    float _nivelDeJuego = jugadorEnLista.getNivelDeJuego();
    int _round = Math.round(_nivelDeJuego);
    return (_round >= handicapDesde);
  }
  
  public boolean matcheaHandicapMax(final Jugador jugadorEnLista, final int handicapHasta) {
    float _nivelDeJuego = jugadorEnLista.getNivelDeJuego();
    int _round = Math.round(_nivelDeJuego);
    return (_round <= handicapHasta);
  }
  
  public boolean matcheaPromedioMin(final Jugador jugadorEnLista, final int promedioDesde) {
    int _promedio = jugadorEnLista.getPromedio();
    int _round = Math.round(_promedio);
    return (_round >= promedioDesde);
  }
  
  public boolean matcheaPromedioMax(final Jugador jugadorEnLista, final int promedioHasta) {
    int _promedio = jugadorEnLista.getPromedio();
    int _round = Math.round(_promedio);
    return (_round <= promedioHasta);
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
