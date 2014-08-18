package materias.home

import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable
import java.util.Date
import materias.domain.Nota

@Observable
class HomeNotas extends CollectionBasedHome<Nota> {
	
	new() {
		this.init
	}

	def void init() {
		this.create("Matemática Discreta", new Date,"Parcial", true)
	}	
	
	def void create(String materia, Date fecha, String descripcion, boolean aprobado) {
		var nota = new Nota
		nota.nombreMateria = materia
		nota.fecha = fecha
		nota.descripcion = descripcion
		nota.aprobado = aprobado
		this.create(nota)
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
	

}

