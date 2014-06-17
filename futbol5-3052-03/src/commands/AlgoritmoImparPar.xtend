package commands

import java.util.LinkedList
import futbol5.Jugador
import java.util.List

class AlgoritmoImparPar implements AlgoritmosCommand {
	
	override dividir(List<Jugador> jugadores, List<Jugador> equipoA, List<Jugador> equipoB) {
		var pos = 0
		while(pos!=10){
			equipoA.add(jugadores.get(pos))
			pos=pos+1
			equipoB.add(jugadores.get(pos))
			pos=pos+1
			//No se si existe en java algo ya creado para ver si es par o impar
		}
	}
	
	
	
}