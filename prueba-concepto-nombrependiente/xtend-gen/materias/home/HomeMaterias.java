package materias.home;

import com.google.common.base.Objects;
import java.util.List;
import materias.domain.Materia;
import materias.domain.Ubicacion;
import materias.home.HomeUbicaciones;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class HomeMaterias extends CollectionBasedHome<Materia> {
  public HomeMaterias() {
    this.init();
  }
  
  public void init() {
    this.create("Analisis Matematico I", "2011", false, "Cafferata", "Nivel 1 - Anual");
    this.create("Algoritmos", "2011", true, "Bruno", "Nivel 1 - 1er. Cuatrimestre");
    this.create("Analisis de sistemas", "2012", true, "Garbarini", "Nivel 2 - Anual");
    this.create("Diseño de sistemas", "2013", false, "Dodino", "Nivel 3 - 1er. Cuatrimestre");
    this.create("Sistemas Operativos", "2012", true, "Bruno", "Nivel 3 - 2do. Cuatrimestre");
  }
  
  public Ubicacion getUbicacion(final String modeloDescripcion) {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Ubicacion.class);
    return ((HomeUbicaciones) _singleton).get(modeloDescripcion);
  }
  
  public void create(final String nombre, final String anioCursada, final boolean finalAprobado, final String profesor, final String ubicacion) {
    Materia materia = new Materia();
    materia.setNombre(nombre);
    materia.setFinalAprobado(Boolean.valueOf(finalAprobado));
    materia.setAnioCursada(anioCursada);
    materia.setProfesor(profesor);
    materia.setUbicacion(ubicacion);
    this.create(materia);
  }
  
  public void validateCreate(final Materia materia) {
    materia.validarNombre();
    this.validarMateriasDuplicadas(materia);
  }
  
  public void validarMateriasDuplicadas(final Materia materia) {
    final String nombre = materia.getNombre();
    List<Materia> _search = this.search(nombre);
    boolean _isEmpty = _search.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      throw new UserException(("Ya existe una materia con el nombre " + nombre));
    }
  }
  
  public List<Materia> getMaterias() {
    return this.allInstances();
  }
  
  /**
   * Busca los celulares que coincidan con los datos recibidos. Tanto número como nombre pueden ser nulos,
   * en ese caso no se filtra por ese atributo.
   * 
   * Soporta búsquedas por substring, por ejemplo el celular (12345, "Juan Gonzalez") será contemplado por
   * la búsqueda (23, "Gonza")
   */
  public List<Materia> search(final String nombre) {
    List<Materia> _allInstances = this.allInstances();
    final Function1<Materia,Boolean> _function = new Function1<Materia,Boolean>() {
      public Boolean apply(final Materia materia) {
        String _nombre = materia.getNombre();
        return Boolean.valueOf(HomeMaterias.this.match(nombre, _nombre));
      }
    };
    Iterable<Materia> _filter = IterableExtensions.<Materia>filter(_allInstances, _function);
    return IterableExtensions.<Materia>toList(_filter);
  }
  
  public boolean match(final Object expectedValue, final Object realValue) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(expectedValue, null);
      if (_equals) {
        return true;
      }
      boolean _equals_1 = Objects.equal(realValue, null);
      if (_equals_1) {
        return false;
      }
      String _string = realValue.toString();
      String _lowerCase = _string.toLowerCase();
      String _string_1 = expectedValue.toString();
      String _lowerCase_1 = _string_1.toLowerCase();
      _xblockexpression = _lowerCase.contains(_lowerCase_1);
    }
    return _xblockexpression;
  }
  
  public Class<Materia> getEntityType() {
    return Materia.class;
  }
  
  public Materia createExample() {
    return new Materia();
  }
  
  public Predicate getCriterio(final Materia example) {
    return null;
  }
}
