package test;

import futbol5.Condicional;
import futbol5.Estandar;
import futbol5.Jugador;
import futbol5.Partido;
import futbol5.PartidoConfirmadoYCompletoException;
import futbol5.Solidario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class PartidoTest {
  private Jugador jugador;
  
  private Jugador jugadorSolidario;
  
  private Jugador jugadorCondicional;
  
  private Jugador jugadorCondicional2;
  
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
    Jugador _jugador_3 = new Jugador();
    this.jugadorCondicional = _jugador_3;
    Jugador _jugador_4 = new Jugador();
    this.jugadorCondicional2 = _jugador_4;
    Partido _partido = new Partido();
    this.partido = _partido;
    Estandar _estandar = new Estandar();
    this.estandar = _estandar;
    Solidario _solidario = new Solidario();
    this.solidario = _solidario;
    Condicional _condicional = new Condicional();
    this.condicional = _condicional;
    this.jugador.setTipoInscripcion(this.estandar);
    this.jugadorSolidario.setTipoInscripcion(this.solidario);
    this.jugadorSolidario2.setTipoInscripcion(this.solidario);
    this.jugadorCondicional.setTipoInscripcion(this.condicional);
    this.jugadorCondicional2.setTipoInscripcion(this.condicional);
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
  
  @Test
  public void testEstandarSacaCondicional() {
    int a = 0;
    boolean _while = (a < 9);
    while (_while) {
      {
        this.jugadorCondicional.inscribirse(this.partido);
        a = (a + 1);
      }
      _while = (a < 9);
    }
    this.jugadorCondicional2.inscribirse(this.partido);
    this.jugador.inscribirse(this.partido);
    int _posicionEnLista = this.partido.posicionEnLista(this.jugador);
    Assert.assertEquals(_posicionEnLista, 9);
  }
  
  @Test(expected = PartidoConfirmadoYCompletoException.class)
  public void testNoInscripcionCuandoElPartidoEstaCompleto() {
    this.inscribir10Personas();
    this.jugador.inscribirse(this.partido);
  }
  
  @Test
  public void testElCondicionalNoDesplazaJugadores() {
    int a = 0;
    boolean _while = (a < 5);
    while (_while) {
      {
        this.partido.agregarJugador(this.jugador);
        a = (a + 1);
      }
      _while = (a < 5);
    }
    boolean _while_1 = (a < 10);
    while (_while_1) {
      {
        this.partido.agregarJugador(this.jugadorSolidario);
        a = (a + 1);
      }
      _while_1 = (a < 10);
    }
    this.jugadorSolidario2.inscribirse(this.partido);
    this.jugadorCondicional.inscribirse(this.partido);
    int _posicionEnLista = this.partido.posicionEnLista(this.jugadorCondicional);
    Assert.assertNotEquals(_posicionEnLista, 10);
  }
  
  @Test
  public void testSolidarioSacaAJugadorCondicional() {
    int a = 0;
    boolean _while = (a < 9);
    while (_while) {
      {
        this.jugadorCondicional.inscribirse(this.partido);
        a = (a + 1);
      }
      _while = (a < 9);
    }
    this.jugadorCondicional2.inscribirse(this.partido);
    this.jugadorSolidario.inscribirse(this.partido);
    int _posicionEnLista = this.partido.posicionEnLista(this.jugadorSolidario);
    Assert.assertEquals(_posicionEnLista, 9);
  }
}
