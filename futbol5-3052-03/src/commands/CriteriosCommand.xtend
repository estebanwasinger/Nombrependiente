package commands

import java.util.LinkedList
import futbol5.Jugador

abstract class CriteriosCommand {

	def void ordenar(LinkedList<Jugador> jugadores){
		jugadores.sortBy[criterioComparacion]
	}
	def  establecerCriterio(){}
	
}