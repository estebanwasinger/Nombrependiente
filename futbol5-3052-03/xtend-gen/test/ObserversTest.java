package test;

import auxiliares.MessageSender;
import futbol5.Jugador;
import futbol5.Partido;
import infracciones.Infraccion;
import inscripciones.Estandar;
import java.util.List;
import junit.framework.Assert;
import observers.BajaSinReemplazoObserver;
import observers.EquipoCompletoObserver;
import observers.EquipoIncompletoObserver;
import observers.InscripcionObserver;
import observers.Notificacion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

@SuppressWarnings("all")
public class ObserversTest {
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
    this.partido.agregarObserverAlta(_inscripcionObserver);
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
    this.partido.agregarObserverAlta(_equipoCompletoObserver);
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
    this.partido.agregarObserverAlta(_equipoCompletoObserver);
    this.partido.inscribir(this.jugador);
    VerificationMode _times = Mockito.times(0);
    MessageSender _verify = Mockito.<MessageSender>verify(mockMessageSender, _times);
    Notificacion _any = Matchers.<Notificacion>any(Notificacion.class);
    _verify.send(_any);
  }
  
  @Test
  public void testPartidoCon10JugadoresYSeBaja1() {
    MessageSender mockMessageSenderAlta = Mockito.<MessageSender>mock(MessageSender.class);
    MessageSender mockMessageSenderBaja = Mockito.<MessageSender>mock(MessageSender.class);
    MessageSender mockMessageSenderInfraccion = Mockito.<MessageSender>mock(MessageSender.class);
    EquipoIncompletoObserver _equipoIncompletoObserver = new EquipoIncompletoObserver(mockMessageSenderBaja);
    this.partido.agregarObserverBaja(_equipoIncompletoObserver);
    EquipoIncompletoObserver _equipoIncompletoObserver_1 = new EquipoIncompletoObserver(mockMessageSenderAlta);
    this.partido.agregarObserverAlta(_equipoIncompletoObserver_1);
    BajaSinReemplazoObserver _bajaSinReemplazoObserver = new BajaSinReemplazoObserver(mockMessageSenderInfraccion);
    this.partido.agregarObserverBaja(_bajaSinReemplazoObserver);
    VerificationMode _times = Mockito.times(0);
    MessageSender _verify = Mockito.<MessageSender>verify(mockMessageSenderAlta, _times);
    Notificacion _any = Matchers.<Notificacion>any(Notificacion.class);
    _verify.send(_any);
    VerificationMode _times_1 = Mockito.times(0);
    MessageSender _verify_1 = Mockito.<MessageSender>verify(mockMessageSenderBaja, _times_1);
    Notificacion _any_1 = Matchers.<Notificacion>any(Notificacion.class);
    _verify_1.send(_any_1);
    this.armarPartido(9);
    this.partido.inscribir(this.jugador);
    VerificationMode _times_2 = Mockito.times(1);
    MessageSender _verify_2 = Mockito.<MessageSender>verify(mockMessageSenderAlta, _times_2);
    Notificacion _any_2 = Matchers.<Notificacion>any(Notificacion.class);
    _verify_2.send(_any_2);
    VerificationMode _times_3 = Mockito.times(0);
    MessageSender _verify_3 = Mockito.<MessageSender>verify(mockMessageSenderBaja, _times_3);
    Notificacion _any_3 = Matchers.<Notificacion>any(Notificacion.class);
    _verify_3.send(_any_3);
    this.partido.bajaSinReemplazo(this.jugador);
    VerificationMode _times_4 = Mockito.times(1);
    MessageSender _verify_4 = Mockito.<MessageSender>verify(mockMessageSenderBaja, _times_4);
    Notificacion _any_4 = Matchers.<Notificacion>any(Notificacion.class);
    _verify_4.send(_any_4);
    boolean _estaInscripto = this.partido.estaInscripto(this.jugador);
    Assert.assertFalse(_estaInscripto);
    List<Infraccion> _infracciones = this.jugador.getInfracciones();
    int _size = _infracciones.size();
    Assert.assertEquals(1, _size);
  }
}
