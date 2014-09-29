package strategyHandicap

import futbol5.domain.Jugador

class HandicapHasta implements HandicapStrategy{
	
	override boolean calcular(Jugador jugadorEnLista, Integer handicapHasta){
		if (handicapHasta != null) {
			Math.round(jugadorEnLista.nivelDeJuego) <= handicapHasta
		} else {
			true
		}
	}
	

	override toString(){
		"Handicap Hasta"
	}
}