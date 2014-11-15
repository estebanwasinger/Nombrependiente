package futbol5.ui;

import commands.CriteriosCommand
import commands.DivisionDeEquiposCommand
import futbol5.auxUtils.DateTextFilter
import futbol5.domain.Jugador
import futbol5.homes.RepositorioJugadores
import java.util.List
import org.uqbar.arena.bindings.DateAdapter
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.commons.utils.ApplicationContext

class CrearJugadorWindow extends SimpleWindow<Jugador> {
	@Property List<DivisionDeEquiposCommand> listaCritDivision
	@Property List<CriteriosCommand> listaCritOrdenamiento

	new(PartidosView parent, Jugador model) {
		super(parent, model)
	}

	override protected addActions(Panel actionPanel) {
		actionPanel.layout = new HorizontalLayout
		new Button(actionPanel).setCaption("Crear").onClick [ |
			this.persistirJugador
			this.close
		].setAsDefault.disableOnError

		new Button(actionPanel).setCaption("Cancelar").onClick [ |
			this.close
		]
	}
	
	override protected createFormPanel(Panel mainPanel) {
		new Label(mainPanel) => [
			text = "Ingrese datos del nuevo Jugador"
			fontSize = 15
		]
		var form = new Panel(mainPanel) => [layout = new ColumnLayout(2)]
		title = "Nuevo Jugador"

		new Label(form).text = "Nombre"
		new TextBox(form) => [
			width = 150
			bindValueToProperty("nombre")
		]
		new Label(form).text = "Apodo"
		new TextBox(form) => [
			width = 150
			bindValueToProperty("apodo")
		]
		new Label(form).text = "Fecha Nacimiento"
		new TextBox(form) => [
			withFilter(new DateTextFilter)
			width = 150
			bindValueToProperty("fechaNacimiento").setTransformer(new DateAdapter)
		]
	}

	def persistirJugador() {
		repoJugadores.createIfNotExists(modelObject)
	}

	def repoJugadores() {
		(ApplicationContext.instance.getSingleton(typeof(Jugador)) as RepositorioJugadores)
	}
}
