package commands

import futbol5.domain.Jugador
import java.util.List

class CriterioMix extends CriteriosCommand {

	List<CriteriosCommand> criterios

	new(List<CriteriosCommand> criterios) {
		this.criterios = criterios
	}

	override (Jugador)=> float criterioComparacion() {
		[ jugador | 
			criterios.fold(0f, [ acum, criterio | acum + criterio.criterioComparacion.apply(jugador) ])
			/
			criterios.size
		]
	}

}
