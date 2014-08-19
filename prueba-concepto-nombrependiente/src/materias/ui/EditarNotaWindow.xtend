package materias.ui

import org.uqbar.arena.windows.WindowOwner
import materias.domain.Nota
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.commons.utils.ApplicationContext
import materias.home.HomeNotas
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.apache.commons.lang.StringUtils
import org.uqbar.arena.widgets.CheckBox

class EditarNotaWindow extends Dialog<Nota>{
	
	new(WindowOwner owner, Nota nota) {
		super(owner, nota)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Editar nota"
		val form = new Panel(mainPanel)
		form.layout = new ColumnLayout(2)
		
		new Label(form).text = "Fecha"
		new TextBox(form).bindValueToProperty("fecha")
		
		new Label(form).text = "Descripción"
		new TextBox(form).bindValueToProperty("descripcion")
		
		new CheckBox(form).bindValueToProperty("aprobado")
		new Label(form).text = "Aprobado"
		}

	override protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick [|this.accept]
			.setAsDefault.disableOnError

		new Button(actions) 
			.setCaption("Cancelar")
			.onClick [|this.cancel]
	}


	
	
	
}