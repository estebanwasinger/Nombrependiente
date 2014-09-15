package test

import futbol5.homes.HomeJugadores
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import futbol5.domain.Jugador
import infracciones.Infraccion

class Entrega6Test {
	
	var HomeJugadores homeDeJugadores
	var Jugador jugadorEsteban
	var Jugador jugadorCaro
	
	var Jugador jugadorCaroNullNombre
	
	@Before
	def void setUP(){
		homeDeJugadores = new HomeJugadores
		homeDeJugadores.create("Carolina","La Carito de Burzaco",21,"09-01-1993")
		jugadorCaro = new Jugador ("Carolina",null,21,"09-01-1993")
		jugadorEsteban = new Jugador("arolina","La Saeta Rubia",21,"02-12-1992")
		jugadorCaroNullNombre = new Jugador(null,"burzaco",21,"09-01-1993")
		
	}
	
	@Test
	def void pruebaNombre(){
		Assert.assertEquals(1,homeDeJugadores.search(jugadorCaro).size)
			}
			
	@Test
	def void pruebaNombreIncorrecto(){
		Assert.assertEquals(0,homeDeJugadores.search(jugadorEsteban).size)
	}
	
	@Test
	def void pruebaApodo(){
		Assert.assertEquals(1,homeDeJugadores.search(jugadorCaroNullNombre).size)
	}
	
	@Test
	def void fechaNacMayor(){
		Assert.assertEquals(1,homeDeJugadores.search(new Jugador(null,null,21,"09-02-2000")).size)
	}
	
	@Test
	def void fechaNacMenor(){
		Assert.assertEquals(0,homeDeJugadores.search(new Jugador(null,null,21,"09-02-1900")).size)
	}
	
}