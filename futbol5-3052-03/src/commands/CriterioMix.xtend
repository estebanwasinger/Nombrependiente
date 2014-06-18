package commands

import futbol5.Jugador
import java.util.List

//Cambie el implements porque es una clase abstracta CriteriosCommands
class CriterioMix extends CriteriosCommand{
	
	def float evaluarCriterios(Jugador jugador, List<CriteriosCommand> criterios, int n) {
		var float sum = 0;
		for(CriteriosCommand criterio : criterios) {
			sum = sum + criterio.criterioComparacion(n).apply(jugador);
		}
		
		//num = criterios.map[criterio |  criterio.criterioComparacion(0).apply(jugador)];
		//criterios.forEach[criterio | criterio.criterioComparacion(0).apply(jugador)];
		return sum / criterios.size;
	}

	def List<Jugador> multiOrdenar(List<Jugador> jugadores, List<CriteriosCommand> criterios, int n){
		
		return jugadores.sortBy[Jugador jugador | jugador.evaluarCriterios(criterios, n)];
	}
}
