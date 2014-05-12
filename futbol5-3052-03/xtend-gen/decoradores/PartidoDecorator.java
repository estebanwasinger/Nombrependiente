package decoradores;

import futbol5.InterfazPartido;
import futbol5.Jugador;

@SuppressWarnings("all")
public class PartidoDecorator implements InterfazPartido {
  private InterfazPartido _decorado;
  
  public InterfazPartido getDecorado() {
    return this._decorado;
  }
  
  public void setDecorado(final InterfazPartido decorado) {
    this._decorado = decorado;
  }
  
  public PartidoDecorator(final InterfazPartido partido) {
    this.setDecorado(partido);
  }
  
  public int cantJugadores() {
    InterfazPartido _decorado = this.getDecorado();
    return _decorado.cantJugadores();
  }
  
  public void bajaSinReemplazo(final Jugador jugador) {
    InterfazPartido _decorado = this.getDecorado();
    _decorado.bajaSinReemplazo(jugador);
  }
  
  public void inscribir(final Jugador jugador) {
    InterfazPartido _decorado = this.getDecorado();
    _decorado.inscribir(jugador);
  }
}
