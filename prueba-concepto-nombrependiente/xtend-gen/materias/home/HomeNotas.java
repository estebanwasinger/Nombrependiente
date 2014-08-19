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
  }
  
  public void create(final String materia, final String fecha, final String descripcion, final boolean aprobado) {
    Nota nota = new Nota();
    nota.setNombreMateria(materia);
    nota.setFecha(fecha);
    nota.setDescripcion(descripcion);
    nota.setAprobado(Boolean.valueOf(aprobado));
    this.create(nota);
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
  
  public List<Nota> getNotas(final String nombreMateria) {
    List<Nota> _allInstances = this.allInstances();
    final Function1<Nota, Boolean> _function = new Function1<Nota, Boolean>() {
      public Boolean apply(final Nota materia) {
        String _nombreMateria = materia.getNombreMateria();
        return Boolean.valueOf(Objects.equal(_nombreMateria, nombreMateria));
      }
    };
    Iterable<Nota> _filter = IterableExtensions.<Nota>filter(_allInstances, _function);
    return IterableExtensions.<Nota>toList(_filter);
  }
}
