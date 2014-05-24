package command

import futbol5.Jugador
import futbol5.Partido

interface Decision {
	
	def void registrarDecision(Jugador jugador, Partido partido,String motivo)
	
}