package futbol5.ui

import java.util.List
import futbol5.applicationModel.Futbol5
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
class VistaPrincipal extends MainWindow<Futbol5> {
	
	
	 @Observable							
	override createContents(Panel mainPanel) {
		
		title = "Futbol5"
		new ErrorsPanel(mainPanel,"FutbolOK")
		var panel2Columnas = new Panel(mainPanel)
		panel2Columnas.setLayout(new ColumnLayout(2))
		var panelIzquierda = new Panel(panel2Columnas)
		var panelDerecha = new Panel(panel2Columnas)
		new Label(panelIzquierda) => [
			text = "Futbol5"
			fontSize = 20
		]
		
		//var panelBotones = new Panel(panelIzquierda).setLayout(new HorizontalLayout)
		//addActions(panelBotones)
		//createFormPanel(panelIzquierda)
		//grillaDeMaterias(panelIzquierda) 
		//panelEdicionMateria(panelDerecha)
		//grillaDeNotas(panelDerecha)
	}
	
	def static main(String[] args) {
		//ApplicationContext.instance.configureSingleton(typeof(Materia), new HomeMaterias) -- COMENTADO POR EL HOME MATERIAS
		new futbol5.ui.VistaPrincipal().startApplication
	}

	def asObjects(List<?> list) {
		list.map[it as Object]
	}
	
	/*def getUbicacionesPosibles(){
		posiblesUbicaciones.asObjects
	}*/

	new() {
		super(new Futbol5)
		modelObject.search()
	}	
	
	/*def protected grillaDeNotas(Panel mainPanel){
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
			.bindContentsToTransformer([nota | if (nota.isAprobado) "SI" else "NO"])			
}*/

	def void panelEdicionMateria(Panel mainPanel){
		
		var panelEdicionColumnas = new Panel(mainPanel)
		panelEdicionColumnas.setLayout(new ColumnLayout(2))
		
		new Label(panelEdicionColumnas).setText("Materia:")
		new Label(panelEdicionColumnas) =>[
			bindValueToProperty("materiaSeleccionada.nombre")
			width = 200
			fontSize = 15]
		
		new Label(panelEdicionColumnas).setText("Profesor")
		new TextBox(panelEdicionColumnas)=>[
			bindValueToProperty("materiaSeleccionada.profesor")
			width = 200
			fontSize = 10]
		
		new Label(panelEdicionColumnas).setText("Año de cursada")
		new TextBox(panelEdicionColumnas)=>[
			bindValueToProperty("materiaSeleccionada.anioCursada")
			width = 200
			fontSize = 10]

		new Label(panelEdicionColumnas).text = ("Final Aprobado")
		var checkAprobado = new CheckBox(panelEdicionColumnas)
		checkAprobado.bindValueToProperty("materiaSeleccionada.finalAprobado")
		
		new Label(panelEdicionColumnas).text = ("Ubicacion Materia")
		new Selector(panelEdicionColumnas) => [
			//owNull = false
			bindItems(new ObservableProperty(this, "ubicacionesPosibles"))
			bindValueToProperty("materiaSeleccionada.ubicacion")
		]
		
		var panelBotones = new Panel(mainPanel).layout = new HorizontalLayout()
		var generarEquipo = new Button(panelBotones)
			.setCaption("Generar Equipos")
			.onClick [ | this.generarElEquipo] 
			.setAsDefault
			.disableOnError
			.setFontSize(9)
			
		var busquedaJugador = new Button(panelBotones)
			.setCaption("Busqueda de Jugadores")
			.onClick [ | this.busquedaJugador] 
			.setAsDefault
			.disableOnError
			.setFontSize(9)
				
	}
	
	/*def void createFormPanel(Panel mainPanel) {
		var searchFormPanel = new Panel(mainPanel)
		searchFormPanel.setLayout(new ColumnLayout(2))

		var labelNombre = new Label(searchFormPanel)
		labelNombre.text = "Nombre de materia"

		new TextBox(searchFormPanel)=>
			[bindValueToProperty("nombre")
			width = 200]
	}*/

	/*def addActions(Panel actionsPanel) {

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
	}*/

	/*def protected grillaDeMaterias(Panel mainPanel) {
		var table = new Table<Materia>(mainPanel, typeof(Materia))
		table.heigth = 230 
		table.width = 300
		table.bindItemsToProperty("resultados")
		table.bindValueToProperty("materiaSeleccionada")
		this.describeResultsGrid(table)
	}*/
	
	/*def void describeResultsGrid(Table<Materia> table) {
		new Column<Materia>(table)
			.setTitle("Nombre")
			.setFixedSize(450)
			.bindContentsToProperty("nombre")
	}	*/

	/*def void crearMateria() {
		this.openDialog(new CrearMateriaWindow(this))
	}*/

	/*def openDialog(Dialog<?> dialog) {
		dialog.onAccept[|modelObject.search]
		dialog.open
	}*/
	
	  def void generarElEquipo(){
		
	}
	
	def void busquedaJugador(){
		
	}
	
	/*def openDialogNota(Dialog<?> dialog){
		dialog.onAccept[|modelObject.buscar]
		dialog.open
	}*/		
}