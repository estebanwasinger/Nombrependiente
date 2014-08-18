package materias.domain;

import com.google.common.base.Objects;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import materias.domain.Materia;
import materias.home.HomeNotas;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Nota extends Entity {
  private String _nombreMateria;
  
  public String getNombreMateria() {
    return this._nombreMateria;
  }
  
  public void setNombreMateria(final String nombreMateria) {
    this._nombreMateria = nombreMateria;
  }
  
  private Date _fecha;
  
  public Date getFecha() {
    return this._fecha;
  }
  
  public void setFecha(final Date fecha) {
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
  
  public void validarDescripcion() {
    String _descripcion = this.getDescripcion();
    boolean _equals = Objects.equal(_descripcion, null);
    if (_equals) {
      throw new UserException("Debe ingresar una descripción");
    }
  }
  
  public void validarFecha() {
    Calendar cal = Calendar.getInstance();
    Date _fecha = this.getFecha();
    cal.setTime(_fecha);
    int anioNota = cal.get(Calendar.YEAR);
    String _anioCursada = this.getAnioCursada();
    boolean _notEquals = (!Objects.equal(Integer.valueOf(anioNota), _anioCursada));
    if (_notEquals) {
      throw new UserException("El año de la cursada debe ser igual al de la nota");
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
  
  public void agregarNota() {
    this.validarFecha();
    this.validarDescripcion();
    HomeNotas _homeNotas = this.getHomeNotas();
    String _nombreMateria = this.getNombreMateria();
    Date _fecha = this.getFecha();
    String _descripcion = this.getDescripcion();
    boolean _isAprobado = this.isAprobado();
    _homeNotas.create(_nombreMateria, _fecha, _descripcion, _isAprobado);
  }
  
  public HomeNotas getHomeNotas() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeNotas>getSingleton(Nota.class);
  }
  
  public List<Nota> getNotas() {
    HomeNotas _homeNotas = this.getHomeNotas();
    String _nombreMateria = this.getNombreMateria();
    return _homeNotas.getNotas(_nombreMateria);
  }
}
