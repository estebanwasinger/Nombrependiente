package materias.domain

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.Entity
import org.uqbar.commons.model.UserException
import java.util.Calendar
import java.util.List
import materias.home.HomeMaterias
import org.uqbar.commons.utils.ApplicationContext

@Observable
class Materia extends Entity {

	@Property Integer id
	@Property String nombre
	@Property String anioCursada
	@Property Boolean finalAprobado = false
	@Property String profesor
	@Property String ubicacion
	
	def validarNombre() {
		if (nombre == null) {
			throw new UserException("Debe ingresar un nombre de materia")
		}
	}
	def ingresoNombre() {
		 nombre != null && !nombre.trim().equals("")
	}
		
	def validarAnio(){
	var Calendar cal = Calendar.getInstance()
	anioCursada != null && Integer.parseInt(anioCursada) <= cal.get(Calendar.YEAR)	
	}
	
	def validarProfesor(){
		if (profesor == null || profesor.trim().equals("")){
			throw new UserException("Debe ingresar un nombre de profesor")
		}
	}
	
	def HomeMaterias getHomeMaterias() {
		ApplicationContext.instance.getSingleton(typeof(Materia))
	}
	
	def List<Materia> getMaterias(){
		getHomeMaterias().getMaterias()
	}
	
	def crearMateria(){
		validarNombre()
		getHomeMaterias.create(nombre, null ,false ,"" ,"")
	}
	
	def getAnioMateria(String nombre){
		getMaterias().filter[materia | materia.nombre == nombre].head.anioCursada
		}
}


