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
  
  private String motivo;
  
  @Before
  public void setUP() {
    Jugador _jugador = new Jugador();
    this.jugador = _jugador;
    Administrador _administrador = new Administrador();
    this.administrador = _administrador;
    Sistema _sistema = new Sistema();
    this.sistema = _sistema;
    Jugador _jugador_1 = new Jugador();
    this.jugadorcalificado = _jugador_1;
    Partido _partido = new Partido("Villa Fiorito");
    this.partido = _partido;
    this.administrador.setMotivo("Se rechaza porque es mujer");
    this.administrador.setLoAcepta(Boolean.valueOf(true));
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
    this.jugador.jugadorProponeA(this.jugador);
    this.administrador.tomarUnaDecision(this.jugador);
    LinkedList<Jugador> _jugadoresRecomendados = this.sistema.getJugadoresRecomendados();
    int _size = _jugadoresRecomendados.size();
    Assert.assertEquals(0, _size);
    List<Jugador> _jugadoresAceptados = this.sistema.getJugadoresAceptados();
    int _size_1 = _jugadoresAceptados.size();
    Assert.assertEquals(1, _size_1);
    List<RegistroRechazo> _jugadoresRechazados = this.sistema.getJugadoresRechazados();
    int _size_2 = _jugadoresRechazados.size();
    Assert.assertEquals(0, _size_2);
  }
  
  /**
   * ya no va..
   * @Test(expected=typeof(BusinessException))
   * def void testSeProponeUnJugadorEsAceptadoYNoSePuedeInscribir(){
   * armarPartido(10)
   * jugador.jugadorProponeA(jugador)
   * administrador.tomarUnaDecision(jugador) //el equipo esta lleno y por eso no se lo inscribe
   */
  @Test
  public void testSeProponeUnJugadorYEsRechazado() {
    this.administrador.setLoAcepta(Boolean.valueOf(false));
    this.jugador.jugadorProponeA(this.jugador);
    this.administrador.tomarUnaDecision(this.jugador);
    LinkedList<Jugador> _jugadoresRecomendados = this.sistema.getJugadoresRecomendados();
    int _size = _jugadoresRecomendados.size();
    Assert.assertEquals(0, _size);
    List<RegistroRechazo> _jugadoresRechazados = this.sistema.getJugadoresRechazados();
    int _size_1 = _jugadoresRechazados.size();
    Assert.assertEquals(1, _size_1);
    List<Jugador> _jugadoresAceptados = this.sistema.getJugadoresAceptados();
    int _size_2 = _jugadoresAceptados.size();
    Assert.assertEquals(0, _size_2);
  }
  
  /**
   * sino esta inscripto no podria calificar, creo q hay que sacar el inscribir
   */
  @Test(expected = BusinessException.class)
  public void testCalificacionAJugadorQueNoJugo() {
    this.partido.inscribir(this.jugadorcalificado);
    this.armarPartido(9);
    this.jugador.calificar(this.jugadorcalificado, this.partido, 10, "excelente");
  }
  
  @Test
  public void testJugadorCalificaASuCompanero() {
    this.partido.inscribir(this.jugadorcalificado);
    this.armarPartido(9);
    this.jugador.calificar(this.jugadorcalificado, this.partido, 10, "excelente");
    List<Calificacion> _calificaciones = this.jugadorcalificado.getCalificaciones();
    int _size = _calificaciones.size();
    Assert.assertEquals(1, _size);
  }
}
