package decoradores

import futbol5.InterfazPartido

class InfraccionDecorator extends PartidoDecorator{
	
	new(InterfazPartido partido) {
		super(partido)
	}
	
}