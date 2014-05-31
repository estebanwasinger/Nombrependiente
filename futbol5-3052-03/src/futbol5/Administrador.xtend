package futbol5

import auxiliares.RegistroRechazo
import excepciones.BusinessException

class Administrador {

	@Property String email
	@Property Sistema sistema

	new() {
		sistema = new Sistema
	}

}
