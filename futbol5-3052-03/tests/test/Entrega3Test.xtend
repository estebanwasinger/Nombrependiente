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
	Partido partido
	Administrador administrador
	Sistema sistema
	
	@Before
		def void setUP() {
			jugador = new Jugador
			administrador = new Administrador
			sistema = new Sistema
			partido = new Partido("Villa Fiorito")
			administrador.motivo = "Se rechaza porque es mujer"		
			administrador.aceptar = true
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
		administrador.tomarUnaDecision(jugador, partido)
		
		Assert.assertEquals(0, partido.jugadoresRecomendados.size)
		Assert.assertEquals(1, sistema.jugadoresAceptados.size)
		Assert.assertEquals(0, sistema.jugadoresRechazados.size)
		Assert.assertTrue(partido.estaInscripto(jugador))
	}
	
	@Test(expected=typeof(BusinessException))
	def void testSeProponeUnJugadorEsAceptadoYNoSePuedeInscribir(){
		armarPartido(10)
		partido.jugadorProponeA(jugador)
		administrador.tomarUnaDecision(jugador, partido) //el equipo esta lleno y por eso no se lo inscribe
	}
	
	@Test
	def void testSeProponeUnJugadorYEsRechazado(){
		administrador.aceptar = false
		partido.jugadorProponeA(jugador)
		administrador.tomarUnaDecision(jugador, partido)
		Assert.assertEquals(0, partido.jugadoresRecomendados.size)
		Assert.assertEquals(1, sistema.jugadoresRechazados.size)
		Assert.assertEquals(0, sistema.jugadoresAceptados.size)
		Assert.assertFalse(partido.estaInscripto(jugador))
	}
	
	}