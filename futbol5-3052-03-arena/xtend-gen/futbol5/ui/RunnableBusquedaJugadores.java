package futbol5.ui;

import futbol5.domain.Jugador;
import futbol5.homes.HomeJugadores;
import futbol5.ui.BusquedaJugadoresWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.ApplicationContext;

@SuppressWarnings("all")
public class RunnableBusquedaJugadores extends Application {
  public static void main(final String[] args) {
    RunnableBusquedaJugadores _runnableBusquedaJugadores = new RunnableBusquedaJugadores();
    _runnableBusquedaJugadores.start();
  }
  
  protected Window<?> createMainWindow() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomeJugadores _homeJugadores = new HomeJugadores();
    _instance.<HomeJugadores>configureSingleton(Jugador.class, _homeJugadores);
    return new BusquedaJugadoresWindow(this);
  }
}
