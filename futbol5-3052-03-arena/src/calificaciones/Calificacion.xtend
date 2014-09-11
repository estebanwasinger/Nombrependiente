package calificaciones

import futbol5.Jugador
import futbol5.Partido

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