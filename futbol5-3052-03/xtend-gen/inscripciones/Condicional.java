package inscripciones;

import condiciones.Condicion;
import futbol5.Jugador;
import futbol5.Partido;
import inscripciones.TipoInscripcion;

@SuppressWarnings("all")
public class Condicional implements TipoInscripcion {
  private Condicion _condicion;
  
  public Condicion getCondicion() {
    return this._condicion;
  }
  
  public void setCondicion(final Condicion condicion) {
    this._condicion = condicion;
  }
  
  private Partido _partidoAInscribirse;
  
  public Partido getPartidoAInscribirse() {
    return this._partidoAInscribirse;
  }
  
  public void setPartidoAInscribirse(final Partido partidoAInscribirse) {
    this._partidoAInscribirse = partidoAInscribirse;
  }
  
  public Condicional(final Partido partido, final Condicion laCondicion) {
    this.setPartidoAInscribirse(partido);
    this.setCondicion(laCondicion);
  }
  
  public boolean cumpleCondicion(final Jugador jugador, final Partido partidoAInscribirse) {
    Condicion _condicion = this.getCondicion();
    return _condicion.seCumple(jugador, partidoAInscribirse);
  }
  
  public int prioridad() {
    return 3;
  }
}
