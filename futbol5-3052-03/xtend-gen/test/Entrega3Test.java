package test;

import excepciones.BusinessException;
import futbol5.Jugador;
import futbol5.Partido;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class Entrega3Test {
  private Jugador jugador;
  
  private Partido partido;
  
  private /* Aceptar */Object decisionAceptar;
  
  private /* Rechazar */Object decisionRechazar;
  
  private String motivo;
  
  @Before
  public void setUP() {
    throw new Error("Unresolved compilation problems:"
      + "\nAceptar cannot be resolved."
      + "\nRechazar cannot be resolved.");
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
      + "\nThe method jugadoresAceptados is undefined for the type Entrega3Test"
      + "\nInvalid number of arguments. The method jugadorProponeA(Jugador) is not applicable for the arguments (Jugador,Aceptar,String)"
      + "\nsize cannot be resolved");
  }
  
  @Test(expected = BusinessException.class)
  public void testSeProponeUnJugadorEsAceptadoYNoSePuedeInscribir() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method jugadorProponeA(Jugador) is not applicable for the arguments (Jugador,Aceptar,String)");
  }
  
  @Test
  public void testSeProponeUnJugadorYEsRechazado() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method jugadoresRechazados is undefined for the type Entrega3Test"
      + "\nInvalid number of arguments. The method jugadorProponeA(Jugador) is not applicable for the arguments (Jugador,Rechazar,String)"
      + "\nsize cannot be resolved");
  }
}
