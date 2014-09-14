package futbol5.ui;

import futbol5.domain.Jugador;
import futbol5.domain.Partido;
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
    Partido partidoEjemplo = new Partido("San Miguel");
    Jugador _jugador = new Jugador("Esteban");
    partidoEjemplo.agregarJugador(_jugador);
    Jugador _jugador_1 = new Jugador("Carolina");
    partidoEjemplo.agregarJugador(_jugador_1);
    return new GenerarEquiposWindow(this, partidoEjemplo);
  }
}
