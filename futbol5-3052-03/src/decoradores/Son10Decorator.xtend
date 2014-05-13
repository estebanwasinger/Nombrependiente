package decoradores

import futbol5.InterfazPartido
import futbol5.Jugador
import futbol5.Administrador

class Son10Decorator extends PartidoDecorator{
	
	new(InterfazPartido partido) {
		super(partido)
	}
	
	override inscribir(Jugador jugador) {
		decorado.inscribir(jugador)
		if (decorado.cantJugadores()==10) {
			notificarAdministrador(jugador.administrador)
		}
	}
	
	def notificarAdministrador(Administrador administrador) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	
}