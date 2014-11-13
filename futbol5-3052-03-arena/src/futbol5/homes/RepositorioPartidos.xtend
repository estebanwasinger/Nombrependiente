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
		this.createIfNotExists("Quilmes")
		this.createIfNotExists("Longchamps")
		this.createIfNotExists("San Miguel")
		this.createIfNotExists("CABA")
		this.get("CABA").agregarJugador(getJugador(1))
		this.get("CABA").agregarJugador(getJugador(3))
		this.get("CABA").agregarJugador(getJugador(6))
		this.get("San Miguel").agregarJugador(getJugador(1))
		this.get("San Miguel").agregarJugador(getJugador(2))
		this.get("Longchamps").agregarJugador(getJugador(6))
		this.get("Longchamps").agregarJugador(getJugador(8))
		this.get("Quilmes").agregarJugador(getJugador(9)) // a Quilmes se le agregan 10 jugadores para poder ordenar
		this.get("Quilmes").agregarJugador(getJugador(10))
		this.get("Quilmes").agregarJugador(getJugador(1))
		this.get("Quilmes").agregarJugador(getJugador(3))
		this.get("Quilmes").agregarJugador(getJugador(6))
		this.get("Quilmes").agregarJugador(getJugador(7))
		this.get("Quilmes").agregarJugador(getJugador(8))
		this.get("Quilmes").agregarJugador(getJugador(2))
		this.get("Quilmes").agregarJugador(getJugador(5))
		this.get("Quilmes").agregarJugador(getJugador(4))
										
	}

	def getJugador(Integer id) {
		(ApplicationContext.instance.getSingleton(typeof(Jugador)) as RepositorioJugadores).get(id)
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
}
