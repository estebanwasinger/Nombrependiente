package futbol5.ui

import futbol5.applicationModel.Futbol5
import futbol5.domain.Jugador
import org.uqbar.arena.bindings.DateAdapter
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.utils.Observable

@Observable
class BusquedaJugadoresWindow extends Dialog<Futbol5>{
		new(WindowOwner parent, Futbol5 modelObject) {
		super(parent, modelObject)
	}
	
	var jugador = new Jugador
		
	override createContents(Panel mainPanel) {
		
		title = "Busqueda de Jugadores"
		var panel2Columnas = new Panel(mainPanel)
		panel2Columnas.setLayout(new ColumnLayout(2))
		var panelIzquierda = new Panel(panel2Columnas) // divido la vista principal en dos paneles
		var panelDerecha = new Panel(panel2Columnas)
		new Label(panelIzquierda) => [
			text = "Busqueda" //le doy un titulo al panel izquierdo que va a contener los tipos de busqueda
			fontSize = 20
			]
		new Label(panelDerecha) => [
			text = "Resultados" //le doy un titulo al panel derecho que va a mostrar los resultados de la busqueda
			fontSize = 20
		]
		
		addActions(mainPanel) 
		createFormPanel(panelIzquierda)
		grillaBasicaJugadores(panelDerecha)
	}
	
	override protected addActions(Panel actionPanel) {
		actionPanel.layout = new HorizontalLayout
		new Button(actionPanel)
			.setCaption("Regresar")
			.onClick[|this.close]
	}
	
	
	override void createFormPanel(Panel panelIzquierda) {
		title = "Busqueda Jugador"

		panelIzquierda.layout = new VerticalLayout
		val busquedaSuperior = new Panel(panelIzquierda)
		busquedaSuperior.layout = new VerticalLayout
	
		criteriosDeBusqueda(busquedaSuperior)
	}
	
	def void criteriosDeBusqueda(Panel busquedaSuperior){
		
		// Por nombre “comienza con” //
		var labelNombre = new Label(busquedaSuperior)
		labelNombre.text = "Nombre Jugador" //hay que afinar el "comienza con"
		

		new TextBox(busquedaSuperior)=>
			[bindValueToProperty("jugadorEjemplo.nombre")
			width = 200]
		
		//Por apodo “contiene” //	
		var labelApodo = new Label(busquedaSuperior)
		labelApodo.text = "Apodo Jugador" //hay que afinar el "contiene"

		new TextBox(busquedaSuperior)=>
			[bindValueToProperty("jugadorEjemplo.apodo")
			width = 200]	
			
		// Búsqueda por fecha de nacimiento “anterior a” //
		new Label(busquedaSuperior).setText = "Fecha de nacimiento menor a:" 
		val textBoxFecha = new TextBox(busquedaSuperior)
		textBoxFecha.withFilter(new DateTextFilter)
		val binding = textBoxFecha.bindValueToProperty("fechaNacimiento")
		binding.transformer = new DateAdapter
		
			
			
		//Por rango desde/hasta del hándicap (puede ingresarse sólo desde, o sólo hasta) //

		var searchFormPanel = new Panel(busquedaSuperior)
		searchFormPanel.setLayout(new ColumnLayout(2))
		
		crearTextBox(busquedaSuperior, "Handicap desde", "busquedaJugadores.handicapDesde")
		crearTextBox(busquedaSuperior, "Handicap hasta", "busquedaJugadores.handicapHasta")
		
		//Por rango desde/hasta del promedio de último partido //
		//Filtrar sólo los que tuvieron infracciones, sólo los que no tuvieron infracciones, todos //
		var labelInfraccion = new Label(busquedaSuperior)
		labelInfraccion.text = "Infracciones" 

		new Selector(busquedaSuperior)=>[
			allowNull = false
			bindItems(new ObservableProperty(this, "eligeInfracciones"))
			bindValueToProperty("infracciones")
		]

			
		new Button(busquedaSuperior)
			.setCaption("Buscar")
			.onClick [ | modelObject.search(modelObject.jugadorEjemplo) ]
			.setFontSize(12)
			.setWidth = 200
			
		new Button(busquedaSuperior) 
			.setCaption("Limpiar")
			.onClick [ | modelObject.clear ]
			.setFontSize(12)
			.setWidth = 200
		
	}
		
		def crearTextBox(Panel searchFormPanel, String label, String binding) {
		var labelNumero = new Label(searchFormPanel)
		labelNumero.text = label
		val textBox = new TextBox(searchFormPanel)
		textBox.bindValueToProperty(binding)
	}
	
	def void grillaBasicaJugadores(Panel panelJugadores){
		var table = new Table<Jugador>(panelJugadores, typeof(Jugador))
		table.heigth = 360
		table.width = 590
		table.bindValueToProperty("jugadorSeleccionado")
		table.bindItemsToProperty("resultados")
		
		new Column<Jugador>(table) //
			.setTitle("Nombre")
			.setFixedSize(150)
			.bindContentsToProperty("nombre")
		new Column<Jugador>(table) //
			.setTitle("Apodo")
			.setFixedSize(150)
			.bindContentsToProperty("apodo")
		new Column<Jugador>(table) //
			.setTitle("Handicap")
			.setFixedSize(150)
			.bindContentsToProperty("nivelDeJuego")
		new Column<Jugador>(table) //
			.setTitle("Promedio")
			.setFixedSize(150)
			.bindContentsToProperty("promedio")
		
		var verDatos = new Button(panelJugadores)
			.setCaption("Ver Datos Completos")
			.onClick [ | this.grillaCompletaJugador] 
			.setAsDefault
			.disableOnError
			.setWidth = 200
			
		var jugadorMarcado = new NotNullObservable("jugadorSeleccionado")
		verDatos.bindEnabled(jugadorMarcado)
	}
	
	def openDialog(Dialog<?> dialog) {
		dialog.onAccept[|modelObject.search(jugador)]
		dialog.open
	}
	
	 def void grillaCompletaJugador(){
		this.openDialog(new VerDatosJugadorWindow(this, modelObject.jugadorSeleccionado))
	}

	def getEligeInfracciones() {
			#["Solo Infracciones","Solo No Infracciones","Todos"]
		}
}
class DateBox extends TextBox {
	new(Panel container) {
		super(container)
	}

	override bindValueToProperty(String propertyName) {
		val binding = super.bindValueToProperty(propertyName)
		this.withFilter(new DateTextFilter)
		binding
	}		
			
}
