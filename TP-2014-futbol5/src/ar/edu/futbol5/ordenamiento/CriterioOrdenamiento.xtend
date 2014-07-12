package ar.edu.futbol5.ordenamiento

import ar.edu.futbol5.Jugador
import ar.edu.futbol5.Partido
import java.util.List

abstract class CriterioOrdenamiento {
	
	def (Jugador) => Double calcularValor()
	
	//modificado por Vero
	def List<Jugador> ordenar(Partido partido){
		partido.inscriptos.sortBy(this.calcularValor()).clone.reverse
		}
}