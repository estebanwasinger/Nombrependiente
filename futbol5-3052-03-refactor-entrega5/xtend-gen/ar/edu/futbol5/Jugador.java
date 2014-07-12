package ar.edu.futbol5;

import ar.edu.futbol5.inscripcion.CriterioInscripcion;
import ar.edu.futbol5.inscripcion.ModoEstandar;
import ar.edu.futbol5.inscripcion.ModoSolidario;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Jugador {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private Double _calificacion;
  
  public Double getCalificacion() {
    return this._calificacion;
  }
  
  public void setCalificacion(final Double calificacion) {
    this._calificacion = calificacion;
  }
  
  private List<Double> _puntajes;
  
  public List<Double> getPuntajes() {
    return this._puntajes;
  }
  
  public void setPuntajes(final List<Double> puntajes) {
    this._puntajes = puntajes;
  }
  
  private CriterioInscripcion criterioInscripcion;
  
  public Jugador() {
    ArrayList<Double> _arrayList = new ArrayList<Double>();
    this.setPuntajes(_arrayList);
    this.setCalificacion(null);
    ModoEstandar _modoEstandar = new ModoEstandar();
    this.criterioInscripcion = _modoEstandar;
    this.setNombre("");
  }
  
  public Jugador(final String nombre, final double calificacion, final List<Double> puntajes) {
    this.setCalificacion(Double.valueOf(calificacion));
    this.setPuntajes(puntajes);
    ModoEstandar _modoEstandar = new ModoEstandar();
    this.criterioInscripcion = _modoEstandar;
    this.setNombre(nombre);
  }
  
  public CriterioInscripcion modoSolidario() {
    ModoSolidario _modoSolidario = new ModoSolidario();
    return this.criterioInscripcion = _modoSolidario;
  }
  
  public boolean dejaLugarAOtro() {
    Class<? extends CriterioInscripcion> _class = this.criterioInscripcion.getClass();
    boolean _equals = _class.equals(ModoSolidario.class);
    if (_equals) {
      return true;
    } else {
      return false;
    }
  }
  
  public String toString() {
    return this.getNombre();
  }
}
