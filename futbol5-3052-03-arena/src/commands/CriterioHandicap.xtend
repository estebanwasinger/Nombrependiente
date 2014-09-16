package commands

import excepciones.BusinessException
import futbol5.domain.Jugador
import java.util.List

class CriterioHandicap extends CriteriosCommand{
	
	new(){
		nombre = "Handicap"
	}

	override (Jugador) => float criterioComparacion(){
		return [Jugador jugador | jugador.nivelDeJuego]
	}
	
	override List<Jugador> ordenar(List<Jugador> jugadores){
		if (jugadores.exists[jugador | (jugador.nivelDeJuego) == 0]) {
			//throw new BusinessException("No todos los jugadores tienen un nivel de juego asignado");
		}
		super.ordenar(jugadores);
	}
}