package futbol5.homes;

import com.google.common.base.Objects;
import futbol5.domain.Jugador;
import futbol5.domain.Partido;
import futbol5.homes.RepositorioJugadores;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
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
    this.createIfNotExists("Quilmes");
    this.createIfNotExists("Longchamps");
    this.createIfNotExists("San Miguel");
    this.createIfNotExists("CABA");
    Partido _get = this.get("CABA");
    Jugador _jugador = this.getJugador(Integer.valueOf(1));
    _get.agregarJugador(_jugador);
    Partido _get_1 = this.get("CABA");
    Jugador _jugador_1 = this.getJugador(Integer.valueOf(3));
    _get_1.agregarJugador(_jugador_1);
    Partido _get_2 = this.get("CABA");
    Jugador _jugador_2 = this.getJugador(Integer.valueOf(6));
    _get_2.agregarJugador(_jugador_2);
    Partido _get_3 = this.get("San Miguel");
    Jugador _jugador_3 = this.getJugador(Integer.valueOf(1));
    _get_3.agregarJugador(_jugador_3);
    Partido _get_4 = this.get("San Miguel");
    Jugador _jugador_4 = this.getJugador(Integer.valueOf(2));
    _get_4.agregarJugador(_jugador_4);
    Partido _get_5 = this.get("Longchamps");
    Jugador _jugador_5 = this.getJugador(Integer.valueOf(6));
    _get_5.agregarJugador(_jugador_5);
    Partido _get_6 = this.get("Longchamps");
    Jugador _jugador_6 = this.getJugador(Integer.valueOf(8));
    _get_6.agregarJugador(_jugador_6);
    Partido _get_7 = this.get("Quilmes");
    Jugador _jugador_7 = this.getJugador(Integer.valueOf(9));
    _get_7.agregarJugador(_jugador_7);
    Partido _get_8 = this.get("Quilmes");
    Jugador _jugador_8 = this.getJugador(Integer.valueOf(10));
    _get_8.agregarJugador(_jugador_8);
    Partido _get_9 = this.get("Quilmes");
    Jugador _jugador_9 = this.getJugador(Integer.valueOf(1));
    _get_9.agregarJugador(_jugador_9);
    Partido _get_10 = this.get("Quilmes");
    Jugador _jugador_10 = this.getJugador(Integer.valueOf(3));
    _get_10.agregarJugador(_jugador_10);
    Partido _get_11 = this.get("Quilmes");
    Jugador _jugador_11 = this.getJugador(Integer.valueOf(6));
    _get_11.agregarJugador(_jugador_11);
    Partido _get_12 = this.get("Quilmes");
    Jugador _jugador_12 = this.getJugador(Integer.valueOf(7));
    _get_12.agregarJugador(_jugador_12);
    Partido _get_13 = this.get("Quilmes");
    Jugador _jugador_13 = this.getJugador(Integer.valueOf(8));
    _get_13.agregarJugador(_jugador_13);
    Partido _get_14 = this.get("Quilmes");
    Jugador _jugador_14 = this.getJugador(Integer.valueOf(2));
    _get_14.agregarJugador(_jugador_14);
    Partido _get_15 = this.get("Quilmes");
    Jugador _jugador_15 = this.getJugador(Integer.valueOf(5));
    _get_15.agregarJugador(_jugador_15);
    Partido _get_16 = this.get("Quilmes");
    Jugador _jugador_16 = this.getJugador(Integer.valueOf(4));
    _get_16.agregarJugador(_jugador_16);
  }
  
  public Jugador getJugador(final Integer id) {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Jugador.class);
    return ((RepositorioJugadores) _singleton).get(id);
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
}
