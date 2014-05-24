package command;

import auxiliares.RegistroRechazo;
import command.Decision;
import futbol5.Jugador;
import futbol5.Partido;
import java.util.List;

@SuppressWarnings("all")
public class Rechazar implements Decision {
  private RegistroRechazo registro;
  
  public Rechazar() {
    RegistroRechazo _registroRechazo = new RegistroRechazo();
    this.registro = _registroRechazo;
  }
  
  public void registrarDecision(final Jugador jugador, final Partido partido, final String motivo) {
    this.registro.generarNuevoRechazo(motivo);
    List<RegistroRechazo> _jugadoresRechazados = partido.getJugadoresRechazados();
    _jugadoresRechazados.add(this.registro);
  }
}
