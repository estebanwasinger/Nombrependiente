package calificaciones;

import futbol5.Jugador;
import futbol5.Partido;

@SuppressWarnings("all")
public class Calificacion {
  private Jugador _calificado;
  
  public Jugador getCalificado() {
    return this._calificado;
  }
  
  public void setCalificado(final Jugador calificado) {
    this._calificado = calificado;
  }
  
  private Partido _partido;
  
  public Partido getPartido() {
    return this._partido;
  }
  
  public void setPartido(final Partido partido) {
    this._partido = partido;
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
  
  public Calificacion(final Jugador calificado, final Partido partido, final Integer nota, final String critica) {
    this.setCalificado(calificado);
    this.setPartido(partido);
    this.setNota((nota).intValue());
    this.setCritica(critica);
  }
}
