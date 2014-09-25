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
    Jugador _jugador = new Jugador("Carolina", "La Carito de Burzaco", 21, "09-01-1993");
    this.jugadorCaro = _jugador;
    Jugador _jugador_1 = new Jugador("Carolina", "La Carito de Burzaco", 21, "09-01-1995");
    this.jugadorCaroJoven = _jugador_1;
    Jugador _jugador_2 = new Jugador(null, null, 0, null);
    this.jugadorNull = _jugador_2;
    Jugador _jugador_3 = new Jugador("arolina", "La Saeta Rubia", 21, "02-12-1990");
    this.jugadorEsteban = _jugador_3;
    Jugador _jugador_4 = new Jugador(null, "burzaco", 21, "09-01-1999");
    this.jugadorCaroNullNombre = _jugador_4;
  }
}
