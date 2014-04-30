package futbol5;

import futbol5.Condicional;
import futbol5.Estandar;
import futbol5.Jugador;
import futbol5.PartidoConfirmadoYCompletoException;
import futbol5.Solidario;
import futbol5.TipoInscripcion;
import java.util.LinkedList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Partido {
  private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
  
  public void partidoCompleto() {
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador unJugador) {
        TipoInscripcion _tipoInscripcion = unJugador.getTipoInscripcion();
        Class<? extends TipoInscripcion> _class = _tipoInscripcion.getClass();
        return Boolean.valueOf(_class.equals(Estandar.class));
      }
    };
    Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(this.jugadores, _function);
    int _size = IterableExtensions.size(_filter);
    boolean _equals = (_size == 10);
    if (_equals) {
      throw new PartidoConfirmadoYCompletoException("No se pueden inscribir mas jugadores. El equipo esta completo");
    }
  }
  
  public int cantJugadores() {
    return this.jugadores.size();
  }
  
  public void agregarJugador(final Jugador jugadorAInscribir) {
    this.jugadores.add(jugadorAInscribir);
  }
  
  public void cambiarJugador(final Integer posicionAGuardar, final Jugador jugador) {
    this.jugadores.set((posicionAGuardar).intValue(), jugador);
  }
  
  public int posicionEnLista(final Jugador jugador) {
    return this.jugadores.indexOf(jugador);
  }
  
  public Jugador ultimoSolidario() {
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador unJugador) {
        TipoInscripcion _tipoInscripcion = unJugador.getTipoInscripcion();
        Class<? extends TipoInscripcion> _class = _tipoInscripcion.getClass();
        return Boolean.valueOf(_class.equals(Solidario.class));
      }
    };
    Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(this.jugadores, _function);
    return IterableExtensions.<Jugador>last(_filter);
  }
  
  public Jugador unCondicional() {
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador unJugador) {
        TipoInscripcion _tipoInscripcion = unJugador.getTipoInscripcion();
        Class<? extends TipoInscripcion> _class = _tipoInscripcion.getClass();
        return Boolean.valueOf(_class.equals(Condicional.class));
      }
    };
    Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(this.jugadores, _function);
    return IterableExtensions.<Jugador>last(_filter);
  }
}
