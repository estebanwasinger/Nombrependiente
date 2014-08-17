package prueba.conversor

import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable

@Observable
class Materia extends Entity {

	@Property Integer id
	@Property String nombre
	

	def ingresoNombre() {
		 nombre != null && !nombre.trim().equals("")
	}


}
