package futbol5.ui

import futbol5.domain.Jugador
import futbol5.domain.Partido
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.utils.Observable
import commands.DivisionDeEquiposCommand
import org.uqbar.arena.bindings.ObservableProperty
import java.util.LinkedList
import java.util.List
import commands.AlgoritmoImparPar
import org.uqbar.arena.bindings.PropertyAdapter
import commands.AlgoritmoLoco
import commands.CriteriosCommand
import commands.CriterioCalifiUltimoPartido
import commands.CriterioHandicap
import commands.CriterioNCalificaciones
import org.uqbar.commons.model.ObservableUtils
import java.util.ArrayList

@Observable
class GenerarEquiposWindow extends SimpleWindow<Partido> {

	Table<Jugador> tableListaEquipoA

	@Property List<DivisionDeEquiposCommand> listaCommand
	@Property List<CriteriosCommand> listaCommand2
	Partido model

	new(WindowOwner parent, Partido model) {
		super(parent, model)
		this.model = model
	}

	new(RunnableTest parent) {
		super(parent, new Partido)
	}

	override protected addActions(Panel actionPanel) {
		actionPanel.layout = new HorizontalLayout
		new Button(actionPanel).setCaption("Cancelar")

		new Button(actionPanel).setCaption("Aceptar")
	}

	override protected createFormPanel(Panel mainPanel) {
		title = "Generar Equipo"

		/* Creacion panel GENERAR EQUIPOS */
		mainPanel.layout = new VerticalLayout
		val botoneraSuperior = new Panel(mainPanel)
		botoneraSuperior.layout = new HorizontalLayout
		val panelListaJugadores = new Panel(mainPanel)
		panelListaJugadores.layout = new ColumnLayout(3)
		val selector1 = new Panel(botoneraSuperior)
		selector1.layout = new VerticalLayout
		val selector2 = new Panel(botoneraSuperior)
		selector2.layout = new VerticalLayout
		val selector3 = new Panel(botoneraSuperior)
		selector3.layout = new VerticalLayout

		/* RELLENO DE LOS SELECTORES ES HORRIBLE PERO POR AHORA FUNCIONA
		 * lo que hay que ver es tipo los algoritmos que necesitan que le pases algun parametro para que funcione como ultimos N partidos
		 */
		new Label(selector1).text = "Criterio de Selección"
		val selectorOrdenamiento = new Selector<DivisionDeEquiposCommand>(selector1) => [
			width = 200
			title = "Generar equipos tentativos"
		]
		listaCommand = new LinkedList<DivisionDeEquiposCommand>
		listaCommand.add(new AlgoritmoImparPar)
		listaCommand.add(new AlgoritmoLoco)
		selectorOrdenamiento.allowNull(false)

		selectorOrdenamiento.bindValueToProperty("algoritmoDivision")
		var propiedadOrdenamiento = selectorOrdenamiento.bindItems(new ObservableProperty(this, "listaCommand"))
		propiedadOrdenamiento.adapter = new PropertyAdapter(typeof(DivisionDeEquiposCommand), "nombre")

		new Label(selector2).text = "Criterio de Ordenamiento"
		val selectorOrdenamiento2 = new Selector<CriteriosCommand>(selector2) => [
			allowNull(false)
			width = 200
		]
		listaCommand2 = new LinkedList<CriteriosCommand>
		listaCommand2.add(new CriterioCalifiUltimoPartido)
		listaCommand2.add(new CriterioHandicap)
		listaCommand2.add(new CriterioNCalificaciones)
		selectorOrdenamiento2.allowNull(false)

		selectorOrdenamiento2.bindValueToProperty("algoritmoOrdenamiento")
		var propiedadOrdenamiento2 = selectorOrdenamiento2.bindItems(new ObservableProperty(this, "listaCommand2"))
		propiedadOrdenamiento2.adapter = new PropertyAdapter(typeof(CriteriosCommand), "nombre")

		new Label(selector3).bindValueToProperty("cantEquipoA")
		val botonGenerar = new Button(selector3) => [
			width = 200
			heigth = 45
			caption = "Generar Equipos"
			onClick[ |
				modelObject.equipoA = new ArrayList<Jugador>
				modelObject.ordenarJugadores(modelObject.algoritmoOrdenamiento)
				modelObject.dividirEquipos(modelObject.algoritmoDivision)
				modelObject.jugadores.add(new Jugador("hola"))
				ObservableUtils.firePropertyChanged(modelObject,"equipoA",modelObject.equipoA)
				ObservableUtils.firePropertyChanged(modelObject,"equipoB",modelObject.equipoB)
			]
		]

		createListaJugadores(panelListaJugadores)
	}

	def void createListaJugadores(Panel panelJugadores) {

		var labelJugadores = new Label(panelJugadores) => [
			text = "Jugadores"
			fontSize = 20
		]

		var labelEquipo1 = new Label(panelJugadores) => [
			text = "Equipo A"
			fontSize = 20
		]

		var labelEquipo2 = new Label(panelJugadores) => [
			text = "Equipo B"
			fontSize = 20
		]

		var tableListaInscriptos = new Table<Jugador>(panelJugadores, typeof(Jugador))
		tableListaInscriptos.heigth = 200
		tableListaInscriptos.width = 285
		tableListaInscriptos.bindItemsToProperty("jugadores")
		new Column<Jugador>(tableListaInscriptos).setTitle("Nombre").bindContentsToProperty("nombre")

		tableListaEquipoA = new Table<Jugador>(panelJugadores, typeof(Jugador))
		tableListaEquipoA.heigth = 200
		tableListaEquipoA.width = 285
		tableListaEquipoA.bindItemsToProperty("equipoA")
		new Column<Jugador>(tableListaEquipoA).setTitle("Nombre").bindContentsToProperty("nombre")

		var tableListaEquipoB = new Table<Jugador>(panelJugadores, typeof(Jugador))
		tableListaEquipoB.heigth = 200
		tableListaEquipoB.width = 285
		tableListaEquipoB.bindItemsToProperty("equipoB")
		new Column<Jugador>(tableListaEquipoB) //
		.setTitle("Nombre").bindContentsToProperty("nombre")
	}
}
