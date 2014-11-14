package futbol5.runnable;

import futbol5.domain.Jugador;
import futbol5.domain.Partido;
import futbol5.homes.RepositorioJugadores;
import futbol5.homes.RepositorioPartidos;
import futbol5.ui.PartidosView;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.ApplicationContext;
import uqbar.arena.persistence.Configuration;

@SuppressWarnings("all")
public class TPFutbolApplication extends Application {
  public static void main(final String[] args) {
    TPFutbolApplication _tPFutbolApplication = new TPFutbolApplication();
    _tPFutbolApplication.start();
  }
  
  protected Window<?> createMainWindow() {
    Configuration.configure();
    ApplicationContext _instance = ApplicationContext.getInstance();
    RepositorioJugadores _repositorioJugadores = new RepositorioJugadores();
    _instance.<RepositorioJugadores>configureSingleton(Jugador.class, _repositorioJugadores);
    ApplicationContext _instance_1 = ApplicationContext.getInstance();
    RepositorioPartidos _repositorioPartidos = new RepositorioPartidos();
    _instance_1.<RepositorioPartidos>configureSingleton(Partido.class, _repositorioPartidos);
    return new PartidosView(this);
  }
}
