package futbol5.ui;

import futbol5.domain.Partido;
import futbol5.homes.HomePartidos;
import futbol5.ui.PartidosAppModel;
import futbol5.ui.PartidosView;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.ApplicationContext;

@SuppressWarnings("all")
public class TPFutbolApplication extends Application {
  public static void main(final String[] args) {
    TPFutbolApplication _tPFutbolApplication = new TPFutbolApplication();
    _tPFutbolApplication.start();
  }
  
  protected Window<?> createMainWindow() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomePartidos _homePartidos = new HomePartidos();
    _instance.<HomePartidos>configureSingleton(Partido.class, _homePartidos);
    PartidosAppModel _partidosAppModel = new PartidosAppModel();
    return new PartidosView(this, _partidosAppModel);
  }
}
