package test

import futbol5.Jugador
import futbol5.Partido
import inscripciones.Estandar
import org.junit.Before
import org.junit.Test
import org.junit.Assert
import static org.mockito.Matchers.*
import static org.mockito.Mockito.*


class NotificacionesTest {
		Jugador jugador 
		Partido partido	
		
	@Before
	def void setUP() {
			jugador = new Jugador
			jugador.setTipoInscripcion(new Estandar)
			partido = new Partido("Berazategui")
		}
	
	def agregarAmigos(int max) {
		var int a = 0
		while (a < max) {
			jugador.amigos.add(new Jugador)
			a = a + 1
		}
	}
	
	@Test
	def void agregar4Amigos() {

		agregarAmigos(4)
		Assert.assertEquals(4, jugador.amigos.size)
	}
}