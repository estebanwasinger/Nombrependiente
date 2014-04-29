package futbol5

import java.util.LinkedList

class Partido {
	
	//@Property LinkedList<Jugador> jugadores
	//@Property String condicion // VER!
	// No podia hacerlo andar con los propertys
	var jugadores = new LinkedList<Jugador>


/* 		if (jugadores.filter[jugador.tipoInscripcion=="Estandar"].size == 10){ 
			throw new EquipoConfirmadoYCompleto("No se pueden inscribir m�s jugadores. El equipo est� completo")
		}
		else{
			jugadorAInscribir.inscribirse(this)
		}
	} 
	La logico de la inscripcion se tiene que delegar a los tiposDeInscripcion*/
	
	
	def int cantJugadores(){
		jugadores.size
	}
	
	def void agregarJugador(Jugador jugadorAInscribir){
		jugadores.add(jugadorAInscribir)
	}
	def void cambiarJugador(Integer posicionAGuardar,Jugador jugador){
		jugadores.set(posicionAGuardar,jugador)
	}
	def int posicionEnLista(Jugador jugador){
		jugadores.indexOf(jugador)
	}
	def Jugador ultimoSolidario(){
		jugadores.filter[unJugador | unJugador.tipoInscripcion.class.equals(Solidario)].last
	}
	def Jugador unCondicional(){
		jugadores.filter[unJugador | unJugador.tipoInscripcion.class.equals(Condicional)].last
	}
	
	}