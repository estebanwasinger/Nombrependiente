package futbol5.homes

import futbol5.auxUtils.InicializadorJugador
import futbol5.domain.Jugador
import futbol5.domain.Partido
import java.util.List
import org.uqbar.commons.model.CollectionBasedHome

class HomePartidos extends CollectionBasedHome<Partido> {

	new() {
		this.init
	}

	def void init() {
		this.createCompleto("Burzaco", InicializadorJugador.crearListaDejugadores(10))
		this.createCompleto("Adrogue", InicializadorJugador.crearListaDejugadores(10))
		this.createCompleto("Bandfiel", InicializadorJugador.crearListaDejugadores(10))
		this.createCompleto("Lomas de Zamora", InicializadorJugador.crearListaDejugadores(10))
		this.createCompleto("Quilmes", InicializadorJugador.crearListaDejugadores(10))
		this.createCompleto("Longchamps", InicializadorJugador.crearListaDejugadores(10))
		this.createCompleto("San Miguel", InicializadorJugador.crearListaDejugadores(10))
	}

	def create(String localidad) {
		var partido = new Partido
		partido.localidad = localidad
		this.create(partido)
	}

	def createCompleto(String localidad, List<Jugador> jugadores) {
		var partido = new Partido
		partido.localidad = localidad
		partido.jugadores = jugadores
		this.create(partido)
	}

	def search(Partido partidoBuscado) {
		if (partidoBuscado != null) {
			allInstances.filter[partido|this.match(partido, partidoBuscado)].toList
		} else {
			init()
		}
	}

	def match(Partido partido, Partido partidoBuscado) {
		if (partido.localidad == null) {
			return true
		}
		if (partidoBuscado.localidad == null) {
			return false
		}
		partidoBuscado.localidad.toString().toLowerCase().contains(partido.localidad.toString().toLowerCase())
	}

	override protected getCriterio(Partido example) {
		null
	}

	override createExample() {
		new Partido
	}

	override getEntityType() {
		typeof(Partido)
	}

}
