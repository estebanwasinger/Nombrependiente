package commands

import futbol5.Jugador

class CriterioCalifiUltimoPartido extends CriteriosCommand {

	override void criterioComparacion(){

		this.criterio = [Jugador jugador | jugador.promedioCalificacionesUltimoPartido()];
		
	}
	
	
}