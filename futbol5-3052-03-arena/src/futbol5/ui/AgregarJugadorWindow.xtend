package futbol5.ui

import commands.CriteriosCommand
import commands.DivisionDeEquiposCommand
import futbol5.applicationModel.BusquedaJugadoresAppModel
import futbol5.auxUtils.Grilla
import futbol5.domain.Partido
import futbol5.homes.RepositorioPartidos
import java.util.List
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.commons.utils.ApplicationContext

class AgregarJugadorWindow extends SimpleWindow<BusquedaJugadoresAppModel> {
	@Property List<DivisionDeEquiposCommand> listaCritDivision
	@Property List<CriteriosCommand> listaCritOrdenamiento
	Partido partido

	new(PartidosView parent, BusquedaJugadoresAppModel model, Partido partido) {
		super(parent, model)
		this.partido = partido
	}

	override protected addActions(Panel actionPanel) {
		actionPanel.layout = new HorizontalLayout
		new Button(actionPanel).setCaption("Agregar").onClick [ |
			this.agregarJugadorSeleccionado
			this.persistirPartido
			this.close
		].setAsDefault.bindEnabled(new NotNullObservable("jugadorSeleccionado"))

		new Button(actionPanel).setCaption("Cancelar").onClick [ |
			this.close
		]
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Nuevo Jugador"
		new Label(mainPanel) => [
			text = "Seleccione jugador a agregar"
			fontSize = 20
		]
		new Grilla => [
			generar(mainPanel, modelObject.jugadorSeleccionado, modelObject.jugadores, "jugadorSeleccionado",
				"jugadores")]
	}

	def agregarJugadorSeleccionado() {
		partido.inscribir(modelObject.jugadorSeleccionado)
	}

	def persistirPartido() {
		repoPartidos.updateMe(partido)
	}

	def repoPartidos() {
		(ApplicationContext.instance.getSingleton(typeof(Partido)) as RepositorioPartidos)
	}
}
