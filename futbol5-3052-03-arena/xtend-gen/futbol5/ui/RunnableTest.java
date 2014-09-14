package futbol5.ui;

import futbol5.ui.GenerarEquiposWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

@SuppressWarnings("all")
public class RunnableTest extends Application {
  public static void main(final String[] args) {
    RunnableTest _runnableTest = new RunnableTest();
    _runnableTest.start();
  }
  
  protected Window<?> createMainWindow() {
    return new GenerarEquiposWindow(this);
  }
}
