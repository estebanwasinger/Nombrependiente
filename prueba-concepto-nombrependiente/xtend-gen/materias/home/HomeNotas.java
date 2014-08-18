package materias.home;

import java.util.Date;
import materias.domain.Nota;
import org.apache.commons.collections15.Predicate;
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
    this.create("Matemática Discreta", _date, "Parcial", true);
  }
  
  public void create(final String materia, final Date fecha, final String descripcion, final boolean aprobado) {
    Nota nota = new Nota();
    nota.setNombreMateria(materia);
    nota.setFecha(fecha);
    nota.setDescripcion(descripcion);
    nota.setAprobado(aprobado);
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
}
