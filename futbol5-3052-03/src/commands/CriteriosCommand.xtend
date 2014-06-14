package commands

import java.util.LinkedList
import futbol5.Jugador

interface CriteriosCommand {

	def void ordenar(LinkedList<Jugador> jugadores)
	
}