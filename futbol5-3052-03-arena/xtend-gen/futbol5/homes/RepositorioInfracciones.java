package futbol5.homes;

import infracciones.Infraccion;
import java.util.List;
import uqbar.arena.persistence.PersistentHome;

@SuppressWarnings("all")
public class RepositorioInfracciones extends PersistentHome<Infraccion> {
  public Class<Infraccion> getEntityType() {
    return Infraccion.class;
  }
  
  public Infraccion createExample() {
    return null;
  }
  
  public Infraccion get(final int id) {
    List<Infraccion> infracciones = this.allInstances();
    for (final Infraccion cal : infracciones) {
      Integer _id = cal.getId();
      boolean _equals = ((_id).intValue() == id);
      if (_equals) {
        return cal;
      }
    }
    return null;
  }
  
  public Infraccion createInfraccion(final Infraccion infraccion) {
    Infraccion _xblockexpression = null;
    {
      this.create(infraccion);
      _xblockexpression = infraccion;
    }
    return _xblockexpression;
  }
}
