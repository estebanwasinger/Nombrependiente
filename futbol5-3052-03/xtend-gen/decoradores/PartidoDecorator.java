package decoradores;

import futbol5.InterfazPartido;
import futbol5.Jugador;
import helper.NotificationSender;

@SuppressWarnings("all")
public class PartidoDecorator implements InterfazPartido {
  private InterfazPartido _decorado;
  
  public InterfazPartido getDecorado() {
    return this._decorado;
  }
  
  public void setDecorado(final InterfazPartido decorado) {
    this._decorado = decorado;
  }
  
  private NotificationSender _notificationSender;
  
  public NotificationSender getNotificationSender() {
    return this._notificationSender;
  }
  
  public void setNotificationSender(final NotificationSender notificationSender) {
    this._notificationSender = notificationSender;
  }
  
  public PartidoDecorator(final InterfazPartido partido) {
    this.setDecorado(partido);
  }
  
  public PartidoDecorator(final InterfazPartido partido, final NotificationSender nuevoNotificationSender) {
    this.setDecorado(partido);
    this.setNotificationSender(nuevoNotificationSender);
  }
  
  public int cantJugadores() {
    InterfazPartido _decorado = this.getDecorado();
    return _decorado.cantJugadores();
  }
  
  public void bajaSinReemplazo(final Jugador jugador) {
    InterfazPartido _decorado = this.getDecorado();
    _decorado.bajaSinReemplazo(jugador);
  }
  
  public void inscribir(final Jugador jugador) {
    InterfazPartido _decorado = this.getDecorado();
    _decorado.inscribir(jugador);
  }
}
