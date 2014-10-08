package strategyHandicap;

import com.google.common.base.Objects;
import futbol5.domain.Jugador;
import strategyHandicap.HandicapStrategy;

@SuppressWarnings("all")
public class HandicapDesde implements HandicapStrategy {
  public boolean calcular(final Jugador jugadorEnLista, final Integer handicapDesde) {
    boolean _xifexpression = false;
    boolean _notEquals = (!Objects.equal(handicapDesde, null));
    if (_notEquals) {
      float _nivelDeJuego = jugadorEnLista.getNivelDeJuego();
      int _round = Math.round(_nivelDeJuego);
      _xifexpression = (_round >= (handicapDesde).intValue());
    } else {
      _xifexpression = true;
    }
    return _xifexpression;
  }
  
  public String toString() {
    return "Handicap desde";
  }
}
