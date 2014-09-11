package test

import futbol5.Jugador
import futbol5.Partido
import inscripciones.Estandar
import org.junit.Before
import org.junit.Test
import static org.mockito.Matchers.*
import static org.mockito.Mockito.*
import observers.EquipoCompletoObserver
import auxiliares.MessageSender
import observers.Notificacion
import observers.InscripcionObserver
import junit.framework.Assert
import observers.EquipoIncompletoObserver
import observers.BajaSinReemplazoObserver
import futbol5.Administrador

class Entrega2Test {
		Jugador jugador 
		Jugador amigo1
		Jugador amigo2
		Jugador amigo3
		Partido partido	
		Administrador administrador 
		
	@Before
	def void setUP() {
			jugador = new Jugador
			jugador.setTipoInscripcion(new Estandar)
			amigo1 = new Jugador
			amigo2 = new Jugador
			amigo3 = new Jugador
			jugador.agregarAmigo(amigo1)
			jugador.agregarAmigo(amigo2)
			jugador.agregarAmigo(amigo3)			
			partido = new Partido("Berazategui")
			administrador = new Administrador
	}
		
	def armarPartido(int max) {
		var int a = 0
		while (a < max) {
			partido.inscribir(new Jugador)
			a = a + 1
		}
	}
	
	@Test
	def testJugadorSeInscribeYSeNotificaASusAmigos(){
		var mockMessageSender = mock(typeof(MessageSender))
		partido.agregarObserverAlta(new InscripcionObserver(mockMessageSender))
		
		verify(mockMessageSender, times(0)).send(any(typeof(Notificacion)))
		partido.inscribir(jugador)
		verify(mockMessageSender, times(3)).send(any(typeof(Notificacion)))
		}
	
		@Test
	def testSeInscribeDecimoJugadorYSeNotificaAAdministrador(){
		var mockMessageSender = mock(typeof(MessageSender))
		partido.agregarObserverAlta(new EquipoCompletoObserver(mockMessageSender))
		
		verify(mockMessageSender, times(0)).send(any(typeof(Notificacion)))
		armarPartido(9)
		partido.inscribir(jugador)
		verify(mockMessageSender, times(1)).send(any(typeof(Notificacion)))
		}
	
	@Test
	def testSeInscribeUnJugadorQueEsElDecimoYNoSeNotificaAAdministrador(){
		var mockMessageSender = mock(typeof(MessageSender))
		partido.agregarObserverAlta(new EquipoCompletoObserver(mockMessageSender))
		
		partido.inscribir(jugador)
		verify(mockMessageSender, times(0)).send(any(typeof(Notificacion))) // no se debe enviar notificacion
		}

	@Test
	def testBajaSinReemplazoConInfraccion(){
		var mockMessageSenderInfraccion = mock(typeof(MessageSender))
		partido.agregarObserverBaja(new BajaSinReemplazoObserver(mockMessageSenderInfraccion))
		
		partido.inscribir(jugador)
		partido.baja(jugador, null)
		
		Assert.assertFalse(partido.estaInscripto(jugador))
		Assert.assertEquals(1, jugador.infracciones.size)
		}
	
	@Test
	def testBajaConReemplazoSinInfraccion(){
		var mockMessageSenderInfraccion = mock(typeof(MessageSender))
		partido.agregarObserverBaja(new BajaSinReemplazoObserver(mockMessageSenderInfraccion))
		
		partido.inscribir(jugador)
		partido.baja(jugador, new Jugador())
		
		Assert.assertFalse(partido.estaInscripto(jugador))
		Assert.assertEquals(0, jugador.infracciones.size)
		}

	@Test
	def void testPartidoCon10JugadoresYSeBaja1NotificaAdministrador(){
		var mockMessageSenderAlta = mock(typeof(MessageSender))
		var mockMessageSenderBaja = mock(typeof(MessageSender))
		
		partido.agregarObserverBaja(new EquipoIncompletoObserver(mockMessageSenderBaja))
		partido.agregarObserverAlta(new EquipoCompletoObserver(mockMessageSenderAlta))
		
		verify(mockMessageSenderAlta, times(0)).send(any(typeof(Notificacion))) //sin notificar
		verify(mockMessageSenderBaja, times(0)).send(any(typeof(Notificacion))) //sin notificar
		armarPartido(9)
		partido.inscribir(jugador)
		verify(mockMessageSenderAlta, times(1)).send(any(typeof(Notificacion))) //notificar partido completo
		verify(mockMessageSenderBaja, times(0)).send(any(typeof(Notificacion))) //sin notificar
		partido.baja(jugador, new Jugador())
		verify(mockMessageSenderBaja, times(0)).send(any(typeof(Notificacion))) //notificar partido incompleto
		}

	@Test 
	def void testPartidoConMenosDe10JugadoresYSeBaja1NoNotificaAdministrador(){
		var mockMessageSenderBaja = mock(typeof(MessageSender))	
		partido.agregarObserverBaja(new EquipoIncompletoObserver(mockMessageSenderBaja))
	
		verify(mockMessageSenderBaja, times(0)).send(any(typeof(Notificacion)))
		partido.inscribir(jugador)
		verify(mockMessageSenderBaja, times(0)).send(any(typeof(Notificacion)))
		}

}