package test;

import futbol5.domain.Jugador;
import futbol5.homes.HomeJugadores;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class Entrega6Test {
  private HomeJugadores homeDeJugadores;
  
  private Jugador jugadorEsteban;
  
  private Jugador jugadorCaro;
  
  private Jugador jugadorCaroNullNombre;
  
  @Before
  public void setUP() {
    HomeJugadores _homeJugadores = new HomeJugadores();
    this.homeDeJugadores = _homeJugadores;
    this.homeDeJugadores.create("Carolina", "La Carito de Burzaco", 21, "09-01-1993");
    Jugador _jugador = new Jugador("Carolina", null, 21, "09-01-1993");
    this.jugadorCaro = _jugador;
    Jugador _jugador_1 = new Jugador("arolina", "La Saeta Rubia", 21, "02-12-1992");
    this.jugadorEsteban = _jugador_1;
    Jugador _jugador_2 = new Jugador(null, "burzaco", 21, "09-01-1993");
    this.jugadorCaroNullNombre = _jugador_2;
  }
  
  @Test
  public void pruebaNombre() {
    List<Jugador> _search = this.homeDeJugadores.search(this.jugadorCaro);
    int _size = _search.size();
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void pruebaNombreIncorrecto() {
    List<Jugador> _search = this.homeDeJugadores.search(this.jugadorEsteban);
    int _size = _search.size();
    Assert.assertEquals(0, _size);
  }
  
  @Test
  public void pruebaApodo() {
    List<Jugador> _search = this.homeDeJugadores.search(this.jugadorCaroNullNombre);
    int _size = _search.size();
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void fechaNacMenor() {
    Jugador _jugador = new Jugador(null, null, 21, "09-02-1900");
    List<Jugador> _search = this.homeDeJugadores.search(_jugador);
    int _size = _search.size();
    Assert.assertEquals(0, _size);
  }
}
