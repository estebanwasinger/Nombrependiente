package futbol5

import java.util.List
import java.util.ArrayList
import inscripciones.TipoInscripcion
import inscripciones.Estandar
import infracciones.Infraccion
import calificaciones.Calificacion
import excepciones.BusinessException


class Jugador {

	@Property TipoInscripcion tipoInscripcion
	@Property int edad
	@Property String email
	@Property List<Infraccion> infracciones
	@Property List<Jugador> amigos
	@Property List <Calificacion> calificaciones
	@Property Administrador administrador
	@Property Sistema sistema
	@Property Partido partido 
	
	new() {
		tipoInscripcion = new Estandar
		amigos = new ArrayList<Jugador>
		infracciones = new ArrayList<Infraccion>
		administrador = new Administrador
		sistema = new Sistema
		partido = new Partido("Villa Fiorito")
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
	/*******************************/
	/*CASO DE USO: NUEVOS JUGADORES */
	/*******************************/
def proponerA(Jugador jugador){
		sistema.jugadoresRecomendados.add(jugador)
	}
	
	/*******************************/
	/****CASO DE USO: CALIFICACIONES ****/
	/*******************************/
		def calificar (Partido partido, int nota, String critica){
		
		if (!partido.estaInscripto(this)){
				throw new BusinessException("El jugador que se quiere calificar no jugo el partido indicado")
				}
		calificaciones.add(new Calificacion(this, partido, nota, critica))
	}
	
}
