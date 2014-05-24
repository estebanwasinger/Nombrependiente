package test;

import condiciones.CondicionJugadoresPorEdad;
import condiciones.CondicionPartidoEnLocalidad;
import excepciones.BusinessException;
import futbol5.Jugador;
import futbol5.Partido;
import inscripciones.Condicional;
import inscripciones.Estandar;
import inscripciones.Solidario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class Entrega1Test {
  private Jugador jugador;
  
  private Jugador reemplazo;
  
  private Jugador jugador1;
  
  private Jugador jugadorSolidario;
  
  private Jugador jugadorSolidario2;
  
  private Jugador jugadorCondicional;
  
  private Jugador jugadorCondicional2;
  
  private Jugador jugadorCondicional3;
  
  private Jugador jugadorCondicional4;
  
  private Partido partido;
  
  private Partido partido2;
  
  private Partido partido3;
  
  private CondicionJugadoresPorEdad condicionEdad;
  
  private CondicionPartidoEnLocalidad condicionLocalidadCABA;
  
  private CondicionPartidoEnLocalidad condicionLocalidadGBA;
  
  @Before
  public void setUP() {
    Jugador _jugador = new Jugador();
    this.jugador = _jugador;
    this.jugador.setEdad(18);
    Jugador _jugador_1 = new Jugador();
    this.reemplazo = _jugador_1;
    Jugador _jugador_2 = new Jugador();
    this.jugador1 = _jugador_2;
    this.jugador1.setEdad(18);
    Jugador _jugador_3 = new Jugador();
    this.jugadorSolidario = _jugador_3;
    this.jugadorSolidario.setEdad(19);
    Jugador _jugador_4 = new Jugador();
    this.jugadorSolidario2 = _jugador_4;
    this.jugadorSolidario2.setEdad(16);
    Jugador _jugador_5 = new Jugador();
    this.jugadorCondicional = _jugador_5;
    Jugador _jugador_6 = new Jugador();
    this.jugadorCondicional2 = _jugador_6;
    Jugador _jugador_7 = new Jugador();
    this.jugadorCondicional3 = _jugador_7;
    Jugador _jugador_8 = new Jugador();
    this.jugadorCondicional4 = _jugador_8;
    Partido _partido = new Partido("CABA");
    this.partido = _partido;
    Partido _partido_1 = new Partido("CABA");
    this.partido2 = _partido_1;
    Partido _partido_2 = new Partido("GBA");
    this.partido3 = _partido_2;
    CondicionPartidoEnLocalidad _condicionPartidoEnLocalidad = new CondicionPartidoEnLocalidad("CABA");
    this.condicionLocalidadCABA = _condicionPartidoEnLocalidad;
    CondicionPartidoEnLocalidad _condicionPartidoEnLocalidad_1 = new CondicionPartidoEnLocalidad("GBA");
    this.condicionLocalidadGBA = _condicionPartidoEnLocalidad_1;
    CondicionJugadoresPorEdad _condicionJugadoresPorEdad = new CondicionJugadoresPorEdad(3, 20);
    this.condicionEdad = _condicionJugadoresPorEdad;
    Estandar _estandar = new Estandar();
    this.jugador.setTipoInscripcion(_estandar);
    Solidario _solidario = new Solidario();
    this.jugadorSolidario.setTipoInscripcion(_solidario);
    Solidario _solidario_1 = new Solidario();
    this.jugadorSolidario2.setTipoInscripcion(_solidario_1);
    Condicional _condicional = new Condicional(this.partido, this.condicionEdad);
    this.jugadorCondicional.setTipoInscripcion(_condicional);
    Condicional _condicional_1 = new Condicional(this.partido2, this.condicionLocalidadCABA);
    this.jugadorCondicional2.setTipoInscripcion(_condicional_1);
    Condicional _condicional_2 = new Condicional(this.partido3, this.condicionLocalidadCABA);
    this.jugadorCondicional3.setTipoInscripcion(_condicional_2);
    Condicional _condicional_3 = new Condicional(this.partido2, this.condicionLocalidadCABA);
    this.jugadorCondicional4.setTipoInscripcion(_condicional_3);
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
    this.partido.inscribir(this.jugadorCondicional4);
    this.partido.inscribir(this.jugadorCondicional2);
    this.partido.inscribir(this.jugador);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugador);
    Assert.assertTrue(_estaInscripto);
    boolean _estaInscripto_1 = this.partido.estaInscripto(this.jugadorCondicional4);
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
    this.partido.inscribir(this.jugadorCondicional2);
    this.partido.inscribir(this.jugadorSolidario);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugadorSolidario);
    Assert.assertTrue(_estaInscripto);
    boolean _estaInscripto_1 = this.partido.estaInscripto(this.jugadorCondicional2);
    Assert.assertFalse(_estaInscripto_1);
  }
  
  @Test
  public void testCondicionalSePuedeInscribirAPartidoSegunEdad() {
    this.partido.inscribir(this.jugador);
    this.partido.inscribir(this.jugadorCondicional);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugadorCondicional);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test(expected = BusinessException.class)
  public void testCondicionalNoSePuedeInscribirAPartidoSegunEdad() {
    this.partido.inscribir(this.jugador);
    this.partido.inscribir(this.jugador1);
    this.partido.inscribir(this.jugadorSolidario);
    this.partido.inscribir(this.jugadorSolidario2);
    this.partido.inscribir(this.jugadorCondicional);
  }
  
  @Test
  public void testCondicionalSePuedeInscribirAPartidoSegunLocalidad() {
    this.partido2.inscribir(this.jugadorCondicional2);
    boolean _estaInscripto = this.partido2.estaInscripto(this.jugadorCondicional2);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test(expected = BusinessException.class)
  public void testCondicionalNoSePuedeInscribirAPartidoSegunLocalidad() {
    this.partido3.inscribir(this.jugadorCondicional2);
  }
  
  @Test(expected = BusinessException.class)
  public void testBajaJugadorQueNoEstaInscripto() {
    this.partido.baja(this.jugador, this.reemplazo);
  }
  
  @Test(expected = BusinessException.class)
  public void testBajaJugadorConReemplazoYaInscripto() {
    this.partido.inscribir(this.jugador);
    this.partido.inscribir(this.reemplazo);
    this.partido.baja(this.jugador, this.reemplazo);
  }
  
  @Test
  public void testBajaJugadorConReemplazo() {
    this.partido.inscribir(this.jugador);
    this.partido.baja(this.jugador, this.reemplazo);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugador);
    Assert.assertFalse(_estaInscripto);
    boolean _estaInscripto_1 = this.partido.estaInscripto(this.reemplazo);
    Assert.assertTrue(_estaInscripto_1);
    int _cantJugadores = this.partido.cantJugadores();
    Assert.assertEquals(1, _cantJugadores);
  }
}
