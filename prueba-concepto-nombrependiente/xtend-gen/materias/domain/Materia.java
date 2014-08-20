package materias.domain;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import materias.domain.Nota;
import materias.home.HomeMaterias;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Materia extends Entity {
  private Integer _id;
  
  public Integer getId() {
    return this._id;
  }
  
  public void setId(final Integer id) {
    this._id = id;
  }
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private String _anioCursada;
  
  public String getAnioCursada() {
    return this._anioCursada;
  }
  
  public void setAnioCursada(final String anioCursada) {
    this._anioCursada = anioCursada;
  }
  
  private Boolean _finalAprobado = Boolean.valueOf(false);
  
  public Boolean getFinalAprobado() {
    return this._finalAprobado;
  }
  
  public void setFinalAprobado(final Boolean finalAprobado) {
    this._finalAprobado = finalAprobado;
  }
  
  private String _profesor;
  
  public String getProfesor() {
    return this._profesor;
  }
  
  public void setProfesor(final String profesor) {
    this._profesor = profesor;
  }
  
  private String _ubicacion;
  
  public String getUbicacion() {
    return this._ubicacion;
  }
  
  public void setUbicacion(final String ubicacion) {
    this._ubicacion = ubicacion;
  }
  
  private List<Nota> _notas;
  
  public List<Nota> getNotas() {
    return this._notas;
  }
  
  public void setNotas(final List<Nota> notas) {
    this._notas = notas;
  }
  
  public void validarNombre() {
    String _nombre = this.getNombre();
    boolean _equals = Objects.equal(_nombre, null);
    if (_equals) {
      throw new UserException("Debe ingresar un nombre de materia");
    }
  }
  
  public boolean ingresoNombre() {
    boolean _and = false;
    String _nombre = this.getNombre();
    boolean _notEquals = (!Objects.equal(_nombre, null));
    if (!_notEquals) {
      _and = false;
    } else {
      String _nombre_1 = this.getNombre();
      String _trim = _nombre_1.trim();
      boolean _equals = _trim.equals("");
      boolean _not = (!_equals);
      _and = _not;
    }
    return _and;
  }
  
  public boolean validarAnio() {
    boolean _xblockexpression = false;
    {
      Calendar cal = Calendar.getInstance();
      boolean _and = false;
      String _anioCursada = this.getAnioCursada();
      boolean _notEquals = (!Objects.equal(_anioCursada, null));
      if (!_notEquals) {
        _and = false;
      } else {
        String _anioCursada_1 = this.getAnioCursada();
        int _parseInt = Integer.parseInt(_anioCursada_1);
        int _get = cal.get(Calendar.YEAR);
        boolean _lessEqualsThan = (_parseInt <= _get);
        _and = _lessEqualsThan;
      }
      _xblockexpression = _and;
    }
    return _xblockexpression;
  }
  
  public void validarProfesor() {
    boolean _or = false;
    String _profesor = this.getProfesor();
    boolean _equals = Objects.equal(_profesor, null);
    if (_equals) {
      _or = true;
    } else {
      String _profesor_1 = this.getProfesor();
      String _trim = _profesor_1.trim();
      boolean _equals_1 = _trim.equals("");
      _or = _equals_1;
    }
    if (_or) {
      throw new UserException("Debe ingresar un nombre de profesor");
    }
  }
  
  public HomeMaterias getHomeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeMaterias>getSingleton(Materia.class);
  }
  
  public List<Materia> getMaterias() {
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    return _homeMaterias.getMaterias();
  }
  
  public void crearMateria() {
    this.validarNombre();
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    String _nombre = this.getNombre();
    ArrayList<Nota> _arrayList = new ArrayList<Nota>();
    _homeMaterias.create(_nombre, null, false, "", "", _arrayList);
  }
  
  public String getAnioMateria(final String nombre) {
    List<Materia> _materias = this.getMaterias();
    final Function1<Materia, Boolean> _function = new Function1<Materia, Boolean>() {
      public Boolean apply(final Materia materia) {
        String _nombre = materia.getNombre();
        return Boolean.valueOf(Objects.equal(_nombre, nombre));
      }
    };
    Iterable<Materia> _filter = IterableExtensions.<Materia>filter(_materias, _function);
    Materia _head = IterableExtensions.<Materia>head(_filter);
    return _head.getAnioCursada();
  }
}
