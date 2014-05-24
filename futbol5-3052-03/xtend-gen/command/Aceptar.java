package command;

import command.Decision;
import futbol5.Jugador;
import futbol5.Partido;
import java.util.List;

@SuppressWarnings("all")
public class Aceptar implements Decision {
  public void registrarDecision(final Jugador jugador, final Partido partido, final String motivo) {
    List<Jugador> _jugadoresAceptados = partido.getJugadoresAceptados();
    _jugadoresAceptados.add(jugador);
    partido.inscribir(jugador);
  }
}
