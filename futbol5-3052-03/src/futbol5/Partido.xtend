package futbol5

import java.util.LinkedList

class Partido {	
	
	var jugadores = new LinkedList<Jugador>

	def void partidoCompleto(){
		if (jugadores.filter[unJugador | unJugador.tipoInscripcion.class.equals(Estandar)].size == 10) 
			throw new PartidoConfirmadoYCompletoException("No se pueden inscribir mas jugadores. El equipo esta completo")
	}
	
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