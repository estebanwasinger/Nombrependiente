package futbol5.domain

import commands.CriteriosCommand
import commands.DivisionDeEquiposCommand
import excepciones.BusinessException
import futbol5.homes.RepositorioPartidos
import java.util.ArrayList
import java.util.LinkedList
import java.util.List
import observers.PartidoObserver
import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.utils.Transactional
import org.uqbar.commons.utils.TransactionalAndObservable
import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.Relation
import org.uqbar.commons.model.UserException

@Observable
@PersistentClass
class Partido extends Entity {

	@Property var String localidad
	@Property var List<Jugador> jugadores
	@Property var List<Jugador> jugadoresOrdenados
	@Property var List<Jugador> equipoA
	@Property var List<Jugador> equipoB
	@Property var List<Jugador> equipoC
	@Property var List<PartidoObserver> altasObservers
	@Property var List<PartidoObserver> bajasObservers
	@Property var int cantEquipoA
	@Property var Boolean estaConfirmado = false
	@Property var Administrador administrador
	@Property var DivisionDeEquiposCommand AlgoritmoDivision
	@Property var CriteriosCommand AlgoritmoOrdenamiento
	@Property var Jugador jugadorSeleccionado

	@PersistentField
	def getEstaConfirmado(){
		_estaConfirmado
	}
	
	def getEstado(){
		!_estaConfirmado
	}
	
	def void setEstaConfirmado(Boolean estaConfirmado){
		_estaConfirmado = estaConfirmado
	}

	@PersistentField
	def String getLocalidad(){
		_localidad
	}
	
	def void setLocalidad(String localidad){
		_localidad = localidad
	}
	
	@Relation
	def List<Jugador> getJugadores(){
		_jugadores
	}
	
	def void setJugadores(List<Jugador> jugadores){
		_jugadores = jugadores
	}
	
	@Relation
		def List<Jugador> getEquipoA(){
		_equipoA
	}
	
	def void setEquipoA(List<Jugador> jugadores){
		_equipoA = jugadores
	}
	
	@Relation
		def List<Jugador> getEquipoB(){
		_equipoB
	}
	
	def void setEquipoB(List<Jugador> jugadores){
		_equipoB = jugadores
	}
	
	
	/****************/
	/*CONSTRUCTORES*/
	/****************/
	new(String localidad) {
		this.localidad = localidad
		init
	}
	
	new() {
		init
	}
	
	def init(){
		jugadores = new LinkedList<Jugador>
		jugadoresOrdenados = new LinkedList<Jugador>
		altasObservers = new LinkedList<PartidoObserver>
		bajasObservers = new LinkedList<PartidoObserver>
		administrador = new Administrador
		equipoA = new ArrayList<Jugador>
		equipoB = new ArrayList<Jugador>
	}
	
		def copiarA(Partido partido) {
	 	partido.localidad= this.localidad
	 	partido.jugadores= this.jugadores
	}

	/********************/
	/*METODOS AUXILIARES*/
	/********************/
	def void notificarInscripcion(Jugador jugador) {
		altasObservers.forEach[observador|observador.notificarInscripcion(this, jugador)]
	}

	def void notificarBaja(Jugador jugador, Jugador reemplazo) {
		bajasObservers.forEach[observador|observador.notificarBaja(this, jugador, reemplazo)]
	}

	def int cantJugadores() {
		jugadores.size
	}

	def void agregarJugador(Jugador jugador) {
		this.jugadores.add(jugador)
	}

	def void eliminarJugador(Jugador jugador) {
		this.jugadores.remove(jugador)
	}

	def estaInscripto(Jugador jugador) {
		this.jugadores.contains(jugador)
	}

	def agregarObserverAlta(PartidoObserver observer) {
		this.altasObservers.add(observer)
	}

	def agregarObserverBaja(PartidoObserver observer) {
		this.bajasObservers.add(observer)
	}

	def quitarObserverAlta(PartidoObserver observer) {
		this.altasObservers.remove(observer)
	}

