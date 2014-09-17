package commands

import futbol5.domain.Jugador

class CriterioNCalificaciones extends CriteriosCommand{
	
	int n
	
	new(){
		nombre = "N Calificaciones"
	}
	
	new(int n) {
		nombre = "Ultimos "+n+" Partidos"
		this.n = n
	}
		
	override (Jugador) => float criterioComparacion(){
		return [Jugador jugador | jugador.promedioNPartidos(n)]
	}
	
}