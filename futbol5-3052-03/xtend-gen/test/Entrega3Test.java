package test;

import auxiliares.RegistroRechazo;
import excepciones.BusinessException;
import futbol5.Administrador;
import futbol5.Jugador;
import futbol5.Partido;
import futbol5.Sistema;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
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
    this.armarPartido(10);
    this.partido.jugadorProponeA(this.jugador);
    this.administrador.tomarUnaDecision(this.jugador);
    LinkedList<Jugador> _jugadoresRecomendados = this.partido.getJugadoresRecomendados();
    int _size = _jugadoresRecomendados.size();
    Assert.assertEquals(0, _size);
    List<Jugador> _jugadoresAceptados = this.sistema.getJugadoresAceptados();
    int _size_1 = _jugadoresAceptados.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testSeProponeUnJugadorYEsRechazado() {
    this.partido.jugadorProponeA(this.jugador);
    this.administrador.tomarUnaDecision(this.jugador);
    LinkedList<Jugador> _jugadoresRecomendados = this.partido.getJugadoresRecomendados();
    int _size = _jugadoresRecomendados.size();
    Assert.assertEquals(0, _size);
    List<RegistroRechazo> _jugadoresRechazados = this.sistema.getJugadoresRechazados();
    int _size_1 = _jugadoresRechazados.size();
    Assert.assertEquals(1, _size_1);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugador);
    Assert.assertFalse(_estaInscripto);
  }
}
