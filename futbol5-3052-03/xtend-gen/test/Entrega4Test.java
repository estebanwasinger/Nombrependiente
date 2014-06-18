package test;

import commands.AlgoritmoImparPar;
import commands.AlgoritmoLoco;
import commands.CriterioCalifiUltimoPartido;
import commands.CriterioHandicap;
import commands.CriterioNCalificaciones;
import commands.CriteriosCommand;
import excepciones.BusinessException;
import futbol5.Jugador;
import futbol5.Partido;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class Entrega4Test {
  private Jugador jugador1;
  
  private Jugador jugadorEstrella;
  
  private Jugador jugadorCalificado;
  
  private Partido partido;
  
  private Partido partido2;
  
  private Partido partido3;
  
  private CriterioHandicap handicap;
  
  private AlgoritmoImparPar algoritmoImparPar;
  
  private AlgoritmoLoco algoritmoLoco;
  
  private CriterioCalifiUltimoPartido criterioCalificacionUltimoPartido;
  
  private CriterioNCalificaciones criterioNCalificaciones;
  
  private Jugador jugadorQueso;
  
  @Before
  public void setUP() {
    Jugador _jugador = new Jugador();
    this.jugador1 = _jugador;
    Partido _partido = new Partido("CABA");
    this.partido = _partido;
    CriterioHandicap _criterioHandicap = new CriterioHandicap();
    this.handicap = _criterioHandicap;
    Partido _partido_1 = new Partido("CABA");
    this.partido2 = _partido_1;
    Partido _partido_2 = new Partido("Burzaco");
    this.partido3 = _partido_2;
    AlgoritmoImparPar _algoritmoImparPar = new AlgoritmoImparPar();
    this.algoritmoImparPar = _algoritmoImparPar;
    AlgoritmoLoco _algoritmoLoco = new AlgoritmoLoco();
    this.algoritmoLoco = _algoritmoLoco;
    CriterioCalifiUltimoPartido _criterioCalifiUltimoPartido = new CriterioCalifiUltimoPartido();
    this.criterioCalificacionUltimoPartido = _criterioCalifiUltimoPartido;
    CriterioNCalificaciones _criterioNCalificaciones = new CriterioNCalificaciones(3);
    this.criterioNCalificaciones = _criterioNCalificaciones;
  }
  
  public void armarPartido(final int max, final Partido partido) {
    int a = 0;
    boolean _while = (a < max);
    while (_while) {
      {
        Jugador _jugador = new Jugador();
        this.jugadorCalificado = _jugador;
        this.jugadorCalificado.setNivelDeJuego(7);
        partido.inscribir(this.jugadorCalificado);
        this.jugadorCalificado.calificar(partido, 8, "muy bueno");
        a = (a + 1);
      }
      _while = (a < max);
    }
  }
  
  public void armarPartido2(final int max, final Partido partido) {
    int a = 0;
    boolean _while = (a < max);
    while (_while) {
      {
        Jugador _jugador = new Jugador();
        partido.inscribir(_jugador);
        a = (a + 1);
      }
      _while = (a < max);
    }
  }
  
  @Test
  public void testPartidoOrdenaPorHandicap() {
    this.armarPartido(9, this.partido);
    this.partido.inscribir(this.jugador1);
    this.jugador1.setNivelDeJuego(1);
    this.partido.ordenarJugadores(this.handicap);
    List<Jugador> _jugadoresOrdenados = this.partido.getJugadoresOrdenados();
    Jugador _head = IterableExtensions.<Jugador>head(_jugadoresOrdenados);
    Assert.assertEquals(this.jugador1, _head);
  }
  
  @Test(expected = BusinessException.class)
  public void testPartidoOrdenaPorHandicapExcepcion() {
    Jugador _jugador = new Jugador();
    this.jugadorCalificado = _jugador;
    this.jugadorCalificado.setNivelDeJuego(0);
    this.partido.inscribir(this.jugadorCalificado);
    this.partido.ordenarJugadores(this.handicap);
  }
  
  @Test
  public void testPartidoMixDeCriterios() {
    this.armarPartido(9, this.partido2);
    Jugador _jugador = new Jugador();
    this.jugadorEstrella = _jugador;
    this.partido2.inscribir(this.jugadorEstrella);
    this.jugadorEstrella.calificar(this.partido2, 10, "excelente");
    this.jugadorEstrella.setNivelDeJuego(10);
    this.armarPartido(9, this.partido);
    List<CriteriosCommand> criterios = new ArrayList<CriteriosCommand>();
    criterios.add(this.handicap);
    criterios.add(this.criterioCalificacionUltimoPartido);
    this.partido.ordenarJugadores(criterios, 2);
    List<Jugador> _jugadoresOrdenados = this.partido.getJugadoresOrdenados();
    final Consumer<Jugador> _function = new Consumer<Jugador>() {
      public void accept(final Jugador jugador) {
        float _nivelDeJuego = jugador.getNivelDeJuego();
        InputOutput.<Float>println(Float.valueOf(_nivelDeJuego));
      }
    };
    _jugadoresOrdenados.forEach(_function);
  }
  
  @Test(expected = BusinessException.class)
  public void testOrdenarJugadoresMenoresADiez() {
    this.armarPartido(9, this.partido2);
    this.partido2.ordenarJugadores(this.handicap);
  }
  
  @Test
  public void testDividirGrupo() {
    this.partido.inscribir(this.jugador1);
    this.armarPartido(10, this.partido2);
    this.partido2.ordenarJugadores(this.criterioCalificacionUltimoPartido);
    this.partido2.dividirEquipos(this.algoritmoImparPar);
  }
  
  @Test
  public void testDividirGrupoCasoLoco() {
    this.armarPartido(10, this.partido3);
    this.partido3.ordenarJugadores(this.criterioCalificacionUltimoPartido);
    this.partido3.dividirEquipos(this.algoritmoLoco);
    List<Jugador> _equipoA = this.partido3.getEquipoA();
    int _size = _equipoA.size();
    Assert.assertEquals(5, _size);
    List<Jugador> _equipoB = this.partido3.getEquipoB();
    int _size_1 = _equipoB.size();
    Assert.assertEquals(5, _size_1);
  }
  
  @Test(expected = BusinessException.class)
  public void testDividirGrupoMenor10() {
    this.armarPartido(9, this.partido2);
    this.partido2.dividirEquipos(this.algoritmoImparPar);
  }
  
  @Test(expected = BusinessException.class)
  public void testDividirGrupoMenor10CasoLoco() {
    this.armarPartido(9, this.partido2);
    this.partido2.dividirEquipos(this.algoritmoLoco);
  }
  
  @Test
  public void testOrdenarJugadoresPorUltimoPromedio() {
    this.armarPartido(8, this.partido2);
    Jugador _jugador = new Jugador();
    this.jugadorEstrella = _jugador;
    this.partido2.inscribir(this.jugadorEstrella);
    this.jugadorEstrella.calificar(this.partido2, 10, "excelente!");
    Jugador _jugador_1 = new Jugador();
    this.jugadorQueso = _jugador_1;
    this.partido2.inscribir(this.jugadorQueso);
    this.jugadorQueso.calificar(this.partido2, 0, "malisimo");
    this.partido2.ordenarJugadores(this.criterioCalificacionUltimoPartido);
    List<Jugador> _jugadoresOrdenados = this.partido2.getJugadoresOrdenados();
    Jugador _last = IterableExtensions.<Jugador>last(_jugadoresOrdenados);
    Assert.assertEquals(this.jugadorEstrella, _last);
    List<Jugador> _jugadoresOrdenados_1 = this.partido2.getJugadoresOrdenados();
    Jugador _head = IterableExtensions.<Jugador>head(_jugadoresOrdenados_1);
    Assert.assertEquals(this.jugadorQueso, _head);
  }
  
  @Test
  public void testOrdenarJugadoresPorPromedioNPartidos() {
    this.armarPartido(9, this.partido3);
    Jugador _jugador = new Jugador();
    this.jugadorEstrella = _jugador;
    this.partido3.inscribir(this.jugadorEstrella);
    this.jugadorEstrella.calificar(this.partido3, 10, "excelente");
    this.partido3.ordenarJugadores(this.criterioNCalificaciones);
    List<Jugador> _jugadoresOrdenados = this.partido3.getJugadoresOrdenados();
    Jugador _last = IterableExtensions.<Jugador>last(_jugadoresOrdenados);
    Assert.assertEquals(this.jugadorEstrella, _last);
  }
  
  @Test(expected = BusinessException.class)
  public void testOrdenarJugadoresPorPromedioNPartidosSinCalificacion() {
    this.armarPartido2(10, this.partido3);
    this.partido3.ordenarJugadores(this.criterioNCalificaciones);
  }
  
  @Test(expected = BusinessException.class)
  public void testSeConfirmaEquipoYJugadorSeQuiereInsribir() {
    Boolean confirmacion = Boolean.valueOf(true);
    this.armarPartido(10, this.partido3);
    this.partido3.ordenarJugadores(this.criterioCalificacionUltimoPartido);
    this.partido3.dividirEquipos(this.algoritmoLoco);
    this.partido3.confirmarEquipos((confirmacion).booleanValue());
    this.partido3.inscribir(this.jugador1);
  }
  
  @Test(expected = BusinessException.class)
  public void testSeConfirmaEquipoYJugadorSeQuiereDarDeBaja() {
    Boolean confirmacion = Boolean.valueOf(true);
    this.armarPartido(10, this.partido3);
    this.partido3.ordenarJugadores(this.criterioCalificacionUltimoPartido);
    this.partido3.dividirEquipos(this.algoritmoLoco);
    this.partido3.confirmarEquipos((confirmacion).booleanValue());
    this.partido3.baja(this.jugador1, null);
  }
  
  @Test(expected = BusinessException.class)
  public void testSeConfirmaEquipoYSeQuiereOrdenarNuevamenteLaLista() {
    Boolean confirmacion = Boolean.valueOf(true);
    this.armarPartido(10, this.partido3);
    this.partido3.ordenarJugadores(this.criterioCalificacionUltimoPartido);
    this.partido3.dividirEquipos(this.algoritmoLoco);
    this.partido3.confirmarEquipos((confirmacion).booleanValue());
    this.partido3.ordenarJugadores(this.criterioCalificacionUltimoPartido);
  }
  
  @Test(expected = BusinessException.class)
  public void testSeConfirmaEquipoYSeQuiereDividirNuevamenteLaLista() {
    Boolean confirmacion = Boolean.valueOf(true);
    this.armarPartido(10, this.partido3);
    this.partido3.ordenarJugadores(this.criterioCalificacionUltimoPartido);
    this.partido3.dividirEquipos(this.algoritmoLoco);
    this.partido3.confirmarEquipos((confirmacion).booleanValue());
    this.partido3.dividirEquipos(this.algoritmoLoco);
  }
}
