package observers;

import auxiliares.MessageSender;
import com.google.common.base.Objects;
import futbol5.Jugador;
import futbol5.Partido;
import infracciones.Infraccion;
import java.util.List;
import observers.PartidoObserver;

@SuppressWarnings("all")
public class BajaSinReemplazoObserver extends PartidoObserver {
  public BajaSinReemplazoObserver(final MessageSender unMessageSender) {
    super(unMessageSender);
  }
  
  public void notificarBaja(final Partido partido, final Jugador jugador, final Jugador reemplazo) {
    boolean _equals = Objects.equal(reemplazo, null);
    if (_equals) {
      this.generarInfraccion(jugador);
    }
  }
  
  public boolean generarInfraccion(final Jugador jugador) {
    List<Infraccion> _infracciones = jugador.getInfracciones();
    Infraccion _infraccion = new Infraccion();
    return _infracciones.add(_infraccion);
  }
}
