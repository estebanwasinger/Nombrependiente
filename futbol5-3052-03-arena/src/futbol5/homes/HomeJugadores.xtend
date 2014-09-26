package futbol5.homes

import futbol5.auxUtils.InicializadorJugador
import futbol5.auxUtils.ModeloBusquedaHyP
import futbol5.domain.Jugador
import java.util.ArrayList
import java.util.List
import org.uqbar.commons.model.CollectionBasedHome

class HomeJugadores extends CollectionBasedHome<Jugador> {
	
	@Property var List <Jugador> jugadoresAceptados
	// SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");

	new() {
		this.init
	}

	def void init() {
 		jugadoresAceptados = new ArrayList<Jugador>
		jugadoresAceptados = InicializadorJugador.crearListaDejugadores(10)
	}
		
	def search(Jugador jugadorBuscado, ModeloBusquedaHyP modelo){ //Float hdesde, Float hhasta, int pdesde, int phasta) {
			jugadoresAceptados.filter[jugador|this.match(jugador,jugadorBuscado,modelo)].toList
	}
		
	def match(Jugador jugadorEnLista, Jugador jugadorBuscado, ModeloBusquedaHyP modelo){//Float hdesde, Float hhasta, int pdesde, int phasta) {
		matcheaNombre(jugadorEnLista,jugadorBuscado) && 
		matcheaApodo(jugadorEnLista,jugadorBuscado) &&
		matcheaFecha(jugadorEnLista,jugadorBuscado) &&
		matcheaHandicapMin(jugadorEnLista, modelo) &&
		matcheaHandicapMax(jugadorEnLista, modelo) && //hdesde, hhasta) &&
		matcheaPromedioMin(jugadorEnLista, modelo) && // pdesde, phasta)
		matcheaPromedioMax(jugadorEnLista, modelo)
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
	def matcheaHandicapMin (Jugador jugadorEnLista, ModeloBusquedaHyP modelo){ //Float hdesde, Float hhasta){
		Math.round(jugadorEnLista.nivelDeJuego) >= modelo.handicapDesde
		//modelo.handicapDesde <= modelo.handicapHasta
	}
	def matcheaHandicapMax(Jugador jugadorEnLista, ModeloBusquedaHyP modelo){
		Math.round(jugadorEnLista.nivelDeJuego) <= modelo.handicapHasta
	}
	def matcheaPromedioMin(Jugador jugadorEnLista, ModeloBusquedaHyP modelo){//int pdesde,int phasta){
		Math.round(jugadorEnLista.promedio) >= modelo.promedioDesde
	}
		def matcheaPromedioMax(Jugador jugadorEnLista, ModeloBusquedaHyP modelo){//int pdesde,int phasta){
		 Math.round(jugadorEnLista.promedio) <= modelo.promedioHasta
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