package test

import futbol5.Jugador
import futbol5.Partido
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import excepciones.BusinessException
import futbol5.Sistema
import commands.CriterioHandicap
import java.util.LinkedList
import java.util.List
import commands.AlgoritmoImparPar
import commands.AlgoritmoLoco
import commands.CriterioCalifiUltimoPartido
import commands.CriterioNCalificaciones
import commands.CriteriosCommand
import java.util.ArrayList

class Entrega4Test {
	
	Jugador jugador1
	Jugador jugador2
	Jugador jugador3
	Jugador jugador4
	Jugador jugador5
	Jugador jugador6
	Jugador jugador7
	Jugador jugador8
	Jugador jugador9
	Jugador jugador10
	
	Jugador jugadorCalificado
	
	Partido partido
	Partido partido2
	Partido partido3
	CriterioHandicap handicap
	AlgoritmoImparPar algoritmoImparPar
	AlgoritmoLoco algoritmoLoco
	CriterioCalifiUltimoPartido criterioCalificacionUltimoPartido
	CriterioNCalificaciones criterioNCalificaciones
	

	@Before def void setUP() {
		jugador1 = new Jugador;
		jugador2 = new Jugador;
		jugador3 = new Jugador;
		jugador4 = new Jugador;
		jugador5 = new Jugador;
		jugador6 = new Jugador;
		jugador7 = new Jugador;
		jugador8 = new Jugador;
		jugador9 = new Jugador;
		jugador10 = new Jugador;
		
		jugador1.nivelDeJuego = 5;
		jugador2.nivelDeJuego = 9;
		jugador3.nivelDeJuego = 10;
		jugador4.nivelDeJuego = 7;
		jugador5.nivelDeJuego = 8;
		jugador6.nivelDeJuego = 6;
		jugador7.nivelDeJuego = 7;
		jugador8.nivelDeJuego = 4;
		jugador9.nivelDeJuego = 8;
		jugador10.nivelDeJuego = 3;
		
		partido = new Partido("CABA");
		handicap = new CriterioHandicap;
		partido2 = new Partido("CABA");
		partido3= new Partido("Burzaco")
		algoritmoImparPar = new AlgoritmoImparPar;
		algoritmoLoco = new AlgoritmoLoco;
		criterioCalificacionUltimoPartido = new CriterioCalifiUltimoPartido
		criterioNCalificaciones = new CriterioNCalificaciones
		
		
		partido.inscribir(jugador1);
		partido.inscribir(jugador2);
		partido.inscribir(jugador3);
		partido.inscribir(jugador4);
		partido.inscribir(jugador5);
		partido.inscribir(jugador6);
		partido.inscribir(jugador7);
		partido.inscribir(jugador8);
		partido.inscribir(jugador9);
		partido.inscribir(jugador10);
	
	}
	
	def armarPartido(int max, Partido partido) {
		var int a = 0
		while (a < max) {
			jugadorCalificado = new Jugador
			partido.inscribir(jugadorCalificado)
			jugadorCalificado.calificar(partido,8,"muy bueno")
		//	println(jugadorCalificado.calificaciones.size)
			a = a + 1
		}
	}

	@Test 
	def void testPartidoOrdenaPorHandicap() {
		partido.ordenarJugadores(handicap);
		partido.jugadoresOrdenados.forEach[jugador|println(jugador.nivelDeJuego)];
	}
	
	@Test(expected=typeof(BusinessException))
	def void testPartidoOrdenaPorHandicapExcepcion() {
		jugador10.nivelDeJuego = 0;
		partido.ordenarJugadores(handicap);
		
	}
	
	@Test
	def void testPartidoMixDeCriterios() {
		var List<CriteriosCommand> criterios = new ArrayList();
		criterios.add(handicap);
		criterios.add(handicap);
		partido.ordenarJugadores(criterios, 3);
		partido.jugadoresOrdenados.forEach[jugador|println(jugador.nivelDeJuego)];
	}
	
	@Test(expected=typeof(BusinessException))
    def void testOrdenarJugadoresMenoresADiez(){
  	armarPartido(9, partido2)
  	partido2.ordenarJugadores(handicap)
  	
    }
    /* @Test
    def void testDividirGrupo(){
    	armarPartido(10, partido2)
  		partido2.dividirEquipos(algoritmoImparPar)
  	}*/
  	/* @Test
    def void testDividirGrupoCasoLoco(){
    	armarPartido(10, partido3)
  		partido3.dividirEquipos(algoritmoLoco)
  	}*/
 	@Test(expected=typeof(BusinessException))
    def void testDividirGrupoMenor10(){
    	armarPartido(9, partido2)
  		partido2.dividirEquipos(algoritmoImparPar)
  	} 
  	@Test(expected=typeof(BusinessException))
    def void testDividirGrupoMenor10CasoLoco(){
    	armarPartido(9, partido2)
  		partido2.dividirEquipos(algoritmoLoco)
  	}
  	@Test  //NO FUNCIONA TODAVIA
	def void testOrdenarJugadoresPorUltimoPromedio(){
	armarPartido(10, partido2)
	partido2.ordenarJugadores(criterioCalificacionUltimoPartido)
	}  
	
	@Test //NO FUNCIONA TODAVIA
	def void testOrdenarJugadoresPorPromedioNPartidos(){
		armarPartido(10, partido2)
		armarPartido(10, partido)
		armarPartido(10,partido3)
		partido2.ordenarJugadores(criterioNCalificaciones)
	
	}
        }  

