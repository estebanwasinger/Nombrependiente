package calificaciones

import futbol5.domain.Jugador
import futbol5.domain.Partido
import org.uqbar.commons.model.Entity
import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField

@PersistentClass
class Calificacion extends Entity{

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

	new(int nota) {
		this.nota = nota
	}
	
	new(){
	}
	@PersistentField
	def getNota(){
		_nota
	}
	
	def void setNota(int nota){
		_nota = nota
	}
}
