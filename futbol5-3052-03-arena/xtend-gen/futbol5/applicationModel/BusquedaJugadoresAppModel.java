package futbol5.applicationModel;

import futbol5.auxUtils.ModeloBusquedaHyP;
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
  
  private ModeloBusquedaHyP _modelo;
  
  public ModeloBusquedaHyP getModelo() {
    return this._modelo;
  }
  
  public void setModelo(final ModeloBusquedaHyP modelo) {
    this._modelo = modelo;
  }
  
  public BusquedaJugadoresAppModel() {
    Jugador _jugador = new Jugador();
    this.setJugadorEjemplo(_jugador);
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadores(_arrayList);
    HomeJugadores _homeJugadores = this.getHomeJugadores();
    List<Jugador> _jugadoresAceptados = _homeJugadores.getJugadoresAceptados();
    this.setJugadores(_jugadoresAceptados);
    ModeloBusquedaHyP _modeloBusquedaHyP = new ModeloBusquedaHyP();
    this.setModelo(_modeloBusquedaHyP);
  }
  
  public void search() {
    this.setJugadorSeleccionado(null);
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setJugadores(_arrayList);
    HomeJugadores _homeJugadores = this.getHomeJugadores();
    Jugador _jugadorEjemplo = this.getJugadorEjemplo();
    ModeloBusquedaHyP _modelo = this.getModelo();
    List<Jugador> _search = _homeJugadores.search(_jugadorEjemplo, _modelo);
    this.setJugadores(_search);
  }
  
  public void clear() {
    Jugador _jugador = new Jugador();
    this.setJugadorEjemplo(_jugador);
    this.setJugadorSeleccionado(null);
    ModeloBusquedaHyP _modeloBusquedaHyP = new ModeloBusquedaHyP();
    this.setModelo(_modeloBusquedaHyP);
    this.search();
  }
  
  public HomeJugadores getHomeJugadores() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeJugadores>getSingleton(Jugador.class);
  }
}
