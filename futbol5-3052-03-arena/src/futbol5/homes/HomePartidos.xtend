package futbol5.homes

import futbol5.domain.Partido
import org.uqbar.commons.model.CollectionBasedHome
import java.util.LinkedList
import java.util.List
import futbol5.domain.Jugador
import java.util.ArrayList

class HomePartidos extends CollectionBasedHome<Partido> {
	
	@Property var List<Partido> partidos
	@Property var List<Jugador> jugadores
	
	new(){
		this.init
	}
	
	def void init(){
		partidos = new LinkedList<Partido>
		this.createCompleto("Burzaco",crearListaDejugadores(10))
		this.createCompleto("Adrogue",crearListaDejugadores(10))
		this.createCompleto("Bandfiel",crearListaDejugadores(10))
		this.createCompleto("Lomas de Zamora",crearListaDejugadores(10))
		this.createCompleto("Quilmes",crearListaDejugadores(10))
		this.createCompleto("Longchamps",crearListaDejugadores(10))
		this.createCompleto("San Miguel",crearListaDejugadores(10))

	}
	
	def create(String localidad){
		var partido = new Partido
		partido.localidad=localidad
		partidos.add(partido)
	}
	
	def createCompleto(String localidad, List<Jugador> jugadores){
		var partido = new Partido
		partido.localidad=localidad
		partido.jugadores=jugadores
		partidos.add(partido)
	}
	
	def crearListaDejugadores(int max){
		var int a = 0
		jugadores = new ArrayList<Jugador>
		while (a < max) {
			jugadores.add(new Jugador("Carolina"))
			a = a + 1
	}
	return jugadores
	}
	
	def search(Partido partidoBuscado) {
		partidos.filter[partido|this.match(partido,partidoBuscado)].toList
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