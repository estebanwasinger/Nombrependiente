package prueba.conversor;

import com.google.common.base.Objects;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.utils.Observable;
import prueba.conversor.Materia;

@Observable
@SuppressWarnings("all")
public class HomeMaterias extends CollectionBasedHome<Materia> {
  public HomeMaterias() {
    this.init();
  }
  
  public void init() {
    this.create("Diseño de sistemas");
    this.create("Analisis Matematico 1");
    this.create("Algoritmos");
  }
  
  public void create(final String pNombre) {
    Materia celular = new Materia();
    celular.setNombre(pNombre);
    this.create(celular);
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
    final Function1<Materia, Boolean> _function = new Function1<Materia, Boolean>() {
      public Boolean apply(final Materia celular) {
        String _nombre = celular.getNombre();
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
