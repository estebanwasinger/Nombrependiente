package test;

import excepciones.BusinessException;
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
  
  private Sistema sistema;
  
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
    this.partido.jugadorProponeA(this.jugador);
    LinkedList<Jugador> _jugadoresRecomendados = this.partido.getJugadoresRecomendados();
    _jugadoresRecomendados.remove(this.jugador);
    List<Jugador> _jugadoresAceptados = this.sistema.getJugadoresAceptados();
    _jugadoresAceptados.add(this.jugador);
    LinkedList<Jugador> _jugadoresRecomendados_1 = this.partido.getJugadoresRecomendados();
    int _size = _jugadoresRecomendados_1.size();
    Assert.assertEquals(0, _size);
    List<Jugador> _jugadoresAceptados_1 = this.sistema.getJugadoresAceptados();
    int _size_1 = _jugadoresAceptados_1.size();
    Assert.assertEquals(1, _size_1);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugador);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test(expected = BusinessException.class)
  public void testSeProponeUnJugadorEsAceptadoYNoSePuedeInscribir() {
    this.armarPartido(10);
    this.partido.jugadorProponeA(this.jugador);
    LinkedList<Jugador> _jugadoresRecomendados = this.partido.getJugadoresRecomendados();
    _jugadoresRecomendados.remove(this.jugador);
    List<Jugador> _jugadoresAceptados = this.sistema.getJugadoresAceptados();
    _jugadoresAceptados.add(this.jugador);
    LinkedList<Jugador> _jugadoresRecomendados_1 = this.partido.getJugadoresRecomendados();
    int _size = _jugadoresRecomendados_1.size();
    Assert.assertEquals(0, _size);
    List<Jugador> _jugadoresAceptados_1 = this.sistema.getJugadoresAceptados();
    int _size_1 = _jugadoresAceptados_1.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testSeProponeUnJugadorYEsRechazado() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The constructor RegistroRechazo(String) is not applicable for the arguments ");
  }
}
