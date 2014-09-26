package futbol5.auxUtils;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class ModeloBusquedaHyP extends Entity {
  private int _handicapDesde;
  
  public int getHandicapDesde() {
    return this._handicapDesde;
  }
  
  public void setHandicapDesde(final int handicapDesde) {
    this._handicapDesde = handicapDesde;
  }
  
  private int _handicapHasta;
  
  public int getHandicapHasta() {
    return this._handicapHasta;
  }
  
  public void setHandicapHasta(final int handicapHasta) {
    this._handicapHasta = handicapHasta;
  }
  
  private int _promedioDesde;
  
  public int getPromedioDesde() {
    return this._promedioDesde;
  }
  
  public void setPromedioDesde(final int promedioDesde) {
    this._promedioDesde = promedioDesde;
  }
  
  private int _promedioHasta;
  
  public int getPromedioHasta() {
    return this._promedioHasta;
  }
  
  public void setPromedioHasta(final int promedioHasta) {
    this._promedioHasta = promedioHasta;
  }
  
  private String _infracciones;
  
  public String getInfracciones() {
    return this._infracciones;
  }
  
  public void setInfracciones(final String infracciones) {
    this._infracciones = infracciones;
  }
  
  public ModeloBusquedaHyP() {
    this.setHandicapDesde(1);
    this.setHandicapHasta(10);
    this.setPromedioDesde(0);
    this.setPromedioHasta(10);
    this.setInfracciones("Todos");
  }
}
