package futbol5.homes

import futbol5.domain.Partido
import org.uqbar.commons.utils.Observable
import uqbar.arena.persistence.PersistentHome

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
		this.createIfNotExists("Burzaco")
		this.createIfNotExists("Adrogue")
		this.createIfNotExists("Bandfiel")
		this.createIfNotExists("Lomas de Zamora")
		this.createIfNotExists("Quilmes")
		this.createIfNotExists("Longchamps")
		this.createIfNotExists("San Miguel")
		this.createIfNotExists("CABA")
	}

	def create(String localidad) {
		var partido = new Partido
		partido.localidad = localidad
		this.create(partido)
	}

	def getPartido(String partido) {
	}

	// ********************************************************
	// ** Altas y bajas
	// ********************************************************
	override create(Partido partido) {
		validarDuplicados(partido)
		super.create(partido)
	}

	def void validarDuplicados(Partido partido) {
	}

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
	/**
	 * Devuelve un celular en base al número (que no puede repetirse)
	 */
	def Partido get(Partido partido) {
		for (Partido partidoDB: this.allInstances){
			if(partidoDB.localidad.equals(partido.localidad)){
				return partidoDB;
			}
		}
		return null 
	}

	/**
	 * Hace la búsqueda de un celular únicamente por número
	 */
	def search(Integer numero) {
		this.search(numero, null)
	}

	def search(Integer unNumero, String unNombre) {

		//allInstances.filter[celular|this.match(numero, celular.numero) && this.match(nombre, celular.nombre)].toList
//		searchByExample(
//			new Celular => [
//				numero = unNumero
//				nombre = unNombre
//			])
	}

//	def match(Object expectedValue, Object realValue) {
//		if (expectedValue == null) {
//			return true
//		}
//		if (realValue == null) {
//			return false
//		}
//		realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase())
//	}
}
