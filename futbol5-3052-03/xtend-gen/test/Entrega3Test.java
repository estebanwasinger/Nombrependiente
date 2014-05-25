package test;

import excepciones.BusinessException;
import futbol5.Administrador;
import futbol5.Jugador;
import futbol5.Partido;
import futbol5.Sistema;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class Entrega3Test {
  private Jugador jugador;
  
  private Partido partido;
  
  private Administrador administrador;
  
  private Sistema sistema;
  
  private String motivo;
  
  @Before
  public void setUP() {
    Jugador _jugador = new Jugador();
    this.jugador = _jugador;
    Partido _partido = new Partido("Villa Fiorito");
    this.partido = _partido;
    this.motivo = "Se rechaza porque es mujer";
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
  public void testSeProponeUnJugadorEsAceptadoYSePuedeInscribir() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method tomarUnaDesicion is undefined for the type Entrega3Test");
  }
  
  @Test(expected = BusinessException.class)
  public void testSeProponeUnJugadorEsAceptadoYNoSePuedeInscribir() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method tomarUnaDecision(Jugador, Partido) is not applicable for the arguments (Jugador)");
  }
  
  @Test
  public void testSeProponeUnJugadorYEsRechazado() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method tomarUnaDecision(Jugador, Partido) is not applicable for the arguments (Jugador)");
  }
}
