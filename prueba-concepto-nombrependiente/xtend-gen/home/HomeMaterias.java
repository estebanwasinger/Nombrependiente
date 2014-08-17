package home;

import domain.Materia;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class HomeMaterias extends CollectionBasedHome<Materia> {
  public HomeMaterias() {
    this.init();
  }
  
  public void init() {
    this.create("Algoritmos");
  }
  
  public void create(final String pNombre) {
    Materia materia = new Materia();
    materia.setNombre(pNombre);
    this.create(materia);
  }
  
  public List<Materia> search() {
    List<Materia> _allInstances = this.allInstances();
    return IterableExtensions.<Materia>toList(_allInstances);
  }
  
  public void setNombre(final Materia materia, final String string) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  protected Predicate getCriterio(final Materia example) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Materia createExample() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Class<Materia> getEntityType() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
