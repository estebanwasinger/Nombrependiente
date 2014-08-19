
package materias.ui

import java.awt.Color
import java.util.List
import materias.applicationModel.SeguidorCarrera
import materias.domain.Materia
import materias.domain.Nota
import materias.home.HomeMaterias
import materias.home.HomeNotas
import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.windows.ErrorsPanel

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
				new Label(panelIzquierda)=>[
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
		ApplicationContext.instance.configureSingleton(typeof(Nota), new HomeNotas)
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
	
	

	def void grillaDeMaterias(Panel mainPanel) {
		this.createResultsGrid(mainPanel)
	}
	
	def void grillaDeNotas(Panel mainPanel){
		var table = new Table<Nota>(mainPanel, typeof(Nota))
		table.heigth = 150
		table.width = 600
		table.bindItemsToProperty("notas")
		table.bindValueToProperty("notaSeleccionada")
		
		new Column<Nota>(table) 
			.setTitle("Fecha")
			.setFixedSize(200)
			.bindContentsToProperty("fecha")
			
		new Column<Nota>(table) 
			.setTitle("Descripcion")
			.setFixedSize(200)
			.bindContentsToProperty("descripcion")
			
		new Column<Nota>(table) 
			.setTitle("Aprobado")
			.setFixedSize(200)
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

	/**
	 * Acciones asociadas de la pantalla principal. Interesante para ver es cómo funciona el binding que mapea
	 * la acción que se dispara cuando el usuario presiona click Para que el binding sea flexible necesito
	 * decirle objeto al que disparo la acción y el mensaje a enviarle Contra: estoy atado a tener métodos sin
	 * parámetros. Eso me impide poder pasarle parámetros como en el caso del alta/modificación.
	 * Buscar/Limpiar -> son acciones que resuelve el modelo (BuscadorCelular) Nuevo -> necesita disparar una
	 * pantalla de alta, entonces lo resuelve la vista (this)
	 *
	 */
	def addActions(Panel actionsPanel) {

		new Button(actionsPanel)
			.setCaption("Buscar")
			.onClick [ | modelObject.search ] 
			.setAsDefault
			.disableOnError
			.setFontSize(12)
			.foreground = Color::BLUE

		new Button(actionsPanel) 
			.setCaption("Limpiar")
			.onClick [ | modelObject.clear ]
			.setFontSize(12)
			.foreground = Color::BLUE
			
		new Button(actionsPanel) //
			.setCaption("Nueva Materia")
			.onClick [ | this.crearMateria ]
			.setFontSize(12)
			.foreground = Color::BLUE
			
		new Button(actionsPanel)
			.setCaption("Cargar notas")
			.onClick [ | modelObject.buscar ] 
			.setAsDefault
			.disableOnError
			.setFontSize(12)
			.foreground = Color::BLUE
			
		new Button(actionsPanel)
			.setCaption("Editar Nota")
			.onClick [ | this.editarNota] 
			.setAsDefault
			.disableOnError
			.setFontSize(12)
			.foreground = Color::BLUE
			
	}

	// *************************************************************************
	// ** RESULTADOS DE LA BUSQUEDA
	// *************************************************************************
	/**
	 * Se crea la grilla en el panel de abajo El binding es: el contenido de la grilla en base a los
	 * resultados de la búsqueda Cuando el usuario presiona Buscar, se actualiza el model, y éste a su vez
	 * dispara la notificación a la grilla que funciona como Observer
	 */
	def protected createResultsGrid(Panel mainPanel) {
		var table = new Table<Materia>(mainPanel, typeof(Materia))
		table.heigth = 150 //mismo valor que la columna para que sea una sola (columna)
		table.width = 450
		table.bindItemsToProperty("resultados")
		table.bindValueToProperty("materiaSeleccionada")
		this.describeResultsGrid(table)
		
	}
	
		/**
	 * Define las columnas de la grilla Cada columna se puede bindear 1) contra una propiedad del model, como
	 * en el caso del número o el nombre 2) contra un transformer que recibe el model y devuelve un tipo
	 * (generalmente String), como en el caso de Recibe Resumen de Cuenta
	 *
	 * @param table
	 */
	def void describeResultsGrid(Table<Materia> table) {
		new Column<Materia>(table) //
			.setTitle("Nombre")
			.setFixedSize(450)
			.bindContentsToProperty("nombre")
	}	
		
	// ********************************************************
	// ** Acciones
	// ********************************************************
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
	
	def openDialogNota(Dialog<?> dialog){
		dialog.onAccept[|modelObject.buscar]
		dialog.open
	}
	
	
	
}
