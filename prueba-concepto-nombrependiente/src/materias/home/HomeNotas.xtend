package materias.home

import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.utils.Observable
import materias.domain.Nota
import java.util.List

@Observable
class HomeNotas extends CollectionBasedHome<Nota> {
	
	new() {
		this.init
	
	}

	def void init() {
		this.create("Diseño de Sistemas", "11/06/2013","Parcial 1", true)
		this.create("Diseño de Sistemas", "15/11/2013","Parcial 2", false)
		this.create("Algoritmos", "31/07/2011","TP", true)
		this.create("Algoritmos", "15/11/2013","Parcial 1", true)
		this.create("Diseño de Sistemas", "11/06/2013","TP", true)
		this.create("Analisis de Sistemas", "11/06/2012","Parcial 1", true)
		this.create("Analisis de Sistemas", "11/08/2012","Parcial 2", true)
		this.create("Analisis de Sistemas", "20/06/2012","TP", true)
		this.create("Sistemas Operativos", "01/03/2012","Parcial 1", true)
		this.create("Sistemas Operativos", "30/06/2012","Parcial 2", true)
		this.create("Sistemas Operativos", "20/06/2012","TP", true)		
	}	
	
	def void create(String materia, String fecha, String descripcion, boolean aprobado) {
		var nota = new Nota
		nota.nombreMateria = materia
		nota.fecha = fecha
		nota.descripcion = descripcion
		nota.aprobado = aprobado
		this.create(nota)
	}
	
		def List<Nota> getNotas(){
		allInstances
	}
	
	override def getEntityType() {
		typeof(Nota)
	}

	override def createExample() {
		new Nota
	}

	override def getCriterio(Nota example) {
		null
	}
	
	def buscar(String nombre) {
		allInstances.filter[materia|this.match(nombre, materia.nombreMateria)].toList
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
}

