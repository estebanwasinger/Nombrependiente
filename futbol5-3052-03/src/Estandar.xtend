
class Estandar implements TipoInscripcion{
	
	override inscribir(Partido partido, Jugador jugador) {
		if (partido.jugadores.size < 10){
			partido.jugadores.add(jugador)
		}
		else{
			//busca en la lista de jugadores del partido el primer CONDICIONAL o SOLIDARIO y lo reemplaza por el jugador
		}
	}
	
}