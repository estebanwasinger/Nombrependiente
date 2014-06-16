package commands

import futbol5.Jugador


class CriterioHandicap extends CriteriosCommand{

	override void criterioComparacion(){

		this.criterio = [Jugador jugador | jugador.nivelDeJuego];
		
	}
	
	
}