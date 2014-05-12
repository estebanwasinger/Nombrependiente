package futbol5

import java.util.LinkedList
import excepciones.BusinessException

class Partido implements InterfazPartido {

	@Property var String localidad
	@Property var LinkedList<Jugador> jugadores
	@Property var Administrador administrador
	@Property var boolean previamenteCompleto
	
					/****************/
					/*CONSTRUCTORES*/
					/****************/
					
	new(String localidad) {
		this.localidad = localidad
		jugadores = new LinkedList<Jugador>	
		administrador = Administrador::getInstance()
		this.previamenteCompleto = false
	}
	
					/********************/
					/*METODOS AUXILIARES*/
					/********************/

	override def int cantJugadores() {
		jugadores.size
	}

	def void agregarJugador(Jugador jugador) {
		this.jugadores.add(jugador)
	}
	
	def void eliminarJugador(Jugador jugador){
		this.jugadores.remove(jugador)
	}

	def estaInscripto(Jugador jugador) {
		this.jugadores.contains(jugador)
	}
	

	
	
					/*******************************/
					/*CASO DE USO: BAJA DE UN JUGADOR*/
					/*******************************/
					
	def bajaConReemplazo (Jugador jugador, Jugador reemplazo){
		if (!this.estaInscripto(jugador)){
			throw new BusinessException("El jugador no est� inscripto en este partido, no se puede dar de baja")
		}
		if (this.estaInscripto(reemplazo)){
			throw new BusinessException("El reemplazo ya est� inscripto en el partido")
		}		
		this.eliminarJugador(jugador)
		/*this.notificar(jugador) no deberia notificar porque elimino un jugador pero inmediatamente inscribo otro*/
		this.inscribir(reemplazo)
	}
	
	override def bajaSinReemplazo (Jugador jugador){
		if (!this.estaInscripto(jugador)){
			throw new BusinessException("El jugador no est� inscripto en este partido, no se puede dar de baja")
		}
		if (this.cantJugadores==10){
			this.previamenteCompleto = true
		}
		this.jugadores.remove(jugador)
		jugador.nuevaInfraccion()
	}

					/**************************************/
					/*CASO DE USO: INSCRIPCION DE UN JUGADOR */
					/**************************************/
					
	override def inscribir(Jugador jugador) {
		if (this.estaInscripto(jugador)) {
			throw new BusinessException("El jugador ya se inscribi�")
		}
		if(!jugador.tipoInscripcion.cumpleCondicion(jugador,this)){
			throw new BusinessException("El jugador no cumple con la condici�n, no se puede inscribir")
		}
		if (this.cantJugadores < 10){
			this.agregarJugador(jugador)
			return
		}
		if (!this.jugadores.exists[ inscripto | jugador.tieneMasPrioridadQue(inscripto) ]) {
			throw new BusinessException("No hay m�s cupo")
		}
		
		val quien = this.jugadores.filter [ unJugador | unJugador.prioridad > jugador.prioridad ].head
		this.jugadores.remove(quien)
		this.agregarJugador(jugador)
	}
}
