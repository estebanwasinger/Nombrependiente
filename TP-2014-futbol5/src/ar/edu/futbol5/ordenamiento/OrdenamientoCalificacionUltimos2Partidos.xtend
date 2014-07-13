package ar.edu.futbol5.ordenamiento

import java.util.List

class OrdenamientoCalificacionUltimos2Partidos extends CriterioOrdenamiento {
	
	override calcularValor() {
		[ jugador |
				val misPuntajes = obtenerPuntajes(jugador.getPuntajes)
				val promedio = misPuntajes.fold(0d, [ acum, puntaje | acum + puntaje ]) / misPuntajes.size
				promedio
		]
	}
	
def obtenerPuntajes(List<Double> puntajes)	{
	devolverNobjetosDeListaInvertida(puntajes,2).toList
}
def devolverNobjetosDeListaInvertida(List<Double> lista, int numero) {
	lista.clone.reverse.take(numero)
}
}