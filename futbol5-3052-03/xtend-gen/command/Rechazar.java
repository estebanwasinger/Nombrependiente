package command;

import auxiliares.RegistroRechazo;
import command.Decision;
import futbol5.Jugador;
import futbol5.Partido;
import java.util.List;

@SuppressWarnings("all")
public class Rechazar implements Decision {
  private RegistroRechazo registro;
  
  public void registrarDecision(final Jugador jugador, final Partido partido, final String motivo) {
    this.registro.generar(motivo);
    List<RegistroRechazo> _jugadoresRechazados = partido.getJugadoresRechazados();
    _jugadoresRechazados.add(this.registro);
  }
}
