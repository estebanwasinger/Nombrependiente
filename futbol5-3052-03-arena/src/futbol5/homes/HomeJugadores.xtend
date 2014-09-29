package futbol5.homes

import futbol5.applicationModel.BusquedaJugadoresAppModel
import futbol5.auxUtils.InicializadorJugador
import futbol5.domain.Jugador
import java.util.ArrayList
import java.util.List
import org.uqbar.commons.model.CollectionBasedHome

class HomeJugadores extends CollectionBasedHome<Jugador> {
	
	@Property var List <Jugador> jugadoresAceptados

	new() {
		this.init
	}

	def void init() {
 		jugadoresAceptados = new ArrayList<Jugador>
		jugadoresAceptados = InicializadorJugador.crearListaDejugadores(10)
		jugadoresAceptados.get(3).infracciones.clear
		jugadoresAceptados.get(5).infracciones.clear
	}
		
	def search(BusquedaJugadoresAppModel modelo){ 
			jugadoresAceptados.filter[jugador|this.match(jugador,modelo)].toList
	}
		
	def match(Jugador jugadorEnLista, BusquedaJugadoresAppModel modelo){
		matcheaNombre(jugadorEnLista,modelo.jugadorEjemplo) && 
		matcheaApodo(jugadorEnLista,modelo.jugadorEjemplo) &&
		matcheaFecha(jugadorEnLista,modelo.jugadorEjemplo) &&
		modelo.metodoHandicap.calcular(jugadorEnLista, modelo.handicap)&&
		matcheaPromedioMin(jugadorEnLista, modelo.promedioDesde) && 
		matcheaPromedioMax(jugadorEnLista, modelo.promedioHasta) &&
		matcheaInfracciones(jugadorEnLista, modelo.infracciones)
	}

	def matcheaNombre(Jugador jugadorEnLista, Jugador jugadorBuscado){
		jugadorBuscado.nombre == null || jugadorEnLista.nombre.toLowerCase.startsWith(jugadorBuscado.nombre.toLowerCase)
	}
	def matcheaApodo(Jugador jugadorEnLista, Jugador jugadorBuscado){
		jugadorBuscado.apodo == null || jugadorEnLista.apodo.toLowerCase.contains(jugadorBuscado.apodo.toLowerCase)
	}
	def matcheaFecha(Jugador jugadorEnLista, Jugador jugadorBuscado){
		jugadorBuscado.fechaNacimiento == null ||jugadorBuscado.fechaNacimiento >= jugadorEnLista.fechaNacimiento
	}	
	def matcheaHandicapMin (Jugador jugadorEnLista, int handicapDesde){ 
		Math.round(jugadorEnLista.nivelDeJuego) >= handicapDesde
	}
	def matcheaHandicapMax(Jugador jugadorEnLista, int handicapHasta){
		Math.round(jugadorEnLista.nivelDeJuego) <= handicapHasta
	}
	def matcheaPromedioMin(Jugador jugadorEnLista, int promedioDesde){
		Math.round(jugadorEnLista.promedio) >= promedioDesde
	}
		def matcheaPromedioMax(Jugador jugadorEnLista, int promedioHasta){
		 Math.round(jugadorEnLista.promedio) <= promedioHasta
	}
		def matcheaInfracciones(Jugador jugadorEnLista, String infracciones ){
			if (infracciones == "Todos"){
				return true
			}else if (infracciones == "Con Infracciones"){
						!jugadorEnLista.infracciones.empty
			}else jugadorEnLista.infracciones.empty
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