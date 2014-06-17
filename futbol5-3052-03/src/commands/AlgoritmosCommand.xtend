package commands

import java.util.LinkedList
import futbol5.Jugador
import java.util.List

interface AlgoritmosCommand {
	
	def void dividir(List<Jugador> jugadores,List<Jugador> equipoA,List<Jugador> equipoB)
	
}