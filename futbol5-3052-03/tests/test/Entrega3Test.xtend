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
	String motivo
	
	@Before
		def void setUP() {
			jugador = new Jugador
			administrador = new Administrador
			sistema = new Sistema
			jugadorcalificado = new Jugador
			partido = new Partido("Villa Fiorito")
			administrador.motivo = "Se rechaza porque es mujer"		
			administrador.loAcepta = true
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
		jugador.jugadorProponeA(jugador)
		administrador.tomarUnaDecision(jugador)
		
		Assert.assertEquals(0, sistema.jugadoresRecomendados.size)
		Assert.assertEquals(1, sistema.jugadoresAceptados.size)
		Assert.assertEquals(0, sistema.jugadoresRechazados.size)
		
	}
	/*ya no va.. 
	@Test(expected=typeof(BusinessException))
	def void testSeProponeUnJugadorEsAceptadoYNoSePuedeInscribir(){
		armarPartido(10)
		jugador.jugadorProponeA(jugador)
		administrador.tomarUnaDecision(jugador) //el equipo esta lleno y por eso no se lo inscribe*/
	
	
	@Test
	def void testSeProponeUnJugadorYEsRechazado(){
		administrador.loAcepta = false
		jugador.jugadorProponeA(jugador)
		administrador.tomarUnaDecision(jugador)
		Assert.assertEquals(0, sistema.jugadoresRecomendados.size)
		Assert.assertEquals(1, sistema.jugadoresRechazados.size)
		Assert.assertEquals(0, sistema.jugadoresAceptados.size)
		
	}
	
	/*sino esta inscripto no podria calificar, creo q hay que sacar el inscribir */
	@Test(expected=typeof(BusinessException))
    def void testCalificacionAJugadorQueNoJugo(){
        partido.inscribir(jugadorcalificado)
        armarPartido(9)
        jugador.calificar(jugadorcalificado, partido, 10, "excelente")
        
        }
  
	@Test
    def void testJugadorCalificaASuCompanero(){
        partido.inscribir(jugadorcalificado)
        armarPartido(9)
        jugador.calificar(jugadorcalificado,partido,10,"excelente")
        Assert.assertEquals(1, jugadorcalificado.calificaciones.size)
        
    }
}	
	