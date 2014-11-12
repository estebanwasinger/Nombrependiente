package futbol5.homes

import uqbar.arena.persistence.PersistentHome
import org.uqbar.commons.utils.Observable
import futbol5.domain.Jugador

@Observable
class RepositorioJugadores extends PersistentHome<Jugador>{
	
	override def getEntityType() {
		typeof(Jugador)
	}

	override def createExample() {
		new Jugador
	}
	
}