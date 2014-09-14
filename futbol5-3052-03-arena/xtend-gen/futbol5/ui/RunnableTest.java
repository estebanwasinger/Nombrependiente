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
    Partido partidoEjemplo = new Partido();
    Jugador _jugador = new Jugador();
    partidoEjemplo.agregarJugador(_jugador);
    Partido _partido = new Partido();
    return new GenerarEquiposWindow(this, _partido);
  }
}
