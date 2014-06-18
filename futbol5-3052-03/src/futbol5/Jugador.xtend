package futbol5

import java.util.List
import java.util.ArrayList
import inscripciones.TipoInscripcion
import inscripciones.Estandar
import infracciones.Infraccion
import calificaciones.Calificacion
import excepciones.BusinessException
import java.util.LinkedList
import java.util.Set
import java.util.HashSet

class Jugador {

	@Property TipoInscripcion tipoInscripcion
	@Property int edad
	@Property String email
	@Property List<Infraccion> infracciones
	@Property List<Jugador> amigos
	@Property List <Calificacion> calificaciones
	@Property float nivelDeJuego
	@Property int criterioComparacion
	
	new() {
		tipoInscripcion = new Estandar
		amigos = new ArrayList<Jugador>
		infracciones = new ArrayList<Infraccion>
		calificaciones = new LinkedList<Calificacion>
		nivelDeJuego = 0
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
	
	def float promedioCalificacionesUltimoPartido() {
		promedioNPartidos(1)
	}

	def float promedioNPartidos(int n) {
		if (calificaciones.size == 0) {
			throw new BusinessException("El jugador no fue calificado aun")
		}
		if (calificaciones.size != 0){
		var int calificacionTotal
		var Set<Partido> partidos = new HashSet<Partido>
		var int pos = 0;
		while (partidos.size <= n && pos < calificaciones.size) {
			partidos.add(calificaciones.get(pos).partido)
			pos= pos +1
		}
		pos = 0
		while (pos < partidos.size) {
			calificacionTotal = calificacionTotal + promedioDeUnPartido(partidos.get(pos))
			pos= pos +1
		}

		return calificacionTotal / partidos.size
		}
		return 0
		}
		
	def promedioDeUnPartido(Partido partido){
		var calificacionesUltimoPartido = calificaciones.filter[calificacion|calificacion.partido== partido]
		var sumaCalificaciones = calificacionesUltimoPartido.map[calificacion|calificacion.nota].reduce[a, b|a + b]
		return (sumaCalificaciones / calificacionesUltimoPartido.size);
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
