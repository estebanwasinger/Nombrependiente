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
  
  public BusquedaJugadoresAppModel() {
    Jugador _jugador = new Jugador();
    this.setJugadorEjemplo(_jugador);
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadores(_arrayList);
    HomeJugadores _homeJugadores = this.getHomeJugadores();
    List<Jugador> _jugadoresAceptados = _homeJugadores.getJugadoresAceptados();
    this.setJugadores(_jugadoresAceptados);
    Float _float = new Float(0.0F);
    this.setHandicapDesde(_float);
    Float _float_1 = new Float(0.0F);
    this.setHandicapHasta(_float_1);
  }
  
  public void search() {
    HomeJugadores _homeJugadores = this.getHomeJugadores();
    Float _handicapDesde = this.getHandicapDesde();
    _homeJugadores.setHandicapDesde(_handicapDesde);
    HomeJugadores _homeJugadores_1 = this.getHomeJugadores();
    Float _handicapHasta = this.getHandicapHasta();
    _homeJugadores_1.setHandicapHasta(_handicapHasta);
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadores(_arrayList);
    HomeJugadores _homeJugadores_2 = this.getHomeJugadores();
    Jugador _jugadorEjemplo = this.getJugadorEjemplo();
    List<Jugador> _search = _homeJugadores_2.search(_jugadorEjemplo);
    this.setJugadores(_search);
  }
  
  public void clear() {
    Jugador _jugador = new Jugador();
    this.setJugadorEjemplo(_jugador);
    this.setJugadorSeleccionado(null);
    this.setHandicapDesde(Float.valueOf(0.0F));
    this.setHandicapHasta(Float.valueOf(0.0F));
    this.search();
  }
  
  public HomeJugadores getHomeJugadores() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeJugadores>getSingleton(Jugador.class);
  }
}
