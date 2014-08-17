package applicationModel;

import domain.Materia;
import home.HomeMaterias;
import java.util.ArrayList;
import java.util.List;
import org.uqbar.commons.utils.ApplicationContext;

@SuppressWarnings("all")
public class SeguidorCarrera {
  private List<Materia> _resultados;
  
  public List<Materia> getResultados() {
    return this._resultados;
  }
  
  public void setResultados(final List<Materia> resultados) {
    this._resultados = resultados;
  }
  
  public void search() {
    ArrayList<Materia> _arrayList = new ArrayList<Materia>();
    this.setResultados(_arrayList);
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    List<Materia> _search = _homeMaterias.search();
    this.setResultados(_search);
  }
  
  public HomeMaterias getHomeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeMaterias>getSingleton(Materia.class);
  }
}
