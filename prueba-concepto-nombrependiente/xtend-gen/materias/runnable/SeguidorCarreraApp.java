package materias.runnable;

import materias.domain.Materia;
import materias.domain.Nota;
import materias.home.HomeMaterias;
import materias.home.HomeNotas;
import materias.ui.SeguidorCarreraWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.ApplicationContext;

@SuppressWarnings("all")
public class SeguidorCarreraApp extends Application {
  public static void main(final String[] args) {
    SeguidorCarreraApp _seguidorCarreraApp = new SeguidorCarreraApp();
    _seguidorCarreraApp.start();
  }
  
  protected Window<?> createMainWindow() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomeMaterias _homeMaterias = new HomeMaterias();
    _instance.<HomeMaterias>configureSingleton(Materia.class, _homeMaterias);
    ApplicationContext _instance_1 = ApplicationContext.getInstance();
    HomeNotas _homeNotas = new HomeNotas();
    _instance_1.<HomeNotas>configureSingleton(Nota.class, _homeNotas);
    return new SeguidorCarreraWindow(this);
  }
}
