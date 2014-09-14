package commands

import futbol5.domain.Jugador

class CriterioCalifiUltimoPartido extends CriteriosCommand {

	new(){}
	
	override (Jugador)=>float criterioComparacion() {
		return [Jugador jugador|jugador.promedioCalificacionesUltimoPartido]
	}

}
