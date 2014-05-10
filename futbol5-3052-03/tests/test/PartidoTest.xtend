package test

import futbol5.Jugador
import futbol5.Partido
import condiciones.CondicionJugadoresPorEdad
import condiciones.CondicionPartidoEnLocalidad
import inscripciones.Estandar
import inscripciones.Solidario
import inscripciones.Condicional
import excepciones.BusinessException
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PartidoTest {
	Jugador jugador 
	Jugador jugador1
	Jugador jugadorSolidario
	Jugador jugadorSolidario2
	Jugador jugadorCondicional 
	Jugador jugadorCondicional2 
	Jugador jugadorCondicional3 
	Jugador jugadorCondicional4
	Partido partido
	Partido partido2 
	Partido partido3	
	CondicionJugadoresPorEdad condicionEdad
	CondicionPartidoEnLocalidad condicionLocalidadCABA
	CondicionPartidoEnLocalidad condicionLocalidadGBA

	@Before
	def void setUP() {
		jugador = new Jugador
		jugador.edad = 18
		jugador1 =new Jugador
		jugador1.edad = 18
		jugadorSolidario = new Jugador
		jugadorSolidario.edad = 19
		jugadorSolidario2 = new Jugador
		jugadorSolidario2.edad = 16
		jugadorCondicional = new Jugador
		jugadorCondicional2 = new Jugador
		jugadorCondicional3 = new Jugador
		jugadorCondicional4 = new Jugador
		partido = new Partido("CABA")
		partido2 = new Partido("CABA")
		partido3 = new Partido("GBA")
		
		condicionLocalidadCABA = new CondicionPartidoEnLocalidad("CABA")
		condicionLocalidadGBA = new CondicionPartidoEnLocalidad("GBA")
		condicionEdad = new CondicionJugadoresPorEdad(3,20)
		
		jugador.setTipoInscripcion(new Estandar)
		jugadorSolidario.setTipoInscripcion(new Solidario)
		jugadorSolidario2.setTipoInscripcion(new Solidario)
		jugadorCondicional.setTipoInscripcion(new Condicional(partido, condicionEdad))
		jugadorCondicional2.setTipoInscripcion(new Condicional(partido2, condicionLocalidadCABA))
		jugadorCondicional3.setTipoInscripcion(new Condicional(partido3, condicionLocalidadCABA))		
		jugadorCondicional4.setTipoInscripcion(new Condicional(partido2, condicionLocalidadCABA))
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
		partido.inscribir(jugadorCondicional4)
		partido.inscribir(jugadorCondicional2)
		partido.inscribir(jugador)
		Assert.assertTrue(partido.estaInscripto(jugador))
		Assert.assertFalse(partido.estaInscripto(jugadorCondicional4))
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
		partido.inscribir(jugadorCondicional2)
		partido.inscribir(jugadorSolidario)		
		Assert.assertTrue(partido.estaInscripto(jugadorSolidario))
		Assert.assertFalse(partido.estaInscripto(jugadorCondicional2))
	}

	@Test
	def void testCondicionalSePuedeInscribirAPartidoSegunEdad(){
		partido.inscribir(jugador) // un jugador menor a 20
		partido.inscribir(jugadorCondicional)
		Assert.assertTrue(partido.estaInscripto(jugadorCondicional))
	}
	
	@Test(expected=typeof(BusinessException))
	def void testCondicionalNoSePuedeInscribirAPartidoSegunEdad(){
		partido.inscribir(jugador) 
		partido.inscribir(jugador1)
		partido.inscribir(jugadorSolidario) 
		partido.inscribir(jugadorSolidario2) // tres jugadores menor a 20, ya no se puede inscribir
		partido.inscribir(jugadorCondicional)
	}
	
	@Test
	def void testCondicionalSePuedeInscribirAPartidoSegunLocalidad(){ //partido en CABA, condicional CABA
		partido2.inscribir(jugadorCondicional2)
		Assert.assertTrue(partido2.estaInscripto(jugadorCondicional2))
	}
	
	@Test (expected=typeof(BusinessException))
	def void testCondicionalNoSePuedeInscribirAPartidoSegunLocalidad() { //partido en GBA, condicional CABA
		partido3.inscribir(jugadorCondicional2)
	}	
	
	@Test(expected=typeof(BusinessException))
	def void testBajaJugadorQueNoEstaInscripto(){
		partido.bajaSinReemplazo(jugador)		
	}
	
	@Test (expected=typeof(BusinessException))
	def void testBajaJugadorConReemplazoYaInscripto(){
		partido.inscribir(jugador)
		partido.inscribir(jugador1)
		partido.bajaConReemplazo(jugador1, jugador)
	}
	
	@Test
	def void testBajaJugadorConReemplazo(){
		partido.inscribir(jugador)
		partido.bajaConReemplazo(jugador, jugador1)
		Assert.assertFalse(partido.estaInscripto(jugador))
		Assert.assertTrue(partido.estaInscripto(jugador1))
		Assert.assertEquals(1, partido.cantJugadores)
	}
	
		@Test
	def void testBajaJugadorSinReemplazo(){
		partido.inscribir(jugador)
		partido.bajaSinReemplazo(jugador)	
		Assert.assertFalse(partido.estaInscripto(jugador))
		Assert.assertEquals(1, jugador.infracciones.size)
	}
	
}