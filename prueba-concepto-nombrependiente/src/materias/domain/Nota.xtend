package materias.domain

import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.UserException
import java.util.Calendar
import org.uqbar.commons.utils.ApplicationContext
import materias.home.HomeNotas
import java.util.List
import java.text.DateFormat

@Observable
class Nota extends Entity {
	@Property String nombreMateria
	@Property String fecha
	@Property String descripcion
	@Property Boolean aprobado
	
	
	def validarDescripcion(){
		if (descripcion == null) {
			throw new UserException("Debe ingresar una descripción")
		}
	}
	def validarFecha(){
		var instance = DateFormat.getInstance()
		var dateNota = instance.parse(fecha)
		var Calendar cal = Calendar.getInstance()
		cal.setTime(dateNota)
		var anioNota = cal.get(Calendar.YEAR)
		if (anioNota != Integer.parseInt(anioCursada)){
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
		getHomeNotas().getNotas()
	}
	
	def cargarNota(){
		validarDescripcion()
		getHomeNotas.create(nombreMateria, "" ,descripcion, false)
	
	}
}