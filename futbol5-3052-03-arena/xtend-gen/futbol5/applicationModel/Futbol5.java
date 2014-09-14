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
public class Futbol5 implements Serializable {
  private Integer _numero;
  
  public Integer getNumero() {
    return this._numero;
  }
  
  public void setNumero(final Integer numero) {
    this._numero = numero;
  }
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
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
  
  private List<Jugador> _resultados;
  
  public List<Jugador> getResultados() {
    return this._resultados;
  }
  
  public void setResultados(final List<Jugador> resultados) {
    this._resultados = resultados;
  }
  
  public void search() {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setResultados(_arrayList);
    HomeJugadores _homeJugadores = this.getHomeJugadores();
    String _nombre = this.getNombre();
    List<Jugador> _search = _homeJugadores.search(_nombre);
    this.setResultados(_search);
  }
  
  public void clear() {
    this.setNombre(null);
  }
  
  public HomeJugadores getHomeJugadores() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeJugadores>getSingleton(Jugador.class);
  }
}
