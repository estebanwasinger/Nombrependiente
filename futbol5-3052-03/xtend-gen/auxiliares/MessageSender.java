package auxiliares;

import observers.Notificacion;

@SuppressWarnings("all")
public interface MessageSender {
  public abstract void send(final Notificacion notificacion);
}
