package futbol5

import java.util.List
import java.util.ArrayList
import inscripciones.TipoInscripcion
import inscripciones.Estandar
import infracciones.Infraccion

class Jugador {

	@Property TipoInscripcion tipoInscripcion
	@Property int edad
	@Property String email
	@Property List<Infraccion> infracciones
	@Property List<Jugador> amigos
	@Property Administrador administrador
	@Property int diasDeInfraccion
	

	
	new() {
		tipoInscripcion = new Estandar
		amigos = new ArrayList<Jugador>
		infracciones = new ArrayList<Infraccion>
		administrador = Administrador::getInstance()
		diasDeInfraccion = 0
	}
	
	def boolean menorA (int edad) {
		this.edad < edad
	}

	def tieneMasPrioridadQue(Jugador jugador) {
		this.prioridad < jugador.prioridad
	}

	def int prioridad() {
		tipoInscripcion.prioridad()
	}
	
	/*ARREGLAR "nos interesa poder discriminar infracciones de diferentes momentos y por distintos motivos"*/
	def nuevaInfraccion(int cantidadDeDias) {
		this.diasDeInfraccion = cantidadDeDias
	}

}
