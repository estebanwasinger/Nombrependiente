package futbol5.homes

import futbol5.auxUtils.InicializadorJugador
import futbol5.domain.Jugador
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.List
import org.uqbar.commons.model.CollectionBasedHome

class HomeJugadores extends CollectionBasedHome<Jugador> {
	
	@Property Float handicapDesde
	@Property Float handicapHasta 
	@Property var List <Jugador> jugadoresAceptados
	// SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");

	new() {
		this.init
	}

	def void init() {
 		jugadoresAceptados = new ArrayList<Jugador>
		jugadoresAceptados = InicializadorJugador.crearListaDejugadores(10)
		handicapDesde = new Float(0.0F)
		handicapHasta = new Float(0.0F)
	}
		
	def search(Jugador jugadorBuscado) {
			jugadoresAceptados.filter[jugador|this.match(jugador,jugadorBuscado)].toList
	}
		
	def match(Jugador jugadorEnLista, Jugador jugadorBuscado) {
		matcheaNombre(jugadorEnLista,jugadorBuscado) && 
		matcheaApodo(jugadorEnLista,jugadorBuscado) &&
		matcheaFecha(jugadorEnLista,jugadorBuscado) &&
		matcheaHandicap(jugadorEnLista)
	}

	def matcheaNombre(Jugador jugadorEnLista, Jugador jugadorBuscado){
		jugadorBuscado.nombre == null || jugadorEnLista.nombre.toLowerCase.startsWith(jugadorBuscado.nombre.toLowerCase)
	}
	def matcheaApodo(Jugador jugadorEnLista, Jugador jugadorBuscado){
		jugadorBuscado.apodo == null || jugadorEnLista.apodo.toLowerCase.contains(jugadorBuscado.apodo.toLowerCase)
	}
	def matcheaFecha(Jugador jugadorEnLista, Jugador jugadorBuscado){
		jugadorBuscado.fechaNacimiento == null ||jugadorBuscado.fechaNacimiento > jugadorEnLista.fechaNacimiento
	}	
	def matcheaHandicap (Jugador jugadorEnLista){
		(jugadorEnLista.nivelDeJuego > handicapDesde || jugadorEnLista.nivelDeJuego < handicapHasta) || 
		(jugadorEnLista.nivelDeJuego > handicapDesde && handicapHasta == 0.0F) ||
		(jugadorEnLista.nivelDeJuego < handicapHasta && handicapDesde == 0.0F)
	}
	
	def List<Jugador> getJugadores(){
		jugadoresAceptados
	}
	
	override def getEntityType() {
		typeof(Jugador)
	}

	override def createExample() {
	new Jugador
	}

	override def getCriterio(Jugador example) {
		null
	}	
	
}