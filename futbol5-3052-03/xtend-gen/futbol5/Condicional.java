package futbol5;

import futbol5.EquipoConfirmadoYCompleto;
import futbol5.Jugador;
import futbol5.Partido;
import futbol5.TipoInscripcion;
import java.util.LinkedList;

@SuppressWarnings("all")
public class Condicional implements TipoInscripcion {
  public void inscribir(final Partido partido, final Jugador jugador) {
    LinkedList<Jugador> _jugadores = partido.getJugadores();
    int _size = _jugadores.size();
    boolean _lessThan = (_size < 10);
    if (_lessThan) {
      LinkedList<Jugador> _jugadores_1 = partido.getJugadores();
      _jugadores_1.add(jugador);
    } else {
      throw new EquipoConfirmadoYCompleto("No se pueden inscribir más jugadores de forma condicional. No tienen prioridad");
    }
  }
}
