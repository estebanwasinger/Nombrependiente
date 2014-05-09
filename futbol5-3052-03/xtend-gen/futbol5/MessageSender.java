package futbol5;

import futbol5.Notificacion;

@SuppressWarnings("all")
public interface MessageSender {
  public abstract void send(final Notificacion notificacion);
}
