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
  
  private Jugador amigo;
  
  private Jugador jugadorCalificado;
  
  private Partido partido;
  
  private Administrador administrador;
  
  private Sistema sistema;
  
  @Before
  public void setUP() {
    Jugador _jugador = new Jugador();
    this.jugador = _jugador;
    Jugador _jugador_1 = new Jugador();
    this.amigo = _jugador_1;
    Administrador _administrador = new Administrador();
    this.administrador = _administrador;
    Sistema _sistema = new Sistema();
    this.sistema = _sistema;
    this.administrador.setSistema(this.sistema);
    this.jugador.setSistema(this.sistema);
    Jugador _jugador_2 = new Jugador();
    this.jugadorCalificado = _jugador_2;
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
    this.jugador.proponerA(this.amigo);
    this.administrador.revisarRecomendados();
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
  
  @Test
  public void testSeProponeUnJugadorYEsRechazado() {
    this.administrador.setLoAcepta(Boolean.valueOf(false));
    this.jugador.proponerA(this.amigo);
    this.administrador.revisarRecomendados();
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
  
  @Test(expected = BusinessException.class)
  public void testCalificacionAJugadorQueNoJugo() {
    this.partido.inscribir(this.jugador);
    this.armarPartido(9);
    this.jugador.calificar(this.jugadorCalificado, this.partido, 10, "excelente");
  }
  
  @Test(expected = BusinessException.class)
  public void testCalificacionDeUnJugadorQueNoJugo() {
    this.partido.inscribir(this.jugadorCalificado);
    this.armarPartido(9);
    this.jugador.calificar(this.jugadorCalificado, this.partido, 10, "excelente");
  }
  
  @Test
  public void testJugadorCalificaASuCompanero() {
    this.partido.inscribir(this.jugador);
    this.partido.inscribir(this.jugadorCalificado);
    this.armarPartido(8);
    this.jugador.calificar(this.jugadorCalificado, this.partido, 10, "excelente");
    List<Calificacion> _calificaciones = this.jugadorCalificado.getCalificaciones();
    int _size = _calificaciones.size();
    Assert.assertEquals(1, _size);
  }
}
