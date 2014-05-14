package test;

import decoradores.InfraccionDecorator;
import decoradores.NotificarAmigosDecorator;
import decoradores.PartidoDecorator;
import decoradores.Son10Decorator;
import decoradores.YaNoSon10Decorator;
import futbol5.Jugador;
import futbol5.Partido;
import helper.StubNotificationSender;
import inscripciones.Estandar;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class NotificacionesTest {
  private Jugador jugador;
  
  private Partido partido;
  
  private StubNotificationSender notificador;
  
  private NotificarAmigosDecorator partidoConNotificarAmigosDecorator;
  
  private Son10Decorator partidoYaSon10Decorator;
  
  private YaNoSon10Decorator partidoYaNoSon10Decorator;
  
  private InfraccionDecorator jugadorConInfraccionDecorator;
  
  @Before
  public void setUP() {
    Estandar _estandar = new Estandar();
    Jugador _jugador = new Jugador(_estandar, "Jorge");
    this.jugador = _jugador;
    Partido _partido = new Partido("Berazategui");
    this.partido = _partido;
    StubNotificationSender _stubNotificationSender = new StubNotificationSender();
    this.notificador = _stubNotificationSender;
    NotificarAmigosDecorator _notificarAmigosDecorator = new NotificarAmigosDecorator(this.partido, this.notificador);
    this.partidoConNotificarAmigosDecorator = _notificarAmigosDecorator;
    Son10Decorator _son10Decorator = new Son10Decorator(this.partido, this.notificador);
    this.partidoYaSon10Decorator = _son10Decorator;
    YaNoSon10Decorator _yaNoSon10Decorator = new YaNoSon10Decorator(this.partido, this.notificador);
    this.partidoYaNoSon10Decorator = _yaNoSon10Decorator;
    InfraccionDecorator _infraccionDecorator = new InfraccionDecorator(this.partido);
    this.jugadorConInfraccionDecorator = _infraccionDecorator;
  }
  
  public void agregarAmigos(final int max) {
    int a = 0;
    boolean _while = (a < max);
    while (_while) {
      {
        List<Jugador> _amigos = this.jugador.getAmigos();
        Estandar _estandar = new Estandar();
        Jugador _jugador = new Jugador(_estandar, "NombreJugador");
        _amigos.add(_jugador);
        a = (a + 1);
      }
      _while = (a < max);
    }
  }
  
  public boolean agregarUnAmigoConNombre(final Jugador pjugador, final String nombre) {
    List<Jugador> _amigos = pjugador.getAmigos();
    Estandar _estandar = new Estandar();
    Jugador _jugador = new Jugador(_estandar, nombre);
    return _amigos.add(_jugador);
  }
  
  public void agregarJugadores(final PartidoDecorator partidoDecorator, final int cantidad) {
    int a = 0;
    boolean _while = (a < cantidad);
    while (_while) {
      {
        Estandar _estandar = new Estandar();
        Jugador _jugador = new Jugador(_estandar, "nombreJugador");
        partidoDecorator.inscribir(_jugador);
        a = (a + 1);
      }
      _while = (a < cantidad);
    }
  }
  
  public boolean agregarLosAmigosDelFutbol(final Jugador jugador) {
    boolean _xblockexpression = false;
    {
      this.agregarUnAmigoConNombre(jugador, "Luis");
      this.agregarUnAmigoConNombre(jugador, "Claudio");
      this.agregarUnAmigoConNombre(jugador, "Arturo");
      _xblockexpression = this.agregarUnAmigoConNombre(jugador, "Julio Cesar");
    }
    return _xblockexpression;
  }
  
  @Test
  public void agregar4Amigos() {
    this.agregarAmigos(4);
    List<Jugador> _amigos = this.jugador.getAmigos();
    int _size = _amigos.size();
    Assert.assertEquals(4, _size);
  }
  
  @Test
  public void mandarNotificacionesAAmigos() {
    this.agregarLosAmigosDelFutbol(this.jugador);
    this.partidoConNotificarAmigosDecorator.inscribir(this.jugador);
    List<Jugador> _amigos = this.jugador.getAmigos();
    int _size = _amigos.size();
    Set<String> _notificacionsDe = this.notificador.notificacionsDe("Jorge");
    int _size_1 = _notificacionsDe.size();
    Assert.assertEquals(_size, _size_1);
  }
  
  @Test
  public void mandarNotificacionAdminPartidoLleno() {
    this.agregarJugadores(this.partidoYaSon10Decorator, 10);
    Set<String> _notificacionsPara = this.notificador.notificacionsPara("Admin");
    int _size = _notificacionsPara.size();
    Assert.assertEquals(_size, 1);
  }
  
  @Test
  public void mandarNotificacionAdminPartidoIncompleto() {
    this.agregarJugadores(this.partidoYaNoSon10Decorator, 9);
    this.partidoYaNoSon10Decorator.inscribir(this.jugador);
    this.partidoYaNoSon10Decorator.bajaSinReemplazo(this.jugador);
    Set<String> _notificacionsPara = this.notificador.notificacionsPara("Admin");
    int _size = _notificacionsPara.size();
    Assert.assertEquals(_size, 1);
  }
  
  @Test
  public void generarInfraccion() {
    this.agregarJugadores(this.jugadorConInfraccionDecorator, 5);
    this.jugadorConInfraccionDecorator.inscribir(this.jugador);
    this.jugadorConInfraccionDecorator.bajaSinReemplazo(this.jugador);
    int _diasDeInfraccion = this.jugador.getDiasDeInfraccion();
    Assert.assertEquals(5, _diasDeInfraccion);
  }
  
  @Test
  public void decoratorCombinado() {
    NotificarAmigosDecorator _notificarAmigosDecorator = new NotificarAmigosDecorator(this.partido, this.notificador);
    Son10Decorator partidoConNotAmigosYPartidoCompletoDecorator = new Son10Decorator(_notificarAmigosDecorator, this.notificador);
    this.agregarJugadores(partidoConNotAmigosYPartidoCompletoDecorator, 9);
    this.agregarLosAmigosDelFutbol(this.jugador);
    partidoConNotAmigosYPartidoCompletoDecorator.inscribir(this.jugador);
    Set<String> _notificacionsPara = this.notificador.notificacionsPara("Admin");
    int _size = _notificacionsPara.size();
    Assert.assertEquals(_size, 1);
    List<Jugador> _amigos = this.jugador.getAmigos();
    int _size_1 = _amigos.size();
    Set<String> _notificacionsDe = this.notificador.notificacionsDe("Jorge");
    int _size_2 = _notificacionsDe.size();
    Assert.assertEquals(_size_1, _size_2);
  }
}
