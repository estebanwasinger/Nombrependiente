package futbol5
class Estandar implements TipoInscripcion{
	
	override inscribir(Partido partido, Jugador jugador){
		if (partido.cantJugadores <10) partido.agregarJugador(jugador) else (
		if(partido.posicionEnLista(partido.unSolidario)!= -1)(partido.cambiarJugador(partido.posicionEnLista(partido.unSolidario),jugador))
		
		)
	}
	// Hay que implementar los desplasamientos
	
	/*def void desplazarJugadorCondicionalOSolidario(Partido partido, Jugador jugador){
		var int posicionADesplazar = 0 
		var Jugador unJugador = null
		
		}
		
		if (partido.jugadores.contains(unJugador.tipoInscripcion=="Condicional")){
			posicionADesplazar = partido.jugadores.indexOf(unJugador.tipoInscripcion=="Condicional")
			partido.jugadores.set(posicionADesplazar, jugador)				
		}
			else{
			posicionADesplazar = partido.jugadores.indexOf(unJugador.tipoInscripcion=="Solidario")
			partido.jugadores.set(posicionADesplazar, jugador)	
			}
			
}
	
	}*/

}