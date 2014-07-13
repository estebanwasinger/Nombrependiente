package ar.edu.futbol5

import ar.edu.futbol5.excepciones.BusinessException
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento
import ar.edu.futbol5.ordenamiento.OrdenamientoPorHandicap
import java.util.ArrayList
import java.util.List
import java.util.LinkedList
import ar.edu.futbol5.distribucion.Distribucion
import ar.edu.futbol5.distribucion.DistribucionParImpar

class Partido {

	@Property List<Jugador> inscriptos
	//agregado los equipos por Pau
	@Property var List<Jugador> equipoA
	@Property var List<Jugador> equipoB
	String estado
	@Property CriterioOrdenamiento criterioOrdenamiento
	@Property Distribucion distribucionEquipos 

	new() {
		inscriptos = new ArrayList<Jugador>
		estado = "A"
		distribucionEquipos = new DistribucionParImpar
		criterioOrdenamiento = new OrdenamientoPorHandicap
		//agregado los equipos por Pau
		equipoA = new LinkedList<Jugador>
		equipoB = new LinkedList<Jugador>
	}

  def generarEquipos() {
    if (this.validarInscripcion) {
        distribucionEquipos.distribuirEquipos(this, this.ordenarEquipos)
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
	
 	def List<Jugador> ordenarEquipos() {
		criterioOrdenamiento.ordenar(this)
	}

	//modificado por Vero 
	def int cantidadInscriptos(){
        	inscriptos.size
        }
	def void agregarJugador(Jugador jugador){
			inscriptos.add(jugador)
		}    
	def void eliminarJugador(Jugador jugador){
    		inscriptos.remove(jugador)
   		}
	def void inscribir(Jugador jugador) {
        if (this.cantidadInscriptos< 10) {
            agregarJugador(jugador)
        	} else {
            	if (this.hayAlgunJugadorQueCedaLugar()) {
                this.eliminarJugador(this.jugadorQueCedeLugar())
                this.agregarJugador(jugador)
            } else {
                throw new BusinessException("No hay más lugar")
            }
        }
	}

	def boolean hayAlgunJugadorQueCedaLugar() {
		inscriptos.exists[jugador|jugador.dejaLugarAOtro]
	}

	def Jugador jugadorQueCedeLugar() {
		return inscriptos.filter[jugador|jugador.dejaLugarAOtro].get(0)
	}

	def void cerrar() {
		estado = "C"
	}
}
