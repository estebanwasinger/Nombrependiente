package commands

import futbol5.Jugador
import java.util.List


abstract class CriteriosCommand {

	@Property var (Jugador) => int criterio; 
	
	def void criterioComparacion(){
		
	}
	
	def List<Jugador> ordenar(List<Jugador> jugadores){
		this.criterioComparacion();
		
		return jugadores.sortBy(this.criterio);
	}
	

	
	
}