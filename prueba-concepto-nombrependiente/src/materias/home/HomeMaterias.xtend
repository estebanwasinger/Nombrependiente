package materias.home

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.CollectionBasedHome
import materias.domain.Materia
import org.uqbar.commons.model.UserException
import materias.domain.Ubicacion
import org.uqbar.commons.utils.ApplicationContext

@Observable
class HomeMaterias extends CollectionBasedHome<Materia> {

	new() {
		this.init
	}

	def void init() {
		this.create("Diseño de sistemas", true, "2014", "Fernando")
		this.create("Analisis Matematico 1", false, "2010", "Cafferata")
		this.create("Algoritmos", true, "2011", "Oscar")
	}
	
		def getUbicacion(String modeloDescripcion) {
		(ApplicationContext::instance.getSingleton(typeof(Ubicacion)) as HomeUbicaciones).get(modeloDescripcion)
	}


	// ********************************************************
	// ** Altas y bajas
	// ********************************************************
	def void create(String pNombre, Boolean finalAprobado, String anioCursada, String profesor) {
		var materia = new Materia
		materia.nombre = pNombre
		materia.finalAprobado = finalAprobado
		materia.anioCursada = anioCursada
		materia.profesor = profesor
		this.create(materia)
	}
	override void validateCreate(Materia materia) {
		materia.validar()
		validarMateriasDuplicadas(materia)
	}

	def void validarMateriasDuplicadas(Materia materia) {
		val nombre = materia.nombre
		if (!this.search(nombre).isEmpty) {
			throw new UserException("Ya existe una materia con el nombre " + nombre)
		}
	}

	// ********************************************************
	// ** Búsquedas
	// ********************************************************

	/**
	 * Busca los celulares que coincidan con los datos recibidos. Tanto número como nombre pueden ser nulos,
	 * en ese caso no se filtra por ese atributo.
	 *
	 * Soporta búsquedas por substring, por ejemplo el celular (12345, "Juan Gonzalez") será contemplado por
	 * la búsqueda (23, "Gonza")
	 */
	def search(String nombre) {
		allInstances.filter[celular|this.match(nombre, celular.nombre)].toList
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
		typeof(Materia)
	}

	override def createExample() {
		new Materia
	}

	override def getCriterio(Materia example) {
		null
	}
	
	
	/**
	 * Para el proyecto web - se mantiene la busqueda por Identificador
	 */

}