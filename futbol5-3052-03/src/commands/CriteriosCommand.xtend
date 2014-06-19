package commands

import futbol5.Jugador
import java.util.List


abstract class CriteriosCommand {

	def (Jugador) => float criterioComparacion(){}
	
	def List<Jugador> ordenar(List<Jugador> jugadores){		
		return jugadores.sortBy(this.criterioComparacion())		
	}
		
	new(){}
		
}