package futbol5.ui;

import futbol5.domain.Jugador;
import futbol5.ui.VerDatosJugadorWindow;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

@SuppressWarnings("all")
public class RunnableJugador extends Application {
  public static void main(final String[] args) {
    RunnableJugador _runnableJugador = new RunnableJugador();
    _runnableJugador.start();
  }
  
  protected Window<?> createMainWindow() {
    Jugador _jugador = new Jugador();
    return new VerDatosJugadorWindow(this, _jugador);
  }
}
