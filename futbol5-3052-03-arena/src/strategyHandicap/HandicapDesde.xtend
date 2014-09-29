package strategyHandicap

import futbol5.domain.Jugador

class HandicapDesde implements HandicapStrategy{
	
	override calcular (Jugador jugadorEnLista, Integer handicapDesde){ 
		if (handicapDesde != null) {
			Math.round(jugadorEnLista.nivelDeJuego) >= handicapDesde
		} else {
			true
		}
	}
	
	override toString(){
		"Handicap desde"
	}
}