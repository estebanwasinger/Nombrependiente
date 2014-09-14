package commands

import futbol5.domain.Jugador
import java.util.List
import org.uqbar.commons.utils.Observable

@Observable
abstract class DivisionDeEquiposCommand {
	
	@Property String nombre
		
	def void dividir(List<Jugador> jugadores,List<Jugador> equipoA,List<Jugador> equipoB)
	
	def esPar(int pos){
		pos %2 ==0
	}
}
	
	