package test

import futbol5.Jugador
import futbol5.Partido
import command.Aceptar
import command.Rechazar
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import excepciones.BusinessException

class Entrega3Test {
	Jugador jugador
	Partido partido
	Aceptar decisionAceptar
	Rechazar decisionRechazar
	String motivo
	
	@Before
		def void setUP() {
			jugador = new Jugador
			partido = new Partido("Villa Fiorito")
			decisionAceptar = new Aceptar
			decisionRechazar = new Rechazar
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
		partido.jugadorProponeA(jugador, decisionAceptar,motivo)
	
		Assert.assertEquals(1, partido.jugadoresAceptados.size)
		Assert.assertEquals(1,partido.jugadores.size)
		Assert.assertTrue(partido.estaInscripto(jugador))
	}
	
	@Test(expected=typeof(BusinessException))
	def void testSeProponeUnJugadorEsAceptadoYNoSePuedeInscribir(){
		armarPartido(10)
		partido.jugadorProponeA(jugador, decisionAceptar,motivo)
	}
	
	@Test
	def void testSeProponeUnJugadorYEsRechazado(){
		partido.jugadorProponeA(jugador, decisionRechazar, motivo)
		
		Assert.assertEquals(1, partido.jugadoresRechazados.size)
		Assert.assertEquals(0,partido.jugadores.size)
		Assert.assertFalse(partido.estaInscripto(jugador))
	}
	
	}