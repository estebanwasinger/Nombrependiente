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
	condicional =new Condicional
	jugador.setTipoInscripcion(estandar)
	jugadorSolidario.setTipoInscripcion(solidario)
	jugadorSolidario2.setTipoInscripcion(solidario)
	jugadorCondicional.setTipoInscripcion(condicional)
	jugadorCondicional2.setTipoInscripcion(condicional)
	}
	
@Test
	def void agregar10Personas(){
		var int a = 0;
		while(a<10){partido.agregarJugador(jugador)
			a = a +1}
			Assert.assertEquals(10,partido.cantJugadores)
		}		
@Test
	def void inscribir10Personas(){
		var int a = 0;
		while(a<10){jugador.inscribirse(partido)
			a = a +1}
			Assert.assertEquals(10,partido.cantJugadores)
		}	
@Test
	def void inscribir11Personas(){
		var int a = 0;
		while(a<11){jugador.inscribirse(partido)
			a = a +1}
			Assert.assertEquals(10,partido.cantJugadores)
		}			
@Test	
def void testEstandarSacaSolidario() {
	var int a = 0;
	while(a<9){
		jugadorSolidario.inscribirse(partido)
		a = a +1
	}
	jugadorSolidario2.inscribirse(partido)
	jugador.inscribirse(partido)
	Assert.assertEquals(partido.posicionEnLista(jugador),9)
	//aca se deberia desplazar un jugador solidario o condicional	
}			
		
@Test	
def void testEstandarSacaCOndicional() {
	var int a = 0;
	while(a<9){
		jugadorCondicional.inscribirse(partido)
		a = a +1
	}
	jugadorCondicional2.inscribirse(partido)
	jugador.inscribirse(partido)
	Assert.assertEquals(partido.posicionEnLista(jugador),9)			
	}
	
	}
	
