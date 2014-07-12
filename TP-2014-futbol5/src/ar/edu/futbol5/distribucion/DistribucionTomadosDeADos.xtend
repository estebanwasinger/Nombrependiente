package ar.edu.futbol5.distribucion

import java.util.List
import ar.edu.futbol5.Jugador
import ar.edu.futbol5.Partido

class DistribucionTomadosDeADos implements Distribucion {
	
	override void distribuirEquipos (Partido partido, List<Jugador> jugadores){
		
	var List<Integer> posicionesA = #[0,3,4,7,8]
	var List<Integer> posicionesB = #[1,2,5,6,9]
	
	posicionesA.forEach [ i | partido.equipoA.add(jugadores.get(i))]	
	posicionesB.forEach [ i | partido.equipoB.add(jugadores.get(i))]
	
	}
	
}