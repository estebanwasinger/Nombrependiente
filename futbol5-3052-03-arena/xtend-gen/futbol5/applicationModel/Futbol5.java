package futbol5.applicationModel;

import futbol5.domain.Jugador;
import futbol5.homes.HomeJugadores;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
  }
  
  public void clear() {
    this.setNombre(null);
  }
  
  public HomeJugadores getHomeJugadores() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeJugadores>getSingleton(Jugador.class);
  }
}
