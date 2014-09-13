package jugadores.home

import java.util.ArrayList
import java.util.List
import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable
import futbol5.Jugador
import inscripciones.TipoInscripcion
import infracciones.Infraccion
import calificaciones.Calificacion

@Observable
class HomeJugadores extends CollectionBasedHome<Jugador> {

	new() {
		this.init
	}

	def void init() {

	}

	def void create(String nombre, TipoInscripcion tipoInscripcion, int edad, List<Infraccion> infracciones, List<Jugador> amigos, List <Calificacion> calificaciones,float nivelDeJuego,int criterioComparacion){
		var jugador = new Jugador
		jugador.nombre = nombre
		jugador.tipoInscripcion = tipoInscripcion
		jugador.edad = edad
		jugador.infracciones = infracciones
		jugador.amigos = amigos
		jugador.calificaciones = calificaciones
		jugador.nivelDeJuego = nivelDeJuego
		jugador.criterioComparacion = criterioComparacion
		
		this.create(jugador)
	}
	
	override void validateCreate(Jugador jugador) {
		jugador.validarNombre()
		validarMateriasDuplicadas(jugador)
	}
	
	def void validarMateriasDuplicadas(Jugador jugador) {
		val nombre = jugador.nombre
		if (!this.search(nombre).isEmpty) {
			throw new UserException("Ya existe una materia con el nombre " + nombre)
		}
	}

	def List<Jugador> getJugadores(){
		allInstances
	}
	def search(String nombre) {
		allInstances.filter[jugador|this.match(nombre, jugador.nombre)].toList
	}
	
	def match(Object expectedValue, Object realValue) {
		if (expectedValue == null) {
			return true
		}
		if (realValue == null) {
			return false
		}
		realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase())
	}

	override def getEntityType() {
		typeof(Jugador)
	}

	override def createExample() {
	new Jugador
	}

	override def getCriterio(Jugador example) {
		null
	}
	
	
}