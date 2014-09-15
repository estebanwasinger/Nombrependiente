package futbol5.applicationModel;

import futbol5.applicationModel.BusquedaJugador;
import futbol5.domain.Jugador;
import futbol5.domain.Partido;
import futbol5.homes.HomeJugadores;
import futbol5.homes.HomePartidos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Futbol5 implements Serializable {
  private Jugador _jugador;
  
  public Jugador getJugador() {
    return this._jugador;
  }
  
  public void setJugador(final Jugador jugador) {
    this._jugador = jugador;
  }
  
  private Integer _numero;
  
  public Integer getNumero() {
    return this._numero;
  }
  
  public void setNumero(final Integer numero) {
    this._numero = numero;
  }
  
  private String _apodo;
  
  public String getApodo() {
    return this._apodo;
  }
  
  public void setApodo(final String apodo) {
    this._apodo = apodo;
  }
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private Date _fechaNacimiento;
  
  public Date getFechaNacimiento() {
    return this._fechaNacimiento;
  }
  
  public void setFechaNacimiento(final Date fechaNacimiento) {
    this._fechaNacimiento = fechaNacimiento;
  }
  
  private int _nivelDeJuego;
  
  public int getNivelDeJuego() {
    return this._nivelDeJuego;
  }
  
  public void setNivelDeJuego(final int nivelDeJuego) {
    this._nivelDeJuego = nivelDeJuego;
  }
  
  private Jugador _seleccionJugador;
  
  public Jugador getSeleccionJugador() {
    return this._seleccionJugador;
  }
  
  public void setSeleccionJugador(final Jugador seleccionJugador) {
    this._seleccionJugador = seleccionJugador;
  }
  
  private List<Jugador> _resultados;
  
  public List<Jugador> getResultados() {
    return this._resultados;
  }
  
  public void setResultados(final List<Jugador> resultados) {
    this._resultados = resultados;
  }
  
  private BusquedaJugador _busquedaJugadores;
  
  public BusquedaJugador getBusquedaJugadores() {
    return this._busquedaJugadores;
  }
  
  public void setBusquedaJugadores(final BusquedaJugador busquedaJugadores) {
    this._busquedaJugadores = busquedaJugadores;
  }
  
  private List<Partido> _partidos;
  
  public List<Partido> getPartidos() {
    return this._partidos;
  }
  
  public void setPartidos(final List<Partido> partidos) {
    this._partidos = partidos;
  }
  
  public Futbol5() {
    HomePartidos _homePartidos = new HomePartidos();
    List<Partido> _partidos = _homePartidos.getPartidos();
    this.setPartidos(_partidos);
  }
  
  public void search(final Jugador jugador) {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setResultados(_arrayList);
    HomeJugadores _homeJugadores = this.getHomeJugadores();
    List<Jugador> _search = _homeJugadores.search(jugador);
    this.setResultados(_search);
  }
  
  public void clear() {
    this.setNombre(null);
  }
  
  public HomeJugadores getHomeJugadores() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeJugadores>getSingleton(Jugador.class);
  }
  
  public HomeJugadores getHomePartidos() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeJugadores>getSingleton(Partido.class);
  }
}
