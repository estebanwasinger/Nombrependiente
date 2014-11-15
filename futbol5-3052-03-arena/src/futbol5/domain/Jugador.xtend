package futbol5.domain

import calificaciones.Calificacion
import excepciones.BusinessException
import infracciones.Infraccion
import inscripciones.Estandar
import inscripciones.TipoInscripcion
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date
import java.util.HashSet
import java.util.LinkedList
import java.util.List
import java.util.Set
import org.uqbar.commons.model.Entity
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable
import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField
import uqbar.arena.persistence.annotations.Relation

@Observable
@PersistentClass
class Jugador extends Entity{

	@Property String nombre
	@Property String apodo
	@Property int edad
	@Property Date fechaNacimiento
	@Property String email
	@Property TipoInscripcion tipoInscripcion
	@Property List<Infraccion> infracciones
	@Property List<Jugador> amigos
	@Property List <Calificacion> calificaciones
	@Property float nivelDeJuego 
	@Property int criterioComparacion
	@Property int cantidadPartidos
	SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
	
	@PersistentField
	def getNombre(){
		_nombre
	}
	
	def void setNombre(String nombre){
		_nombre = nombre
	}
	
	@PersistentField
	def getApodo(){
		_apodo
	}
	
	def void setApodo(String apodo){
		_apodo = apodo
	}
	
	def setapodo(String apodo){
		_apodo = apodo
	}
	
	@PersistentField
	def getNivelDeJuego(){
		_nivelDeJuego
	}
	
	def setNivelDeJuego(Integer nivel){
		_nivelDeJuego = nivel
	}
	
	@Relation
	def getCalificaciones(){
		_calificaciones
	}
	
	def setCalificaciones(ArrayList<Calificacion> calificaciones){
		_calificaciones = calificaciones
	}
	
	@Relation
	def getAmigos(){
		_amigos
	}
	
	def setAmigos(ArrayList<Jugador> amigos){
		_amigos = amigos
	}
	
	@Relation
	def getInfracciones(){
		_infracciones
	}
	
	def setInfracciones(ArrayList<Infraccion> infracciones){
		_infracciones = infracciones
	}
	
	@PersistentField
	def getFechaNacimiento(){
		_fechaNacimiento
	}
	
	def void setFechaNacimiento(Date fecha){
		_fechaNacimiento = fecha
	}
	
	
	
	new() {
		init
	}

	new(String nombre,String apodo, int edad, String fechaDeNacimientoStr, float nivelDeJuego, List<Jugador> amigos, ArrayList <Calificacion> calificaciones, int cantidadPartidos){
		init
		this.nombre = nombre
		this.apodo = apodo
		this.edad = edad
		if(fechaDeNacimientoStr!= null){
		this.fechaNacimiento = formateador.parse(fechaDeNacimientoStr)}
		this.nivelDeJuego= nivelDeJuego
		this.amigos=amigos
		this.calificaciones= calificaciones
		this.cantidadPartidos=cantidadPartidos
	}
	
	new(String nombre, String apodo, float handicap, List<Calificacion>calificaciones){
		init
		this.nombre = nombre
		this.apodo = apodo
		this.nivelDeJuego = handicap
		//this.calificaciones = calificaciones
	}
	
	new(Integer id, String nombre, String apodo, float handicap, List<Calificacion>calificaciones){
		//init
		this.id = id
		this.nombre = nombre
		this.apodo = apodo
		this.nivelDeJuego = handicap
		this.calificaciones = calificaciones
	}
	
	def init(){
		tipoInscripcion = new Estandar
		amigos = new ArrayList<Jugador>
		infracciones = new ArrayList<Infraccion>
		calificaciones = new LinkedList<Calificacion>
	}
	
	def validarNombre() {
		if (nombre == null) {
			throw new UserException("El jugador no puede tener nombre nulo")
		}
	}
	
	
	def agregarAmigo(Jugador jugador) {
		this.amigos.add(jugador)
	}
	
	def boolean menorA (int edad) {
		this.edad < edad
	}

	def tieneMasPrioridadQue(Jugador jugador) {
		this.prioridad < jugador.prioridad
	}

	def int prioridad() {
		tipoInscripcion.prioridad()
	}
	
	def float promedioCalificacionesUltimoPartido() {
		promedioNPartidos(1)
	}
	
	def void agregarInfraccion(Infraccion infraccion){
		infracciones.add(infraccion)
	}

	def float promedioNPartidos(int n) {
		if (calificaciones.size != 0){
		var int calificacionTotal
		var Set<Partido> partidos = new HashSet<Partido>
		var int pos = 0;
		while (partidos.size <= n && pos < calificaciones.size) {
			partidos.add(calificaciones.get(pos).partido)
			pos= pos +1
		}
		pos = 0
		while (pos < partidos.size) {
			calificacionTotal = calificacionTotal + promedioDeUnPartido(partidos.get(pos))
			pos= pos +1
		}

		return calificacionTotal / partidos.size
		}
		return 0
		}
		
	def promedioDeUnPartido(Partido partido){
		var calificacionesUltimoPartido = calificaciones.filter[calificacion|calificacion.partido== partido]
		var sumaCalificaciones = calificacionesUltimoPartido.map[calificacion|calificacion.nota].reduce[a, b|a + b]
		return (sumaCalificaciones / calificacionesUltimoPartido.size);
	}
	
	def getPromedio(){
		var int promedio
		var i = 0
		while(i < calificaciones.size){
			promedio = calificaciones.get(0).nota
			i = i+1
		}
		promedio = promedio/calificaciones.size
	}
	
	def getPromedioUltimoPartido(){
		Math.round(this.promedioNPartidos(this.cantidadPartidos))
	}
	
	def getFechaNacimientoString(){
		formateador.format(fechaNacimiento)
	}
	
	def setFechaNacimientoString(String fecha){
		fechaNacimiento = formateador.parse(fecha)
	}

			
	/*******************************/
	/****CASO DE USO: CALIFICACIONES ****/
	/*******************************/
		def calificar (Partido partido, int nota, String critica){
		
		if (!partido.estaInscripto(this)){
				throw new BusinessException("El jugador que se quiere calificar no jugo el partido indicado")
				}
		calificaciones.add(new Calificacion(this, partido, nota, critica))
	}
		
}
