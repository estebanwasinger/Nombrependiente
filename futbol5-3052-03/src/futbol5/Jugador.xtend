package futbol5

import java.util.List
import java.util.ArrayList
import inscripciones.TipoInscripcion
import inscripciones.Estandar
import infracciones.Infraccion
import calificaciones.Calificacion
import excepciones.BusinessException
import java.util.LinkedList

class Jugador {

	@Property TipoInscripcion tipoInscripcion
	@Property int edad
	@Property String email
	@Property List<Infraccion> infracciones
	@Property List<Jugador> amigos
	@Property List <Calificacion> calificaciones
	@Property int nivelDeJuego
	@Property int criterioComparacion
	
	new() {
		tipoInscripcion = new Estandar
		amigos = new ArrayList<Jugador>
		infracciones = new ArrayList<Infraccion>
		calificaciones = new LinkedList<Calificacion>
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
	
	def  int promedioCalificacionesUltimoPartido(){
		//arreglar
		if (calificaciones.size==0){
			throw new BusinessException("El jugador no fue calificado aun")
				}		
		var calificacionesUltimoPartido =calificaciones.filter[calificacion.nota|calificacion.partido==(calificaciones.last).partido]
		var sumaCalificaciones = calificacionesUltimoPartido.forEach[calificacion.nota|sumaCalificaciones + calificacion.nota]
		return sumaCalificaciones;
	}
	
	def promedioNCalificaciones(int n){
		// desarrollar
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
