package commands

import futbol5.Jugador
import java.util.List


abstract class CriteriosCommand {

	var int nPartidos
	def (Jugador) => float criterioComparacion(int n){}
	
	def List<Jugador> ordenar(List<Jugador> jugadores){		
		return jugadores.sortBy(this.criterioComparacion(nPartidos))		
	}
		
	new(){}
		
	new(int n){
		nPartidos = n
	}
}