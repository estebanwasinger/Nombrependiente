package futbol5.ui

import futbol5.applicationModel.BusquedaJugadoresAppModel
import futbol5.domain.Jugador
import futbol5.homes.HomeJugadores
import org.uqbar.arena.bindings.DateAdapter
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable

@Observable
class BusquedaJugadoresWindow extends Dialog<BusquedaJugadoresAppModel>{
		
	new(WindowOwner parent, BusquedaJugadoresAppModel modelObject) {
		super(parent, modelObject)
	}
		
	override createContents(Panel mainPanel) {		
		title = "Busqueda de Jugadores"
		var panel2Columnas = new Panel(mainPanel)
		panel2Columnas.setLayout(new ColumnLayout(2))
		var panelIzquierda = new Panel(panel2Columnas) // divido la vista principal en dos paneles
		var panelDerecha = new Panel(panel2Columnas)
		new Label(panelIzquierda) => [
			text = "Busqueda" //le doy un titulo al panel izquierdo que va a contener los tipos de busqueda
			fontSize = 30
			]
		new Label(panelDerecha) => [
			text = "Resultados" //le doy un titulo al panel derecho que va a mostrar los resultados de la busqueda
			fontSize = 30
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
	
		var panelBusqueda = new Panel(panelIzquierda)
		panelBusqueda.setLayout(new ColumnLayout(2))
		var izquierda = new Panel(panelBusqueda)
		var derecha = new Panel(panelBusqueda)

		// Por nombre “comienza con” 
		var labelNombre = new Label(izquierda)
		labelNombre.fontSize = 10
		labelNombre.text = "Nombre comienza con.." 
		
		new TextBox(derecha)=>
			[bindValueToProperty("jugadorEjemplo.nombre")
			width = 200
			]
		
		//Por apodo “contiene” //	
		var labelApodo = new Label(izquierda)
		labelApodo.fontSize = 10
		labelApodo.text = "Apodo contiene..."

		new TextBox(derecha)=>
			[bindValueToProperty("jugadorEjemplo.apodo")
			width = 200]	
			
		// Búsqueda por fecha de nacimiento “anterior a” //
		var labelFecha = new Label(izquierda)
		labelFecha.setText = "Fecha de nacimiento menor a:" 
		labelFecha.fontSize = 10
		new TextBox(derecha) =>[
			withFilter(new DateTextFilter)
			bindValueToProperty("jugadorEjemplo.fechaNacimiento").transformer = new DateAdapter		
			]
			
		//Por rango desde/hasta del hándicap (puede ingresarse sólo desde, o sólo hasta) //
		var labelHandicap = new Label(izquierda)
		labelHandicap.fontSize = 10
		labelHandicap.text = "Handicap" 
		
		 new Selector(izquierda)=>[
			allowNull = false
			bindItems(new ObservableProperty(this, "eligeHandicap"))
			bindValueToProperty("tipoHandicap")
				]
		
		new TextBox(derecha)=>[
			bindValueToProperty("jugadorEjemplo.nivelDeJuego")
			width =20
			]	
		
		//Por rango desde/hasta del promedio de último partido //
		

		//Filtrar sólo los que tuvieron infracciones, sólo los que no tuvieron infracciones, todos //
		var labelInfraccion = new Label(izquierda)
		labelInfraccion.fontSize = 10
		labelInfraccion.text = "Infracciones" 

		new Selector(derecha)=>[
			allowNull = false
			bindItems(new ObservableProperty(this, "eligeInfracciones"))
			bindValueToProperty("jugadorEjemplo.infracciones")
		]
			
		new Button(panelBusqueda)
			.setCaption("Buscar")
			.onClick [ | modelObject.search(modelObject.jugadorEjemplo) ]
			.setFontSize(12)
			.setWidth = 200
			
		new Button(panelBusqueda) 
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
	
	def void grillaBasicaJugadores(Panel panelResultados){
		var table = new Table<Jugador>(panelResultados, typeof(Jugador))
		table.heigth = 360
		table.width = 590
		table.bindValueToProperty("jugadorSeleccionado")
		table.bindItemsToProperty("jugadores")
		
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
		
		var verDatos = new Button(panelResultados)
			.setCaption("Ver Datos Completos")
			.onClick [ | this.grillaCompletaJugador] 
			.setAsDefault
			.disableOnError
			.setWidth = 200
			
		var jugadorMarcado = new NotNullObservable("jugadorSeleccionado")
		verDatos.bindEnabled(jugadorMarcado)
	}
	
	def openDialog(Dialog<?> dialog) {
		dialog.onAccept[|]
		dialog.open
	}
	
	 def void grillaCompletaJugador(){
		this.openDialog(new VerDatosJugadorWindow(this, modelObject.jugadorSeleccionado))
	}

	def getEligeInfracciones() {
			#["Con Infracciones","Sin Infracciones","Todos"]
		}
		
	def getEligeHandicap() {
			#["Desde","Hasta"]
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
		
		def homeJugadores() {
		ApplicationContext::instance.getSingleton(typeof(Jugador)) as HomeJugadores
	}			
}
