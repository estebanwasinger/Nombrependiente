package futbol5.homes;

import futbol5.domain.Partido;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

@SuppressWarnings("all")
public class HomePartidos extends CollectionBasedHome<Partido> {
  private List<Partido> _partidos;
  
  public List<Partido> getPartidos() {
    return this._partidos;
  }
  
  public void setPartidos(final List<Partido> partidos) {
    this._partidos = partidos;
  }
  
  public void init() {
    LinkedList<Partido> _linkedList = new LinkedList<Partido>();
    this.setPartidos(_linkedList);
  }
  
  public boolean create() {
    boolean _xblockexpression = false;
    {
      Partido partido = new Partido();
      List<Partido> _partidos = this.getPartidos();
      _xblockexpression = _partidos.add(partido);
    }
    return _xblockexpression;
  }
  
  public HomePartidos() {
    this.init();
  }
  
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
