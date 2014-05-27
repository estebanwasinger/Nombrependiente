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
	Jugador jugadorcalificado
	Partido partido
	Administrador administrador
	Sistema sistema

	@Before
	def void setUP() {
		jugador = new Jugador
		administrador = new Administrador
		sistema = Sistema::getInstance()
		jugadorcalificado = new Jugador
		partido = new Partido("Villa Fiorito")
		administrador.motivo = "Se rechaza porque es mujer"
		administrador.aceptar = true
		limpiarListasDelSistema(sistema)
	}

	def armarPartido(int max) {
		var int a = 0
		while (a < max) {
			partido.inscribir(new Jugador)
			a = a + 1
		}
	}

	def limpiarListasDelSistema(Sistema sistema) {
		sistema.jugadoresRechazados.clear
		sistema.jugadoresAceptados.clear
	}

	@Test
	def void testSeProponeUnJugadorEsAceptadoYSePuedeInscribir() {
		sistema.jugadorProponeA(jugador)
		sistema.tomarDecision(true, jugador, null);
		Assert.assertEquals(0, sistema.jugadoresRecomendados.size)
		Assert.assertEquals(1, sistema.jugadoresAceptados.size)
		Assert.assertEquals(0, sistema.jugadoresRechazados.size)
	}

	// Este test ya no sirve mas
	//	@Test(expected=typeof(BusinessException))
	//	def void testSeProponeUnJugadorEsAceptadoYNoSePuedeInscribir(){
	@Test
	def void testSeProponeUnJugadorYEsRechazado() {
		sistema.jugadorProponeA(jugador)
		sistema.tomarDecision(false, jugador, "Es un jugador agresivo")
		Assert.assertEquals(0, sistema.jugadoresRecomendados.size)
		Assert.assertEquals(1, sistema.jugadoresRechazados.size)
		Assert.assertEquals(0, sistema.jugadoresAceptados.size)
		Assert.assertFalse(partido.estaInscripto(jugador))
	}

	@Test(expected=typeof(BusinessException))
	def void testCalificacionAJugadorQueNoJugo() {
		partido.inscribir(jugador)
		armarPartido(9)
		partido.calificar(jugador, jugadorcalificado, 10, "excelente")

	}

	@Test(expected=typeof(BusinessException))
	def void testDesconocidoCalificaJugador() {
		partido.inscribir(jugadorcalificado)
		armarPartido(9)
		partido.calificar(jugador, jugadorcalificado, 10, "normal")

	}

	@Test
	def void testJugadorCalificaASuCompanero() {
		partido.inscribir(jugador)
		partido.inscribir(jugadorcalificado)
		armarPartido(8)
		partido.calificar(jugador, jugadorcalificado, 10, "excelente")
		Assert.assertEquals(1, jugadorcalificado.calificaciones.size)

	}

}
