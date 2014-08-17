package prueba.conversor;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.ApplicationContext;
import prueba.conversor.HomeMaterias;
import prueba.conversor.Materia;
import prueba.conversor.SeguidorCarreraWindow;

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
    return new SeguidorCarreraWindow(this);
  }
}
