package futbol5.homes;

import calificaciones.Calificacion;
import java.util.List;
import uqbar.arena.persistence.PersistentHome;

@SuppressWarnings("all")
public class RepositorioCalificaciones extends PersistentHome<Calificacion> {
  public Class<Calificacion> getEntityType() {
    return Calificacion.class;
  }
  
  public Calificacion createExample() {
    return null;
  }
  
  public Calificacion get(final int id) {
    List<Calificacion> calificaciones = this.allInstances();
    for (final Calificacion cal : calificaciones) {
      Integer _id = cal.getId();
      boolean _equals = ((_id).intValue() == id);
      if (_equals) {
        return cal;
      }
    }
    return null;
  }
  
  public Calificacion createCal(final Calificacion cal) {
    Calificacion _xblockexpression = null;
    {
      this.create(cal);
      _xblockexpression = cal;
    }
    return _xblockexpression;
  }
}
