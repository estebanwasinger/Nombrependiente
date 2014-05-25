package test

import futbol5.Jugador
import futbol5.Partido
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import excepciones.BusinessException
import futbol5.Sistema
import auxiliares.RegistroRechazo
import futbol5.Administrador

class Entrega3Test {
	Jugador jugador
	Partido partido
	Administrador administrador
	Sistema sistema
	String motivo
	
	@Before
		def void setUP() {
			jugador = new Jugador
			partido = new Partido("Villa Fiorito")
			motivo = "Se rechaza porque es mujer"		
		}
	
	def armarPartido(int max) {
		var int a = 0
		while (a < max) {
			partido.inscribir(new Jugador)
			a = a + 1
		}
	}
	
	@Test
	def void testSeProponeUnJugadorEsAceptadoYSePuedeInscribir(){
		partido.jugadorProponeA(jugador)
		administrador.tomarUnaDesicion(jugador)
		Assert.assertEquals(0, partido.jugadoresRecomendados.size)
		Assert.assertEquals(1, sistema.jugadoresAceptados.size)
		Assert.assertTrue(partido.estaInscripto(jugador))
	}
	
	@Test(expected=typeof(BusinessException))
	def void testSeProponeUnJugadorEsAceptadoYNoSePuedeInscribir(){
		armarPartido(10)
		partido.jugadorProponeA(jugador)
		administrador.tomarUnaDecision(jugador)
		Assert.assertEquals(0, partido.jugadoresRecomendados.size)
		Assert.assertEquals(1, sistema.jugadoresAceptados.size)
	}
	
	@Test
	def void testSeProponeUnJugadorYEsRechazado(){
		partido.jugadorProponeA(jugador)
		administrador.tomarUnaDecision(jugador)
		Assert.assertEquals(0, partido.jugadoresRecomendados.size)
		Assert.assertEquals(1, sistema.jugadoresRechazados.size)
	
		Assert.assertFalse(partido.estaInscripto(jugador))
	}
	
	}