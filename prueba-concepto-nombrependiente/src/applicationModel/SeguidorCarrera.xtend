package applicationModel

import domain.Materia
import java.util.ArrayList
import home.HomeMaterias
import org.uqbar.commons.utils.ApplicationContext
import java.util.List

class SeguidorCarrera {
	@Property List<Materia> resultados
	
		def void search() { 
		// WORKAROUND para que refresque la grilla en las actualizaciones
		resultados = new ArrayList<Materia>

		// FIN WORKAROUND
		resultados = getHomeMaterias().search()
		// también se puede llamar homeCelulares.search(numero, nombre) 
	}
	
	def HomeMaterias getHomeMaterias() {
		ApplicationContext::instance.getSingleton(typeof(Materia))
	}
	
}