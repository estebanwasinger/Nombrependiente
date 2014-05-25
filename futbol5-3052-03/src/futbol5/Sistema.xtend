package futbol5

import auxiliares.RegistroRechazo
import java.util.List
import java.util.LinkedList

class Sistema {
	@Property var List<Jugador> jugadoresAceptados
	@Property var List<RegistroRechazo> jugadoresRechazados
	
	new(){
		jugadoresAceptados = new LinkedList<Jugador>
		jugadoresRechazados = new LinkedList<RegistroRechazo>	
		}
		
	/*******************************/
	/*CASO DE USO: NUEVOS JUGADORES */
	/*******************************/
	def jugadorProponeA(Jugador jugador){}
	
	def decisionAdministrador(boolean decision, String motivo){}

}