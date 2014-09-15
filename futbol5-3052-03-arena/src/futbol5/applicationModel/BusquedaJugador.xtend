package futbol5.applicationModel

import futbol5.domain.Jugador

class BusquedaJugador {
	
	@Property int handicapDesde
	@Property int handicapHasta
	
	
	def cumple(Jugador jugador) {
		(!ingresoHandicapDesde || jugador.nivelDeJuego >= handicapDesde) &&
			(!ingresoHandicapHasta || jugador.nivelDeJuego <= handicapDesde) // aca se agregan las distintas validaciones de las busquedas para los puntos siguientes
	}

	def void clear() {
		handicapDesde = 0
		handicapHasta = 10000
		}

	def ingresoHandicapDesde() {
		!handicapDesde.equals(0)
	}

	def ingresoHandicapHasta() {
		 !handicapHasta.equals(10000)
	}}