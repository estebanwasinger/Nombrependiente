package ar.edu.futbol5;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.Partido;
import ar.edu.futbol5.excepciones.BusinessException;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestGenerarEquipos {
  private Partido partidoPocosJugadores;
  
  private Partido partidoOk;
  
  private Partido partido1;
  
  private Jugador sytek;
  
  private Jugador chicho;
  
  private Jugador pato;
  
  private Jugador lechu;
  
  private Jugador rodri;
  
  private Jugador mike;
  
  private Jugador dodi;
  
  private Jugador roly;
  
  private Jugador eric;
  
  private Jugador leo;
  
  private Jugador ferme;
  
  @Before
  public void init() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (double,double)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (double,double,double)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (double,double)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (double,double)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (double,double)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (double,double,double,double)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (double,double)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (double,double,double)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (double,double,double,double)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (double,double,double)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (double,double,double)"
      + "\nType mismatch: cannot convert from double to Object[]"
      + "\nType mismatch: cannot convert from double to Object[]"
      + "\nType mismatch: cannot convert from double to Object[]"
      + "\nType mismatch: cannot convert from double to Object[]"
      + "\nType mismatch: cannot convert from double to Object[]"
      + "\nType mismatch: cannot convert from double to Object[]"
      + "\nType mismatch: cannot convert from double to Object[]"
      + "\nType mismatch: cannot convert from double to Object[]"
      + "\nType mismatch: cannot convert from double to Object[]"
      + "\nType mismatch: cannot convert from double to Object[]"
      + "\nType mismatch: cannot convert from double to Object[]");
  }
  
  @Test(expected = BusinessException.class)
  public void pocosInscriptosNoGeneranEquipos() {
    this.partidoPocosJugadores.generarEquipos();
  }
  
  @Test(expected = BusinessException.class)
  public void partidoSinIniciarNoPuedeGenerarEquipos() {
    IntegerRange _upTo = new IntegerRange(1, 4);
    final Consumer<Object> _function = new Consumer<Object>() {
      public void accept(final Object it) {
        Jugador _jugador = new Jugador();
        TestGenerarEquipos.this.inscribir(TestGenerarEquipos.this.partidoPocosJugadores, _jugador);
      }
    };
    _upTo.forEach(_function);
    this.partidoPocosJugadores.generarEquipos();
  }
  
  @Test
  public void inscripcionJugadorNuevoDesplazaAPrimerSolidario() {
    this.inscribir(this.partido1, this.roly);
    List<Jugador> _inscriptos = this.partido1.getInscriptos();
    boolean _contains = _inscriptos.contains(this.roly);
    Assert.assertTrue(_contains);
    List<Jugador> _inscriptos_1 = this.partido1.getInscriptos();
    boolean _contains_1 = _inscriptos_1.contains(this.eric);
    Assert.assertFalse(_contains_1);
    List<Jugador> _inscriptos_2 = this.partido1.getInscriptos();
    boolean _contains_2 = _inscriptos_2.contains(this.ferme);
    Assert.assertTrue(_contains_2);
  }
  
  @Test
  public void generarEquiposPorHandicap() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method calificacion is undefined for the type TestGenerarEquipos"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (Jugador,Jugador,Jugador,Jugador,Jugador,Jugador,Jugador,Jugador,Jugador,Jugador)"
      + "\nType mismatch: cannot convert from Jugador to Object[]");
  }
  
  @Test
  public void generarEquiposPorCalificacionUltimos2Partidos() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method puntajes is undefined for the type TestGenerarEquipos"
      + "\nThe method puntajes is undefined for the type TestGenerarEquipos"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (Jugador,Jugador,Jugador,Jugador,Jugador,Jugador,Jugador,Jugador,Jugador,Jugador)"
      + "\nType mismatch: cannot convert from Jugador to Object[]"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nclone cannot be resolved"
      + "\nreverse cannot be resolved"
      + "\ntake cannot be resolved"
      + "\ntoList cannot be resolved"
      + "\nfold cannot be resolved"
      + "\n/ cannot be resolved"
      + "\nsize cannot be resolved");
  }
  
  @Test
  public void generarEquiposPorMixDeCriterios() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (Jugador,Jugador,Jugador,Jugador,Jugador,Jugador,Jugador,Jugador,Jugador,Jugador)"
      + "\nType mismatch: cannot convert from Jugador to Object[]");
  }
  
  @Test
  public void distribuirEquiposParEImpar() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (Jugador,Jugador,Jugador,Jugador,Jugador)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (Jugador,Jugador,Jugador,Jugador,Jugador)"
      + "\nType mismatch: cannot convert from Jugador to Object[]"
      + "\nType mismatch: cannot convert from Jugador to Object[]");
  }
  
  @Test
  public void distribuirEquipos14589() {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (Jugador,Jugador,Jugador,Jugador,Jugador)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (Jugador,Jugador,Jugador,Jugador,Jugador)"
      + "\nType mismatch: cannot convert from Jugador to Object[]"
      + "\nType mismatch: cannot convert from Jugador to Object[]");
  }
  
  @Test(expected = BusinessException.class)
  public void generarEquiposCuandoSeCierra() {
    this.partido1.setDistribucionEquipos(16);
    this.partido1.cerrar();
    this.partido1.generarEquipos();
    this.partido1.generarEquipos();
  }
  
  /**
   * METODOS AUXILIARES DE LOS TESTS
   */
  public void inscribir(final Partido partido, final Jugador jugador) {
    partido.inscribir(jugador);
  }
}
