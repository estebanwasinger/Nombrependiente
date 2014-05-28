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
  
  private Jugador _jugador;
  
  public Jugador getJugador() {
    return this._jugador;
  }
  
  public void setJugador(final Jugador jugador) {
    this._jugador = jugador;
  }
  
  public RegistroRechazo(final String motivo) {
    Date _date = new Date();
    this.setFechaDelDia(_date);
    this.setMotivoRechazo(motivo);
  }
  
  public RegistroRechazo(final Jugador jugadorRechazado, final String motivo) {
    Date _date = new Date();
    this.setFechaDelDia(_date);
    this.setMotivoRechazo(motivo);
    this.setJugador(jugadorRechazado);
  }
}
