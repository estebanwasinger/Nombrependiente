package commands

import futbol5.Jugador
import java.util.List

class AlgoritmoLoco extends AlgoritmosCommand{
	
	override dividir(List<Jugador> jugadores, List<Jugador> equipoA, List<Jugador> equipoB) {
		var posA=0 
		var posB=1
		while (posA<9 && posB<10){
			equipoA.add(jugadores.get(posA))
			posA = calculaPosicion(posA)
			equipoB.add(jugadores.get(posB))
			posB = calculaPosicion(posB)
		}
	}
		
		def calculaPosicion(int pos){
			if (super.esPar(pos)){
			return pos+1
			
			}
			else{
			return pos+3
		}
	
	}
}
	
	
