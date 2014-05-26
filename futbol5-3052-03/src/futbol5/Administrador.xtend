package futbol5

import auxiliares.RegistroRechazo

class Administrador {

	@Property String email
	@Property Boolean aceptar
	@Property Sistema sistema
	@Property String motivo
		
	static Administrador unico
			
	def static Administrador getInstance() {
		if (unico == null) {
			unico = new Administrador
		}
		unico
	}
	
	new(){
		sistema = new Sistema
	}
		
	def revisarRecomendados(Partido partido) {
		partido.jugadoresRecomendados.forEach[jugador| tomarUnaDecision(jugador, partido)]
	}
	
	def tomarUnaDecision(Jugador jugador, Partido partido){
		var RegistroRechazo registro
		
		if (aceptar){
			sistema.jugadoresAceptados.add(jugador)
			partido.inscribir(jugador)
			}else{ 
			registro = new RegistroRechazo(jugador,motivo) 
			sistema.jugadoresRechazados.add(registro)
			}
		partido.jugadoresRecomendados.remove(jugador)
 }
	
	
}
	

  

	
