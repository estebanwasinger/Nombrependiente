package materias.home;

import com.google.common.base.Objects;
import java.util.List;
import materias.domain.Nota;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class HomeNotas extends CollectionBasedHome<Nota> {
  public HomeNotas() {
    this.init();
  }
  
  public void init() {
    this.create("Diseño de Sistemas", "11/06/2013", "Parcial 1", true);
    this.create("Diseño de Sistemas", "15/11/2013", "Parcial 2", false);
    this.create("Algoritmos", "31/07/2011", "TP", true);
    this.create("Algoritmos", "15/11/2013", "Parcial 1", true);
    this.create("Diseño de Sistemas", "11/06/2013", "TP", true);
    this.create("Analisis de Sistemas", "11/06/2012", "Parcial 1", true);
    this.create("Analisis de Sistemas", "11/08/2012", "Parcial 2", true);
    this.create("Analisis de Sistemas", "20/06/2012", "TP", true);
    this.create("Sistemas Operativos", "01/03/2012", "Parcial 1", true);
    this.create("Sistemas Operativos", "30/06/2012", "Parcial 2", true);
    this.create("Sistemas Operativos", "20/06/2012", "TP", true);
  }
  
  public void create(final String materia, final String fecha, final String descripcion, final boolean aprobado) {
    Nota nota = new Nota();
    nota.setNombreMateria(materia);
    nota.setFecha(fecha);
    nota.setDescripcion(descripcion);
    nota.setAprobado(Boolean.valueOf(aprobado));
    this.create(nota);
  }
  
  public List<Nota> getNotas() {
    return this.allInstances();
  }
  
  public Class<Nota> getEntityType() {
    return Nota.class;
  }
  
  public Nota createExample() {
    return new Nota();
  }
  
  public Predicate getCriterio(final Nota example) {
    return null;
  }
  
  public List<Nota> buscar(final String nombre) {
    List<Nota> _allInstances = this.allInstances();
    final Function1<Nota,Boolean> _function = new Function1<Nota,Boolean>() {
      public Boolean apply(final Nota materia) {
        String _nombreMateria = materia.getNombreMateria();
        return Boolean.valueOf(HomeNotas.this.match(nombre, _nombreMateria));
      }
    };
    Iterable<Nota> _filter = IterableExtensions.<Nota>filter(_allInstances, _function);
    return IterableExtensions.<Nota>toList(_filter);
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
}
