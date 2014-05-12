package test;

import futbol5.Jugador;
import futbol5.Partido;
import inscripciones.Estandar;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class NotificacionesTest {
  private Jugador jugador;
  
  private Partido partido;
  
  @Before
  public void setUP() {
    Jugador _jugador = new Jugador();
    this.jugador = _jugador;
    Estandar _estandar = new Estandar();
    this.jugador.setTipoInscripcion(_estandar);
    Partido _partido = new Partido("Berazategui");
    this.partido = _partido;
  }
  
  public void agregarAmigos(final int max) {
    int a = 0;
    boolean _while = (a < max);
    while (_while) {
      {
        List<Jugador> _amigos = this.jugador.getAmigos();
        Jugador _jugador = new Jugador();
        _amigos.add(_jugador);
        a = (a + 1);
      }
      _while = (a < max);
    }
  }
  
  @Test
  public void agregar4Amigos() {
    this.agregarAmigos(4);
    List<Jugador> _amigos = this.jugador.getAmigos();
    int _size = _amigos.size();
    Assert.assertEquals(4, _size);
  }
}
