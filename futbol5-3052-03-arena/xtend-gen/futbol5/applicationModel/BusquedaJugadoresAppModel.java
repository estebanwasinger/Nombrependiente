package futbol5.applicationModel;

import com.google.common.collect.Lists;
import futbol5.domain.Jugador;
import futbol5.homes.RepositorioJugadores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;
import strategyHandicap.HandicapDesde;
import strategyHandicap.HandicapHasta;
import strategyHandicap.HandicapStrategy;

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
  
  private List<Jugador> _jugadores;
  
  public List<Jugador> getJugadores() {
    return this._jugadores;
  }
  
  public void setJugadores(final List<Jugador> jugadores) {
    this._jugadores = jugadores;
  }
  
  private Jugador _jugadorSeleccionado;
  
  public Jugador getJugadorSeleccionado() {
    return this._jugadorSeleccionado;
  }
  
  public void setJugadorSeleccionado(final Jugador jugadorSeleccionado) {
    this._jugadorSeleccionado = jugadorSeleccionado;
  }
  
  private Integer _handicap;
  
  public Integer getHandicap() {
    return this._handicap;
  }
  
  public void setHandicap(final Integer handicap) {
    this._handicap = handicap;
  }
  
  private Integer _promedioDesde;
  
  public Integer getPromedioDesde() {
    return this._promedioDesde;
  }
  
  public void setPromedioDesde(final Integer promedioDesde) {
    this._promedioDesde = promedioDesde;
  }
  
  private Integer _promedioHasta;
  
  public Integer getPromedioHasta() {
    return this._promedioHasta;
  }
  
  public void setPromedioHasta(final Integer promedioHasta) {
    this._promedioHasta = promedioHasta;
  }
  
  private String _infracciones;
  
  public String getInfracciones() {
    return this._infracciones;
  }
  
  public void setInfracciones(final String infracciones) {
    this._infracciones = infracciones;
  }
  
  private HandicapStrategy _metodoHandicap;
  
  public HandicapStrategy getMetodoHandicap() {
    return this._metodoHandicap;
  }
  
  public void setMetodoHandicap(final HandicapStrategy metodoHandicap) {
    this._metodoHandicap = metodoHandicap;
  }
  
  public BusquedaJugadoresAppModel() {
    this.iniciar();
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadores(_arrayList);
    RepositorioJugadores _homeJugadores = this.getHomeJugadores();
    List<Jugador> _allInstances = _homeJugadores.allInstances();
    this.setJugadores(_allInstances);
  }
  
  public void search() {
    this.setJugadorSeleccionado(null);
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadores(_arrayList);
    RepositorioJugadores _homeJugadores = this.getHomeJugadores();
    List<Jugador> _search = _homeJugadores.search(this);
    this.setJugadores(_search);
  }
  
  public void clear() {
    this.iniciar();
    this.setJugadorSeleccionado(null);
    this.search();
  }
  
  public void iniciar() {
    Jugador _jugador = new Jugador();
    this.setJugadorEjemplo(_jugador);
    this.setHandicap(null);
    this.setPromedioDesde(null);
    this.setPromedioHasta(null);
    this.setInfracciones("Todos");
    List<? extends HandicapStrategy> _handicaps = this.getHandicaps();
    HandicapStrategy _get = _handicaps.get(0);
    this.setMetodoHandicap(_get);
  }
  
  public RepositorioJugadores getHomeJugadores() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<RepositorioJugadores>getSingleton(Jugador.class);
  }
  
  public List<? extends HandicapStrategy> getHandicaps() {
    HandicapHasta _handicapHasta = new HandicapHasta();
    HandicapDesde _handicapDesde = new HandicapDesde();
    return Collections.<HandicapStrategy>unmodifiableList(Lists.<HandicapStrategy>newArrayList(_handicapHasta, _handicapDesde));
  }
}
