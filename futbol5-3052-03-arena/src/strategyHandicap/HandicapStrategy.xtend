package strategyHandicap

import futbol5.domain.Jugador

interface HandicapStrategy {
	
	def boolean calcular(Jugador jugadorEnLista, Integer handicapHasta)
	
	 abstract override toString()
}