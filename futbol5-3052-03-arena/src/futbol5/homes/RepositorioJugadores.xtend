package futbol5.homes

import uqbar.arena.persistence.PersistentHome
import org.uqbar.commons.utils.Observable
import futbol5.domain.Jugador
import java.util.ArrayList
import calificaciones.Calificacion
import java.util.List

@Observable
class RepositorioJugadores extends PersistentHome<Jugador> {

	new() {
		this.init
	}

	def void init() {
		this.createIfNotExists(1, "Esteban", "El champ", 5, new ArrayList<Calificacion>)
		this.createIfNotExists(2, "Carolina", "Caro", 8, new ArrayList<Calificacion>)
		this.createIfNotExists(3, "Paula", "Pau", 2, new ArrayList<Calificacion>)
		this.createIfNotExists(4, "Juan", "Fantasma", 1, new ArrayList<Calificacion>)
		this.createIfNotExists(5, "Alejandro", "Ale", 9, new ArrayList<Calificacion>)
		this.createIfNotExists(6, "Juan", "L", 1, new ArrayList<Calificacion>)
		this.createIfNotExists(7, "Alejandro", "Pepep", 9, new ArrayList<Calificacion>)
		this.createIfNotExists(8, "Pedro", "El loco", 1, new ArrayList<Calificacion>)
		this.createIfNotExists(9, "Maria", "La Mary", 9, new ArrayList<Calificacion>)
		this.createIfNotExists(10, "Alberto", "Perro", 1, new ArrayList<Calificacion>)
		this.createIfNotExists(11, "Santiago", "Santi", 9, new ArrayList<Calificacion>)
		this.createIfNotExists(12, "Florencia", "Florcita", 1, new ArrayList<Calificacion>)
		this.createIfNotExists(13, "Martin", "Tin", 9, new ArrayList<Calificacion>)
	}

	def createIfNotExists(Integer idJ, String nombreJ, String apodoJ, float nivelDeJuegoJ, ArrayList<Calificacion> calificacionesJ) {
		println("Creando si no existe jugador con id: " + idJ)
		var jugador = new Jugador (idJ, nombreJ, apodoJ, nivelDeJuegoJ, calificacionesJ)
		var jugadorDB = this.get(idJ)
		if (jugadorDB== null) {
					this.create(jugador)
					jugadorDB =jugador
					println("Jugador con id "+idJ+" fue creado")
		}else{
				println("Jugador ya existente")
		}
		jugadorDB
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
