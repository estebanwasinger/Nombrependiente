package futbol5.homes

import uqbar.arena.persistence.PersistentHome
import org.uqbar.commons.utils.Observable
import futbol5.domain.Jugador
import java.util.ArrayList
import calificaciones.Calificacion
import java.util.List
import futbol5.auxUtils.InicializadorJugador
import futbol5.applicationModel.BusquedaJugadoresAppModel

@Observable
class RepositorioJugadores extends PersistentHome<Jugador> {

	new() {
		this.init
	}

	def void init() {
		this.createIfNotExists(1)
		this.createIfNotExists(2)
		this.createIfNotExists(3)
		this.createIfNotExists(4)
		this.createIfNotExists(5)
		this.createIfNotExists(6)
		this.createIfNotExists(7)
		this.createIfNotExists(8)
		this.createIfNotExists(9)
		this.createIfNotExists(10)
		this.createIfNotExists(11)
		this.createIfNotExists(12)
		this.createIfNotExists(13)
	}

	def createIfNotExists(Integer id){
		println("Creando si no existe jugador con id: " + id)
		var jugador = new Jugador(InicializadorJugador.nombreRandom(),	InicializadorJugador.apodoRandom, 21, 
			InicializadorJugador.fechaRandom, InicializadorJugador.handicapRandom(), InicializadorJugador.listaAmigos(10),
			InicializadorJugador.listaCalificaciones(InicializadorJugador.nRan(2,9)), InicializadorJugador.nRan(2,6))
		jugador.id = id	
		InicializadorJugador.crearListaNotificacioens(jugador)
											
		var jugadorDB = this.get(id)
		if (jugadorDB== null) {
					this.create(jugador)
					jugadorDB =jugador
					println("Jugador con id "+id+" fue creado")
		}else{
				println("Jugador ya existente")
		}
		jugadorDB
	}
	
	def search(BusquedaJugadoresAppModel modelo) {
		allInstances.filter[jugador|this.match(jugador, modelo)].toList
	}

	def match(Jugador jugadorEnLista, BusquedaJugadoresAppModel modelo) {
		matcheaNombre(jugadorEnLista, modelo.jugadorEjemplo) && matcheaApodo(jugadorEnLista, modelo.jugadorEjemplo) &&
			matcheaFecha(jugadorEnLista, modelo.jugadorEjemplo) &&
			modelo.metodoHandicap.calcular(jugadorEnLista, modelo.handicap) &&
			matcheaPromedioMin(jugadorEnLista, modelo.promedioDesde) &&
			matcheaPromedioMax(jugadorEnLista, modelo.promedioHasta) &&
			matcheaInfracciones(jugadorEnLista, modelo.infracciones)
	}

	def matcheaNombre(Jugador jugadorEnLista, Jugador jugadorBuscado) {
		jugadorBuscado.nombre == null || jugadorEnLista.nombre.toLowerCase.startsWith(jugadorBuscado.nombre.toLowerCase)
	}

	def matcheaApodo(Jugador jugadorEnLista, Jugador jugadorBuscado) {
		jugadorBuscado.apodo == null || jugadorEnLista.apodo.toLowerCase.contains(jugadorBuscado.apodo.toLowerCase)
	}

	def matcheaFecha(Jugador jugadorEnLista, Jugador jugadorBuscado) {
		jugadorBuscado.fechaNacimiento == null || jugadorBuscado.fechaNacimiento >= jugadorEnLista.fechaNacimiento
	}

	def matcheaPromedioMin(Jugador jugadorEnLista, Integer promedioDesde) {
		if (promedioDesde != null) {
			Math.round(jugadorEnLista.promedio) >= promedioDesde
		} else {
			true
		}
	}

	def matcheaPromedioMax(Jugador jugadorEnLista, Integer promedioHasta) {
		if (promedioHasta != null) {
			Math.round(jugadorEnLista.promedio) <= promedioHasta
		} else {
			true
		}
	}

	def matcheaInfracciones(Jugador jugadorEnLista, String infracciones) {
		if (infracciones == "Todos") {
			return true
		} else if (infracciones == "Con Infracciones") {
			!jugadorEnLista.infracciones.empty
		} else
			jugadorEnLista.infracciones.empty
	}
	

	def List<Jugador> getJugadores() {
		allInstances
	}

	def Jugador get(Integer id) {
		for (Jugador jugadorDB: this.allInstances){
			if(jugadorDB.id.equals(id)){
				return jugadorDB;
			}
		}
		return null 
	}
	
	def search(Integer unId) {
		searchByExample(
			new Jugador => [
				id = unId])
	}

	override def getEntityType() {
		typeof(Jugador)
	}

	override def createExample() {
		new Jugador()
	}
}
