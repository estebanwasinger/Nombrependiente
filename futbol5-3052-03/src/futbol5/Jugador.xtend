package futbol5
class Jugador {
	
	@Property TipoInscripcion tipoInscripcion
	@Property Partido partido 
		
	def void inscribirse(Partido partido){ 
		partido.partidoCompleto
		tipoInscripcion.inscribir(partido, this)
	}

}