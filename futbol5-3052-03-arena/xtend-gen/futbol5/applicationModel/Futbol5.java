package futbol5.applicationModel;

import futbol5.applicationModel.BusquedaJugador;
import futbol5.domain.Jugador;
import futbol5.domain.Partido;
import futbol5.homes.HomeJugadores;
import futbol5.homes.HomePartidos;
import infracciones.Infraccion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Futbol5 implements Serializable {
  private Jugador _jugadorEjemplo;
  
  public Jugador getJugadorEjemplo() {
    return this._jugadorEjemplo;
  }
  
  public void setJugadorEjemplo(final Jugador jugadorEjemplo) {
    this._jugadorEjemplo = jugadorEjemplo;
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
  
  private Partido _partido;
  
  public Partido getPartido() {
    return this._partido;
  }
  
  public void setPartido(final Partido partido) {
    this._partido = partido;
  }
  
  private Jugador _jugadorSeleccionado;
  
  public Jugador getJugadorSeleccionado() {
    return this._jugadorSeleccionado;
  }
  
  public void setJugadorSeleccionado(final Jugador jugadorSeleccionado) {
    this._jugadorSeleccionado = jugadorSeleccionado;
  }
  
  private List<Infraccion> _infracciones;
  
  public List<Infraccion> getInfracciones() {
    return this._infracciones;
  }
  
  public void setInfracciones(final List<Infraccion> infracciones) {
    this._infracciones = infracciones;
  }
  
  private HomeJugadores _homeJugadores;
  
  public HomeJugadores getHomeJugadores() {
    return this._homeJugadores;
  }
  
  public void setHomeJugadores(final HomeJugadores homeJugadores) {
    this._homeJugadores = homeJugadores;
  }
  
  public Futbol5() {
    HomeJugadores _homeJugadores = new HomeJugadores();
    this.setHomeJugadores(_homeJugadores);
    Jugador _jugador = new Jugador();
    this.setJugadorEjemplo(_jugador);
  }
  
  public void search(final Jugador jugador) {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setResultados(_arrayList);
    HomeJugadores _homeJugadores = this.getHomeJugadores();
    List<Jugador> _search = _homeJugadores.search(jugador);
    this.setResultados(_search);
    List<Jugador> _resultados = this.getResultados();
    int _size = _resultados.size();
    InputOutput.<Integer>println(Integer.valueOf(_size));
  }
  
  public void searchPartido() {
    ArrayList<Partido> _arrayList = new ArrayList<Partido>();
    this.setPartidos(_arrayList);
    HomePartidos _homePartidos = this.getHomePartidos();
    Partido _partido = this.getPartido();
    List<Partido> _search = _homePartidos.search(_partido);
    this.setPartidos(_search);
  }
  
  public void clear() {
    Jugador _jugador = new Jugador();
    this.setJugadorEjemplo(_jugador);
  }
  
  /**
   * def HomeJugadores getHomeJugadores() {
   * ApplicationContext.instance.getSingleton(typeof(Jugador))
   * }
   */
  public HomePartidos getHomePartidos() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomePartidos>getSingleton(Partido.class);
  }
}
