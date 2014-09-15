package futbol5.ui;

import futbol5.applicationModel.Futbol5;
import futbol5.domain.Partido;
import futbol5.homes.HomePartidos;
import futbol5.ui.VistaPrincipal;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.ApplicationContext;

@SuppressWarnings("all")
public class RunnableVistaPrincipal extends Application {
  public static void main(final String[] args) {
    RunnableVistaPrincipal _runnableVistaPrincipal = new RunnableVistaPrincipal();
    _runnableVistaPrincipal.start();
  }
  
  protected Window<?> createMainWindow() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomePartidos _homePartidos = new HomePartidos();
    _instance.<HomePartidos>configureSingleton(Partido.class, _homePartidos);
    Futbol5 appModel = new Futbol5();
    Futbol5 _futbol5 = new Futbol5();
    return new VistaPrincipal(this, _futbol5);
  }
}
