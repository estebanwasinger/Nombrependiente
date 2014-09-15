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
		this.create("Burzaco")
		this.create("Adrogue")
		this.create("Bandfiel")
		this.create("Lomas de Zamora")
		this.create("Quilmes")
		this.create("Longchamps")
		this.create("San Miguel")
		this.createCompleto("Burzaco",crearListaDejugadores(10))
		this.createCompleto("Adrogue",crearListaDejugadores(10))
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
			jugadores.add(new Jugador)
			a = a + 1
	}
	return jugadores
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