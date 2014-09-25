package futbol5.ui;

import futbol5.domain.Jugador;
import futbol5.homes.HomeJugadores;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.commons.utils.ApplicationContext;

@SuppressWarnings("all")
public class DateBox extends TextBox {
  public DateBox(final Panel container) {
    super(container);
  }
  
  /**
   * override bindValueToProperty(String propertyName) {
   * val binding = super.bindValueToProperty(propertyName)
   * this.withFilter(new DateTextFilter)
   * binding
   * }
   */
  public HomeJugadores homeJugadores() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Jugador.class);
    return ((HomeJugadores) _singleton);
  }
}
