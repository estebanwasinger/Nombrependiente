package materias.home

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.CollectionBasedHome
import materias.domain.Ubicacion
import java.util.List

@Observable
class HomeUbicaciones extends CollectionBasedHome<Ubicacion> {

	new() {
		this.init
	}

	def void init() {
		this.create("1er Cuatrimestre - 1 Año")
		this.create("1er Cuatrimestre - 2 Año")
		this.create("1er Cuatrimestre - 3 Año")
		this.create("1er Cuatrimestre - 4 Año")
		this.create("1er Cuatrimestre - 5 Año")
		this.create("2do Cuatrimestre - 1 Año")
		this.create("2do Cuatrimestre - 2 Año")
		this.create("2do Cuatrimestre - 3 Año")
		this.create("2do Cuatrimestre - 4 Año")
		this.create("2do Cuatrimestre - 5 Año")
	}

	def void create(String descripcion) {
		var ubicacion = new Ubicacion
		ubicacion.descripcion = descripcion
		this.create(ubicacion)
	}

	def List<Ubicacion> getUbicaciones() {
		allInstances	
	}
	
	def Ubicacion get(String descripcion) {
		ubicaciones.findFirst [ ubicacion | ubicacion.descripcion.equals(descripcion) ]
	}

	override def Class<Ubicacion> getEntityType() {
		typeof(Ubicacion)
	}

	override def createExample() {
		new Ubicacion()
	}

	override def getCriterio(Ubicacion example) {
		null
	}
	
}