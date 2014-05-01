package test

import futbol5.BusinessException
import futbol5.Condicional
import futbol5.Estandar
import futbol5.Jugador
import futbol5.Partido
import futbol5.Solidario
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PartidoTest {
	Jugador jugador
	Jugador jugadorSolidario
	Jugador jugadorSolidario2
	Jugador jugadorCondicional
	Jugador jugadorCondicional2
	Partido partido
	Estandar estandar
	Condicional condicional
	Solidario solidario

	@Before
	def void setUP() {
		jugador = new Jugador
		jugadorSolidario = new Jugador
		jugadorSolidario2 = new Jugador
		jugadorCondicional = new Jugador
		jugadorCondicional2 = new Jugador
		partido = new Partido
		estandar = new Estandar
		solidario = new Solidario
		condicional = new Condicional
		jugadorSolidario.setTipoInscripcion(solidario)
		jugadorSolidario2.setTipoInscripcion(solidario)
		jugadorCondicional.setTipoInscripcion(condicional)
		jugadorCondicional2.setTipoInscripcion(condicional)
	}
	
		def armarPartido(int max) {
		var int a = 0
		while (a < max) {
			partido.inscribir(new Jugador)
			a = a + 1
		}
	}

	@Test
	def void agregar10Personas() {
		var int a = 0
		while (a < 10) {
			partido.agregarJugador(new Jugador)
			a = a + 1
		}
		Assert.assertEquals(10, partido.cantJugadores)
	}

	@Test(expected=typeof(BusinessException))
	def void inscribirALaMismaPersonaMasDeUnaVez() {
		partido.inscribir(jugador)
		partido.inscribir(jugador)
	}
	
	@Test
	def void testEstandarSacaSolidario() {
		armarPartido(8)
		partido.inscribir(jugadorSolidario)
		partido.inscribir(jugadorSolidario2)
		partido.inscribir(jugador)
		Assert.assertTrue(partido.estaInscripto(jugador))
		Assert.assertFalse(partido.estaInscripto(jugadorSolidario))
		Assert.assertTrue(partido.estaInscripto(jugadorSolidario2))
	}

	@Test
	def void testEstandarSacaCondicional() {
		armarPartido(8)
		partido.inscribir(jugadorCondicional)
		partido.inscribir(jugadorCondicional2)
		partido.inscribir(jugador)
		Assert.assertTrue(partido.estaInscripto(jugador))
		Assert.assertFalse(partido.estaInscripto(jugadorCondicional))
		Assert.assertTrue(partido.estaInscripto(jugadorCondicional2))
	}

	@Test(expected=typeof(BusinessException))
	def void testNoInscripcionCuandoElPartidoEstaCompleto() {
		this.armarPartido(10)
		partido.inscribir(jugador)
	}

	@Test(expected=typeof(BusinessException))
	def void testCondicionalNoDesplazaJugadoresYSeQuedaSinCupo() {
		armarPartido(8)
		partido.inscribir(jugadorCondicional)
		partido.inscribir(jugadorSolidario)		
		partido.inscribir(jugadorCondicional2)
		Assert.assertFalse(partido.estaInscripto(jugadorCondicional2))
	}

	@Test
	def void testSolidarioSacaAJugadorCondicional() {
		armarPartido(9)
		partido.inscribir(jugadorCondicional)
		partido.inscribir(jugadorSolidario)		
		Assert.assertTrue(partido.estaInscripto(jugadorSolidario))
		Assert.assertFalse(partido.estaInscripto(jugadorCondicional))
	}

}
