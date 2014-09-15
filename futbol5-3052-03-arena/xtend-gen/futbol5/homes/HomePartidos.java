package futbol5.homes;

import futbol5.domain.Jugador;
import futbol5.domain.Partido;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.collections15.Predicate;
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
    this.create("Burzaco");
    this.create("Adrogue");
    this.create("Bandfiel");
    this.create("Lomas de Zamora");
    this.create("Quilmes");
    this.create("Longchamps");
    this.create("San Miguel");
    List<Jugador> _crearListaDejugadores = this.crearListaDejugadores(10);
    this.createCompleto("Burzaco", _crearListaDejugadores);
    List<Jugador> _crearListaDejugadores_1 = this.crearListaDejugadores(10);
    this.createCompleto("Adrogue", _crearListaDejugadores_1);
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
        Jugador _jugador = new Jugador();
        _jugadores.add(_jugador);
        a = (a + 1);
      }
      _while = (a < max);
    }
    return this.getJugadores();
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
