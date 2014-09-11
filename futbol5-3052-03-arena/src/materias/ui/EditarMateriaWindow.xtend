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