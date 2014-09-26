package futbol5.homes

import futbol5.auxUtils.InicializadorJugador
import futbol5.auxUtils.ModeloBusquedaHyP
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
		
	def search(Jugador jugadorBuscado, ModeloBusquedaHyP modelo){ 
			jugadoresAceptados.filter[jugador|this.match(jugador,jugadorBuscado,modelo)].toList
	}
		
	def match(Jugador jugadorEnLista, Jugador jugadorBuscado, ModeloBusquedaHyP modelo){
		matcheaNombre(jugadorEnLista,jugadorBuscado) && 
		matcheaApodo(jugadorEnLista,jugadorBuscado) &&
		matcheaFecha(jugadorEnLista,jugadorBuscado) &&
		matcheaHandicapMin(jugadorEnLista, modelo) &&
		matcheaHandicapMax(jugadorEnLista, modelo) &&
		matcheaPromedioMin(jugadorEnLista, modelo) && 
		matcheaPromedioMax(jugadorEnLista, modelo) &&
		matcheaInfracciones(jugadorEnLista, modelo)
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
	def matcheaHandicapMin (Jugador jugadorEnLista, ModeloBusquedaHyP modelo){ 
		Math.round(jugadorEnLista.nivelDeJuego) >= modelo.handicapDesde
	}
	def matcheaHandicapMax(Jugador jugadorEnLista, ModeloBusquedaHyP modelo){
		Math.round(jugadorEnLista.nivelDeJuego) <= modelo.handicapHasta
	}
	def matcheaPromedioMin(Jugador jugadorEnLista, ModeloBusquedaHyP modelo){
		Math.round(jugadorEnLista.promedio) >= modelo.promedioDesde
	}
		def matcheaPromedioMax(Jugador jugadorEnLista, ModeloBusquedaHyP modelo){
		 Math.round(jugadorEnLista.promedio) <= modelo.promedioHasta
	}
		def matcheaInfracciones(Jugador jugadorEnLista,ModeloBusquedaHyP modelo ){
			if (modelo.infracciones == "Todos"){
				return true
			}else if (modelo.infracciones == "Con Infracciones"){
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