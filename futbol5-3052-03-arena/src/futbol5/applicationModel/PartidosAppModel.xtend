package futbol5.applicationModel

import futbol5.domain.Partido
import futbol5.homes.RepositorioPartidos
import java.util.List
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable

@Observable
class PartidosAppModel {

	@Property List<Partido> partidos 
	@Property Partido partidoSeleccionado

	new() {
		searchPartido()
	}
	
	def searchPartido() {
		partidos = getHomePartidos().allInstances
	}
	
	def RepositorioPartidos getHomePartidos() {
		ApplicationContext.instance.getSingleton(typeof(Partido))
	}

}
