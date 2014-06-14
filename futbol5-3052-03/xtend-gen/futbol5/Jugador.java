package futbol5;

import calificaciones.Calificacion;
import excepciones.BusinessException;
import futbol5.Partido;
import infracciones.Infraccion;
import inscripciones.Estandar;
import inscripciones.TipoInscripcion;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class Jugador {
  private TipoInscripcion _tipoInscripcion;
  
  public TipoInscripcion getTipoInscripcion() {
    return this._tipoInscripcion;
  }
  
  public void setTipoInscripcion(final TipoInscripcion tipoInscripcion) {
    this._tipoInscripcion = tipoInscripcion;
  }
  
  private int _edad;
  
  public int getEdad() {
    return this._edad;
  }
  
  public void setEdad(final int edad) {
    this._edad = edad;
  }
  
  private String _email;
  
  public String getEmail() {
    return this._email;
  }
  
  public void setEmail(final String email) {
    this._email = email;
  }
  
  private List<Infraccion> _infracciones;
  
  public List<Infraccion> getInfracciones() {
    return this._infracciones;
  }
  
  public void setInfracciones(final List<Infraccion> infracciones) {
    this._infracciones = infracciones;
  }
  
  private List<Jugador> _amigos;
  
  public List<Jugador> getAmigos() {
    return this._amigos;
  }
  
  public void setAmigos(final List<Jugador> amigos) {
    this._amigos = amigos;
  }
  
  private List<Calificacion> _calificaciones;
  
  public List<Calificacion> getCalificaciones() {
    return this._calificaciones;
  }
  
  public void setCalificaciones(final List<Calificacion> calificaciones) {
    this._calificaciones = calificaciones;
  }
  
  private int _nivelDeJuego;
  
  public int getNivelDeJuego() {
    return this._nivelDeJuego;
  }
  
  public void setNivelDeJuego(final int nivelDeJuego) {
    this._nivelDeJuego = nivelDeJuego;
  }
  
  public Jugador() {
    Estandar _estandar = new Estandar();
    this.setTipoInscripcion(_estandar);
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setAmigos(_arrayList);
    ArrayList<Infraccion> _arrayList_1 = new ArrayList<Infraccion>();
    this.setInfracciones(_arrayList_1);
    ArrayList<Calificacion> _arrayList_2 = new ArrayList<Calificacion>();
    this.setCalificaciones(_arrayList_2);
  }
  
  public boolean agregarAmigo(final Jugador jugador) {
    List<Jugador> _amigos = this.getAmigos();
    return _amigos.add(jugador);
  }
  
  public boolean menorA(final int edad) {
    int _edad = this.getEdad();
    return (_edad < edad);
  }
  
  public boolean tieneMasPrioridadQue(final Jugador jugador) {
    int _prioridad = this.prioridad();
    int _prioridad_1 = jugador.prioridad();
    return (_prioridad < _prioridad_1);
  }
  
  public int prioridad() {
    TipoInscripcion _tipoInscripcion = this.getTipoInscripcion();
    return _tipoInscripcion.prioridad();
  }
  
  public int promedioCalificacionesUltimoPartido() {
    throw new Error("Unresolved compilation problems:"
      + "\nno viable alternative at input \'|\'"
      + "\nThe method forEach is undefined for the type Jugador"
      + "\nThe method or field calificacion is undefined for the type Jugador"
      + "\nThe method or field calificacion is undefined for the type Jugador"
      + "\nCannot refer to the non-final variable sumaCalificaciones inside a lambda expression"
      + "\nType mismatch: cannot convert from Iterable<Calificacion> to Calificacion"
      + "\nnota cannot be resolved"
      + "\nnota cannot be resolved");
  }
  
  public boolean calificar(final Partido partido, final int nota, final String critica) {
    try {
      boolean _xblockexpression = false;
      {
        boolean _estaInscripto = partido.estaInscripto(this);
        boolean _not = (!_estaInscripto);
        if (_not) {
          throw new BusinessException("El jugador que se quiere calificar no jugo el partido indicado");
        }
        List<Calificacion> _calificaciones = this.getCalificaciones();
        Calificacion _calificacion = new Calificacion(this, partido, Integer.valueOf(nota), critica);
        _xblockexpression = _calificaciones.add(_calificacion);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
