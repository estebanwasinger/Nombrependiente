package futbol5

import java.util.List
import java.util.LinkedList
import excepciones.BusinessException
import observers.PartidoObserver

class Partido {

	@Property var String localidad
	@Property var LinkedList<Jugador> jugadores
	@Property var List<PartidoObserver> altasObservers
	@Property var List<PartidoObserver>bajasObservers
	@Property var Administrador administrador
	@Property var boolean previamenteCompleto
		
					/****************/
					/*CONSTRUCTORES*/
					/****************/
					
	new(String localidad) {
		this.localidad = localidad
		jugadores = new LinkedList<Jugador>
		altasObservers = new LinkedList<PartidoObserver>	
		bajasObservers = new LinkedList<PartidoObserver>	
		administrador = Administrador::getInstance()
		this.previamenteCompleto = false
		
	}
	
					/********************/
					/*METODOS AUXILIARES*/
					/********************/

	def notificarInscripcion(Jugador jugador){
		if (!(this.altasObservers.isEmpty())){
			altasObservers.forEach [ observador  | observador.hacerLoSuyo(this, jugador) ]
		}
	}
	
	def notificarBaja(Jugador jugador){
		if (!(this.bajasObservers.isEmpty())){
			bajasObservers.forEach [ observador  | observador.hacerLoSuyo(this, jugador) ]
		}
	}

	def int cantJugadores() {
		jugadores.size
	}

	def void agregarJugador(Jugador jugador) {
		this.jugadores.add(jugador)
		this.notificarInscripcion(jugador)
	}
	
	def void eliminarJugador(Jugador jugador){
		this.jugadores.remove(jugador)
		notificarBaja(jugador)
	}

	def estaInscripto(Jugador jugador) {
		this.jugadores.contains(jugador)
	}
	
	def agregarObserverAlta(PartidoObserver observer){
		this.altasObservers.add(observer)
	}
	
	def agregarObserverBaja(PartidoObserver observer){
		this.bajasObservers.add(observer)
	}
	
	def quitarObserverAlta(PartidoObserver observer){
		this.altasObservers.remove(observer)
	}
	
	def quitarObserverBaja(PartidoObserver observer){
		this.bajasObservers.remove(observer)
	}
	
	def agregarReemplazo(Jugador jugador, Jugador reemplazo){
		jugador.reemplazo = reemplazo
	}
	
	
					/*******************************/
					/*CASO DE USO: BAJA DE UN JUGADOR*/
					/*******************************/
					
	def baja(Jugador jugador){
		if (!this.estaInscripto(jugador)){
			throw new BusinessException("El jugador no está inscripto en este partido, no se puede dar de baja")
		}		
		if (jugador.reemplazo!=null){
				if (this.estaInscripto(jugador.reemplazo)){
					throw new BusinessException("El reemplazo ya está inscripto en el partido")
				}	
				this.eliminarJugador(jugador)
				this.inscribir(jugador.reemplazo)
			}else{
				this.eliminarJugador(jugador)
			}
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
			return
		}
		if (!this.jugadores.exists[ inscripto | jugador.tieneMasPrioridadQue(inscripto) ]) {
			throw new BusinessException("No hay más cupo")
		}
		
		val quien = this.jugadores.filter [ unJugador | unJugador.prioridad > jugador.prioridad ].head
		this.eliminarJugador(quien)
		this.agregarJugador(jugador)
	}
}
