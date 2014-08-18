package materias.home

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.CollectionBasedHome
import materias.domain.Materia
import org.uqbar.commons.model.UserException
import java.util.List
import materias.domain.Ubicacion
import org.uqbar.commons.utils.ApplicationContext

@Observable
class HomeMaterias extends CollectionBasedHome<Materia> {

	new() {
		this.init
	}

	def void init() {
		this.create("Analisis Matematico I","2011", false, "Cafferata","Nivel 1 - Anual")
		this.create("Algoritmos", "2011", true, "Bruno","Nivel 1 - 1er. Cuatrimestre" )
		this.create("Analisis de sistemas", "2012", true, "Garbarini","Nivel 2 - Anual" )
		this.create("Diseño de sistemas", "2013", false, "Dodino","Nivel 3 - 1er. Cuatrimestre" )
		this.create("Sistemas Operativos", "2012", true, "Bruno","Nivel 3 - 2do. Cuatrimestre" )
		
		
	}
	
		def getUbicacion(String modeloDescripcion) {
		(ApplicationContext::instance.getSingleton(typeof(Ubicacion)) as HomeUbicaciones).get(modeloDescripcion)
	}


	// ********************************************************
	// ** Altas y bajas
	// ********************************************************
	def void create(String nombre, String anioCursada, boolean finalAprobado, String profesor, String ubicacion){
		var materia = new Materia
		materia.nombre = nombre
		materia.finalAprobado = finalAprobado
		materia.anioCursada = anioCursada
		materia.profesor = profesor
		materia.ubicacion = ubicacion
		this.create(materia)
	}
	override void validateCreate(Materia materia) {
		materia.validarNombre()
		validarMateriasDuplicadas(materia)
	}

	def void validarMateriasDuplicadas(Materia materia) {
		val nombre = materia.nombre
		if (!this.search(nombre).isEmpty) {
			throw new UserException("Ya existe una materia con el nombre " + nombre)
		}
	}

	def List<Materia> getMaterias(){
		allInstances
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
		allInstances.filter[materia|this.match(nombre, materia.nombre)].toList
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