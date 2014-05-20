package condiciones;

import com.google.common.base.Objects;
import condiciones.Condicion;
import futbol5.Jugador;
import futbol5.Partido;

@SuppressWarnings("all")
public class CondicionPartidoEnLocalidad implements Condicion {
  private String _localidad;
  
  public String getLocalidad() {
    return this._localidad;
  }
  
  public void setLocalidad(final String localidad) {
    this._localidad = localidad;
  }
  
  public CondicionPartidoEnLocalidad(final String localidad) {
    this.setLocalidad(localidad);
  }
  
  public boolean seCumple(final Jugador jugador, final Partido partido) {
    String _localidad = partido.getLocalidad();
    String _localidad_1 = this.getLocalidad();
    return Objects.equal(_localidad, _localidad_1);
  }
}
