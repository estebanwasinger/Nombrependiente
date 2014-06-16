package test;

import futbol5.Jugador;
import futbol5.Partido;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class Entrega4Test {
  private Jugador jugador1;
  
  private Jugador jugador2;
  
  private Jugador jugador3;
  
  private Jugador jugador4;
  
  private Jugador jugador5;
  
  private Jugador jugador6;
  
  private Jugador jugador7;
  
  private Jugador jugador8;
  
  private Jugador jugador9;
  
  private Jugador jugador10;
  
  private Partido partido;
  
  private /* CriterioHandicap */Object handicap;
  
  @Before
  public void setUP() {
    throw new Error("Unresolved compilation problems:"
      + "\nCriterioHandicap cannot be resolved.");
  }
  
  @Test
  public void testPartidoOrdenaPorHandicap() {
    this.partido.ordenarJugadores(this.handicap);
    List<Jugador> _jugadoresOrdenados = this.partido.getJugadoresOrdenados();
    final Consumer<Jugador> _function = new Consumer<Jugador>() {
      public void accept(final Jugador jugador) {
        int _nivelDeJuego = jugador.getNivelDeJuego();
        InputOutput.<Integer>println(Integer.valueOf(_nivelDeJuego));
      }
    };
    _jugadoresOrdenados.forEach(_function);
  }
}
