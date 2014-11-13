package futbol5.applicationModel;

import futbol5.domain.Partido;
import futbol5.homes.RepositorioPartidos;
import java.util.List;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class PartidosAppModel {
  private List<Partido> _partidos;
  
  public List<Partido> getPartidos() {
    return this._partidos;
  }
  
  public void setPartidos(final List<Partido> partidos) {
    this._partidos = partidos;
  }
  
  private Partido _partidoSeleccionado;
  
  public Partido getPartidoSeleccionado() {
    return this._partidoSeleccionado;
  }
  
  public void setPartidoSeleccionado(final Partido partidoSeleccionado) {
    this._partidoSeleccionado = partidoSeleccionado;
  }
  
  public PartidosAppModel() {
    this.searchPartido();
  }
  
  public void searchPartido() {
    RepositorioPartidos _homePartidos = this.getHomePartidos();
    List<Partido> _allInstances = _homePartidos.allInstances();
    this.setPartidos(_allInstances);
  }
  
  public RepositorioPartidos getHomePartidos() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<RepositorioPartidos>getSingleton(Partido.class);
  }
}
