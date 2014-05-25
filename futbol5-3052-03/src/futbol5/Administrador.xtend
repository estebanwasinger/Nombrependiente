package futbol5

import java.util.LinkedList

class Administrador {

	@Property String email
	@Property Boolean decisionATomar
	@Property Sistema sistema
	@Property var LinkedList<Partido> partidos
	
	
	static Administrador unico
	
	Boolean True
		
	def static Administrador getInstance() {
		if (unico == null) {
			unico = new Administrador
		}
		unico
	}
	def tomarUnaDecision(Jugador jugador){
		if (this.decisionATomar=True){
			partidos.forEach[partido| partido.jugadoresRecomendados.remove(jugador)]
			sistema.jugadoresAceptados.add(jugador)
			}
		else 
			motivo = motivoDeRechazo(jugador) 
			registro = new RegistroRechazo(motivo) 
			partidos.forEach[partido| partido.jugadoresRecomendados.remove(jugador]
			sistema.jugadoresRechazados.add(registro)
		}
	
		
	

  

	
