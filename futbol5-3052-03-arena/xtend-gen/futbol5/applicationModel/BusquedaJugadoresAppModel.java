package futbol5.applicationModel;

import futbol5.domain.Jugador;
import futbol5.homes.HomeJugadores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class BusquedaJugadoresAppModel implements Serializable {
  private Jugador _jugadorEjemplo;
  
  public Jugador getJugadorEjemplo() {
    return this._jugadorEjemplo;
  }
  
  public void setJugadorEjemplo(final Jugador jugadorEjemplo) {
    this._jugadorEjemplo = jugadorEjemplo;
  }
  
  private ArrayList<Jugador> _jugadores;
  
  public ArrayList<Jugador> getJugadores() {
    return this._jugadores;
  }
  
  public void setJugadores(final ArrayList<Jugador> jugadores) {
    this._jugadores = jugadores;
  }
  
  /**
   * @Property Integer numero
   * @Property String apodo
   * @Property String nombre
   * @Property int nivelDeJuego
   */
  private List<Jugador> _resultados;
  
  /**
   * @Property Integer numero
   * @Property String apodo
   * @Property String nombre
   * @Property int nivelDeJuego
   */
  public List<Jugador> getResultados() {
    return this._resultados;
  }
  
  /**
   * @Property Integer numero
   * @Property String apodo
   * @Property String nombre
   * @Property int nivelDeJuego
   */
  public void setResultados(final List<Jugador> resultados) {
    this._resultados = resultados;
  }
  
  /**
   * @Property List<Partido> partidos
   * @Property Partido partido
   */
  private Jugador _jugadorSeleccionado;
  
  /**
   * @Property List<Partido> partidos
   * @Property Partido partido
   */
  public Jugador getJugadorSeleccionado() {
    return this._jugadorSeleccionado;
  }
  
  /**
   * @Property List<Partido> partidos
   * @Property Partido partido
   */
  public void setJugadorSeleccionado(final Jugador jugadorSeleccionado) {
    this._jugadorSeleccionado = jugadorSeleccionado;
  }
  
  /**
   * @Property List<Infraccion> infracciones
   * @Property HomeJugadores homeJugadores
   */
  private String _tipoHandicap;
  
  /**
   * @Property List<Infraccion> infracciones
   * @Property HomeJugadores homeJugadores
   */
  public String getTipoHandicap() {
    return this._tipoHandicap;
  }
  
  /**
   * @Property List<Infraccion> infracciones
   * @Property HomeJugadores homeJugadores
   */
  public void setTipoHandicap(final String tipoHandicap) {
    this._tipoHandicap = tipoHandicap;
  }
  
  public BusquedaJugadoresAppModel() {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadores(_arrayList);
    HomeJugadores _homeJugadores = this.homeJugadores();
    ArrayList<Jugador> _jugadoresAceptados = _homeJugadores.getJugadoresAceptados();
    this.setJugadores(_jugadoresAceptados);
  }
  
  public void search(final Jugador jugador) {
    this.homeJugadores();
    String _tipoHandicap = this.getTipoHandicap();
    this.setTipoHandicap(_tipoHandicap);
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setResultados(_arrayList);
    HomeJugadores _homeJugadores = this.homeJugadores();
    Jugador _jugadorEjemplo = this.getJugadorEjemplo();
    List<Jugador> _search = _homeJugadores.search(_jugadorEjemplo);
    this.setResultados(_search);
  }
  
  /**
   * def cumple(Jugador jugador) {
   * (!ingresoHandicapDesde || jugador.nivelDeJuego >= handicapDesde) &&
   * (!ingresoHandicapHasta || jugador.nivelDeJuego <= handicapDesde) // aca se agregan las distintas validaciones de las busquedas para los puntos siguientes
   * }
   * 
   * def ingresoHandicapDesde() {
   * !handicapDesde.equals(0)
   * }
   * 
   * def ingresoHandicapHasta() {
   * !handicapHasta.equals(10000)
   * }
   */
  public void clear() {
    Jugador _jugador = new Jugador();
    this.setJugadorEjemplo(_jugador);
  }
  
  public HomeJugadores homeJugadores() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Jugador.class);
    return ((HomeJugadores) _singleton);
  }
}
