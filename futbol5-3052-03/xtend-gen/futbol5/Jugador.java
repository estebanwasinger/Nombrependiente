package futbol5;

import futbol5.Partido;
import futbol5.TipoInscripcion;

@SuppressWarnings("all")
public class Jugador {
  private TipoInscripcion _tipoInscripcion;
  
  public TipoInscripcion getTipoInscripcion() {
    return this._tipoInscripcion;
  }
  
  public void setTipoInscripcion(final TipoInscripcion tipoInscripcion) {
    this._tipoInscripcion = tipoInscripcion;
  }
  
  private Partido _partido;
  
  public Partido getPartido() {
    return this._partido;
  }
  
  public void setPartido(final Partido partido) {
    this._partido = partido;
  }
  
  public void inscribirse(final Partido partido) {
    partido.partidoCompleto();
    TipoInscripcion _tipoInscripcion = this.getTipoInscripcion();
    _tipoInscripcion.inscribir(partido, this);
  }
}
