package futbol5.homes;

import futbol5.domain.Partido;
import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

@SuppressWarnings("all")
public class HomePartidos extends CollectionBasedHome<Partido> {
  protected Predicate getCriterio(final Partido example) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Partido createExample() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public Class<Partido> getEntityType() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
