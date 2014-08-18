package materias.domain

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.Entity

@Observable
class Materia extends Entity {

	@Property Integer id
	@Property String nombre
	

	def ingresoNombre() {
		 nombre != null && !nombre.trim().equals("")
	}


}
