package commands

import java.util.LinkedList
import futbol5.Jugador
import java.util.List

class AlgoritmoImparPar extends AlgoritmosCommand {
	
	override dividir(List<Jugador> jugadores, List<Jugador> equipoA, List<Jugador> equipoB) {
		var pos = 0
		while(pos<10){
			if (super.esPar(pos+1)){
			equipoA.add(jugadores.get(pos))	
			}
			else{
			equipoB.add(jugadores.get(pos))	
			}
			pos=pos+1
		}
	}
	
}