package futbol5.ui;

import futbol5.domain.Jugador;
import futbol5.homes.HomeJugadores;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.lacar.ui.model.Action;

@SuppressWarnings("all")
public class VerDatosJugadorWindow extends Dialog<Jugador> {
  public VerDatosJugadorWindow(final WindowOwner owner, final Jugador model) {
    super(owner, model);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Datos del Jugador");
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    Button _setCaption = _button.setCaption("Volver");
    final Action _function = new Action() {
      public void execute() {
        VerDatosJugadorWindow.this.cancel();
      }
    };
    _setCaption.onClick(_function);
  }
  
  public HomeJugadores homeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Jugador.class);
    return ((HomeJugadores) _singleton);
  }
}
