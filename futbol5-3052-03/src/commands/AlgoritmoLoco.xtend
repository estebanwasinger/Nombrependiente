package commands

import futbol5.Jugador
import java.util.List

class AlgoritmoLoco extends DivisionDeEquiposCommand {

	List<Integer> posicionesA = #[0,3,4,7,8]
	List<Integer> posicionesB = #[1,2,5,6,9]
	
	override dividir(List<Jugador> jugadores, List<Jugador> equipoA, List<Jugador> equipoB) {
//		var posA = 0
//		var posB = 1
//		while (posA < 9 && posB < 10) {
//			equipoA.add(jugadores.get(posA))
//			posA = calculaPosicion(posA)
//			equipoB.add(jugadores.get(posB))
//			posB = calculaPosicion(posB)
//		}
		posicionesA.forEach [ i | equipoA.add(jugadores.get(i))]	
		posicionesB.forEach [ i | equipoB.add(jugadores.get(i))]	
	}

//	def calculaPosicion(int pos) {
//		if (this.esPar(pos)) {
//			return pos + 1
//		} else {
//			return pos + 3
//		}
//	}

}
