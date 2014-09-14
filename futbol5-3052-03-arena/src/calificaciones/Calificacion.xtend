package calificaciones

import futbol5.domain.Jugador
import futbol5.domain.Partido

class Calificacion {
	
	@Property Jugador calificado
	@Property Partido partido
	@Property int nota
	@Property String critica
	
	new(Jugador calificado, Partido partido, Integer nota, String critica) {
			this.calificado = calificado
			this.partido = partido
			this.nota = nota
			this.critica = critica
		}
	}