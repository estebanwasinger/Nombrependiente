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
  
  private HashMap<String,Set<String>> notificacionsRecibidos;
  
  public StubNotificationSender() {
    HashMap<String,Set<String>> _hashMap = new HashMap<String, Set<String>>();
    this.notificacionsEnviados = _hashMap;
    HashMap<String,Set<String>> _hashMap_1 = new HashMap<String, Set<String>>();
    this.notificacionsRecibidos = _hashMap_1;
  }
  
  public void send(final Notificacion notificacion) {
    String _de = notificacion.getDe();
    String _a = notificacion.getA();
    String _contenido = notificacion.getContenido();
    this.simularEnvioNotificacion(_de, _a, _contenido);
    String _de_1 = notificacion.getDe();
    String _plus = ("Simulación envío de notificacion | Quien lo manda: " + _de_1);
    String _plus_1 = (_plus + " | A quien: ");
    String _a_1 = notificacion.getA();
    String _plus_2 = (_plus_1 + _a_1);
    String _plus_3 = (_plus_2 + 
      " Mensaje: ");
    String _contenido_1 = notificacion.getContenido();
    String _plus_4 = (_plus_3 + _contenido_1);
    InputOutput.<String>println(_plus_4);
  }
  
  public Set<String> simularEnvioNotificacion(final String from, final String to, final String message) {
    Set<String> _xblockexpression = null;
    {
      Set<String> mensajes = this.notificacionsDe(from);
      mensajes.add(message);
      this.notificacionsEnviados.put(from, mensajes);
      _xblockexpression = this.notificacionsRecibidos.put(to, mensajes);
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
  
  public Set<String> notificacionsPara(final String to) {
    Set<String> _xblockexpression = null;
    {
      Set<String> mensajes = this.notificacionsRecibidos.get(to);
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
