package materias.home

import java.util.ArrayList
import java.util.List
import materias.domain.Materia
import materias.domain.Nota
import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable

@Observable
class HomeMaterias extends CollectionBasedHome<Materia> {

	new() {
		this.init
	}

	def void init() {
		var notasAM = new ArrayList<Nota>
		var notaParcial = new Nota
		notaParcial=>[descripcion = "Parcial"	fecha = "20/12/2014" aprobado = true nombreMateria = "Analisis Matematico I"]
		var notaTP = new Nota
		notaTP=>[descripcion = "TP"	fecha = "20/11/2014" aprobado = true nombreMateria = "Analisis Matematico I"]
		notasAM.add(notaParcial)
		notasAM.add(notaTP)
		
		var notasAYED = new ArrayList<Nota>
		var notaParcial1 = new Nota
		notaParcial1=>[descripcion = "Parcial 2"	fecha = "20/12/2013" aprobado = true nombreMateria = "Algoritmos"]
		notasAYED.add(notaParcial1)
		
		var notasADS = new ArrayList<Nota>
		var notaParcial2 = new Nota
		notaParcial2=>[descripcion = "Parcial" fecha = "12/08/2012" aprobado = true nombreMateria = "Analisis de Sistemas"]
		notasADS.add(notaParcial2)
		
		var notasDDS = new ArrayList<Nota>
		var notaTP2 = new Nota
		notaTP2=>[descripcion = "TP" fecha = "01/06/2012" aprobado = true nombreMateria = "Diseño de Sistemas"]
		notasDDS.add(notaTP2)
		
		var notasSO = new ArrayList<Nota>
		var notaTP3 = new Nota
		notaTP3=>[descripcion = "TP" fecha = "01/05/2014" aprobado = true nombreMateria = "Sistemas Operativos"]
		notasSO.add(notaTP3)

		this.create("Analisis Matematico I","2011", false, "Cafferata","Nivel 1 - Anual", notasAM)
		this.create("Algoritmos", "2011", true, "Bruno","Nivel 1 - 1er. Cuatrimestre",notasAYED )
		this.create("Analisis de Sistemas", "2012", true, "Garbarini","Nivel 2 - Anual",notasADS )
		this.create("Diseño de Sistemas", "2013", false, "Dodino","Nivel 3 - 1er. Cuatrimestre",notasDDS )
		this.create("Sistemas Operativos", "2012", true, "Bruno","Nivel 3 - 2do. Cuatrimestre", notasSO )
		
		
	}


	// ********************************************************
	// ** Altas y bajas
	// ********************************************************
	def void create(String nombre, String anioCursada, boolean finalAprobado, String profesor, String ubicacion, List<Nota> notas){
		var materia = new Materia
		materia.nombre = nombre
		materia.finalAprobado = finalAprobado
		materia.anioCursada = anioCursada
		materia.profesor = profesor
		materia.ubicacion = ubicacion
		materia.notas = notas
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
	
}