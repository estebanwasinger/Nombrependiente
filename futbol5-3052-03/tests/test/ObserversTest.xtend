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

class ObserversTest {
		Jugador jugador 
		Jugador amigo1
		Jugador amigo2
		Jugador amigo3
		Partido partido	
		
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
	def testSeInscribeUnJugadorYNoSeNotificaAAdministrador(){
		var mockMessageSender = mock(typeof(MessageSender))
		partido.agregarObserverAlta(new EquipoCompletoObserver(mockMessageSender))
		
		partido.inscribir(jugador)
		verify(mockMessageSender, times(0)).send(any(typeof(Notificacion))) // no se debe enviar notificacion
	}

	@Test
	def void testPartidoCon10JugadoresYSeBaja1(){
		var mockMessageSenderAlta = mock(typeof(MessageSender))
		var mockMessageSenderBaja = mock(typeof(MessageSender))
		var mockMessageSenderInfraccion = mock(typeof(MessageSender)) //se crea pero no se necesita. arreglar!
		
		partido.agregarObserverBaja(new EquipoIncompletoObserver(mockMessageSenderBaja))
		partido.agregarObserverAlta(new EquipoIncompletoObserver(mockMessageSenderAlta))
		partido.agregarObserverBaja(new BajaSinReemplazoObserver(mockMessageSenderInfraccion))
		
		verify(mockMessageSenderAlta, times(0)).send(any(typeof(Notificacion))) //sin notificar
		verify(mockMessageSenderBaja, times(0)).send(any(typeof(Notificacion))) //sin notificar
		armarPartido(9)
		partido.inscribir(jugador)
		verify(mockMessageSenderAlta, times(1)).send(any(typeof(Notificacion))) //notificar partido completo
		verify(mockMessageSenderBaja, times(0)).send(any(typeof(Notificacion))) //sin notificar
		partido.bajaSinReemplazo(jugador)
		verify(mockMessageSenderBaja, times(1)).send(any(typeof(Notificacion))) //notificar partido incompleto
		Assert.assertFalse(partido.estaInscripto(jugador))
		Assert.assertEquals(1, jugador.infracciones.size)
		}
}