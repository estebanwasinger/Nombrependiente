package futbol5

import java.util.List
import java.util.LinkedList
import excepciones.BusinessException
import observers.PartidoObserver
import commands.AlgoritmosCommand
import commands.CriteriosCommand


class Partido {

	@Property var String localidad
	@Property var List<Jugador> jugadores
	@Property var List<Jugador> jugadoresOrdenados
	@Property var List<PartidoObserver> altasObservers
	@Property var List<PartidoObserver> bajasObservers
//	@Property var List<CriteriosCommand> criteriosOrdenamiento
//	@Property var List<AlgoritmosCommand> algoritmosDivision
	@Property var Administrador administrador 
	
	/****************/
	/*CONSTRUCTORES*/
	/****************/
	new(String localidad) {
		this.localidad = localidad
		jugadores = new LinkedList<Jugador>
		jugadoresOrdenados = new LinkedList<Jugador>
		altasObservers = new LinkedList<PartidoObserver>
		bajasObservers = new LinkedList<PartidoObserver>
		administrador = new Administrador
	//	criteriosOrdenamiento = new LinkedList<CriteriosCommand>
	//	algoritmosDivision = new LinkedList<AlgoritmosCommand>
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
		if (!estaInscripto(jugador)) {
			throw new BusinessException("El jugador no esta inscripto en este partido, no se puede dar de baja")
		}
		if (reemplazo == null && this.estaInscripto(reemplazo)) {
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
		
	def hola(){
		
	}
	
	def ordenarJugadores(CriteriosCommand criterioOrdenamiento){
		if (cantJugadores<10) {
			throw new BusinessException("No se puede ordenar la lista porque no hay 10 jugadores inscriptos aun.")
		}
		
		this.jugadoresOrdenados = criterioOrdenamiento.ordenar(jugadores);
	}
		
	def dividirEquipos(AlgoritmosCommand algoritmoDivision){
		if (cantJugadores<10) {
			throw new BusinessException("No se pueden armar los dos equipos porque no hay 10 jugadores inscriptos a�n.")
		}
		//algoritmoDivision.dividir(jugadores)
	}
		
	/*def armarEquiposTentativos(){
		ordenarJugadores(criterioOrdenamiento)
		dividirEquipos(algoritmoDivision)
	}*/
	
	def confirmarEquipos(){}
		/*ac� hay que impedir que se puedan inscribir los jugadores si se confirma */
		//la lista ordenada en caso de que el equipo no se confirme deberia vaciarse (ver si no hay otra opcion)
}
