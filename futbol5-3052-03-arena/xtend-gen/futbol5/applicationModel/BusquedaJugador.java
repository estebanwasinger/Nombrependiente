package futbol5.applicationModel;

import futbol5.domain.Jugador;

@SuppressWarnings("all")
public class BusquedaJugador {
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
  
  public boolean cumple(final Jugador jugador) {
    boolean _and = false;
    boolean _or = false;
    boolean _ingresoHandicapDesde = this.ingresoHandicapDesde();
    boolean _not = (!_ingresoHandicapDesde);
    if (_not) {
      _or = true;
    } else {
      float _nivelDeJuego = jugador.getNivelDeJuego();
      int _handicapDesde = this.getHandicapDesde();
      boolean _greaterEqualsThan = (_nivelDeJuego >= _handicapDesde);
      _or = _greaterEqualsThan;
    }
    if (!_or) {
      _and = false;
    } else {
      boolean _or_1 = false;
      boolean _ingresoHandicapHasta = this.ingresoHandicapHasta();
      boolean _not_1 = (!_ingresoHandicapHasta);
      if (_not_1) {
        _or_1 = true;
      } else {
        float _nivelDeJuego_1 = jugador.getNivelDeJuego();
        int _handicapDesde_1 = this.getHandicapDesde();
        boolean _lessEqualsThan = (_nivelDeJuego_1 <= _handicapDesde_1);
        _or_1 = _lessEqualsThan;
      }
      _and = _or_1;
    }
    return _and;
  }
  
  public void clear() {
    this.setHandicapDesde(0);
    this.setHandicapHasta(10000);
  }
  
  public boolean ingresoHandicapDesde() {
    int _handicapDesde = this.getHandicapDesde();
    boolean _equals = Integer.valueOf(_handicapDesde).equals(Integer.valueOf(0));
    return (!_equals);
  }
  
  public boolean ingresoHandicapHasta() {
    int _handicapHasta = this.getHandicapHasta();
    boolean _equals = Integer.valueOf(_handicapHasta).equals(Integer.valueOf(10000));
    return (!_equals);
  }
}
