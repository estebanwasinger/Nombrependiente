package futbol5.ui;

import futbol5.ui.BusquedaJugadoresWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

@SuppressWarnings("all")
public class RunnableBusquedaJugadores extends Application {
  public static void main(final String[] args) {
    RunnableBusquedaJugadores _runnableBusquedaJugadores = new RunnableBusquedaJugadores();
    _runnableBusquedaJugadores.start();
  }
  
  protected Window<?> createMainWindow() {
    return new BusquedaJugadoresWindow(this);
  }
}
