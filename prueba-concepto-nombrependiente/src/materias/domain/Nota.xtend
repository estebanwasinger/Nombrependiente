package materias.domain

import org.uqbar.commons.utils.Observable
import java.util.Date

@Observable
class Nota {
	@Property Date fecha
	@Property String descripcion
	@Property boolean aprobado
	
	new (Date unaFecha, String laDescripcion, boolean estaAprobado){
		this.fecha = unaFecha
		this.descripcion = laDescripcion
		this.aprobado = estaAprobado
	}
	
}