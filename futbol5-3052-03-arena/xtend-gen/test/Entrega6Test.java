package test;

import futbol5.domain.Jugador;
import futbol5.homes.HomeJugadores;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    this.homeDeJugadores.create("Carolina", "La Carito de Burzaco", 21, "09-01-1993");
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
  
  @Test
  public void matchearJugadorNull() {
    boolean _matchea = this.jugadorCaro.matchea(this.jugadorNull);
    Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(_matchea));
  }
  
  @Test
  public void pruebaNombreIncorrecto() {
    boolean _matchea = this.jugadorEsteban.matchea(this.jugadorCaro);
    Assert.assertEquals(Boolean.valueOf(false), Boolean.valueOf(_matchea));
  }
  
  @Test
  public void pruebaApodo() {
    boolean _matchea = this.jugadorCaro.matchea(this.jugadorCaroNullNombre);
    Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(_matchea));
  }
  
  @Test
  public void fechaNacMayor() {
    boolean _matchea = this.jugadorCaro.matchea(this.jugadorCaroJoven);
    Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(_matchea));
  }
  
  @Test
  public void fechaNacMenor() {
    final byte maximum = ((byte) 0);
    int randomNum = 0;
    int i = 0;
    boolean _while = (i < 10);
    while (_while) {
      {
        int _randomNum = randomNum = (0 + ((int) (Math.random() * 10)));
        InputOutput.<Integer>println(Integer.valueOf(_randomNum));
        i++;
      }
      _while = (i < 10);
    }
  }
}
