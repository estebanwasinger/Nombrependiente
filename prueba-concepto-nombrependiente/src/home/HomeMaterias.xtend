package home

import domain.Materia
import domain.Nota
import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable

@Observable
class HomeMaterias extends CollectionBasedHome<Materia> {
	
	new() {
		this.init
	}

	def void init() {
		this.create("Algoritmos")
	}

	//def getModelo(String modeloDescripcion) {
		//(ApplicationContext::instance.getSingleton(typeof(Modelo)) as HomeModelos).get(modeloDescripcion)
	//}

	// ********************************************************
	// ** Altas y bajas
	// ********************************************************
	def void create(String pNombre) {
		var materia = new Materia
		materia.nombre = pNombre
		this.create(materia)
	}
	
	def search() {
		allInstances.toList
	}
	
	def setNombre(Materia materia, String string) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected getCriterio(Materia example) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override createExample() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getEntityType() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}