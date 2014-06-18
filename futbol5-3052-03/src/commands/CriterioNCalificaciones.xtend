package commands

import futbol5.Jugador

class CriterioNCalificaciones extends CriteriosCommand{
	
	new(int n) {
	
	}
	
	override (Jugador) => float criterioComparacion(int n){
		return [Jugador jugador | jugador.promedioNPartidos(n)];
	}
	
}