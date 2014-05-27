package futbol5

import java.util.List
import java.util.ArrayList
import inscripciones.TipoInscripcion
import inscripciones.Estandar
import infracciones.Infraccion
import calificaciones.Calificacion

class Jugador {

	@Property TipoInscripcion tipoInscripcion
	@Property int edad
	@Property String email
	@Property List<Infraccion> infracciones
	@Property List<Jugador> amigos
	@Property List <Calificacion> calificaciones
	@Property Administrador administrador
	
	new() {
		tipoInscripcion = new Estandar
		amigos = new ArrayList<Jugador>
		infracciones = new ArrayList<Infraccion>
		administrador = Administrador::getInstance()
		calificaciones = new ArrayList<Calificacion>
	}
	
	def agregarAmigo(Jugador jugador) {
		this.amigos.add(jugador)
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
	
	def agregarCalificacion(Calificacion calificacion) {
		calificaciones.add(calificacion)
	}
	
}
