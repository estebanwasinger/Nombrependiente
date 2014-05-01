package test

import futbol5.BusinessException
import futbol5.Condicional
import futbol5.Estandar
import futbol5.Jugador
import futbol5.Partido
import futbol5.PartidoConfirmadoYCompletoException
import futbol5.Solidario
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PartidoTest {
	Jugador jugador
	Jugador jugadorSolidario
	Jugador jugadorCondicional
	Jugador jugadorCondicional2
	Jugador jugadorSolidario2
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
		jugador.setTipoInscripcion(estandar)
		jugadorSolidario.setTipoInscripcion(solidario)
		jugadorSolidario2.setTipoInscripcion(solidario)
		jugadorCondicional.setTipoInscripcion(condicional)
		jugadorCondicional2.setTipoInscripcion(condicional)
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

	def armarPartido(int max) {
		var int a = 0
		while (a < max) {
			partido.inscribir(new Jugador)
			a = a + 1
		}
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
		armarPartido(9)
		jugadorCondicional2.inscribirse(partido)
		jugador.inscribirse(partido)
		Assert.assertEquals(partido.posicionEnLista(jugador), 9)
	}

	@Test(expected=PartidoConfirmadoYCompletoException)
	def void testNoInscripcionCuandoElPartidoEstaCompleto() {
		this.armarPartido(10)
		jugador.inscribirse(partido)
	}

	// TODO: Arreglar, agregan al mismo jugador
	@Test
	def void testElCondicionalNoDesplazaJugadores() {
		var int a = 0
		while (a < 5) {
			partido.agregarJugador(jugador)
			a = a + 1
		}
		while (a < 10) {
			partido.agregarJugador(jugadorSolidario)
			a = a + 1
		}
		jugadorSolidario2.inscribirse(partido)
		jugadorCondicional.inscribirse(partido)
		Assert.assertNotEquals(partido.posicionEnLista(jugadorCondicional), 10)
	}

	@Test
	def void testSolidarioSacaAJugadorCondicional() {
		armarPartido(9)
		jugadorCondicional2.inscribirse(partido)
		jugadorSolidario.inscribirse(partido)
		Assert.assertEquals(partido.posicionEnLista(jugadorSolidario), 9)
	}

}
