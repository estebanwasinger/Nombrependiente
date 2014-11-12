package futbol5.homes

import futbol5.domain.Partido
import org.uqbar.commons.utils.Observable
import uqbar.arena.persistence.PersistentHome
import futbol5.domain.Jugador
import java.util.List
import calificaciones.Calificacion
import java.util.ArrayList

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
//		this.createIfNotExists("Burzaco")
//		this.createIfNotExists("Adrogue")
//		this.createIfNotExists("Bandfiel")
//		this.createIfNotExists("Lomas de Zamora")
//		this.createIfNotExists("Quilmes")
//		this.createIfNotExists("Longchamps")
//		this.createIfNotExists("San Miguel")
		this.createIfNotExists("CABA")
		var part = this.get(new Partido("CABA"));
		part.agregarJugador(new Jugador("Esteban","El champ",5,new ArrayList<Calificacion>))
		part.agregarJugador(new Jugador("Esteban","El champ",5,new ArrayList<Calificacion>))
		part.agregarJugador(new Jugador("Esteban","El champ",5,new ArrayList<Calificacion>))
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
		var partidoDB = this.get(partido)
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

	def Partido get(Partido partido) {
		for (Partido partidoDB: this.allInstances){
			if(partidoDB.localidad.equals(partido.localidad)){
				return partidoDB;
			}
		}
		return null 
	}
}
