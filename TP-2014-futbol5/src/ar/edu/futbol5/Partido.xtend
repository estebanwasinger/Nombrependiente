package ar.edu.futbol5

import ar.edu.futbol5.excepciones.BusinessException
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento
import ar.edu.futbol5.ordenamiento.OrdenamientoPorHandicap
import java.util.ArrayList
import java.util.List
import java.util.LinkedList

class Partido {

	@Property List<Jugador> inscriptos
	//agregado los equipos por Pau
	@Property var List<Jugador> equipoA
	@Property var List<Jugador> equipoB
	String estado
	@Property CriterioOrdenamiento criterioOrdenamiento
	@Property int distribucionEquipos // 5 es par/impar, 16 = 1,4,5,8,9 vs. 2,3,6,7,10

	new() {
		inscriptos = new ArrayList<Jugador>
		estado = "A"
		distribucionEquipos = 5 // par/impar
		criterioOrdenamiento = new OrdenamientoPorHandicap
		//agregado los equipos por Pau
		equipoA = new LinkedList<Jugador>
		equipoB = new LinkedList<Jugador>
	}

  def generarEquipos() {
    if (this.validarInscripcion) {
        this.distribuirEquipos(this.ordenarEquipos)
        estado = "G"
    }
}

 def validarInscripcion() {
    if (inscriptos.size < 10) {
        throw new BusinessException("La cantidad de jugadores es menor a 10.")
    }
    if (estado.equalsIgnoreCase("A")) {
        throw new BusinessException("Las inscripciones todavía están abiertas.")
    }    
    if (estado.equalsIgnoreCase("G")) {
        throw new BusinessException("Los equipos ya fueron generados")
    }
    return true
}	
	
 // modificado por Pau (y Maru luego)
def distribuirEquipos(List<Jugador> jugadores) {
	var List<Integer> posicionesA16 = #[0,3,4,7,8]
	var List<Integer> posicionesB16 = #[1,2,5,6,9]
	var List<Integer> posicionesA5 = #[0,2,4,6,8]
	var List<Integer> posicionesB5 = #[1,3,5,7,9]
	
		if (distribucionEquipos == 5) {
			posicionesA5.forEach [ i | equipoA.add(jugadores.get(i))]	
			posicionesB5.forEach [ i | equipoB.add(jugadores.get(i))]
		} else {
			posicionesA16.forEach [ i | equipoA.add(jugadores.get(i))]	
			posicionesB16.forEach [ i | equipoB.add(jugadores.get(i))]
		}
	}

	def List<Jugador> ordenarEquipos() {
		criterioOrdenamiento.ordenar(this)
	}

	def void inscribir(Jugador jugador) {
		if (inscriptos.size < 10) {
			this.inscriptos.add(jugador)
		} else {
			if (this.hayAlgunJugadorQueCedaLugar()) {
				this.inscriptos.remove(this.jugadorQueCedeLugar())
				this.inscriptos.add(jugador)
			} else {
				throw new BusinessException("No hay más lugar")
			}
		}
	}

	def boolean hayAlgunJugadorQueCedaLugar() {
		inscriptos.exists[jugador|jugador.dejaLugarAOtro]
	}

	def Jugador jugadorQueCedeLugar() {
		if (!hayAlgunJugadorQueCedaLugar()) {
			return null
		}
		return inscriptos.filter[jugador|jugador.dejaLugarAOtro].get(0)
	}

	def void cerrar() {
		estado = "C"
	}
}
