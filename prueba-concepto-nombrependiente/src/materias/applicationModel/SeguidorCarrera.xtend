package materias.applicationModel

import java.io.Serializable
import java.util.ArrayList
import java.util.List
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable
import materias.home.HomeMaterias
import materias.domain.Materia

@Observable
class SeguidorCarrera implements Serializable {

	@Property Integer numero
	@Property String nombre
	@Property List<Materia> resultados
	@Property Materia materiaSeleccionada

	// ********************************************************
	// ** Acciones
	// ********************************************************
	def void search() { 
		// WORKAROUND para que refresque la grilla en las actualizaciones
		resultados = new ArrayList<Materia>

		// FIN WORKAROUND
		resultados = getHomeMaterias().search(nombre)
		// también se puede llamar homeCelulares.search(numero, nombre) 
	}


	def void clear() {
		nombre = null
	}


	def HomeMaterias getHomeMaterias() {
		ApplicationContext::instance.getSingleton(typeof(Materia))
	}

}