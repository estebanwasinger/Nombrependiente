package futbol5

import java.util.List
import java.util.ArrayList
import inscripciones.TipoInscripcion
import inscripciones.Estandar
import infracciones.Infraccion
import helper.Notificacion

class Jugador {

	@Property TipoInscripcion tipoInscripcion
	@Property String nombre
	@Property int edad
	@Property String email
	@Property List<Infraccion> infracciones
	@Property List<Jugador> amigos
	@Property List<Notificacion> notificaciones
	@Property Administrador administrador
	@Property int diasDeInfraccion

	def initialize() {
		amigos = new ArrayList<Jugador>
		infracciones = new ArrayList<Infraccion>
		administrador = Administrador::getInstance()
		diasDeInfraccion = 0
	}
	def initialize2() {
		tipoInscripcion = new Estandar
		amigos = new ArrayList<Jugador>
		infracciones = new ArrayList<Infraccion>
		administrador = Administrador::getInstance()
		diasDeInfraccion = 0
	}

	new(TipoInscripcion inscripcion, String pNombre) {
		initialize
		tipoInscripcion = inscripcion
		nombre = pNombre
	}
	new(){
		initialize2
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

	/*ARREGLAR "nos interesa poder discriminar infracciones de diferentes momentos y por distintos motivos"*/
	def nuevaInfraccion(int cantidadDeDias) {
		this.diasDeInfraccion = cantidadDeDias 
	}

}
