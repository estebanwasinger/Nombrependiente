package futbol5

class Condicional implements TipoInscripcion{
	
override inscribir(Partido partido, Jugador jugador){
		if (partido.cantJugadores <10) 
		partido.agregarJugador(jugador) }
	}
	
