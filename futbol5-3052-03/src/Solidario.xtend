
class Solidario implements TipoInscripcion{
	
	def void desplazarJugadorCondicional(Partido partido, Jugador jugador){
		var int posicionADesplazar = 0
		var Jugador unJugador = null
		
		posicionADesplazar = partido.jugadores.indexOf(unJugador.tipoInscripcion=="Condicional")
		partido.jugadores.set(posicionADesplazar, jugador)
		}
	
	override inscribir(Partido partido, Jugador jugador) {
		if (partido.jugadores.size < 10){
			partido.jugadores.add(jugador)
		}
		else{
			desplazarJugadorCondicional(partido,jugador)
		}
	}
}
		