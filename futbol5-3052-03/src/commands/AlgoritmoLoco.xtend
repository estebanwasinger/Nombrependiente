package commands

import java.util.LinkedList
import futbol5.Jugador
import java.util.List

class AlgoritmoLoco extends AlgoritmosCommand{
	
	override dividir(List<Jugador> jugadores, List<Jugador> equipoA, List<Jugador> equipoB) {
		var posA=1 
		var posB=2
		while (posA<9 && posB<=10){
			equipoA.add(jugadores.get(posA))
			calculaPosicion(posA)
			equipoB.add(jugadores.get(posB))
			calculaPosicion(posB)
		}
		}
		
		def calculaPosicion(int pos){
			if (super.esPar(pos)){
			pos==pos+1
			}
			else{
			pos==pos+3
		}
	
	}
}
	
	
