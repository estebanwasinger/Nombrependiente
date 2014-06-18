package condiciones;

import condiciones.Condicion;
import futbol5.Jugador;
import futbol5.Partido;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class CondicionJugadoresPorEdad implements Condicion {
  private int _edadLimite;
  
  public int getEdadLimite() {
    return this._edadLimite;
  }
  
  public void setEdadLimite(final int edadLimite) {
    this._edadLimite = edadLimite;
  }
  
  private int _jugadoresLimite;
  
  public int getJugadoresLimite() {
    return this._jugadoresLimite;
  }
  
  public void setJugadoresLimite(final int jugadoresLimite) {
    this._jugadoresLimite = jugadoresLimite;
  }
  
  public CondicionJugadoresPorEdad(final int jugadoresLimite, final int edadLimite) {
    this.setJugadoresLimite(jugadoresLimite);
    this.setEdadLimite(edadLimite);
  }
  
  public boolean seCumple(final Jugador jugador, final Partido partido) {
    int _edadLimite = this.getEdadLimite();
    int _cantInscriptosConEdadLimite = this.cantInscriptosConEdadLimite(partido, _edadLimite);
    int _jugadoresLimite = this.getJugadoresLimite();
    return (_cantInscriptosConEdadLimite <= _jugadoresLimite);
  }
  
  public int cantInscriptosConEdadLimite(final Partido partido, final int edadLimite) {
    List<Jugador> _jugadores = partido.getJugadores();
    final Function1<Jugador, Boolean> _function = new Function1<Jugador, Boolean>() {
      public Boolean apply(final Jugador jugador) {
        return Boolean.valueOf(jugador.menorA(edadLimite));
      }
    };
    Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(_jugadores, _function);
    return IterableExtensions.size(_filter);
  }
}
