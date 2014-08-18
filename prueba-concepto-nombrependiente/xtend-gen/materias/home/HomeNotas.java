package materias.home;

import com.google.common.base.Objects;
import java.util.Date;
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
    Date _date = new Date();
    this.create("Diseño de Sistemas", _date, "Parcial", true);
    Date _date_1 = new Date();
    this.create("Algoritmos", _date_1, "TP", true);
  }
  
  public void create(final String materia, final Date fecha, final String descripcion, final boolean aprobado) {
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
    final Function1<Nota,Boolean> _function = new Function1<Nota,Boolean>() {
      public Boolean apply(final Nota materia) {
        String _nombreMateria = materia.getNombreMateria();
        return Boolean.valueOf(Objects.equal(_nombreMateria, nombreMateria));
      }
    };
    Iterable<Nota> _filter = IterableExtensions.<Nota>filter(_allInstances, _function);
    return IterableExtensions.<Nota>toList(_filter);
  }
}
