package test;

import futbol5.BusinessException;
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
  
  private Jugador jugadorSolidario2;
  
  private Jugador jugadorCondicional;
  
  private Jugador jugadorCondicional2;
  
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
    this.jugadorSolidario.setTipoInscripcion(this.solidario);
    this.jugadorSolidario2.setTipoInscripcion(this.solidario);
    this.jugadorCondicional.setTipoInscripcion(this.condicional);
    this.jugadorCondicional2.setTipoInscripcion(this.condicional);
  }
  
  public void armarPartido(final int max) {
    int a = 0;
    boolean _while = (a < max);
    while (_while) {
      {
        Jugador _jugador = new Jugador();
        this.partido.inscribir(_jugador);
        a = (a + 1);
      }
      _while = (a < max);
    }
  }
  
  @Test
  public void agregar10Personas() {
    int a = 0;
    boolean _while = (a < 10);
    while (_while) {
      {
        Jugador _jugador = new Jugador();
        this.partido.agregarJugador(_jugador);
        a = (a + 1);
      }
      _while = (a < 10);
    }
    int _cantJugadores = this.partido.cantJugadores();
    Assert.assertEquals(10, _cantJugadores);
  }
  
  @Test(expected = BusinessException.class)
  public void inscribirALaMismaPersonaMasDeUnaVez() {
    this.partido.inscribir(this.jugador);
    this.partido.inscribir(this.jugador);
  }
  
  @Test
  public void testEstandarSacaSolidario() {
    this.armarPartido(8);
    this.partido.inscribir(this.jugadorSolidario);
    this.partido.inscribir(this.jugadorSolidario2);
    this.partido.inscribir(this.jugador);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugador);
    Assert.assertTrue(_estaInscripto);
    boolean _estaInscripto_1 = this.partido.estaInscripto(this.jugadorSolidario);
    Assert.assertFalse(_estaInscripto_1);
    boolean _estaInscripto_2 = this.partido.estaInscripto(this.jugadorSolidario2);
    Assert.assertTrue(_estaInscripto_2);
  }
  
  @Test
  public void testEstandarSacaCondicional() {
    this.armarPartido(8);
    this.partido.inscribir(this.jugadorCondicional);
    this.partido.inscribir(this.jugadorCondicional2);
    this.partido.inscribir(this.jugador);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugador);
    Assert.assertTrue(_estaInscripto);
    boolean _estaInscripto_1 = this.partido.estaInscripto(this.jugadorCondicional);
    Assert.assertFalse(_estaInscripto_1);
    boolean _estaInscripto_2 = this.partido.estaInscripto(this.jugadorCondicional2);
    Assert.assertTrue(_estaInscripto_2);
  }
  
  @Test(expected = BusinessException.class)
  public void testNoInscripcionCuandoElPartidoEstaCompleto() {
    this.armarPartido(10);
    this.partido.inscribir(this.jugador);
  }
  
  @Test(expected = BusinessException.class)
  public void testCondicionalNoDesplazaJugadoresYSeQuedaSinCupo() {
    this.armarPartido(8);
    this.partido.inscribir(this.jugadorCondicional);
    this.partido.inscribir(this.jugadorSolidario);
    this.partido.inscribir(this.jugadorCondicional2);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugadorCondicional2);
    Assert.assertFalse(_estaInscripto);
  }
  
  @Test
  public void testSolidarioSacaAJugadorCondicional() {
    this.armarPartido(9);
    this.partido.inscribir(this.jugadorCondicional);
    this.partido.inscribir(this.jugadorSolidario);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugadorSolidario);
    Assert.assertTrue(_estaInscripto);
    boolean _estaInscripto_1 = this.partido.estaInscripto(this.jugadorCondicional);
    Assert.assertFalse(_estaInscripto_1);
  }
}
