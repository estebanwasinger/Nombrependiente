
class Estandar implements TipoInscripcion{
	
	def void desplazarJugadorCondicionalOSolidario(Partido partido, Jugador jugador){
		var int posicionADesplazar = 0 
		var Jugador unJugador = null
		
		if (partido.jugadores.contains(unJugador.tipoInscripcion=="Condicional")){
			posicionADesplazar = partido.jugadores.indexOf(unJugador.tipoInscripcion=="Condicional")
			partido.jugadores.set(posicionADesplazar, jugador)				
		}
			else{
			posicionADesplazar = partido.jugadores.indexOf(unJugador.tipoInscripcion=="Solidario")
			partido.jugadores.set(posicionADesplazar, jugador)	
			}
			
}
	
	override inscribir(Partido partido, Jugador jugador) {
		if (partido.jugadores.size < 10){
			partido.jugadores.add(jugador)
		}
		else{
			desplazarJugadorCondicionalOSolidario(partido, jugador)
		}
	}

}