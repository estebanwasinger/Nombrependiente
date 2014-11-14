package futbol5.homes

import uqbar.arena.persistence.PersistentHome
import org.uqbar.commons.utils.Observable
import futbol5.domain.Jugador
import java.util.ArrayList
import calificaciones.Calificacion
import java.util.List
import org.uqbar.commons.utils.ApplicationContext
import infracciones.Infraccion

@Observable
class RepositorioJugadores extends PersistentHome<Jugador> {

	new() {
		this.init
	}

	def void init() {
		this.createIfNotExists(new Jugador("Paula","Pau",9,new ArrayList<Calificacion>) => [calificaciones.add(repoCal.createCal(new Calificacion(9))) infracciones.add(repoInf.createInfraccion(new Infraccion))])
		this.createIfNotExists(new Jugador("Esteban","quito",6,new ArrayList<Calificacion>) => [calificaciones.add(repoCal.createCal(new Calificacion(9))) infracciones.add(repoInf.createInfraccion(new Infraccion))])
		this.createIfNotExists(new Jugador("Carolina","Caro",10,new ArrayList<Calificacion>) => [calificaciones.add(repoCal.createCal(new Calificacion(9))) infracciones.add(repoInf.createInfraccion(new Infraccion))])
		this.createIfNotExists(new Jugador("Juan","Fantasma",5,new ArrayList<Calificacion>) => [calificaciones.add(repoCal.createCal(new Calificacion(9))) infracciones.add(repoInf.createInfraccion(new Infraccion))])
		this.createIfNotExists(new Jugador("Alejandro","Pepe",2,new ArrayList<Calificacion>) => [calificaciones.add(repoCal.createCal(new Calificacion(9))) infracciones.add(repoInf.createInfraccion(new Infraccion))])
		this.createIfNotExists(new Jugador("Pedro","El Loco",5,new ArrayList<Calificacion>) => [calificaciones.add(repoCal.createCal(new Calificacion(9))) infracciones.add(repoInf.createInfraccion(new Infraccion))])
		this.createIfNotExists(new Jugador("Maria","La Mary",4,new ArrayList<Calificacion>) => [calificaciones.add(repoCal.createCal(new Calificacion(9))) infracciones.add(repoInf.createInfraccion(new Infraccion))])
		this.createIfNotExists(new Jugador("Alberto","Perro",5,new ArrayList<Calificacion>) => [calificaciones.add(repoCal.createCal(new Calificacion(9))) infracciones.add(repoInf.createInfraccion(new Infraccion))])
		this.createIfNotExists(new Jugador("Santiago","Santi",3,new ArrayList<Calificacion>) => [calificaciones.add(repoCal.createCal(new Calificacion(9))) infracciones.add(repoInf.createInfraccion(new Infraccion))])
		this.createIfNotExists(new Jugador("Florencia","Florcita",5,new ArrayList<Calificacion>) => [calificaciones.add(repoCal.createCal(new Calificacion(9))) infracciones.add(repoInf.createInfraccion(new Infraccion))])
		this.createIfNotExists(new Jugador("Martin","Tin",5,new ArrayList<Calificacion>) => [calificaciones.add(repoCal.createCal(new Calificacion(9))) infracciones.add(repoInf.createInfraccion(new Infraccion))])
		
		var jugadores = this.allInstances
		for (Jugador jugador : jugadores){
			jugador.update
		}
	}

	def repoCal(){
		ApplicationContext.instance.getSingleton(typeof(Calificacion)) as RepositorioCalificaciones
	}
	
	def repoInf(){
		ApplicationContext.instance.getSingleton(typeof(Infraccion)) as RepositorioInfracciones
	}

	def createIfNotExists(String nombreJ, String apodoJ, float nivelDeJuegoJ, ArrayList<Calificacion> calificacionesJ) {
		println("Creando si no existe jugador con id: "+nombreJ)
		var jugador = new Jugador ( nombreJ, apodoJ, nivelDeJuegoJ, calificacionesJ)
		var jugadorDB = this.get(nombreJ)
		if (jugadorDB== null) {
					this.create(jugador)
					jugadorDB =jugador
					println("Jugador con id "+nombreJ+" fue creado")
		}else{
				println("Jugador ya existente")
		}
		jugadorDB
	}
	
	def createIfNotExists(Jugador jugador) {
		println("Creando si no existe jugador con id: "+jugador.nombre)
		var jugadorDB = this.get(jugador.nombre)
		if (jugadorDB== null) {
					this.create(jugador)
					jugadorDB =jugador
					println("Jugador con id "+jugador.nombre+" fue creado")
		}else{
				println("Jugador ya existente")
		}
		jugadorDB
	}

	def List<Jugador> getJugadores() {
		allInstances
	}

	def Jugador get(String nombre) {
		for (Jugador jugadorDB: this.allInstances){
			if(jugadorDB.nombre.equals(nombre)){
				return jugadorDB;
			}
		}
		return null 
	}
	
	def Jugador get(int id) {
		for (Jugador jugadorDB: this.allInstances){
			if(jugadorDB.nombre.equals(id)){
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
