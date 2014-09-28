package test;

import futbol5.domain.Jugador;
import futbol5.homes.HomeJugadores;
import org.junit.Before;

@SuppressWarnings("all")
public class Entrega6Test {
  private HomeJugadores homeDeJugadores;
  
  private Jugador jugadorEsteban;
  
  private Jugador jugadorCaro;
  
  private Jugador jugadorCaroNullNombre;
  
  private Jugador jugadorNull;
  
  private Jugador jugadorCaroJoven;
  
  @Before
  public void setUP() {
    HomeJugadores _homeJugadores = new HomeJugadores();
    this.homeDeJugadores = _homeJugadores;
  }
}
