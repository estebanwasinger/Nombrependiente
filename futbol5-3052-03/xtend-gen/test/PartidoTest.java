package test;

import futbol5.Condicional;
import futbol5.Estandar;
import futbol5.Jugador;
import futbol5.Partido;
import futbol5.Solidario;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class PartidoTest {
  private Jugador jugador;
  
  private Jugador jugador1;
  
  private Jugador jugador2;
  
  private Partido partido;
  
  private Estandar estandar;
  
  private Condicional condicional;
  
  private Solidario solidario;
  
  @Before
  public void setUP() {
    Jugador _jugador = new Jugador();
    this.jugador = _jugador;
    Partido _partido = new Partido();
    this.partido = _partido;
    Estandar _estandar = new Estandar();
    this.estandar = _estandar;
    Condicional _condicional = new Condicional();
    this.condicional = _condicional;
    Solidario _solidario = new Solidario();
    this.solidario = _solidario;
    this.jugador.setTipoInscripcion(this.estandar);
    this.jugador1.setTipoInscripcion(this.condicional);
    this.jugador2.setTipoInscripcion(this.solidario);
  }
  
  @Test(expected = RuntimeException.class)
  public void test11JugadoresEstandar() {
    int a = 0;
    boolean _while = (a < 12);
    while (_while) {
      {
        this.partido.inscribirJugador(this.jugador);
        a = (a + 1);
      }
      _while = (a < 12);
    }
  }
  
  @Test(expected = RuntimeException.class)
  public void testEstandarSacaSolidario() {
    this.partido.inscribirJugador(this.jugador);
  }
  
  @Test(expected = RuntimeException.class)
  public void testFaltanJugadores() {
  }
}
