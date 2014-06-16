package test;

import commands.CriterioHandicap;
import futbol5.Jugador;
import futbol5.Partido;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
  
  private CriterioHandicap handicap;
  
  @Before
  public void setUP() {
    Jugador _jugador = new Jugador();
    this.jugador1 = _jugador;
    Jugador _jugador_1 = new Jugador();
    this.jugador2 = _jugador_1;
    Jugador _jugador_2 = new Jugador();
    this.jugador3 = _jugador_2;
    Jugador _jugador_3 = new Jugador();
    this.jugador4 = _jugador_3;
    Jugador _jugador_4 = new Jugador();
    this.jugador5 = _jugador_4;
    Jugador _jugador_5 = new Jugador();
    this.jugador6 = _jugador_5;
    Jugador _jugador_6 = new Jugador();
    this.jugador7 = _jugador_6;
    Jugador _jugador_7 = new Jugador();
    this.jugador8 = _jugador_7;
    Jugador _jugador_8 = new Jugador();
    this.jugador9 = _jugador_8;
    Jugador _jugador_9 = new Jugador();
    this.jugador10 = _jugador_9;
    this.jugador1.setNivelDeJuego(5);
    this.jugador2.setNivelDeJuego(9);
    this.jugador3.setNivelDeJuego(10);
    this.jugador4.setNivelDeJuego(7);
    this.jugador5.setNivelDeJuego(8);
    this.jugador6.setNivelDeJuego(6);
    this.jugador7.setNivelDeJuego(7);
    this.jugador8.setNivelDeJuego(4);
    this.jugador9.setNivelDeJuego(8);
    this.jugador10.setNivelDeJuego(3);
    Partido _partido = new Partido("CABA");
    this.partido = _partido;
    CriterioHandicap _criterioHandicap = new CriterioHandicap();
    this.handicap = _criterioHandicap;
    this.partido.inscribir(this.jugador1);
    this.partido.inscribir(this.jugador2);
    this.partido.inscribir(this.jugador3);
    this.partido.inscribir(this.jugador4);
    this.partido.inscribir(this.jugador5);
    this.partido.inscribir(this.jugador6);
    this.partido.inscribir(this.jugador7);
    this.partido.inscribir(this.jugador8);
    this.partido.inscribir(this.jugador9);
    this.partido.inscribir(this.jugador10);
  }
  
  @Test
  public void testPartidoOrdenaPorHandicap() {
    this.partido.ordenarJugadores(this.handicap);
    List<Jugador> _jugadoresOrdenados = this.partido.getJugadoresOrdenados();
    final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
      public void apply(final Jugador jugador) {
        int _nivelDeJuego = jugador.getNivelDeJuego();
        InputOutput.<Integer>println(Integer.valueOf(_nivelDeJuego));
      }
    };
    IterableExtensions.<Jugador>forEach(_jugadoresOrdenados, _function);
  }
}
