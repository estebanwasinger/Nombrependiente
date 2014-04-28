package test

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import futbol5.Jugador
import futbol5.Partido
import futbol5.Estandar
import futbol5.Condicional
import futbol5.Solidario


class PartidoTest {
	Jugador jugador
	Jugador jugador1
	Jugador jugador2
	Partido partido
	Estandar estandar
	Condicional condicional
	Solidario solidario
	
	@Before
	def void setUP() {
	jugador = new Jugador
	partido = new Partido
	estandar = new Estandar
	condicional = new Condicional
	solidario = new Solidario
	jugador.setTipoInscripcion(estandar)
	jugador1.setTipoInscripcion(condicional)
	jugador2.setTipoInscripcion(solidario)	
	}
	
@Test(expected = typeof(RuntimeException))
	def void test11JugadoresEstandar(){
		var int a = 0;
		while(a<12){partido.inscribirJugador(jugador)
			a = a +1
		}		
	}
@Test (expected = typeof(RuntimeException))	
def void testEstandarSacaSolidario() {
	partido.inscribirJugador(jugador)
	//aca se deberia desplazar un jugador solidario o condicional	
}	
@Test (expected = typeof(RuntimeException))
def void testFaltanJugadores(){
	
}
									
	}
