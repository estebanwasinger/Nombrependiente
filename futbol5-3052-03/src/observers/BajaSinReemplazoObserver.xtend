package observers

import futbol5.Jugador
import futbol5.Partido
import infracciones.Infraccion
import auxiliares.MessageSender

class BajaSinReemplazoObserver extends PartidoObserver {
	
	new(MessageSender unMessageSender) {
		super(unMessageSender)
	}
	
	override  hacerLoSuyo(Partido partido, Jugador jugador) {
		if (jugador.reemplazo==null){
			generarInfraccion(jugador)
		}
	}
	def generarInfraccion(Jugador jugador) {
		jugador.infracciones.add(new Infraccion)
	}
	
}