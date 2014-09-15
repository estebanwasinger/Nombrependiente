package futbol5.domain;

import auxiliares.RegistroRechazo;
import com.google.common.base.Objects;
import excepciones.BusinessException;
import futbol5.domain.Jugador;
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
  
  private LinkedList<Jugador> _jugadoresRecomendados;
  
  public LinkedList<Jugador> getJugadoresRecomendados() {
    return this._jugadoresRecomendados;
  }
  
  public void setJugadoresRecomendados(final LinkedList<Jugador> jugadoresRecomendados) {
    this._jugadoresRecomendados = jugadoresRecomendados;
  }
  
  private static Sistema unico;
  
  public static Sistema getInstance() {
    Sistema _xblockexpression = null;
    {
      boolean _equals = Objects.equal(Sistema.unico, null);
      if (_equals) {
        Sistema _sistema = new Sistema();
        Sistema.unico = _sistema;
      }
      _xblockexpression = Sistema.unico;
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
  
  public boolean proponerA(final Jugador jugador) {
    LinkedList<Jugador> _jugadoresRecomendados = this.getJugadoresRecomendados();
    return _jugadoresRecomendados.add(jugador);
  }
  
  public boolean tomarUnaDecision(final Jugador jugador, final boolean loAcepta, final String motivo) {
    try {
      boolean _xblockexpression = false;
      {
        LinkedList<Jugador> _jugadoresRecomendados = this.getJugadoresRecomendados();
        boolean _remove = _jugadoresRecomendados.remove(jugador);
        boolean _not = (!_remove);
        if (_not) {
          throw new BusinessException(
            "El jugador que se desea aceptar/rechazar no se encuentra en la lista de recomendados");
        }
        boolean _xifexpression = false;
        if (loAcepta) {
          List<Jugador> _jugadoresAceptados = this.getJugadoresAceptados();
          _xifexpression = _jugadoresAceptados.add(jugador);
        } else {
          List<RegistroRechazo> _jugadoresRechazados = this.getJugadoresRechazados();
          RegistroRechazo _registroRechazo = new RegistroRechazo(jugador, motivo);
          _xifexpression = _jugadoresRechazados.add(_registroRechazo);
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
