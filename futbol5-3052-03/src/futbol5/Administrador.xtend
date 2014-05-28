package futbol5

import auxiliares.RegistroRechazo

class Administrador {

	@Property String email
	@Property Sistema sistema
			
	new(){
		sistema = new Sistema
	}
		
	def tomarUnaDecision(Jugador jugador, boolean loAcepta, String motivo ){
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