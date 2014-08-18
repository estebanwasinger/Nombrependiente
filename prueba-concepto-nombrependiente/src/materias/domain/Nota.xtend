package materias.domain

import java.util.Date
import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.UserException
import java.util.Calendar
import org.uqbar.commons.utils.ApplicationContext
import materias.home.HomeNotas
import java.util.List

@Observable
class Nota extends Entity {
	@Property String nombreMateria
	@Property Date fecha
	@Property String descripcion
	@Property boolean aprobado
	
	
	def validarDescripcion(){
		if (descripcion == null) {
			throw new UserException("Debe ingresar una descripción")
		}
	}
	def validarFecha(){
		var Calendar cal = Calendar.getInstance()
		cal.setTime(fecha)
		var anioNota =cal.get(Calendar.YEAR)
		if (anioNota != anioCursada){
			throw new UserException("El año de la cursada debe ser igual al de la nota")
		}
	}
	def getAnioCursada(){
		var materia = new Materia
		materia.getAnioMateria(nombreMateria)
	}
	
	def agregarNota(){
		validarFecha()
		validarDescripcion()
		getHomeNotas().create(nombreMateria, fecha, descripcion,aprobado)
	}
	
	def HomeNotas getHomeNotas() {
		ApplicationContext.instance.getSingleton(typeof(Nota))
	}
	
	def List<Nota> getNotas(){
		getHomeNotas().getNotas(nombreMateria)
	}
}