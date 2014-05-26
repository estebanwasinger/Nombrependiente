package auxiliares;

import futbol5.Jugador;
import java.util.Date;

@SuppressWarnings("all")
public class RegistroRechazo {
  private Date _fechaDelDia;
  
  public Date getFechaDelDia() {
    return this._fechaDelDia;
  }
  
  public void setFechaDelDia(final Date fechaDelDia) {
    this._fechaDelDia = fechaDelDia;
  }
  
  private String _motivoRechazo;
  
  public String getMotivoRechazo() {
    return this._motivoRechazo;
  }
  
  public void setMotivoRechazo(final String motivoRechazo) {
    this._motivoRechazo = motivoRechazo;
  }
  
  private Jugador _jugadorRechazado;
  
  public Jugador getJugadorRechazado() {
    return this._jugadorRechazado;
  }
  
  public void setJugadorRechazado(final Jugador jugadorRechazado) {
    this._jugadorRechazado = jugadorRechazado;
  }
  
  public RegistroRechazo(final Jugador jugador, final String motivo) {
    Date _date = new Date();
    this.setFechaDelDia(_date);
    this.setMotivoRechazo(motivo);
    this.setJugadorRechazado(jugador);
  }
}
