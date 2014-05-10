package futbol5

import java.util.List
import java.util.LinkedList
import java.util.ArrayList
import observers.MailObserver
import excepciones.BusinessException

class Partido {

	@Property var String localidad
	@Property var LinkedList<Jugador> jugadores
	@Property var List<MailObserver> mailObservers
	@Property var Administrador administrador
	@Property var boolean previamenteCompleto
	
					/****************/
					/*CONSTRUCTORES*/
					/****************/
					
	new(String localidad) {
		this.localidad = localidad
		jugadores = new LinkedList<Jugador>
		mailObservers = new ArrayList<MailObserver>	
		administrador = Administrador::getInstance()
		this.previamenteCompleto = false
	}
	
					/********************/
					/*METODOS AUXILIARES*/
					/********************/

	def notificar(Jugador jugador){
		if (!(this.mailObservers.isEmpty())){
			mailObservers.forEach [ observador  | observador.enviarNotificacion(this, jugador) ]
		}
	}

	def int cantJugadores() {
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
	
	def agregarObserver(MailObserver observer){
		this.mailObservers.add(observer)
	}
	
	def quitarObserver(MailObserver observer){
		this.mailObservers.remove(observer)
	}
	
	
					/*******************************/
					/*CASO DE USO: BAJA DE UN JUGADOR*/
					/*******************************/
					
	def bajaConReemplazo (Jugador jugador, Jugador reemplazo){
		if (!this.estaInscripto(jugador)){
			throw new BusinessException("El jugador no está inscripto en este partido, no se puede dar de baja")
		}
		if (this.estaInscripto(reemplazo)){
			throw new BusinessException("El reemplazo ya está inscripto en el partido")
		}		
		this.eliminarJugador(jugador)
		/*this.notificar(jugador) no deberia notificar porque elimino un jugador pero inmediatamente inscribo otro*/
		this.inscribir(reemplazo)
	}
	
	def bajaSinReemplazo (Jugador jugador){
		if (!this.estaInscripto(jugador)){
			throw new BusinessException("El jugador no está inscripto en este partido, no se puede dar de baja")
		}
		if (this.cantJugadores==10){
			this.previamenteCompleto = true
		}
		this.jugadores.remove(jugador)
		this.notificar(jugador)
		jugador.nuevaInfraccion()
	}

					/**************************************/
					/*CASO DE USO: INSCRIPCION DE UN JUGADOR */
					/**************************************/
					
	def inscribir(Jugador jugador) {
		if (this.estaInscripto(jugador)) {
			throw new BusinessException("El jugador ya se inscribió")
		}
		if(!jugador.tipoInscripcion.cumpleCondicion(jugador,this)){
			throw new BusinessException("El jugador no cumple con la condición, no se puede inscribir")
		}
		if (this.cantJugadores < 10){
			this.agregarJugador(jugador)
			this.notificar(jugador)
			return
		}
		if (!this.jugadores.exists[ inscripto | jugador.tieneMasPrioridadQue(inscripto) ]) {
			throw new BusinessException("No hay más cupo")
		}
		
		val quien = this.jugadores.filter [ unJugador | unJugador.prioridad > jugador.prioridad ].head
		this.jugadores.remove(quien)
		this.agregarJugador(jugador)
	}
}
