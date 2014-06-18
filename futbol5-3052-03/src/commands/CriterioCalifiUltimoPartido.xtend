package commands

import futbol5.Jugador

class CriterioCalifiUltimoPartido extends CriteriosCommand {

	new(int n) {
		super(n)
	}
	
	new(){}
	
	override (Jugador)=>float criterioComparacion(int n) {
		return [Jugador jugador|jugador.promedioCalificacionesUltimoPartido]
	}

}
