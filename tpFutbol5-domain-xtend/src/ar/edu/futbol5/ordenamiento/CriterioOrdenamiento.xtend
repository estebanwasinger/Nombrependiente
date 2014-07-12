package ar.edu.futbol5.ordenamiento

import ar.edu.futbol5.Jugador
import ar.edu.futbol5.Partido
import java.util.List

interface CriterioOrdenamiento {
	
	def List<Jugador> ordenar(Partido partido)

	def (Jugador) => Double calcularValor()
		 
}