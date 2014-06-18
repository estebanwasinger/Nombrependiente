package commands

import java.util.LinkedList
import futbol5.Jugador
import java.util.List

abstract class AlgoritmosCommand {
	
	def void dividir(List<Jugador> jugadores,List<Jugador> equipoA,List<Jugador> equipoB)
	
	def esPar(int pos){
		pos %2 ==0
	}
}
	
	