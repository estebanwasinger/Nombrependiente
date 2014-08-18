package materias.domain;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import materias.home.HomeMaterias;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
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
  
  private int _anioCursada;
  
  public int getAnioCursada() {
    return this._anioCursada;
  }
  
  public void setAnioCursada(final int anioCursada) {
    this._anioCursada = anioCursada;
  }
  
  private Boolean _finalAprobado;
  
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
  
  private final List<String> posiblesUbicaciones = Collections.<String>unmodifiableList(Lists.<String>newArrayList("Nivel 1 - 1er. Cuatrimestre", "Nivel 1 - 2do. Cuatrimestre", "Nivel 1 - Anual", "Nivel 2 - 1er. Cuatrimestre", "Nivel 2 - 2do. Cuatrimestre", "Nivel 2 - Anual", "Nivel 3 - 1er. Cuatrimestre", "Nivel 3 - 2do. Cuatrimestre", "Nivel 3 - Anual", "Nivel 4 - 1er. Cuatrimestre", "Nivel 4 - 2do. Cuatrimestre", "Nivel 4 - Anual", "Nivel 5 - 1er. Cuatrimestre", "Nivel 5 - 2do. Cuatrimestre", "Nivel 5 - Anual"));
  
  public List<Object> asObjects(final List<?> list) {
    final Function1<Object, Object> _function = new Function1<Object, Object>() {
      public Object apply(final Object it) {
        return ((Object) it);
      }
    };
    return ListExtensions.map(list, _function);
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
      int _anioCursada = this.getAnioCursada();
      boolean _greaterEqualsThan = (_anioCursada >= 1900);
      if (!_greaterEqualsThan) {
        _and = false;
      } else {
        int _anioCursada_1 = this.getAnioCursada();
        int _get = cal.get(Calendar.YEAR);
        boolean _lessEqualsThan = (_anioCursada_1 <= _get);
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
  
  public List<Object> getUbicacionesPosibles() {
    return this.asObjects(this.posiblesUbicaciones);
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
    _homeMaterias.create(_nombre, 0, false, "", "");
  }
  
  public int getAnioMateria(final String nombre) {
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
