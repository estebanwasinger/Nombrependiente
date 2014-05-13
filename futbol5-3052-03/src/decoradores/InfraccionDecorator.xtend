package decoradores

import futbol5.InterfazPartido
import futbol5.Jugador


class InfraccionDecorator extends PartidoDecorator{
	
	new(InterfazPartido partido) {
		super(partido)
	}

override bajaSinReemplazo(Jugador jugador) {
	decorado.bajaSinReemplazo(jugador)
	jugador.nuevaInfraccion(10)
}
}