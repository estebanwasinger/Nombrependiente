package commands

import futbol5.Jugador
import java.util.List
import excepciones.BusinessException

class CriterioHandicap extends CriteriosCommand{

	override (Jugador) => float criterioComparacion(int n){

		return [Jugador jugador | jugador.nivelDeJuego];
		
	}
	
	override List<Jugador> ordenar(List<Jugador> jugadores, int n){
		if (jugadores.exists[jugador | (jugador.nivelDeJuego) == 0]) {
			
			throw new BusinessException("No todos los jugadores tienen un nivel de juego asignado");
		}
		
		super.ordenar(jugadores, n);
	
	}
}