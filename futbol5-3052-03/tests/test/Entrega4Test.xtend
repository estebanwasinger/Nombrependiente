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

	Jugador jugadorEstrella
	
	Jugador jugadorCalificado
	
	Partido partido
	Partido partido2
	Partido partido3
	CriterioHandicap handicap
	AlgoritmoImparPar algoritmoImparPar
	AlgoritmoLoco algoritmoLoco
	CriterioCalifiUltimoPartido criterioCalificacionUltimoPartido
	CriterioNCalificaciones criterioNCalificaciones
	
	Jugador jugadorQueso
	

	@Before def void setUP() {
		jugador1 = new Jugador;

		
		
		partido = new Partido("CABA");
		handicap = new CriterioHandicap;
		partido2 = new Partido("CABA");
		partido3= new Partido("Burzaco")
		algoritmoImparPar = new AlgoritmoImparPar;
		algoritmoLoco = new AlgoritmoLoco;
		criterioCalificacionUltimoPartido = new CriterioCalifiUltimoPartido
		criterioNCalificaciones = new CriterioNCalificaciones(3)
		}
	
	def armarPartido(int max, Partido partido) {
		var int a = 0
		while (a < max) {
			jugadorCalificado = new Jugador
			jugadorCalificado.nivelDeJuego = 7
			partido.inscribir(jugadorCalificado)
			jugadorCalificado.calificar(partido,8,"muy bueno")
		//	println(jugadorCalificado.calificaciones.size)
			a = a + 1
		}
	}

	@Test 
	def void testPartidoOrdenaPorHandicap() {
		armarPartido(10, partido)
		partido.ordenarJugadores(handicap);
		partido.jugadoresOrdenados.forEach[jugador|println(jugador.nivelDeJuego)];
	}
	
	@Test(expected=typeof(BusinessException))
	def void testPartidoOrdenaPorHandicapExcepcion() {
		jugadorCalificado= new Jugador
		armarPartido(9,partido)
		jugadorCalificado.nivelDeJuego = 0
		partido.inscribir(jugadorCalificado)
		partido.ordenarJugadores(handicap)
		
	}
	
	@Test
	def void testPartidoMixDeCriterios() {
		armarPartido(9,partido2)
		jugadorEstrella = new Jugador
		partido2.inscribir(jugadorEstrella)
		jugadorEstrella.calificar(partido2,10,"excelente")
		jugadorEstrella.nivelDeJuego=10
		armarPartido(9,partido)
		var List<CriteriosCommand> criterios = new ArrayList();
		criterios.add(handicap);
		criterios.add(criterioCalificacionUltimoPartido);
		partido.ordenarJugadores(criterios, 2);
		partido.jugadoresOrdenados.forEach[jugador|println(jugador.nivelDeJuego)];
	}
	
	@Test(expected=typeof(BusinessException))
    def void testOrdenarJugadoresMenoresADiez(){
  	armarPartido(9, partido2)
  	partido2.ordenarJugadores(handicap)
  	
    }
     @Test
    def void testDividirGrupo(){
    	armarPartido(10, partido2)
    	partido2.ordenarJugadores(criterioCalificacionUltimoPartido)
  		partido2.dividirEquipos(algoritmoImparPar)
  	}
  @Test
    def void testDividirGrupoCasoLoco(){
    	armarPartido(10, partido3)
    	partido3.ordenarJugadores(criterioCalificacionUltimoPartido)
  		partido3.dividirEquipos(algoritmoLoco)
  		Assert.assertEquals(5, partido3.equipoA.size)
  		Assert.assertEquals(5, partido3.equipoB.size)
  	}
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

	@Test
	def void testOrdenarJugadoresPorUltimoPromedio(){
	armarPartido(8, partido2)
	jugadorEstrella = new Jugador()
	partido2.inscribir(jugadorEstrella)
	jugadorEstrella.calificar(partido2,10,"excelente!")
	
	jugadorQueso = new Jugador
	partido2.inscribir(jugadorQueso)
	jugadorQueso.calificar(partido2,0,"malisimo")
	partido2.ordenarJugadores(criterioCalificacionUltimoPartido)
	Assert.assertEquals(jugadorEstrella,partido2.jugadoresOrdenados.last)
	Assert.assertEquals(jugadorQueso,partido2.jugadoresOrdenados.head)
	}  
	
	@Test
	def void testOrdenarJugadoresPorPromedioNPartidos(){
		armarPartido(9,partido3)
	
		jugadorEstrella = new Jugador

		partido3.inscribir(jugadorEstrella)
		
		jugadorEstrella.calificar(partido3,10,"excelente")
		partido3.ordenarJugadores(criterioNCalificaciones)	
		Assert.assertEquals(jugadorEstrella,partido3.jugadoresOrdenados.last)
	}
	
	@Test
	def void testArmarEquiposTentativos(){
		jugadorEstrella = new Jugador
		armarPartido(9,partido)
		partido.inscribir(jugadorEstrella)
		jugadorEstrella.calificar(partido,10,"excelente")
		partido.armarEquiposTentativos(criterioCalificacionUltimoPartido, algoritmoImparPar)
		Assert.assertEquals(jugadorEstrella,partido.jugadoresOrdenados.last)
	}
	
	@Test(expected=typeof(BusinessException))
	def void testConfirmarEquipo(){
		armarPartido(10, partido)
		partido.armarEquiposTentativos(criterioCalificacionUltimoPartido, algoritmoImparPar)
		partido.confirmarEquipos
		partido.confirmarEquipos
	}
       } 

