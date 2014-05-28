package futbol5

import auxiliares.RegistroRechazo

class Administrador {

	@Property String email
	@Property Boolean loAcepta
	@Property Sistema sistema
	@Property String motivo
			
	new(){
		sistema = new Sistema
	}
		
	def revisarRecomendados(){
		sistema.jugadoresRecomendados.forEach[jugador| tomarUnaDecision(jugador)]
	}
	
	def tomarUnaDecision(Jugador jugador){
		var RegistroRechazo registro
		
		if (loAcepta){
			sistema.jugadoresAceptados.add(jugador)
			}else{ 
			registro = new RegistroRechazo(motivo) 
			sistema.jugadoresRechazados.add(registro)
			}
		sistema.jugadoresRecomendados.remove(jugador)
	 }
	
}