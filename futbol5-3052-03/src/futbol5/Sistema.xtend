package futbol5

import auxiliares.RegistroRechazo
import java.util.List
import java.util.LinkedList

class Sistema {
	@Property var List<Jugador> jugadoresAceptados
	@Property var List<RegistroRechazo> jugadoresRechazados

	//static Sistema unico = null
	private static Sistema INSTANCE = null;

	def static Sistema getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Sistema()
		}
		INSTANCE
	}

	new() {
		jugadoresAceptados = new LinkedList<Jugador>
		jugadoresRechazados = new LinkedList<RegistroRechazo>
	}
	
}
