package ui

import java.awt.Color
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.windows.MainWindow
import applicationModel.SeguidorCarrera
import domain.Materia
import org.uqbar.commons.utils.ApplicationContext
import home.HomeMaterias

/**
 * Ejemplo de conversor millas -> kilometros en xtend
 */
class SeguirCarreraWindow extends MainWindow<SeguidorCarrera> {
	new() {
		super(new SeguidorCarrera)
		ApplicationContext::instance.configureSingleton(typeof(Materia), new HomeMaterias)
	}

	override createContents(Panel mainPanel) {
		this.createResultsGrid(mainPanel)
		this.createActionPanel(mainPanel)
	}
	
	def createActionPanel(Panel panel) {
			new Button(panel)
			.setCaption("Buscar")
			.onClick [ | modelObject.search ] 
			.setAsDefault
			.disableOnError
	}
	
	def protected createResultsGrid(Panel mainPanel) {
		var table = new Table<Materia>(mainPanel, typeof(Materia))
		table.heigth = 200
		table.width = 450
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
			.setTitle("Materias")
			.setFixedSize(150)
			.bindContentsToProperty("nombre")
	}


	def static main(String[] args) {
		new SeguirCarreraWindow().startApplication
	}

}
