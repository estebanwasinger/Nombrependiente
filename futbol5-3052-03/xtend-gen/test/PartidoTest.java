package test;

import futbol5.Condicional;
import futbol5.Estandar;
import futbol5.Jugador;
import futbol5.Partido;
import futbol5.Solidario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class PartidoTest {
  private Jugador jugador;
  
  private Jugador jugadorSolidario;
  
  private Jugador jugadorCondicional;
  
  private Jugador jugadorSolidario2;
  
  private Partido partido;
  
  private Estandar estandar;
  
  private Condicional condicional;
  
  private Solidario solidario;
  
  @Before
  public void setUP() {
    Jugador _jugador = new Jugador();
    this.jugador = _jugador;
    Jugador _jugador_1 = new Jugador();
    this.jugadorSolidario = _jugador_1;
    Jugador _jugador_2 = new Jugador();
    this.jugadorSolidario2 = _jugador_2;
    Partido _partido = new Partido();
    this.partido = _partido;
    Estandar _estandar = new Estandar();
    this.estandar = _estandar;
    Solidario _solidario = new Solidario();
    this.solidario = _solidario;
    this.jugador.setTipoInscripcion(this.estandar);
    this.jugadorSolidario.setTipoInscripcion(this.solidario);
    this.jugadorSolidario2.setTipoInscripcion(this.solidario);
  }
  
  @Test
  public void agregar10Personas() {
    int a = 0;
    boolean _while = (a < 10);
    while (_while) {
      {
        this.partido.agregarJugador(this.jugador);
        a = (a + 1);
      }
      _while = (a < 10);
    }
    int _cantJugadores = this.partido.cantJugadores();
    Assert.assertEquals(10, _cantJugadores);
  }
  
  @Test
  public void inscribir10Personas() {
    int a = 0;
    boolean _while = (a < 10);
    while (_while) {
      {
        this.jugador.inscribirse(this.partido);
        a = (a + 1);
      }
      _while = (a < 10);
    }
    int _cantJugadores = this.partido.cantJugadores();
    Assert.assertEquals(10, _cantJugadores);
  }
  
  @Test
  public void inscribir11Personas() {
    int a = 0;
    boolean _while = (a < 11);
    while (_while) {
      {
        this.jugador.inscribirse(this.partido);
        a = (a + 1);
      }
      _while = (a < 11);
    }
    int _cantJugadores = this.partido.cantJugadores();
    Assert.assertEquals(10, _cantJugadores);
  }
  
  @Test
  public void testEstandarSacaSolidario() {
    int a = 0;
    boolean _while = (a < 9);
    while (_while) {
      {
        this.jugadorSolidario.inscribirse(this.partido);
        a = (a + 1);
      }
      _while = (a < 9);
    }
    this.jugadorSolidario2.inscribirse(this.partido);
    this.jugador.inscribirse(this.partido);
    int _posicionEnLista = this.partido.posicionEnLista(this.jugador);
    Assert.assertEquals(_posicionEnLista, 9);
  }
}
