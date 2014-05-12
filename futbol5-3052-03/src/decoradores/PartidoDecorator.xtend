package decoradores

import futbol5.InterfazPartido
import futbol5.Jugador

class PartidoDecorator implements InterfazPartido {
	
	@Property InterfazPartido decorado
	
	new(InterfazPartido partido) {
		decorado = partido
	}
	
	override cantJugadores() {
		decorado.cantJugadores()
	}
	
	override bajaSinReemplazo(Jugador jugador) {
		decorado.bajaSinReemplazo(jugador)
	}
	
	override inscribir(Jugador jugador) {
		decorado.inscribir(jugador)
	}
	
}