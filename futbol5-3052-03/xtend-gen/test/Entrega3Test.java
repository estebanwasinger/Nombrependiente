package test;

import auxiliares.RegistroRechazo;
import calificaciones.Calificacion;
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
  
  private Jugador amigo;
  
  private Jugador jugadorCalificado;
  
  private Partido partido;
  
  private Sistema sistema;
  
  @Before
  public void setUP() {
    Jugador _jugador = new Jugador();
    this.jugador = _jugador;
    Jugador _jugador_1 = new Jugador();
    this.amigo = _jugador_1;
    Partido _partido = new Partido("VIlla Fiorito");
    this.partido = _partido;
    Jugador _jugador_2 = new Jugador();
    this.jugadorCalificado = _jugador_2;
    Sistema _instance = Sistema.getInstance();
    this.sistema = _instance;
  }
  
  @Test
  public void testSeProponeUnJugadorEsAceptado() {
    this.sistema.proponerA(this.amigo);
    this.sistema.tomarUnaDecision(this.amigo, true, null);
    LinkedList<Jugador> _jugadoresRecomendados = this.sistema.getJugadoresRecomendados();
    int _size = _jugadoresRecomendados.size();
    Assert.assertEquals(0, _size);
    List<Jugador> _jugadoresAceptados = this.sistema.getJugadoresAceptados();
    int _size_1 = _jugadoresAceptados.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test
  public void testSeProponeUnJugadorYEsRechazado() {
    this.sistema.proponerA(this.amigo);
    this.sistema.tomarUnaDecision(this.amigo, false, "no me parace simpatico este chico");
    LinkedList<Jugador> _jugadoresRecomendados = this.sistema.getJugadoresRecomendados();
    int _size = _jugadoresRecomendados.size();
    Assert.assertEquals(0, _size);
    List<RegistroRechazo> _jugadoresRechazados = this.sistema.getJugadoresRechazados();
    int _size_1 = _jugadoresRechazados.size();
    Assert.assertEquals(1, _size_1);
  }
  
  @Test(expected = BusinessException.class)
  public void testSeTrataDeAceptarUnJugadorNoRecomendado() {
    this.sistema.tomarUnaDecision(this.amigo, false, "no me parace simpatico este chico");
  }
  
  @Test(expected = BusinessException.class)
  public void testCalificacionAJugadorQueNoJugo() {
    this.partido.inscribir(this.jugador);
    this.jugadorCalificado.calificar(this.partido, 10, "excelente");
  }
  
  @Test
  public void testJugadorCalificaASuCompanero() {
    this.partido.inscribir(this.jugador);
    this.partido.inscribir(this.jugadorCalificado);
    this.jugadorCalificado.calificar(this.partido, 10, "excelente");
    List<Calificacion> _calificaciones = this.jugadorCalificado.getCalificaciones();
    int _size = _calificaciones.size();
    Assert.assertEquals(1, _size);
  }
}
