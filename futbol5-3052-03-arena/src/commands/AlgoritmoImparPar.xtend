package commands

import futbol5.domain.Jugador
import java.util.List

class AlgoritmoImparPar extends DivisionDeEquiposCommand {

	override dividir(List<Jugador> jugadores, List<Jugador> equipoA, List<Jugador> equipoB) {
		(0 .. 9).forEach [ pos |
			if ((pos + 1).esPar) {
				equipoA.add(jugadores.get(pos))
			} else {
				equipoB.add(jugadores.get(pos))
			}
		]
	}

}
