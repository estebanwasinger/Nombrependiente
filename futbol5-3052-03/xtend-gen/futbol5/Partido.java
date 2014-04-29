package futbol5;

import futbol5.Condicional;
import futbol5.Jugador;
import futbol5.Solidario;
import futbol5.TipoInscripcion;
import java.util.LinkedList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Partido {
  private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
  
  /**
   * if (jugadores.filter[jugador.tipoInscripcion=="Estandar"].size == 10){
   * throw new EquipoConfirmadoYCompleto("No se pueden inscribir m�s jugadores. El equipo est� completo")
   * }
   * else{
   * jugadorAInscribir.inscribirse(this)
   * }
   * }
   * La logico de la inscripcion se tiene que delegar a los tiposDeInscripcion
   */
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
