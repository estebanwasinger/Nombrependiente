package futbol5.homes

import auxiliares.RegistroRechazo
import calificaciones.Calificacion
import futbol5.domain.Jugador
import infracciones.Infraccion
import inscripciones.TipoInscripcion
import java.util.LinkedList
import java.util.List
import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable

@Observable
class HomeJugadores extends CollectionBasedHome<Jugador> {
	
	@Property var List<Jugador> jugadoresAceptados
	@Property var List<RegistroRechazo> jugadoresRechazados
	@Property var LinkedList<Jugador> jugadoresRecomendados

	new() {
		this.init
	}

	def void init() {
 		jugadoresAceptados = new LinkedList<Jugador>
		jugadoresRechazados = new LinkedList<RegistroRechazo>
		jugadoresRecomendados = new LinkedList<Jugador>
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
		
		jugadoresAceptados.add(jugador)
	}
	
	override void validateCreate(Jugador jugador) {
		jugador.validarNombre()
		validarMateriasDuplicadas(jugador)
	}
	
	def void validarMateriasDuplicadas(Jugador jugador) {
		val nombre = jugador.nombre
		if (!this.search(nombre).isEmpty) {
			throw new UserException("Ya existe una jugador con el nombre " + nombre)
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