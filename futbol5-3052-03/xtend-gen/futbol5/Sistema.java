package futbol5;

import auxiliares.RegistroRechazo;
import com.google.common.base.Objects;
import excepciones.BusinessException;
import futbol5.Jugador;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;

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
  
  private List<Jugador> _jugadoresRecomendados;
  
  public List<Jugador> getJugadoresRecomendados() {
    return this._jugadoresRecomendados;
  }
  
  public void setJugadoresRecomendados(final List<Jugador> jugadoresRecomendados) {
    this._jugadoresRecomendados = jugadoresRecomendados;
  }
  
  private static Sistema INSTANCE = null;
  
  public static Sistema getInstance() {
    Sistema _xblockexpression = null;
    {
      boolean _equals = Objects.equal(Sistema.INSTANCE, null);
      if (_equals) {
        Sistema _sistema = new Sistema();
        Sistema.INSTANCE = _sistema;
      }
      _xblockexpression = Sistema.INSTANCE;
    }
    return _xblockexpression;
  }
  
  public Sistema() {
    LinkedList<Jugador> _linkedList = new LinkedList<Jugador>();
    this.setJugadoresAceptados(_linkedList);
    LinkedList<RegistroRechazo> _linkedList_1 = new LinkedList<RegistroRechazo>();
    this.setJugadoresRechazados(_linkedList_1);
    LinkedList<Jugador> _linkedList_2 = new LinkedList<Jugador>();
    this.setJugadoresRecomendados(_linkedList_2);
  }
  
  public boolean jugadorProponeA(final Jugador jugador) {
    List<Jugador> _jugadoresRecomendados = this.getJugadoresRecomendados();
    return _jugadoresRecomendados.add(jugador);
  }
  
  public boolean tomarDecision(final Boolean decision, final Jugador jugador, final String motivo) {
    try {
      boolean _xifexpression = false;
      List<Jugador> _jugadoresRecomendados = this.getJugadoresRecomendados();
      boolean _remove = _jugadoresRecomendados.remove(jugador);
      boolean _equals = (_remove == false);
      if (_equals) {
        throw new BusinessException("El jugador que se desea aceptar no se encuentra en la lista de recomendados");
      } else {
        boolean _xifexpression_1 = false;
        if ((decision).booleanValue()) {
          List<Jugador> _jugadoresAceptados = this.getJugadoresAceptados();
          _xifexpression_1 = _jugadoresAceptados.add(jugador);
        } else {
          List<RegistroRechazo> _jugadoresRechazados = this.getJugadoresRechazados();
          RegistroRechazo _registroRechazo = new RegistroRechazo(jugador, motivo);
          _xifexpression_1 = _jugadoresRechazados.add(_registroRechazo);
        }
        _xifexpression = _xifexpression_1;
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
