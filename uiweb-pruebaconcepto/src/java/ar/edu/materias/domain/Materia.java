package ar.edu.materias.domain;

import ar.edu.materias.exceptions.BusinessException;
import com.google.common.base.Objects;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class Materia implements Cloneable {
  private Long _id;
  
  public Long getId() {
    return this._id;
  }
  
  public void setId(final Long id) {
    this._id = id;
  }
  
  private String _profesor;
  
  public String getProfesor() {
    return this._profesor;
  }
  
  public void setProfesor(final String profesor) {
    this._profesor = profesor;
  }
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private String _ubicacion;
  
  public String getUbicacion() {
    return this._ubicacion;
  }
  
  public void setUbicacion(final String ubicacion) {
    this._ubicacion = ubicacion;
  }
  
  private Integer _anioCursada;
  
  public Integer getAnioCursada() {
    return this._anioCursada;
  }
  
  public void setAnioCursada(final Integer anioCursada) {
    this._anioCursada = anioCursada;
  }
  
  private String _finalAprobado;
  
  public String getFinalAprobado() {
    return this._finalAprobado;
  }
  
  public void setFinalAprobado(final String finalAprobado) {
    this._finalAprobado = finalAprobado;
  }
  
  public Materia() {
    this.setProfesor("");
    this.setNombre("");
    this.setUbicacion("");
  }
  
  public Materia(final String nombre, final String profesor, final String ubicacion, final Integer anioCursada, final String finalAprobado) {
    this.setProfesor(profesor);
    this.setNombre(nombre);
    this.setUbicacion(ubicacion);
    this.setAnioCursada(anioCursada);
    this.setFinalAprobado(finalAprobado);
  }
  
  public String toString() {
    return this.getNombre();
  }
  
  public void validar() {
    boolean _or = false;
    String _profesor = this.getProfesor();
    boolean _equals = Objects.equal(_profesor, null);
    if (_equals) {
      _or = true;
    } else {
      String _profesor_1 = this.getProfesor();
      boolean _equals_1 = _profesor_1.equals("");
      _or = _equals_1;
    }
    if (_or) {
      throw new BusinessException("profesor", "Debe completar el profesor");
    }
    boolean _or_1 = false;
    String _nombre = this.getNombre();
    boolean _equals_2 = Objects.equal(_nombre, null);
    if (_equals_2) {
      _or_1 = true;
    } else {
      String _nombre_1 = this.getNombre();
      boolean _equals_3 = _nombre_1.equals("");
      _or_1 = _equals_3;
    }
    if (_or_1) {
      throw new BusinessException("nombre", "Debe completar el nombre");
    }
    boolean _or_2 = false;
    String _ubicacion = this.getUbicacion();
    boolean _equals_4 = Objects.equal(_ubicacion, null);
    if (_equals_4) {
      _or_2 = true;
    } else {
      String _ubicacion_1 = this.getUbicacion();
      boolean _equals_5 = _ubicacion_1.equals("");
      _or_2 = _equals_5;
    }
    if (_or_2) {
      throw new BusinessException("ubicacion", "Debe completar la ubicacion");
    }
    Integer _anioCursada = this.getAnioCursada();
    boolean _equals_6 = Objects.equal(_anioCursada, null);
    if (_equals_6) {
      throw new BusinessException("anioCursada", "Debe completar el año de cursada");
    } else {
      Integer _anioCursada_1 = this.getAnioCursada();
      Date _date = new Date();
      int _year = _date.getYear();
      int _plus = (_year + 1900);
      boolean _greaterThan = ((_anioCursada_1).intValue() > _plus);
      if (_greaterThan) {
        throw new BusinessException("anioCursada", "El año de cursada no puede ser posterior al a�o actual");
      }
    }
    boolean _or_3 = false;
    String _finalAprobado = this.getFinalAprobado();
    boolean _equals_5 = Objects.equal(_finalAprobado, null);
    if (_equals_5) {
      _or_3 = true;
    } else {
      String _finalAprobado_1 = this.getFinalAprobado();
      boolean _equals_7 = _finalAprobado_1.equals("");
      _or_3 = _equals_7;
    }
   }
  
  public void actualizarCon(final Materia materia) {
    String _profesor = materia.getProfesor();
    this.setProfesor(_profesor);
    String _nombre = materia.getNombre();
    this.setNombre(_nombre);
    String _ubicacion = materia.getUbicacion();
    this.setUbicacion(_ubicacion);
    Integer _anioCursada = materia.getAnioCursada();
    this.setAnioCursada(_anioCursada);
    String _finalAprobado = materia.getFinalAprobado();
    this.setFinalAprobado(_finalAprobado);
  }
  
  public boolean matchea(final Materia materia) {
    boolean _or = false;
    String _nombre = materia.getNombre();
    boolean _equals = Objects.equal(_nombre, null);
    if (_equals) {
      _or = true;
    } else {
      String _nombre_1 = this.getNombre();
      String _nombre_2 = materia.getNombre();
      boolean _contains = _nombre_1.contains(_nombre_2);
      _or = _contains;
    }
    return _or;
  }
  
  public Materia copy() {
    try {
      Object _clone = super.clone();
      return ((Materia) _clone);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
