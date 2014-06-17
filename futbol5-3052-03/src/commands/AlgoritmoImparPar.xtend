package commands

import java.util.LinkedList
import futbol5.Jugador
import java.util.List

class AlgoritmoImparPar implements AlgoritmosCommand {
	
	override dividir(List<Jugador> jugadores, List<Jugador> equipoA, List<Jugador> equipoB) {
		var pos = 1
		while(pos<=10){
			if (pos %2==0){
			equipoA.add(jugadores.get(pos))	
			}
			else{
			equipoB.add(jugadores.get(pos))	
			}
			pos=pos+1
		}
	}
	
}