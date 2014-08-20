package materias.applicationModel

import java.io.Serializable
import java.util.ArrayList
import java.util.List
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable
import materias.home.HomeMaterias
import materias.domain.Materia
import materias.domain.Nota

@Observable
class SeguidorCarrera implements Serializable {

	@Property Integer numero
	@Property String nombre
	@Property List<Materia> resultados
	@Property List<Nota> notas
	@Property Materia materiaSeleccionada
	@Property Nota notaSeleccionada

	def void search() { 
		resultados = new ArrayList<Materia>
		resultados = getHomeMaterias().search(nombre)
	}

	def void buscar() { 
		notas = new ArrayList<Nota>
		 if (materiaSeleccionada != null){
		notas = materiaSeleccionada.notas
		}
	} 
	
	def void clear() {
		nombre = null
	}

	def HomeMaterias getHomeMaterias() {
		ApplicationContext.instance.getSingleton(typeof(Materia))
	}
}