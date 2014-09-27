package futbol5.applicationModel;

import futbol5.domain.Jugador;
import futbol5.homes.HomeJugadores;
import java.io.Serializable;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class VisualizacionDatosAppModel implements Serializable {
  private Jugador _jugadorModelo;
  
  public Jugador getJugadorModelo() {
    return this._jugadorModelo;
  }
  
  public void setJugadorModelo(final Jugador jugadorModelo) {
    this._jugadorModelo = jugadorModelo;
  }
  
  private int _promedioUltimoPartido;
  
  public int getPromedioUltimoPartido() {
    return this._promedioUltimoPartido;
  }
  
  public void setPromedioUltimoPartido(final int promedioUltimoPartido) {
    this._promedioUltimoPartido = promedioUltimoPartido;
  }
  
  private int _promedioTotal;
  
  public int getPromedioTotal() {
    return this._promedioTotal;
  }
  
  public void setPromedioTotal(final int promedioTotal) {
    this._promedioTotal = promedioTotal;
  }
  
  public VisualizacionDatosAppModel() {
    Jugador _jugador = new Jugador();
    this.setJugadorModelo(_jugador);
    Jugador _jugadorModelo = this.getJugadorModelo();
    Jugador _jugadorModelo_1 = this.getJugadorModelo();
    int _cantidadPartidos = _jugadorModelo_1.getCantidadPartidos();
    float _promedioNPartidos = _jugadorModelo.promedioNPartidos(_cantidadPartidos);
    int _round = Math.round(_promedioNPartidos);
    this.setPromedioUltimoPartido(_round);
    Jugador _jugadorModelo_2 = this.getJugadorModelo();
    int _promedio = _jugadorModelo_2.getPromedio();
    int _round_1 = Math.round(_promedio);
    this.setPromedioTotal(_round_1);
  }
  
  public HomeJugadores getHomeJugadores() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeJugadores>getSingleton(Jugador.class);
  }
}
