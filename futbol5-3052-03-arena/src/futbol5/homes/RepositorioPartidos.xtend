package futbol5.homes

import futbol5.domain.Partido
import org.uqbar.commons.utils.Observable
import uqbar.arena.persistence.PersistentHome
import futbol5.domain.Jugador
import java.util.List
import calificaciones.Calificacion
import java.util.ArrayList
import org.uqbar.commons.utils.ApplicationContext

@Observable
class RepositorioPartidos  extends PersistentHome<Partido> {

	override def getEntityType() {
		typeof(Partido)
	}

	override def createExample() {
		new Partido
	}

	// ********************************************************
	// ** Inicialización fixture
	// ********************************************************
	new() {
		this.init
	}

	def void init() {
		this.createIfNotExists(new Partido("Quilmes") => [
			agregarJugador(getJugador("Carolina"))
			agregarJugador(getJugador("Paula"))
			agregarJugador(getJugador("Esteban"))
			agregarJugador(getJugador("Juan"))
			agregarJugador(getJugador("Alejandro"))
			agregarJugador(getJugador("Pedro"))
			agregarJugador(getJugador("Maria"))
			agregarJugador(getJugador("Paula"))
			agregarJugador(getJugador("Carolina"))
			agregarJugador(getJugador("Alejandro"))
		])
		this.createIfNotExists(new Partido("Longchamps") => [
			agregarJugador(getJugador("Maria"))
			agregarJugador(getJugador("Esteban"))
		])
		this.createIfNotExists(new Partido("San Miguel")=> [
			agregarJugador(getJugador("Alejandro"))
			agregarJugador(getJugador("Pedro"))
		])
		this.createIfNotExists(new Partido("CABA") => [
			agregarJugador(getJugador("Esteban"))
			agregarJugador(getJugador("Paula"))
			agregarJugador(getJugador("Carolina"))
		])
		var jugadores = repoJugadores.allInstances
		for(Jugador jugador: jugadores){
			println(jugador.id + jugador.nombre)
		}

		var partidos = this.allInstances
		for (Partido partido : partidos){
			partido.update
		}
	}

	def getJugador(int id) {
		(ApplicationContext.instance.getSingleton(typeof(Jugador)) as RepositorioJugadores).get(id)
	}
	
	def repoJugadores(){
		(ApplicationContext.instance.getSingleton(typeof(Jugador)) as RepositorioJugadores)
	}
	
	def getJugador(String nombre) {
		(ApplicationContext.instance.getSingleton(typeof(Jugador)) as RepositorioJugadores).get(nombre)
	}
	

	
	def create(String localidad) {
		var partido = new Partido
		partido.localidad = localidad
		this.create(partido)
	}

	// ********************************************************
	// ** Altas y bajas
	// ********************************************************
	def createIfNotExists(String localidad) {
		println("Creando si no existe partido con localidad: " + localidad)
		var partido = new Partido(localidad)
		var partidoDB = this.get(localidad)
		if (partidoDB == null){
			this.create(partido)
			partidoDB = partido
			println("Partido en "+localidad+" fue creado")
		}else{
			println("Partido ya existente")
		}
		partidoDB
	}
	
	// REFACTORIZAR
	def createIfNotExists(Partido partido){
		println("Creando si no existe partido con localidad: " + partido.localidad)
		var partidoDB = this.get(partido.localidad)
		if (partidoDB == null){
			this.create(partido)
			partidoDB = partido
			println("Partido en "+partido.localidad+" fue creado")
		}else{
			println("Partido ya existente")
		}
		partidoDB
	}


	// ********************************************************
	// ** Búsquedas
	// ********************************************************

	def Partido get(String localidad) {
		for (Partido partidoDB: this.allInstances){
			if(partidoDB.localidad.equals(localidad)){
				return partidoDB;
			}
		}
		return null 
	}
	
	def updateMe(Partido partido) {
		this.get(partido.localidad).update
	}
	
}
