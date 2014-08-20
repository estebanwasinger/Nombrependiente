
package materias.ui

import java.util.List
import materias.applicationModel.SeguidorCarrera
import materias.domain.Materia
import materias.domain.Nota
import materias.home.HomeMaterias
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable

@Observable
class SeguidorCarreraWindow extends MainWindow<SeguidorCarrera> {
	
	val posiblesUbicaciones = #["Nivel 1 - 1er. Cuatrimestre",
								"Nivel 1 - 2do. Cuatrimestre",
								"Nivel 1 - Anual",
								"Nivel 2 - 1er. Cuatrimestre",
								"Nivel 2 - 2do. Cuatrimestre",
								"Nivel 2 - Anual",
								"Nivel 3 - 1er. Cuatrimestre",
								"Nivel 3 - 2do. Cuatrimestre",
								"Nivel 3 - Anual",
								"Nivel 4 - 1er. Cuatrimestre",
								"Nivel 4 - 2do. Cuatrimestre",
								"Nivel 4 - Anual",
								"Nivel 5 - 1er. Cuatrimestre",
								"Nivel 5 - 2do. Cuatrimestre",
								"Nivel 5 - Anual"]
	@Observable							
	override createContents(Panel mainPanel) {
		
		title = "Seguidor de carrera"
		new ErrorsPanel(mainPanel,"Seguidor OK")
		var panel2Columnas = new Panel(mainPanel)
		panel2Columnas.setLayout(new ColumnLayout(2))
		var panelIzquierda = new Panel(panel2Columnas)
		var panelDerecha = new Panel(panel2Columnas)
		new Label(panelIzquierda) => [
			text = "Seguidor de Carreras"
			fontSize = 20
		]
		var panelBotones = new Panel(panelIzquierda).setLayout(new HorizontalLayout)
		addActions(panelBotones)
		createFormPanel(panelIzquierda)
		grillaDeMaterias(panelIzquierda) 
		panelEdicionMateria(panelDerecha)
		grillaDeNotas(panelDerecha)
	}
	def static main(String[] args) {
		ApplicationContext.instance.configureSingleton(typeof(Materia), new HomeMaterias)
		new SeguidorCarreraWindow().startApplication
	}

	def asObjects(List<?> list) {
		list.map[it as Object]
	}
	
	def getUbicacionesPosibles(){
		posiblesUbicaciones.asObjects
	}

	new() {
		super(new SeguidorCarrera)
		modelObject.search()
	}
	
	
	def void grillaDeNotas(Panel mainPanel){
		var table = new Table<Nota>(mainPanel, typeof(Nota))
		table.heigth = 150
		table.width = 400
		table.bindItemsToProperty("materiaSeleccionada.notas")
		table.bindValueToProperty("notaSeleccionada")
		new Column<Nota>(table) 
			.setTitle("Fecha")
			.bindContentsToProperty("fecha")
			
		new Column<Nota>(table) 
			.setTitle("Descripcion")
			.bindContentsToProperty("descripcion")
			
		new Column<Nota>(table) 
			.setTitle("Aprobado")
			.bindContentsToTransformer([nota | if (nota.aprobado) "SI" else "NO"])
			
}
	def void panelEdicionMateria(Panel mainPanel){
		
		var panelEdicionColumnas = new Panel(mainPanel)
		panelEdicionColumnas.setLayout(new ColumnLayout(2))
		
		new Label(panelEdicionColumnas).setText("Materia:")
		new Label(panelEdicionColumnas) =>[
			bindValueToProperty("materiaSeleccionada.nombre")
			width = 200
			fontSize = 15
			]
		
		new Label(panelEdicionColumnas).setText("Profesor")
		new TextBox(panelEdicionColumnas)=>[
			bindValueToProperty("materiaSeleccionada.profesor")
			width = 200
			fontSize = 10
			]
		
		new Label(panelEdicionColumnas).setText("Año de cursada")
		new TextBox(panelEdicionColumnas)=>[
			bindValueToProperty("materiaSeleccionada.anioCursada")
			width = 200
			fontSize = 10
			]
		// este check DEBERIA habilitarse solo si estan cargadas las 3 notas con Aprobado en SI (validacion!)
		//se debe modificar despues de agregar la grilla o tabla de notas
		
		new Label(panelEdicionColumnas).setText = ("Final Aprobado")
		var checkAprobado = new CheckBox(panelEdicionColumnas)
		checkAprobado.bindValueToProperty("materiaSeleccionada.finalAprobado")
		
		new Label(panelEdicionColumnas).text = ("Ubicacion Materia")
		new Selector(panelEdicionColumnas) => [
			allowNull = false
			bindItems(new ObservableProperty(this, "ubicacionesPosibles"))
			bindValueToProperty("materiaSeleccionada.ubicacion")
		]
		
		var panelBotonesNotas = new Panel(mainPanel).layout = new HorizontalLayout()
		var edicionNota = new Button(panelBotonesNotas)
			.setCaption("Editar Nota")
			.onClick [ | this.editarNota] 
			.setAsDefault
			.disableOnError
			.setFontSize(9)
			
		var nuevaNota = new Button(panelBotonesNotas)
			.setCaption("Agregar Nota")
			.onClick [ | this.cargarNota] 
			.setAsDefault
			.disableOnError
			.setFontSize(9)
				
		var notaMarcada = new NotNullObservable("notaSeleccionada")
		edicionNota.bindEnabled(notaMarcada)
		
		var materiaMarcada = new NotNullObservable("materiaSeleccionada")
		nuevaNota.bindEnabled(materiaMarcada)
					
		new Label(mainPanel).setText = ("Notas de Cursada")
			
	}
	
	
	// *************************************************************************
	// * FORMULARIO DE BUSQUEDA
	// *************************************************************************
	/**
	 * El panel principal de búsuqeda permite filtrar por número o nombre
	 */
	def void createFormPanel(Panel mainPanel) {
		var searchFormPanel = new Panel(mainPanel)
		searchFormPanel.setLayout(new ColumnLayout(2))

		var labelNombre = new Label(searchFormPanel)
		labelNombre.text = "Nombre de materia"


		new TextBox(searchFormPanel)=>
			[bindValueToProperty("nombre")
			width = 200
			]
	}

	def addActions(Panel actionsPanel) {

		new Button(actionsPanel)
			.setCaption("Buscar")
			.onClick [ | modelObject.search ] 
			.setAsDefault
			.disableOnError
			.setFontSize(12)

		new Button(actionsPanel) 
			.setCaption("Limpiar")
			.onClick [ | modelObject.clear ]
			.setFontSize(12)
			
		new Button(actionsPanel) //
			.setCaption("Nueva Materia")
			.onClick [ | this.crearMateria ]
			.setFontSize(12)
						
	}

	//***************************************
	//**    Resultado busqueda materias    **
	//***************************************
	def protected grillaDeMaterias(Panel mainPanel) {
		var table = new Table<Materia>(mainPanel, typeof(Materia))
		table.heigth = 230 //mismo valor que la columna para que sea una sola (columna)
		table.width = 300
		table.bindItemsToProperty("resultados")
		table.bindValueToProperty("materiaSeleccionada")
		this.describeResultsGrid(table)
		
	}
	
	def void describeResultsGrid(Table<Materia> table) {
		new Column<Materia>(table) //
			.setTitle("Nombre")
			.setFixedSize(450)
			.bindContentsToProperty("nombre")
	}	
		
	// *******************************
	// **          Acciones         **
	// *******************************
	def void crearMateria() {
		this.openDialog(new CrearMateriaWindow(this))
	}

	def openDialog(Dialog<?> dialog) {
		dialog.onAccept[|modelObject.search]
		dialog.open
	}
	
	 def void editarNota(){
		this.openDialogNota(new EditarNotaWindow(this, modelObject.notaSeleccionada))
	}
	
	def void cargarNota(){
		this.openDialogNota(new CrearNotaWindow(this, new Nota,modelObject.materiaSeleccionada))
	}

	
	def openDialogNota(Dialog<?> dialog){
		dialog.onAccept[|modelObject.buscar]
		dialog.open
	}	
	
}
