package decoradores


import java.util.List
import futbol5.InterfazPartido
import futbol5.Jugador

class NotificarAmigosDecorator extends PartidoDecorator {
	
	new(InterfazPartido partido) {
		super(partido)
	}
	
	override inscribir(Jugador jugador) {
		decorado.inscribir(jugador)
		notificarAmigos(jugador.amigos)
	}
	
	def notificarAmigos(List<Jugador> jugadores) {
	}
	
}