package futbol5.homes;

import com.google.common.base.Objects;
import futbol5.auxUtils.InicializadorJugador;
import futbol5.domain.Jugador;
import futbol5.domain.Partido;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;

@SuppressWarnings("all")
public class HomePartidos extends CollectionBasedHome<Partido> {
  public HomePartidos() {
    this.init();
  }
  
  public void init() {
    ArrayList<Jugador> _crearListaDejugadores = InicializadorJugador.crearListaDejugadores(10);
    this.createCompleto("Burzaco", _crearListaDejugadores);
    ArrayList<Jugador> _crearListaDejugadores_1 = InicializadorJugador.crearListaDejugadores(10);
    this.createCompleto("Adrogue", _crearListaDejugadores_1);
    ArrayList<Jugador> _crearListaDejugadores_2 = InicializadorJugador.crearListaDejugadores(10);
    this.createCompleto("Bandfiel", _crearListaDejugadores_2);
    ArrayList<Jugador> _crearListaDejugadores_3 = InicializadorJugador.crearListaDejugadores(10);
    this.createCompleto("Lomas de Zamora", _crearListaDejugadores_3);
    ArrayList<Jugador> _crearListaDejugadores_4 = InicializadorJugador.crearListaDejugadores(10);
    this.createCompleto("Quilmes", _crearListaDejugadores_4);
    ArrayList<Jugador> _crearListaDejugadores_5 = InicializadorJugador.crearListaDejugadores(10);
    this.createCompleto("Longchamps", _crearListaDejugadores_5);
    ArrayList<Jugador> _crearListaDejugadores_6 = InicializadorJugador.crearListaDejugadores(10);
    this.createCompleto("San Miguel", _crearListaDejugadores_6);
  }
  
  public void create(final String localidad) {
    Partido partido = new Partido();
    partido.setLocalidad(localidad);
    this.create(partido);
  }
  
  public void createCompleto(final String localidad, final List<Jugador> jugadores) {
    Partido partido = new Partido();
    partido.setLocalidad(localidad);
    partido.setJugadores(jugadores);
    this.create(partido);
  }
  
  public List<Partido> search(final Partido partidoBuscado) {
    List<Partido> _xifexpression = null;
    boolean _notEquals = (!Objects.equal(partidoBuscado, null));
    if (_notEquals) {
      List<Partido> _allInstances = this.allInstances();
      final Function1<Partido, Boolean> _function = new Function1<Partido, Boolean>() {
        public Boolean apply(final Partido partido) {
          return Boolean.valueOf(HomePartidos.this.match(partido, partidoBuscado));
        }
      };
      Iterable<Partido> _filter = IterableExtensions.<Partido>filter(_allInstances, _function);
      _xifexpression = IterableExtensions.<Partido>toList(_filter);
    } else {
      this.init();
    }
    return _xifexpression;
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
