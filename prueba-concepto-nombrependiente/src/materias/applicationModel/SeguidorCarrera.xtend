package materias.applicationModel

import java.io.Serializable
import java.util.ArrayList
import java.util.List
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable
import materias.home.HomeMaterias
import materias.domain.Materia
import materias.domain.Nota
import materias.home.HomeNotas
import org.uqbar.commons.model.UserException

@Observable
class SeguidorCarrera implements Serializable {

	@Property Integer numero
	@Property String nombre
	@Property List<Materia> resultados
	@Property List<Nota> notas
	@Property Materia materiaSeleccionada
	@Property Nota notaSeleccionada

	// ********************************************************
	// ** Acciones
	// ********************************************************
	def void search() { 
		// WORKAROUND para que refresque la grilla en las actualizaciones
		resultados = new ArrayList<Materia>
		

		// FIN WORKAROUND
		resultados = getHomeMaterias().search(nombre)
		 
	}

	def void buscar() { 
		// WORKAROUND para que refresque la grilla en las actualizaciones
		notas = new ArrayList<Nota>

		// FIN WORKAROUND
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

	def HomeNotas getHomeNotas() {
		ApplicationContext.instance.getSingleton(typeof(Nota))
	}
}