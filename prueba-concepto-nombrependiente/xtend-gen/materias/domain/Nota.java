package materias.domain;

import com.google.common.base.Objects;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import materias.domain.Materia;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Nota extends Entity implements Cloneable {
  private String _nombreMateria;
  
  public String getNombreMateria() {
    return this._nombreMateria;
  }
  
  public void setNombreMateria(final String nombreMateria) {
    this._nombreMateria = nombreMateria;
  }
  
  private String _fecha;
  
  public String getFecha() {
    return this._fecha;
  }
  
  public void setFecha(final String fecha) {
    this._fecha = fecha;
  }
  
  private String _descripcion;
  
  public String getDescripcion() {
    return this._descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this._descripcion = descripcion;
  }
  
  private boolean _aprobado;
  
  public boolean isAprobado() {
    return this._aprobado;
  }
  
  public void setAprobado(final boolean aprobado) {
    this._aprobado = aprobado;
  }
  
  public Nota() {
  }
  
  public Nota(final String fechaN, final String descripcionN, final Boolean estadoAprobacion) {
    this.setFecha(fechaN);
    this.setDescripcion(descripcionN);
    this.setAprobado((estadoAprobacion).booleanValue());
    this.setNombreMateria("Hola");
  }
  
  public void validarDescripcion() {
    String _descripcion = this.getDescripcion();
    boolean _equals = Objects.equal(_descripcion, null);
    if (_equals) {
      throw new UserException("Debe ingresar una descripción");
    }
  }
  
  public void validarFecha() {
    try {
      DateFormat instance = DateFormat.getInstance();
      String _fecha = this.getFecha();
      Date dateNota = instance.parse(_fecha);
      Calendar cal = Calendar.getInstance();
      cal.setTime(dateNota);
      int anioNota = cal.get(Calendar.YEAR);
      String _anioCursada = this.getAnioCursada();
      int _parseInt = Integer.parseInt(_anioCursada);
      boolean _notEquals = (anioNota != _parseInt);
      if (_notEquals) {
        throw new UserException("El año de la cursada debe ser igual al de la nota");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getAnioCursada() {
    String _xblockexpression = null;
    {
      Materia materia = new Materia();
      String _nombreMateria = this.getNombreMateria();
      _xblockexpression = materia.getAnioMateria(_nombreMateria);
    }
    return _xblockexpression;
  }
  
  public Object clone() {
    try {
      return super.clone();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
