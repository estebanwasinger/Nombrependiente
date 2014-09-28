package test

import futbol5.domain.Jugador
import futbol5.homes.HomeJugadores
import org.junit.Before

class Entrega6Test {
	
	var HomeJugadores homeDeJugadores
	var Jugador jugadorEsteban
	var Jugador jugadorCaro
	
	var Jugador jugadorCaroNullNombre
	
	var Jugador jugadorNull
	
	Jugador jugadorCaroJoven
	
	@Before
	def void setUP(){
		homeDeJugadores = new HomeJugadores
		//homeDeJugadores.create("Carolina","La Carito de Burzaco",21,"09-01-1993")
	/*	jugadorCaro = new Jugador ("Carolina","La Carito de Burzaco",21,"09-01-1993")
		jugadorCaroJoven = new Jugador ("Carolina","La Carito de Burzaco",21,"09-01-1995")
		jugadorNull = new Jugador(null,null,0,null)
		jugadorEsteban = new Jugador("arolina","La Saeta Rubia",21,"02-12-1990")
		jugadorCaroNullNombre = new Jugador(null,"burzaco",21,"09-01-1999")*/
		
	}
	
/* 	@Test
	def void matchearJugadorNull(){
		Assert.assertEquals(true, jugadorCaro.matchea(jugadorNull))
			}
			
	@Test
	def void pruebaNombreIncorrecto(){
		Assert.assertEquals(false,jugadorEsteban.matchea(jugadorCaro))
	}
	
	@Test
	def void pruebaApodo(){
		Assert.assertEquals(true,jugadorCaro.matchea(jugadorCaroNullNombre))
	}
	
	@Test
	def void fechaNacMayor(){
		Assert.assertEquals(true,jugadorCaro.matchea(jugadorCaroJoven))
	}
	
	@Test
	def void fechaNacMenor(){
	val maximum = 0 as byte
	var int randomNum
	var int i = 0
	while(i<10){
	println(randomNum = 0 + (Math.random()*10)as int)
	i = i+1
	}
	}
	*/
	
}