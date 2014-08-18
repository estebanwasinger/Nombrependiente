package materias.domain

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.Entity
import org.uqbar.commons.model.UserException

@Observable
class Materia extends Entity {

	@Property Integer id
	@Property String nombre
	@Property String anioCursada
	@Property Boolean finalAprobado
	@Property String profesor
	
	
	def validar() {
		if (nombre == null) {
			throw new UserException("Debe ingresar un nombre de materia")
		}
	}
	def ingresoNombre() {
		 nombre != null && !nombre.trim().equals("")
	}
}


