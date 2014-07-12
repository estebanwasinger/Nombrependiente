package ar.edu.futbol5;

import ar.edu.futbol5.Jugador;
import java.util.List;

@SuppressWarnings("all")
public class Equipo {
  private List<Jugador> _jugadores;
  
  public List<Jugador> getJugadores() {
    return this._jugadores;
  }
  
  public void setJugadores(final List<Jugador> jugadores) {
    this._jugadores = jugadores;
  }
}
