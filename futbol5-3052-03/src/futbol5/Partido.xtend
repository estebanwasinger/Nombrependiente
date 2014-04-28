package futbol5

import java.util.LinkedList

class Partido {
	
	@Property LinkedList<Jugador> jugadores
	@Property String condicion // VER!
	
	def void inscribirJugador(Jugador jugadorAInscribir){
		val Jugador jugador = null
		
		if (jugadores.filter[jugador.tipoInscripcion=="Estandar"].size == 10){ 
			throw new EquipoConfirmadoYCompleto("No se pueden inscribir más jugadores. El equipo está completo")
		}
		else{
			jugadorAInscribir.inscribirse(this)
		}
	}
	def int cantJugadores(){
		jugadores.size;
	}
	
	def void agregarJugador(Jugador jugadorAInscribir){
		jugadores.add(jugadorAInscribir)
	}
	
	
	}