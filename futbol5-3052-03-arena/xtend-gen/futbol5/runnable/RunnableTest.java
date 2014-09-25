package futbol5.runnable;

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
    Jugador _jugador_2 = new Jugador("Vero");
    partidoEjemplo.agregarJugador(_jugador_2);
    Jugador _jugador_3 = new Jugador("Pau");
    partidoEjemplo.agregarJugador(_jugador_3);
    Jugador _jugador_4 = new Jugador("Esteban");
    partidoEjemplo.agregarJugador(_jugador_4);
    Jugador _jugador_5 = new Jugador("Carolina");
    partidoEjemplo.agregarJugador(_jugador_5);
    Jugador _jugador_6 = new Jugador("Vero");
    partidoEjemplo.agregarJugador(_jugador_6);
    Jugador _jugador_7 = new Jugador("Pau");
    partidoEjemplo.agregarJugador(_jugador_7);
    Jugador _jugador_8 = new Jugador("Esteban");
    partidoEjemplo.agregarJugador(_jugador_8);
    Jugador _jugador_9 = new Jugador("Carolina");
    partidoEjemplo.agregarJugador(_jugador_9);
    return new GenerarEquiposWindow(this, partidoEjemplo);
  }
}
