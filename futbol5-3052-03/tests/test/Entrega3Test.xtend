package test

import futbol5.Jugador
import futbol5.Partido
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import excepciones.BusinessException
import futbol5.Sistema
import futbol5.Administrador

class Entrega3Test {
	Jugador jugador
	Jugador amigo
	Jugador jugadorCalificado
	Partido partido
	Administrador administrador
	Sistema sistema
	
	@Before
		def void setUP() {
			jugador = new Jugador
			amigo = new Jugador
			administrador = new Administrador
			sistema = new Sistema
			administrador.sistema = sistema
			jugador.sistema = sistema
			jugadorCalificado = new Jugador
			partido = new Partido("Villa Fiorito")
	}
	
	def armarPartido(int max) {
		var int a = 0
		while (a < max) {
			partido.inscribir(new Jugador)
			a = a + 1
		}
	}
	
	@Test
	def void testSeProponeUnJugadorEsAceptado(){
		jugador.proponerA(amigo)
		sistema.tomarUnaDecision(amigo, true, null)
		
		Assert.assertEquals(0, sistema.jugadoresRecomendados.size)
		Assert.assertEquals(1, sistema.jugadoresAceptados.size)
		Assert.assertEquals(0, sistema.jugadoresRechazados.size)
	}
	
	@Test
	def void testSeProponeUnJugadorYEsRechazado(){
		jugador.proponerA(amigo)
		sistema.tomarUnaDecision(amigo, false, "no me parace simpatico este chico")
		Assert.assertEquals(0, sistema.jugadoresRecomendados.size)
		Assert.assertEquals(1, sistema.jugadoresRechazados.size)
		Assert.assertEquals(0, sistema.jugadoresAceptados.size)
	}
	
	@Test(expected=typeof(BusinessException))
	def void testSeTrataDeAceptarUnJugadorNoRecomendado() {
		sistema.tomarUnaDecision(amigo, false, "no me parace simpatico este chico")
	}

	@Test(expected=typeof(BusinessException))
    def void testCalificacionAJugadorQueNoJugo(){
        partido.inscribir(jugador)
        armarPartido(9)
        jugadorCalificado.calificar(partido, 10, "excelente")
    }
    
//	@Test(expected=typeof(BusinessException))
//	    def void testCalificacionDeUnJugadorQueNoJugo(){
// 	       partido.inscribir(jugadorCalificado)
// 	       armarPartido(9)
//  	      jugadorCalificado.calificar( partido, 10, "excelente")
// 	   }  
  
	@Test
    def void testJugadorCalificaASuCompanero(){
        partido.inscribir(jugador)
        partido.inscribir(jugadorCalificado)
  	    armarPartido(8)  
        jugadorCalificado.calificar(partido,10,"excelente")
        Assert.assertEquals(1, jugadorCalificado.calificaciones.size)
        
    }
}	
	