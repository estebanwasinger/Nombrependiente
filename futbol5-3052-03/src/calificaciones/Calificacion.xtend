package calificaciones

import futbol5.Jugador
import futbol5.Partido

class Calificacion {
	@Property Jugador jugadorQueCalifica
	@Property Jugador jugadorACalificar
	@Property int nota
	@Property String critica
	@Property Partido partido
	
	def void generar(Jugador jugadorQueCalifica, Jugador jugadorACalificar, Integer nota, String critica, Partido partido) {
			this.jugadorQueCalifica = jugadorQueCalifica
			this.jugadorACalificar = jugadorACalificar
			this.nota = nota
			this.critica = critica
			this.partido = partido
	}}