package test;

import auxiliares.RegistroRechazo;
import calificaciones.Calificacion;
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
  
  private Jugador jugadorcalificado;
  
  private Partido partido;
  
  private Administrador administrador;
  
  private Sistema sistema;
  
  @Before
  public void setUP() {
    Jugador _jugador = new Jugador();
    this.jugador = _jugador;
    Administrador _administrador = new Administrador();
    this.administrador = _administrador;
    Sistema _instance = Sistema.getInstance();
    this.sistema = _instance;
    Jugador _jugador_1 = new Jugador();
    this.jugadorcalificado = _jugador_1;
    Partido _partido = new Partido("Villa Fiorito");
    this.partido = _partido;
    this.administrador.setMotivo("Se rechaza porque es mujer");
    this.administrador.setAceptar(Boolean.valueOf(true));
    this.limpiarListasDelSistema(this.sistema);
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
  
  public void limpiarListasDelSistema(final Sistema sistema) {
    List<RegistroRechazo> _jugadoresRechazados = sistema.getJugadoresRechazados();
    _jugadoresRechazados.clear();
    List<Jugador> _jugadoresAceptados = sistema.getJugadoresAceptados();
    _jugadoresAceptados.clear();
  }
  
  @Test
  public void testSeProponeUnJugadorEsAceptadoYSePuedeInscribir() {
    this.partido.jugadorProponeA(this.jugador);
    this.partido.tomarDecision(Boolean.valueOf(true), this.jugador, null);
    LinkedList<Jugador> _jugadoresRecomendados = this.partido.getJugadoresRecomendados();
    int _size = _jugadoresRecomendados.size();
    Assert.assertEquals(0, _size);
    List<Jugador> _jugadoresAceptados = this.sistema.getJugadoresAceptados();
    int _size_1 = _jugadoresAceptados.size();
    Assert.assertEquals(1, _size_1);
    List<RegistroRechazo> _jugadoresRechazados = this.sistema.getJugadoresRechazados();
    int _size_2 = _jugadoresRechazados.size();
    Assert.assertEquals(0, _size_2);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugador);
    Assert.assertTrue(_estaInscripto);
  }
  
  @Test(expected = BusinessException.class)
  public void testSeProponeUnJugadorEsAceptadoYNoSePuedeInscribir() {
    this.armarPartido(10);
    this.partido.jugadorProponeA(this.jugador);
    this.partido.tomarDecision(Boolean.valueOf(true), this.jugador, null);
  }
  
  @Test
  public void testSeProponeUnJugadorYEsRechazado() {
    this.partido.jugadorProponeA(this.jugador);
    this.partido.tomarDecision(Boolean.valueOf(false), this.jugador, "Es un jugador agresivo");
    LinkedList<Jugador> _jugadoresRecomendados = this.partido.getJugadoresRecomendados();
    int _size = _jugadoresRecomendados.size();
    Assert.assertEquals(0, _size);
    List<RegistroRechazo> _jugadoresRechazados = this.sistema.getJugadoresRechazados();
    int _size_1 = _jugadoresRechazados.size();
    Assert.assertEquals(1, _size_1);
    List<Jugador> _jugadoresAceptados = this.sistema.getJugadoresAceptados();
    int _size_2 = _jugadoresAceptados.size();
    Assert.assertEquals(0, _size_2);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugador);
    Assert.assertFalse(_estaInscripto);
  }
  
  @Test(expected = BusinessException.class)
  public void testCalificacionAJugadorQueNoJugo() {
    this.partido.inscribir(this.jugador);
    this.armarPartido(9);
    this.partido.calificar(this.jugador, this.jugadorcalificado, 10, "excelente");
  }
  
  @Test(expected = BusinessException.class)
  public void testDesconocidoCalificaJugador() {
    this.partido.inscribir(this.jugadorcalificado);
    this.armarPartido(9);
    this.partido.calificar(this.jugador, this.jugadorcalificado, 10, "normal");
  }
  
  @Test
  public void testJugadorCalificaASuCompanero() {
    this.partido.inscribir(this.jugador);
    this.partido.inscribir(this.jugadorcalificado);
    this.armarPartido(8);
    this.partido.calificar(this.jugador, this.jugadorcalificado, 10, "excelente");
    List<Calificacion> _calificaciones = this.jugadorcalificado.getCalificaciones();
    int _size = _calificaciones.size();
    Assert.assertEquals(1, _size);
  }
}
