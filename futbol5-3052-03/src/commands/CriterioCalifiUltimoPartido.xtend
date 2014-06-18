package commands

import futbol5.Jugador

class CriterioCalifiUltimoPartido extends CriteriosCommand {

	override void criterioComparacion(int n){

		this.criterio = [Jugador jugador | jugador.promedioCalificacionesUltimoPartido()];
		
	}
	
	
}