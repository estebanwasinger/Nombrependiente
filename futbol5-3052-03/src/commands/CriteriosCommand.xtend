package commands

import futbol5.Jugador
import java.util.List


abstract class CriteriosCommand {

	
	def (Jugador) => float criterioComparacion(int n){
		
	}
	
	def List<Jugador> ordenar(List<Jugador> jugadores, int n){
		
		return jugadores.sortBy(this.criterioComparacion(n));
		
		}
}