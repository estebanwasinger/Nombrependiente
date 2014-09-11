package commands

import futbol5.Jugador

class CriterioCalifiUltimoPartido extends CriteriosCommand {

	new(){}
	
	override (Jugador)=>float criterioComparacion() {
		return [Jugador jugador|jugador.promedioCalificacionesUltimoPartido]
	}

}
