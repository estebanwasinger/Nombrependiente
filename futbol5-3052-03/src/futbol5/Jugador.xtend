package futbol5

import java.util.List
import java.util.ArrayList
import inscripciones.TipoInscripcion
import inscripciones.Estandar
import helper.Notificacion

class Jugador {

	@Property TipoInscripcion tipoInscripcion
	@Property String nombre
	@Property int edad
	@Property String email
	@Property List<Jugador> amigos
	@Property List<Notificacion> notificaciones
	@Property Administrador administrador
	// falta coleccion de infracciones en jugador
	@Property int diasDeInfraccion
    // FALTA INFRACCION COMO ABSTRACCION
    
	def initialize() {
		amigos = new ArrayList<Jugador>
		diasDeInfraccion = 0
	}

	def initializeTipoEstandar() {
		tipoInscripcion = new Estandar
		amigos = new ArrayList<Jugador>
		diasDeInfraccion = 0
	}

	new(TipoInscripcion inscripcion, String pNombre) {
		initialize
		tipoInscripcion = inscripcion
		nombre = pNombre
	}

	new() {
		initializeTipoEstandar
	}

	def boolean menorA(int edad) {
		this.edad < edad
	}

	def tieneMasPrioridadQue(Jugador jugador) {
		this.prioridad < jugador.prioridad
	}

	def int prioridad() {
		tipoInscripcion.prioridad()
	}

	def nuevaInfraccion(int cantidadDeDias) {
		this.diasDeInfraccion = cantidadDeDias
	}

}
