package commands

import futbol5.domain.Jugador
import java.util.List

abstract class DivisionDeEquiposCommand {
	
	def void dividir(List<Jugador> jugadores,List<Jugador> equipoA,List<Jugador> equipoB)
	
	def esPar(int pos){
		pos %2 ==0
	}
}
	
	