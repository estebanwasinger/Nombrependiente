package materias.ui

import org.uqbar.arena.windows.WindowOwner
import materias.domain.Materia
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.commons.utils.ApplicationContext
import materias.home.HomeMaterias
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.apache.commons.lang.StringUtils

class EditarMateriaWindow extends Dialog<Materia> {

	new(WindowOwner owner, Materia model) {
		super(owner, model)
	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Nueva Materia"
		val form = new Panel(mainPanel)
		form.layout = new ColumnLayout(2)
		new Label(form).text = "Nombre de Materia"
		new TextBox(form)
			.withFilter [ event | StringUtils::isAlphaSpace(event.potentialTextResult) ]
			.bindValueToProperty("nombre")
	}

	override protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick [|this.accept]
			.setAsDefault.disableOnError

		new Button(actions) //
			.setCaption("Cancelar")
			.onClick [|this.cancel]
	}

	def homeMaterias() {
		ApplicationContext::instance.getSingleton(typeof(Materia)) as HomeMaterias
	}

}

/*package materias.ui

import org.uqbar.arena.windows.WindowOwner
import materias.domain.Materia
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.commons.utils.ApplicationContext
import materias.home.HomeMaterias
import materias.home.HomeUbicaciones
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.apache.commons.lang.StringUtils
import materias.domain.Ubicacion
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.CheckBox

class EditarMateriaWindow extends Dialog<Materia> {

	
	new(WindowOwner owner, Materia model) {
		super(owner, model)
	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Editar Materia"
		val form = new Panel(mainPanel)
		form.layout = new ColumnLayout(2)
		new Label(form).text = "Nombre de Materia"
		new TextBox(form)
			.withFilter [ event | StringUtils::isAlphaSpace(event.potentialTextResult) ]
			.bindValueToProperty("nombre")
		
		new Label(form).text = "Nombre de la Materia"
		new TextBox(form).bindValueToProperty("nombre")
		
new Label(form).text = "Ubicacion Materia"
		val selectorUbicacion = new Selector<Ubicacion>(form)
		selectorUbicacion.allowNull(false)
		selectorUbicacion.bindValueToProperty("ubicacion")
		var propiedadUbicaciones = selectorUbicacion.bindItems(new ObservableProperty(homeUbicaciones, "ubicaciones"))
		propiedadUbicaciones.adapter = new PropertyAdapter(typeof(Ubicacion), "descripcion")
		
		new Label(form).text = "Aprobado"
		var checkAprobado = new CheckBox(form)
		//checkAprobado.bindEnabledToProperty("habilitaResumenCuenta")
		checkAprobado.bindValueToProperty("finalAprobado")
	}
	


	override protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick [|this.accept]
			.setAsDefault.disableOnError

		new Button(actions) //
			.setCaption("Cancelar")
			.onClick [|this.cancel]
	}
	
	def homeMaterias() {
		ApplicationContext::instance.getSingleton(typeof(Materia)) as HomeMaterias
	}
	
		def getHomeUbicaciones() {
		ApplicationContext::instance.getSingleton(typeof(Ubicacion)) as HomeUbicaciones
	}

}*/
