package futbol5.ui

import futbol5.applicationModel.BusquedaJugadoresAppModel
import futbol5.applicationModel.PartidosAppModel
import futbol5.domain.Jugador
import futbol5.domain.Partido
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.ObservableUtils
import org.uqbar.commons.utils.Observable

@Observable
class PartidosView extends SimpleWindow<PartidosAppModel> {

	new(WindowOwner parent) {
		super(parent, new PartidosAppModel)
	}

	override protected addActions(Panel panel) {
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Organizador de Futbol5"
		mainPanel.layout = new VerticalLayout
		new Label(mainPanel) => [
			text = "Futbol 5"
			fontSize = 20
			]
		var columns = new Panel(mainPanel) => [layout = new ColumnLayout(2)]
		var columnaIzq = new Panel(columns)
		var columnaDer = new Panel(columns) => [layout = new VerticalLayout ]
		
		crearTabla(columnaIzq)
			
		crearModuloPartidos(columnaDer)
		
		crearModuloJugadores(columnaDer)
		
	}
	
	protected def crearTabla(Panel columnaIzq) {
		new Label(columnaIzq) => [text = "Ultimos Partidos"
			fontSize = 15
		]
		new Table<Partido>(columnaIzq, typeof(Partido)) => [
			heigth = 200
			width = 150
			bindItemsToProperty("partidos")
			bindValueToProperty("partidoSeleccionado")
			new Column<Partido>(it).setTitle("Localidad").bindContentsToProperty("localidad")
			]
	}
	
	protected def crearModuloPartidos(Panel columnaDer) {
		new Label(columnaDer) => [
			text = "Partidos"
			fontSize = 15
		]
		new Button(columnaDer).setCaption("Generar Equipo") => [
			bindEnabled(new NotNullObservable("partidoSeleccionado"))
			onClick[|this.generarEquipo]
		]
		new Button(columnaDer).setCaption("Crear Partido").onClick[|this.crearPartido]
		
		new Button(columnaDer).setCaption("Agregar Jugador") => [
			bindEnabled(new NotNullObservable("partidoSeleccionado"))
			onClick[|this.agregarJugador]
		]
	}
	
	protected def crearModuloJugadores(Panel columnaDer) {
		new Label(columnaDer) => [
			text = "Jugadores"
			fontSize = 15
		]
		new Button(columnaDer).setCaption("Buscar Jugador").onClick[|this.buscarJugador]
		new Button(columnaDer).setCaption("Crear Jugador").onClick[|this.crearJugador]
	}
	
	def agregarJugador() {
		this.openWindow(new AgregarJugadorWindow(this, new BusquedaJugadoresAppModel, modelObject.partidoSeleccionado))
	}

	def void generarEquipo() {
		this.openWindow(new GenerarEquiposWindow(this, modelObject.partidoSeleccionado))
	}

	def void buscarJugador() {
		this.openWindow(new BusquedaJugadoresWindow(this, new BusquedaJugadoresAppModel))
	}
	
	def void crearPartido() {
		this.openWindow(new CrearPartidoWindow(this, new Partido, modelObject))
	}
	def crearJugador() {
		this.openWindow(new CrearJugadorWindow(this, new Jugador))
	}
	
	def openWindow(SimpleWindow<?> ventana) {
		ventana.open
	}
}
