package futbol5.homes

import auxiliares.RegistroRechazo
import calificaciones.Calificacion
import futbol5.domain.Jugador
import infracciones.Infraccion
import inscripciones.TipoInscripcion
import java.util.LinkedList
import java.util.List
import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable
import java.util.Date
import inscripciones.Estandarimport java.text.SimpleDateFormat

@Observable
class HomeJugadores extends CollectionBasedHome<Jugador> {
	
	@Property var List<Jugador> jugadoresAceptados
	@Property var List<RegistroRechazo> jugadoresRechazados
	@Property var LinkedList<Jugador> jugadoresRecomendados
	SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");

	new() {
		this.init
	}

	def void init() {
 		jugadoresAceptados = new LinkedList<Jugador>
		jugadoresRechazados = new LinkedList<RegistroRechazo>
		jugadoresRecomendados = new LinkedList<Jugador>
		
		this.create("Juan","Juani", 22, "14-04-1992")
		this.create("Maria","Juani", 23, "02-05-1991")
		this.create("Julian","Juani", 21, "19-09-1993")
		this.create("Julieta","Juani", 25, "14-04-1989")
		this.create("Jose","Juani", 19, "23-01-1995")
		this.create("Delfina","Juani", 22, "19-07-1992")
		this.create("Candelaria","Juani", 22, "20-07-1992")
		this.create("Martin","Juani", 17, "01-02-1997")
	}

	def void createJugadorCompleto(String nombre, TipoInscripcion tipoInscripcion, int edad, List<Infraccion> infracciones, List<Jugador> amigos, List <Calificacion> calificaciones,float nivelDeJuego,int criterioComparacion, String apodo, Date fechaDeNacimiento){
		var jugador = new Jugador
		jugador.nombre = nombre
		jugador.tipoInscripcion = tipoInscripcion
		jugador.edad = edad
		jugador.infracciones = infracciones
		jugador.amigos = amigos
		jugador.calificaciones = calificaciones
		jugador.nivelDeJuego = nivelDeJuego
		jugador.criterioComparacion = criterioComparacion
		jugador.apodo = apodo
		jugador.fechaNacimiento = fechaDeNacimiento
		
		jugadoresAceptados.add(jugador)
	}
	
		
	def void create(String nombre,String apodo, int edad, String fechaDeNacimientoStr){
		var jugador = new Jugador
		jugador.nombre = nombre
		jugador.apodo = apodo
		jugador.edad = edad
		jugador.fechaNacimiento = formateador.parse(fechaDeNacimientoStr)	
		
		jugadoresAceptados.add(jugador)
	}
		
	def void agregarAceptado(Jugador jugador){
		jugadoresAceptados.add(jugador)
	}
	
	def List<Jugador> getJugadores(){
		jugadoresAceptados
	}
	
	def search(Jugador jugadorBuscado) {
		jugadoresAceptados.filter[jugador|jugador.matchea(jugadorBuscado)].toList
	}
	
	/*def match(Jugador jugadorEnLista, Jugador jugadorBuscado) {
		matcheaNombre(jugadorEnLista,jugadorBuscado) && 
		matcheaApodo(jugadorEnLista,jugadorBuscado) &&
		!esMenorAnioNacimiento(jugadorEnLista,jugadorBuscado)
	}
	
	def matcheaNombre( Jugador jugadorEnLista, Jugador jugadorBuscado){
	jugadorBuscado.nombre == null || jugadorEnLista.nombre.toLowerCase.startsWith(jugadorBuscado.nombre.toLowerCase)
	}
	def matcheaApodo( Jugador jugadorEnLista, Jugador jugadorBuscado){
		jugadorBuscado.apodo == null || jugadorEnLista.apodo.toLowerCase.contains(jugadorBuscado.apodo.toLowerCase)
	}
	def esMenorAnioNacimiento( Jugador jugadorEnLista, Jugador jugadorBuscado){
		jugadorBuscado.fechaNacimiento == null || jugadorBuscado.fechaNacimiento < jugadorEnLista.fechaNacimiento
	}*/
	

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