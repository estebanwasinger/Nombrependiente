package inscripciones

import inscripciones.TipoInscripcion
import condiciones.Condicion
import futbol5.Partido
import futbol5.Jugador

class Condicional implements TipoInscripcion {
	@Property Condicion condicion
	@Property Partido partidoAInscribirse
		
	new(Partido partido, Condicion laCondicion) {
		this.partidoAInscribirse = partido
		this.condicion = laCondicion		
	}
		
override cumpleCondicion(Jugador jugador, Partido partidoAInscribirse){
		condicion.seCumple(jugador, partidoAInscribirse)
	}

	override prioridad() {
		3
	}

}
