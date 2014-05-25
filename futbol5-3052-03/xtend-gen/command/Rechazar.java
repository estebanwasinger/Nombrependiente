package command;

import auxiliares.RegistroRechazo;
import command.Decision;
import futbol5.Jugador;
import futbol5.Partido;

@SuppressWarnings("all")
public class Rechazar implements Decision {
  private RegistroRechazo registro;
  
  public void registrarDecision(final Jugador jugador, final Partido partido, final String motivo) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method jugadoresRechazados is undefined for the type Rechazar"
      + "\nadd cannot be resolved");
  }
}
