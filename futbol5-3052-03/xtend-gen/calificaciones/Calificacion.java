package calificaciones;

import futbol5.Jugador;
import futbol5.Partido;

@SuppressWarnings("all")
public class Calificacion {
  private Jugador _jugadorQueCalifica;
  
  public Jugador getJugadorQueCalifica() {
    return this._jugadorQueCalifica;
  }
  
  public void setJugadorQueCalifica(final Jugador jugadorQueCalifica) {
    this._jugadorQueCalifica = jugadorQueCalifica;
  }
  
  private Jugador _jugadorACalificar;
  
  public Jugador getJugadorACalificar() {
    return this._jugadorACalificar;
  }
  
  public void setJugadorACalificar(final Jugador jugadorACalificar) {
    this._jugadorACalificar = jugadorACalificar;
  }
  
  private int _nota;
  
  public int getNota() {
    return this._nota;
  }
  
  public void setNota(final int nota) {
    this._nota = nota;
  }
  
  private String _critica;
  
  public String getCritica() {
    return this._critica;
  }
  
  public void setCritica(final String critica) {
    this._critica = critica;
  }
  
  private Partido _partido;
  
  public Partido getPartido() {
    return this._partido;
  }
  
  public void setPartido(final Partido partido) {
    this._partido = partido;
  }
  
  public void generar(final Jugador jugadorQueCalifica, final Jugador jugadorACalificar, final Integer nota, final String critica, final Partido partido) {
    this.setJugadorQueCalifica(jugadorQueCalifica);
    this.setJugadorACalificar(jugadorACalificar);
    this.setNota((nota).intValue());
    this.setCritica(critica);
    this.setPartido(partido);
  }
}
