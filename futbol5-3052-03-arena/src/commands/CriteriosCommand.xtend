package commands

import futbol5.domain.Jugador
import java.util.List
import org.uqbar.commons.utils.Observable

@Observable
abstract class CriteriosCommand {
	
	@Property String nombre

	def (Jugador) => float criterioComparacion(){}
	
	def List<Jugador> ordenar(List<Jugador> jugadores){		
		return jugadores.sortBy(this.criterioComparacion())		
	}
		
	new(){}
		
}