	def quitarObserverBaja(PartidoObserver observer) {
		this.bajasObservers.remove(observer)
	}

	/*******************************/
	/*CASO DE USO: BAJA DE UN JUGADOR*/
	/*******************************/
	def baja(Jugador jugador, Jugador reemplazo) {
		if (estaConfirmado) {
			throw new BusinessException("Los equipos estan confirmados, no se puede dar de baja")
		}
		if (!estaInscripto(jugador)) {
			throw new BusinessException("El jugador no esta inscripto en este partido, no se puede dar de baja")
		}
		if (reemplazo != null && this.estaInscripto(reemplazo)) {
			throw new BusinessException("El reemplazo ya esta inscripto en el partido")
		}
		eliminarJugador(jugador)
		if (reemplazo != null) {
			jugadores.add(reemplazo)
		}
		notificarBaja(jugador, reemplazo)
		notificarInscripcion(reemplazo)
	}

	def bajaSinReemplazo(Jugador jugador) {
		baja(jugador, null)
	}

	/**************************************/
	/*CASO DE USO: INSCRIPCION DE UN JUGADOR */
	/**************************************/
	def inscribir(Jugador jugador) {
		if (estaConfirmado) {
			throw new BusinessException("Los equipos estan confirmados, no se puede inscribir")
		}
		if (this.estaInscripto(jugador)) {
			throw new BusinessException("El jugador ya se inscribio")
		}
		if (!jugador.tipoInscripcion.cumpleCondicion(jugador, this)) {
			throw new BusinessException("El jugador no cumple con la condicion, no se puede inscribir")
		}
		if (this.cantJugadores < 10) {
			this.agregarJugador(jugador)
			notificarInscripcion(jugador)
			return
		}
		if (!this.jugadores.exists[inscripto|jugador.tieneMasPrioridadQue(inscripto)]) {
			throw new BusinessException("No hay mas cupo")
		}

		val quien = this.jugadores.filter[unJugador|unJugador.prioridad > jugador.prioridad].head
		this.eliminarJugador(quien)
		this.agregarJugador(jugador)
		this.notificarInscripcion(jugador)
	}

	/***************************************/
	/*CASO DE USO: GENERAR EQUIPOS TENTATIVOS*/
	/***************************************/
	@Observable
	def ordenarJugadores(CriteriosCommand criterioOrdenamiento) {
		if (estaConfirmado) {
			throw new BusinessException("Los equipos estan confirmados, no se puede ordenar")
		}
		if (cantJugadores < 10) {
			throw new UserException("No se puede ordenar la lista porque no hay 10 jugadores inscriptos aun.")
		}
		this.jugadoresOrdenados = criterioOrdenamiento.ordenar(jugadores);
	}
	@Observable
	def dividirEquipos(DivisionDeEquiposCommand algoritmoDivision) {
		if (estaConfirmado) {
			throw new BusinessException("Los equipos estan confirmados, no se puede dividir")
		}
		hay10Jugadores()
		equipoB = new ArrayList<Jugador>
		algoritmoDivision.dividir(jugadoresOrdenados, equipoA, equipoB)
		homePartidos.updateMe(this)
		cantEquipoA = equipoA.size
	}
	
	def hay10Jugadores() {
		if (jugadoresOrdenados.size < 10) {
			throw new UserException("No se pueden armar los dos equipos porque no hay 10 jugadores inscriptos aun.")
		}
	}
	
	def losEquiposEstanLlenos(){
		if(equipoA.size < 5 || equipoB.size < 5){
			throw new UserException("No se pueden confirmar los equipos porque aun no han sido dividos.")
		}
	}

	def confirmarEquipos(Boolean confirmacion) {
		hay10Jugadores()
		losEquiposEstanLlenos()
		estaConfirmado = confirmacion
		homePartidos.updateMe(this)
	}
	
	def RepositorioPartidos getHomePartidos() {
		ApplicationContext.instance.getSingleton(typeof(Partido))
	}

}
