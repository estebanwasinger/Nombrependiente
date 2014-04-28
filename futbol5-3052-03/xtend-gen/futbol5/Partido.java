package futbol5;

import com.google.common.base.Objects;
import futbol5.EquipoConfirmadoYCompleto;
import futbol5.Jugador;
import futbol5.TipoInscripcion;
import java.util.LinkedList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Partido {
  private LinkedList<Jugador> _jugadores;
  
  public LinkedList<Jugador> getJugadores() {
    return this._jugadores;
  }
  
  public void setJugadores(final LinkedList<Jugador> jugadores) {
    this._jugadores = jugadores;
  }
  
  private String _condicion;
  
  public String getCondicion() {
    return this._condicion;
  }
  
  public void setCondicion(final String condicion) {
    this._condicion = condicion;
  }
  
  public void inscribirJugador(final Jugador jugadorAInscribir) {
    final Jugador jugador = null;
    LinkedList<Jugador> _jugadores = this.getJugadores();
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador it) {
        TipoInscripcion _tipoInscripcion = jugador.getTipoInscripcion();
        return Boolean.valueOf(Objects.equal(_tipoInscripcion, "Estandar"));
      }
    };
    Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(_jugadores, _function);
    int _size = IterableExtensions.size(_filter);
    boolean _equals = (_size == 10);
    if (_equals) {
      throw new EquipoConfirmadoYCompleto("No se pueden inscribir más jugadores. El equipo está completo");
    } else {
      jugadorAInscribir.inscribirse(this);
    }
  }
  
  public int cantJugadores() {
    LinkedList<Jugador> _jugadores = this.getJugadores();
    return _jugadores.size();
  }
  
  public void agregarJugador(final Jugador jugadorAInscribir) {
    LinkedList<Jugador> _jugadores = this.getJugadores();
    _jugadores.add(jugadorAInscribir);
  }
}
