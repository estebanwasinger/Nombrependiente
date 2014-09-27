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
  
  private int _handicapDesde;
  
  public int getHandicapDesde() {
    return this._handicapDesde;
  }
  
  public void setHandicapDesde(final int handicapDesde) {
    this._handicapDesde = handicapDesde;
  }
  
  private int _handicapHasta;
  
  public int getHandicapHasta() {
    return this._handicapHasta;
  }
  
  public void setHandicapHasta(final int handicapHasta) {
    this._handicapHasta = handicapHasta;
  }
  
  private int _promedioDesde;
  
  public int getPromedioDesde() {
    return this._promedioDesde;
  }
  
  public void setPromedioDesde(final int promedioDesde) {
    this._promedioDesde = promedioDesde;
  }
  
  private int _promedioHasta;
  
  public int getPromedioHasta() {
    return this._promedioHasta;
  }
  
  public void setPromedioHasta(final int promedioHasta) {
    this._promedioHasta = promedioHasta;
  }
  
  private String _infracciones;
  
  public String getInfracciones() {
    return this._infracciones;
  }
  
  public void setInfracciones(final String infracciones) {
    this._infracciones = infracciones;
  }
  
  public BusquedaJugadoresAppModel() {
    this.iniciar();
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadores(_arrayList);
    HomeJugadores _homeJugadores = this.getHomeJugadores();
    List<Jugador> _jugadoresAceptados = _homeJugadores.getJugadoresAceptados();
    this.setJugadores(_jugadoresAceptados);
  }
  
  public void search() {
    this.setJugadorSeleccionado(null);
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadores(_arrayList);
    HomeJugadores _homeJugadores = this.getHomeJugadores();
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
    this.setHandicapDesde(1);
    this.setHandicapHasta(10);
    this.setPromedioDesde(0);
    this.setPromedioHasta(10);
    this.setInfracciones("Todos");
  }
  
  public HomeJugadores getHomeJugadores() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeJugadores>getSingleton(Jugador.class);
  }
}
