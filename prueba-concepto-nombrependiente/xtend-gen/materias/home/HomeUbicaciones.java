package materias.home;

import java.util.List;
import materias.domain.Ubicacion;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class HomeUbicaciones extends CollectionBasedHome<Ubicacion> {
  public HomeUbicaciones() {
    this.init();
  }
  
  public void init() {
    this.create("1er Cuatrimestre - 1 Año");
    this.create("1er Cuatrimestre - 2 Año");
    this.create("1er Cuatrimestre - 3 Año");
    this.create("1er Cuatrimestre - 4 Año");
    this.create("1er Cuatrimestre - 5 Año");
    this.create("2do Cuatrimestre - 1 Año");
    this.create("2do Cuatrimestre - 2 Año");
    this.create("2do Cuatrimestre - 3 Año");
    this.create("2do Cuatrimestre - 4 Año");
    this.create("2do Cuatrimestre - 5 Año");
  }
  
  public void create(final String descripcion) {
    Ubicacion ubicacion = new Ubicacion();
    ubicacion.setDescripcion(descripcion);
    this.create(ubicacion);
  }
  
  public List<Ubicacion> getUbicaciones() {
    return this.allInstances();
  }
  
  public Ubicacion get(final String descripcion) {
    List<Ubicacion> _ubicaciones = this.getUbicaciones();
    final Function1<Ubicacion, Boolean> _function = new Function1<Ubicacion, Boolean>() {
      public Boolean apply(final Ubicacion ubicacion) {
        String _descripcion = ubicacion.getDescripcion();
        return Boolean.valueOf(_descripcion.equals(descripcion));
      }
    };
    return IterableExtensions.<Ubicacion>findFirst(_ubicaciones, _function);
  }
  
  public Class<Ubicacion> getEntityType() {
    return Ubicacion.class;
  }
  
  public Ubicacion createExample() {
    return new Ubicacion();
  }
  
  public Predicate getCriterio(final Ubicacion example) {
    return null;
  }
}
