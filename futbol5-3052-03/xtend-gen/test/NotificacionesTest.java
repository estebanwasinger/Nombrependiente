package test;

import auxiliares.MessageSender;
import futbol5.Jugador;
import futbol5.Partido;
import inscripciones.Estandar;
import observers.EquipoCompletoObserver;
import observers.InscripcionObserver;
import observers.Notificacion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

@SuppressWarnings("all")
public class NotificacionesTest {
  private Jugador jugador;
  
  private Jugador amigo1;
  
  private Jugador amigo2;
  
  private Jugador amigo3;
  
  private Partido partido;
  
  @Before
  public void setUP() {
    Jugador _jugador = new Jugador();
    this.jugador = _jugador;
    Estandar _estandar = new Estandar();
    this.jugador.setTipoInscripcion(_estandar);
    Jugador _jugador_1 = new Jugador();
    this.amigo1 = _jugador_1;
    Jugador _jugador_2 = new Jugador();
    this.amigo2 = _jugador_2;
    Jugador _jugador_3 = new Jugador();
    this.amigo3 = _jugador_3;
    this.jugador.agregarAmigo(this.amigo1);
    this.jugador.agregarAmigo(this.amigo2);
    this.jugador.agregarAmigo(this.amigo3);
    Partido _partido = new Partido("Berazategui");
    this.partido = _partido;
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
  public void testJugadorSeInscribeYSeNotificaASusAmigos() {
    MessageSender mockMessageSender = Mockito.<MessageSender>mock(MessageSender.class);
    InscripcionObserver _inscripcionObserver = new InscripcionObserver(mockMessageSender);
    this.partido.agregarObserver(_inscripcionObserver);
    VerificationMode _times = Mockito.times(0);
    MessageSender _verify = Mockito.<MessageSender>verify(mockMessageSender, _times);
    Notificacion _any = Matchers.<Notificacion>any(Notificacion.class);
    _verify.send(_any);
    this.partido.inscribir(this.jugador);
    VerificationMode _times_1 = Mockito.times(3);
    MessageSender _verify_1 = Mockito.<MessageSender>verify(mockMessageSender, _times_1);
    Notificacion _any_1 = Matchers.<Notificacion>any(Notificacion.class);
    _verify_1.send(_any_1);
  }
  
  @Test
  public void testSeInscribeDecimoJugadorYSeNotificaAAdministrador() {
    MessageSender mockMessageSender = Mockito.<MessageSender>mock(MessageSender.class);
    EquipoCompletoObserver _equipoCompletoObserver = new EquipoCompletoObserver(mockMessageSender);
    this.partido.agregarObserver(_equipoCompletoObserver);
    VerificationMode _times = Mockito.times(0);
    MessageSender _verify = Mockito.<MessageSender>verify(mockMessageSender, _times);
    Notificacion _any = Matchers.<Notificacion>any(Notificacion.class);
    _verify.send(_any);
    this.armarPartido(9);
    this.partido.inscribir(this.jugador);
    VerificationMode _times_1 = Mockito.times(1);
    MessageSender _verify_1 = Mockito.<MessageSender>verify(mockMessageSender, _times_1);
    Notificacion _any_1 = Matchers.<Notificacion>any(Notificacion.class);
    _verify_1.send(_any_1);
  }
  
  @Test
  public void testSeInscribeUnJugadorYNoSeNotificaAAdministrador() {
    MessageSender mockMessageSender = Mockito.<MessageSender>mock(MessageSender.class);
    EquipoCompletoObserver _equipoCompletoObserver = new EquipoCompletoObserver(mockMessageSender);
    this.partido.agregarObserver(_equipoCompletoObserver);
    this.partido.inscribir(this.jugador);
    VerificationMode _times = Mockito.times(0);
    MessageSender _verify = Mockito.<MessageSender>verify(mockMessageSender, _times);
    Notificacion _any = Matchers.<Notificacion>any(Notificacion.class);
    _verify.send(_any);
  }
  
  @Test
  public void testPartidoCon10JugadoresYSeBaja1() {
    MessageSender mockMessageSender = Mockito.<MessageSender>mock(MessageSender.class);
    EquipoCompletoObserver _equipoCompletoObserver = new EquipoCompletoObserver(mockMessageSender);
    this.partido.agregarObserver(_equipoCompletoObserver);
    VerificationMode _times = Mockito.times(0);
    MessageSender _verify = Mockito.<MessageSender>verify(mockMessageSender, _times);
    Notificacion _any = Matchers.<Notificacion>any(Notificacion.class);
    _verify.send(_any);
    this.armarPartido(9);
    this.partido.inscribir(this.jugador);
    VerificationMode _times_1 = Mockito.times(1);
    MessageSender _verify_1 = Mockito.<MessageSender>verify(mockMessageSender, _times_1);
    Notificacion _any_1 = Matchers.<Notificacion>any(Notificacion.class);
    _verify_1.send(_any_1);
    this.partido.bajaSinReemplazo(this.jugador);
    VerificationMode _times_2 = Mockito.times(2);
    MessageSender _verify_2 = Mockito.<MessageSender>verify(mockMessageSender, _times_2);
    Notificacion _any_2 = Matchers.<Notificacion>any(Notificacion.class);
    _verify_2.send(_any_2);
  }
}
