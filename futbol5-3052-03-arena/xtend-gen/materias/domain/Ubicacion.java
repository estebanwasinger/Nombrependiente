package materias.domain;

import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Ubicacion extends Entity {
  @Property
  private String _descripcion;
  
  @Pure
  public String getDescripcion() {
    return this._descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this._descripcion = descripcion;
  }
}
