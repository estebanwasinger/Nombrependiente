package ar.edu.futbol5.distribucion

import ar.edu.futbol5.Partido
import java.util.List
import ar.edu.futbol5.Jugador

class DistribucionParImpar implements Distribucion {
	

	override void distribuirEquipos(Partido partido, List<Jugador> jugadores){
		
	var List<Integer> posicionesA = #[0,2,4,6,8]
	var List<Integer> posicionesB = #[1,3,5,7,9]
	
	posicionesA.forEach [ i | partido.equipoA.add(jugadores.get(i))]	
	posicionesB.forEach [ i | partido.equipoB.add(jugadores.get(i))]
}

}