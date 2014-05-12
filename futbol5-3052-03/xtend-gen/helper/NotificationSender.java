package helper;

import helper.Notificacion;

@SuppressWarnings("all")
public interface NotificationSender {
  public abstract void send(final Notificacion notificacion);
}
