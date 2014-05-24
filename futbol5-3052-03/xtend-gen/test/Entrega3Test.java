package test;

import auxiliares.RegistroRechazo;
import command.Aceptar;
import command.Rechazar;
import excepciones.BusinessException;
import futbol5.Jugador;
import futbol5.Partido;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
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
    this.partido.jugadorProponeA(this.jugador, this.decisionAceptar, this.motivo);
    List<Jugador> _jugadoresAceptados = this.partido.getJugadoresAceptados();
    int _size = _jugadoresAceptados.size();
    Assert.assertEquals(1, _size);
    LinkedList<Jugador> _jugadores = this.partido.getJugadores();
    int _size_1 = _jugadores.size();
    Assert.assertEquals(1, _size_1);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugador);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test(expected = BusinessException.class)
  public void testSeProponeUnJugadorEsAceptadoYNoSePuedeInscribir() {
    this.armarPartido(10);
    this.partido.jugadorProponeA(this.jugador, this.decisionAceptar, this.motivo);
  }
  
  @Test
  public void testSeProponeUnJugadorYEsRechazado() {
    this.partido.jugadorProponeA(this.jugador, this.decisionRechazar, this.motivo);
    List<RegistroRechazo> _jugadoresRechazados = this.partido.getJugadoresRechazados();
    int _size = _jugadoresRechazados.size();
    Assert.assertEquals(1, _size);
    LinkedList<Jugador> _jugadores = this.partido.getJugadores();
    int _size_1 = _jugadores.size();
    Assert.assertEquals(0, _size_1);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugador);
    Assert.assertFalse(_estaInscripto);
  }
}
