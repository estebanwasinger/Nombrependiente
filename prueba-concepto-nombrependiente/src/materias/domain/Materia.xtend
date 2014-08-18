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
	@Property Boolean finalAprobado
	@Property String profesor
	@Property String ubicacion
	
	
	val posiblesUbicaciones = #["Nivel 1 - 1er. Cuatrimestre",
								"Nivel 1 - 2do. Cuatrimestre",
								"Nivel 1 - Anual",
								"Nivel 2 - 1er. Cuatrimestre",
								"Nivel 2 - 2do. Cuatrimestre",
								"Nivel 2 - Anual",
								"Nivel 3 - 1er. Cuatrimestre",
								"Nivel 3 - 2do. Cuatrimestre",
								"Nivel 3 - Anual",
								"Nivel 4 - 1er. Cuatrimestre",
								"Nivel 4 - 2do. Cuatrimestre",
								"Nivel 4 - Anual",
								"Nivel 5 - 1er. Cuatrimestre",
								"Nivel 5 - 2do. Cuatrimestre",
								"Nivel 5 - Anual"]

	def asObjects(List<?> list) {
		list.map[it as Object]
	}
	
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
	
	def getUbicacionesPosibles(){
		posiblesUbicaciones.asObjects
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


