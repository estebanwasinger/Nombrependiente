package materias.domain

import java.text.DateFormat
import java.util.Calendar
import org.uqbar.commons.model.Entity
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable

@Observable
class Nota extends Entity implements Cloneable {
	@Property String nombreMateria
	@Property String fecha
	@Property String descripcion
	@Property boolean aprobado //con el boolean (!= de Boolean)se permite crear una nueva nota desaprobado
	
	new(){}
	new(String fechaN,String descripcionN,Boolean estadoAprobacion){
		fecha = fechaN
		descripcion = descripcionN
		aprobado = estadoAprobacion
		nombreMateria = "Hola"
	}
	
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
	
	override clone() {
		super.clone()
	}
}