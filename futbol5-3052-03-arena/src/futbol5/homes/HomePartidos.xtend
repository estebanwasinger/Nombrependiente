package futbol5.homes

import futbol5.domain.Partido
import org.uqbar.commons.model.CollectionBasedHome
import java.util.LinkedList
import java.util.List
import futbol5.domain.Jugador
import java.util.ArrayList
import calificaciones.Calificacion
import futbol5.aux.InicializadorJugador

class HomePartidos extends CollectionBasedHome<Partido> {
	
	@Property var List<Partido> partidos
	@Property var List<Jugador> jugadores
	
	new(){
		this.init
	}
	
	def void init(){
		partidos = new LinkedList<Partido>
		this.createCompleto("Burzaco",InicializadorJugador.crearListaDejugadores(10))
		this.createCompleto("Adrogue",InicializadorJugador.crearListaDejugadores(10))
		this.createCompleto("Bandfiel",InicializadorJugador.crearListaDejugadores(10))
		this.createCompleto("Lomas de Zamora",InicializadorJugador.crearListaDejugadores(10))
		this.createCompleto("Quilmes",InicializadorJugador.crearListaDejugadores(10))
		this.createCompleto("Longchamps",InicializadorJugador.crearListaDejugadores(10))
		this.createCompleto("San Miguel",InicializadorJugador.crearListaDejugadores(10))

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
	
	
	def search(Partido partidoBuscado) {
		if(partidoBuscado!=null){
		partidos.filter[partido|this.match(partido,partidoBuscado)].toList}else
		{init()}
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