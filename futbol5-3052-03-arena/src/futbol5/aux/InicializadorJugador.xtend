package futbol5.aux

import futbol5.domain.Jugador
import java.util.ArrayList
import calificaciones.Calificacion

class InicializadorJugador {
//	def createCompleto(String localidad, List<Jugador> jugadores){
//		var partido = new Partido
//		partido.localidad=localidad
//		partido.jugadores=jugadores
//		partidos.add(partido)
//	}

	
	def static crearListaDejugadores(int max){
		var ArrayList<Jugador> jugadores
		var int a = 0
		jugadores = new ArrayList<Jugador>
		while (a < max) {
			jugadores.add(new Jugador(nombreRandom(), apodoRandom,21,fechaRandom, 2, listaAmigos(8), listaCalificaciones(nRan(2,9)),nRan(2,6)))
			a = a + 1
	}
	return jugadores
	}
	
	def static String nombreRandom(){
		var String[] arrayNombres = #["Caro","Esteban","Vero","Pau","Jorge","Rodrigo","Jose","Catalina","Luisa","Carlo","Ronaldo","Jean Carlos","Pepe","El Willy","Marcos"]
		arrayNombres.get( 0 + (Math.random()*10)as int)
	}
	
	def static String apodoRandom(){
		var String[] arrayApodos = #["Carolinita","Estabnquito","Saeta","Hacha","Durex","El Mago","El messi","Fantasma","Sanguche","Sin piernas","Correcaminos","Saca corchos","Barriga","Colorado","Negro"]
		arrayApodos.get( nRan(0,15))
	}
	
	def static String fechaRandom(){
		var String[] arrayFechas = #["09-01-1991","09-01-1993","09-01-1999","09-01-2000","09-01-2003","09-01-1993"]
		arrayFechas.get( nRan(0,6))
	}
	
	def static listaAmigos(int max){
		var int a=0
		var amigos = new ArrayList<Jugador>
		while (a<max){
			amigos.add(new Jugador(nombreRandom))
			a=a+1
		}
	return amigos
	}
	
	def static int nRan(int min, int max){
		 min + (Math.random()*max)as int
	}
	
	def static listaCalificaciones(int max){
		var int a=0
		var calificaciones = new ArrayList<Calificacion>
		while (a<max){
			calificaciones.add(new Calificacion(nRan(1,9)))
			a=a+1
		}
		return calificaciones
		}
}