package futbol5;

import auxiliares.RegistroRechazo;
import futbol5.Jugador;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class Sistema {
  private List<Jugador> _jugadoresAceptados;
  
  public List<Jugador> getJugadoresAceptados() {
    return this._jugadoresAceptados;
  }
  
  public void setJugadoresAceptados(final List<Jugador> jugadoresAceptados) {
    this._jugadoresAceptados = jugadoresAceptados;
  }
  
  private List<RegistroRechazo> _jugadoresRechazados;
  
  public List<RegistroRechazo> getJugadoresRechazados() {
    return this._jugadoresRechazados;
  }
  
  public void setJugadoresRechazados(final List<RegistroRechazo> jugadoresRechazados) {
    this._jugadoresRechazados = jugadoresRechazados;
  }
  
  public Sistema() {
    LinkedList<Jugador> _linkedList = new LinkedList<Jugador>();
    this.setJugadoresAceptados(_linkedList);
    LinkedList<RegistroRechazo> _linkedList_1 = new LinkedList<RegistroRechazo>();
    this.setJugadoresRechazados(_linkedList_1);
  }
  
  public Object jugadorProponeA(final Jugador jugador) {
    return null;
  }
  
  public Object decisionAdministrador(final boolean decision, final String motivo) {
    return null;
  }
}
