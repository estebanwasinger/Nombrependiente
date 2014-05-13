package helper;

import com.google.common.base.Objects;
import helper.Notificacion;
import helper.NotificationSender;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class StubNotificationSender implements NotificationSender {
  private Map<String,Set<String>> notificacionsEnviados;
  
  public StubNotificationSender() {
    HashMap<String,Set<String>> _hashMap = new HashMap<String, Set<String>>();
    this.notificacionsEnviados = _hashMap;
  }
  
  public void send(final Notificacion notificacion) {
    String _de = notificacion.getDe();
    String _contenido = notificacion.getContenido();
    this.simularEnvioNotificacion(_de, _contenido);
    String _de_1 = notificacion.getDe();
    String _plus = ("Simulación envío de notificacion | From: " + _de_1);
    String _plus_1 = (_plus + " | To: ");
    String _a = notificacion.getA();
    String _plus_2 = (_plus_1 + _a);
    String _plus_3 = (_plus_2 + " | Message: ");
    String _contenido_1 = notificacion.getContenido();
    String _plus_4 = (_plus_3 + _contenido_1);
    InputOutput.<String>println(_plus_4);
  }
  
  public Set<String> simularEnvioNotificacion(final String from, final String message) {
    Set<String> _xblockexpression = null;
    {
      Set<String> mensajes = this.notificacionsDe(from);
      mensajes.add(message);
      _xblockexpression = this.notificacionsEnviados.put(from, mensajes);
    }
    return _xblockexpression;
  }
  
  public Set<String> notificacionsDe(final String from) {
    Set<String> _xblockexpression = null;
    {
      Set<String> mensajes = this.notificacionsEnviados.get(from);
      boolean _equals = Objects.equal(mensajes, null);
      if (_equals) {
        HashSet<String> _hashSet = new HashSet<String>();
        mensajes = _hashSet;
      }
      _xblockexpression = mensajes;
    }
    return _xblockexpression;
  }
}
