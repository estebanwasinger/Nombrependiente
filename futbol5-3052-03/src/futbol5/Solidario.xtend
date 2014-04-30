package futbol5
class Solidario implements TipoInscripcion{
	
override inscribir(Partido partido, Jugador jugador){
		if (partido.cantJugadores <10) partido.agregarJugador(jugador) else (
			if (partido.posicionEnLista(partido.unCondicional)!= -1) (partido.cambiarJugador(partido.posicionEnLista(partido.unCondicional),jugador))
		)
	}
}
		