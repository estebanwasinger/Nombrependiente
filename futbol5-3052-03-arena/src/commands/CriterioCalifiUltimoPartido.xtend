package commands

import futbol5.domain.Jugador

class CriterioCalifiUltimoPartido extends CriteriosCommand {

	new(){
		nombre = "Ultimo Partido"
	}
	
	override (Jugador)=>float criterioComparacion() {
		return [Jugador jugador|jugador.promedioCalificacionesUltimoPartido]
	}

}
