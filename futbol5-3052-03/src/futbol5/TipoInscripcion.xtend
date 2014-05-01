package futbol5
interface TipoInscripcion {
	
	def int prioridad()
	
	def boolean cumpleCondicion(Jugador jugador, Partido partido)
	
}