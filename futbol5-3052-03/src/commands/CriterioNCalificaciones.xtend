package commands

import futbol5.Jugador

class CriterioNCalificaciones extends CriteriosCommand{
	
	def criterioComparacion(int n){
	this.criterio = [Jugador jugador | jugador.promedioNPartidos(n)];
	}
}