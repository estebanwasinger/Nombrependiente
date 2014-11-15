package futbol5.ui

import commands.CriteriosCommand
import commands.DivisionDeEquiposCommand
import futbol5.applicationModel.PartidosAppModel
import futbol5.domain.Partido
import futbol5.homes.RepositorioPartidos
import java.util.List
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.arena.bindings.NotNullObservable

class CrearPartidoWindow extends SimpleWindow<Partido> {
	@Property List<DivisionDeEquiposCommand> listaCritDivision
	@Property List<CriteriosCommand> listaCritOrdenamiento
	WindowOwner padre
	PartidosAppModel partidosAppModel

	new(PartidosView parent, Partido model, PartidosAppModel partidos) {
		super(parent, model)
		padre = parent
		partidosAppModel = partidos
	}

	override protected addActions(Panel actionPanel) {
		actionPanel.layout = new HorizontalLayout
		new Button(actionPanel) => [
			setCaption("Crear")
			onClick [|this.persistirPartido partidosAppModel.searchPartido this.close]
			setAsDefault
			bindEnabled(new NotNullObservable("localidad"))
		]
		new Button(actionPanel).setCaption("Cancelar").onClick [ |
			this.close
		]
	}

	override protected createFormPanel(Panel mainPanel) {
		new Label(mainPanel) => [
			text = "Ingrese datos del nuevo partido"
			fontSize = 15
		]
		var form = new Panel(mainPanel) => [layout = new ColumnLayout(2)]
		title = "Generar Equipo"
		new Label(form).text = "Lugar"
		new TextBox(form) => [
			bindValueToProperty("localidad")
			width = 150
		]
	}

	def persistirPartido() {
		repoJugadores.createIfNotExists( modelObject)
	}

	def repoJugadores() {
		(ApplicationContext.instance.getSingleton(typeof(Partido)) as RepositorioPartidos)
	}
}
