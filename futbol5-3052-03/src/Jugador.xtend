
class Jugador {
	
		@Property TipoInscripcion tipoInscripcion
		@Property Partido partido 
		
		def void inscribirse(Partido partido){ 
			tipoInscripcion.inscribir(partido, this)
		}

}