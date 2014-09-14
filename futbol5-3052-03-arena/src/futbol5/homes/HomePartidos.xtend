package futbol5.homes

import futbol5.domain.Partido
import org.uqbar.commons.model.CollectionBasedHome
import java.util.LinkedList
import java.util.List

class HomePartidos extends CollectionBasedHome<Partido> {
	
	@Property var List<Partido> partidos
	
	def init(){
		partidos = new LinkedList<Partido>
	}
	
	def create(){
		var partido = new Partido
		partidos.add(partido)
	}
	
	new(){
		this.init
	}
	
	override protected getCriterio(Partido example) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override createExample() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getEntityType() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}