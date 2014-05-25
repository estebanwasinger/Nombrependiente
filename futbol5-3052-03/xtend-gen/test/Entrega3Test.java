package test;

import command.Aceptar;
import command.Rechazar;
import excepciones.BusinessException;
import futbol5.Jugador;
import futbol5.Partido;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class Entrega3Test {
  private Jugador jugador;
  
  private Partido partido;
  
  private Aceptar decisionAceptar;
  
  private Rechazar decisionRechazar;
  
  private String motivo;
  
  @Before
  public void setUP() {
    Jugador _jugador = new Jugador();
    this.jugador = _jugador;
    Partido _partido = new Partido("Villa Fiorito");
    this.partido = _partido;
    Aceptar _aceptar = new Aceptar();
    this.decisionAceptar = _aceptar;
    Rechazar _rechazar = new Rechazar();
    this.decisionRechazar = _rechazar;
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
      + "\nThe method jugadorProponeA is undefined for the type Entrega3Test"
      + "\nThe method jugadoresAceptados is undefined for the type Entrega3Test"
      + "\nsize cannot be resolved");
  }
  
  @Test(expected = BusinessException.class)
  public void testSeProponeUnJugadorEsAceptadoYNoSePuedeInscribir() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method jugadorProponeA is undefined for the type Entrega3Test");
  }
  
  @Test
  public void testSeProponeUnJugadorYEsRechazado() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method jugadorProponeA is undefined for the type Entrega3Test"
      + "\nThe method jugadoresRechazados is undefined for the type Entrega3Test"
      + "\nsize cannot be resolved");
  }
}
