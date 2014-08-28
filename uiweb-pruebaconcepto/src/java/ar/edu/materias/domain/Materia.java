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
  
  public Materia() {
    this.setProfesor("");
    this.setNombre("");
    this.setUbicacion("");
  }
  
  public Materia(final String profesor, final String nombre, final String ubicacion, final Integer anioCursada) {
    this.setProfesor(profesor);
    this.setNombre(nombre);
    this.setUbicacion(ubicacion);
    this.setAnioCursada(anioCursada);
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
        throw new BusinessException("anioCursada", "El año de cursada no puede ser posterior al año actual");
      }
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
  }
  
  public boolean matchea(final Materia materia) {
    boolean _and = false;
    boolean _matcheaAutor = this.matcheaAutor(materia);
    if (!_matcheaAutor) {
      _and = false;
    } else {
      boolean _matcheaTitulo = this.matcheaTitulo(materia);
      _and = _matcheaTitulo;
    }
    return _and;
  }
  
  public boolean matcheaTitulo(final Materia materia) {
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
  
  public boolean matcheaAutor(final Materia materia) {
    boolean _or = false;
    String _profesor = materia.getProfesor();
    boolean _equals = Objects.equal(_profesor, null);
    if (_equals) {
      _or = true;
    } else {
      String _profesor_1 = this.getProfesor();
      String _profesor_2 = materia.getProfesor();
      boolean _contains = _profesor_1.contains(_profesor_2);
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
