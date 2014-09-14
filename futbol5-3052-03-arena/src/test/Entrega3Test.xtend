package test

import futbol5.domain.Jugador
import futbol5.domain.Partido
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import excepciones.BusinessException
import futbol5.domain.Sistema

class Entrega3Test {
	Jugador jugador
	Jugador amigo
	Jugador jugadorCalificado
	Partido partido
	Sistema sistema
	
	@Before
		def void setUP() {
			jugador = new Jugador
			amigo = new Jugador
			partido = new Partido("VIlla Fiorito")
			jugadorCalificado = new Jugador
			sistema= Sistema::getInstance()
	}
		
	@Test
	def void testSeProponeUnJugadorEsAceptado(){
		sistema.proponerA(amigo)
		sistema.tomarUnaDecision(amigo, true, null)		
		Assert.assertEquals(0, sistema.jugadoresRecomendados.size)
		Assert.assertEquals(1, sistema.jugadoresAceptados.size)
	}
	
	@Test
	def void testSeProponeUnJugadorYEsRechazado(){
		sistema.proponerA(amigo)
		sistema.tomarUnaDecision(amigo, false, "no me parace simpatico este chico")
		Assert.assertEquals(0, sistema.jugadoresRecomendados.size)
		Assert.assertEquals(1, sistema.jugadoresRechazados.size)
	}
		
	@Test(expected=typeof(BusinessException))
	def void testSeTrataDeAceptarUnJugadorNoRecomendado() {
		sistema.tomarUnaDecision(amigo, false, "no me parace simpatico este chico")
	}

	@Test(expected=typeof(BusinessException))
    def void testCalificacionAJugadorQueNoJugo(){
        partido.inscribir(jugador)
        jugadorCalificado.calificar(partido, 10, "excelente")
    }
      
	@Test
    def void testJugadorCalificaASuCompanero(){
        partido.inscribir(jugador)
        partido.inscribir(jugadorCalificado)
        jugadorCalificado.calificar(partido,10,"excelente")
        Assert.assertEquals(1, jugadorCalificado.calificaciones.size)
     }
}	
	