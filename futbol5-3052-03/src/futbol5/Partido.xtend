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
		
					/****************/
					/*CONSTRUCTORES*/
					/****************/
					
	new(String localidad) {
		this.localidad = localidad
		jugadores = new LinkedList<Jugador>
		altasObservers = new LinkedList<PartidoObserver>	
		bajasObservers = new LinkedList<PartidoObserver>	
		administrador = Administrador::getInstance()
		
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
	}
	
	def void eliminarJugador(Jugador jugador){
		this.jugadores.remove(jugador)
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
		

					/*******************************/
					/*CASO DE USO: BAJA DE UN JUGADOR*/
					/*******************************/
					
	def bajaConReemplazo (Jugador jugador, Jugador reemplazo){
		if (!estaInscripto(jugador)){
			throw new BusinessException("El jugador no est� inscripto en este partido, no se puede dar de baja")
		}
		if (this.estaInscripto(reemplazo)){
			throw new BusinessException("El reemplazo ya est� inscripto en el partido")
		}		
		eliminarJugador(jugador) //no se notifica baja  porque tiene reemplazo y se va a agregar otro jugador
		jugadores.add(reemplazo)
		notificarInscripcion(reemplazo)
	}

 def bajaSinReemplazo (Jugador jugador){
		if (!this.estaInscripto(jugador)){
			throw new BusinessException("El jugador no est� inscripto en este partido, no se puede dar de baja")
		}
		eliminarJugador(jugador)
		notificarBaja(jugador)
	}
	
					/**************************************/
					/*CASO DE USO: INSCRIPCION DE UN JUGADOR */
					/**************************************/
					
	def inscribir(Jugador jugador) {
		if (this.estaInscripto(jugador)) {
			throw new BusinessException("El jugador ya se inscribi�")
		}
		if(!jugador.tipoInscripcion.cumpleCondicion(jugador,this)){
			throw new BusinessException("El jugador no cumple con la condici�n, no se puede inscribir")
		}
		if (this.cantJugadores < 10){
			this.agregarJugador(jugador)
			notificarInscripcion(jugador)		
			return
		}
		if (!this.jugadores.exists[ inscripto | jugador.tieneMasPrioridadQue(inscripto) ]) {
			throw new BusinessException("No hay m�s cupo")
		}
		
		val quien = this.jugadores.filter [ unJugador | unJugador.prioridad > jugador.prioridad ].head
		this.eliminarJugador(quien) //no se notifica baja porque si queda con 9, al reemplazar vuelve a 10 y es por reemplazo
		this.agregarJugador(jugador)
		this.notificarInscripcion(jugador)		
	}
}
