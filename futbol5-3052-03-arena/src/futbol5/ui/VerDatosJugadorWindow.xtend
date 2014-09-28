package futbol5.ui

import futbol5.auxUtils.Grilla
import futbol5.domain.Jugador
import futbol5.homes.HomeJugadores
import infracciones.Infraccion
import java.text.SimpleDateFormat
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.commons.utils.Observable
import java.awt.Color

@Observable
class VerDatosJugadorWindow extends Dialog<Jugador>{
	
	@Property Grilla grilla
	
	new(WindowOwner owner, Jugador model) {
		super(owner, model)
		grilla = new Grilla
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Datos del Jugador"
		var principal = new Panel(mainPanel).layout = new ColumnLayout(2)
		var panelIzq = new Panel(principal).layout = new ColumnLayout(2)
		var panelDer = new Panel(principal).layout = new ColumnLayout(2)
		
		mostrarDatos(panelIzq)
		verTablas(panelDer)
	}
	
	def mostrarDatos(Panel panel){		
		new Label(panel)=>[bindValueToProperty("nombre") setFontSize(16)setForeground(Color.RED)]
		new Label(panel)=>[text ="" setFontSize(16)]
		new Label(panel)=>[bindValueToProperty("apodo")setFontSize(14)setForeground(Color.LIGHT_GRAY)]
		new Label(panel)=>[text ="" setFontSize(14)]
		new Label(panel).text = "Handicap =>"
		new Label(panel).bindValueToProperty("nivelDeJuego")
		new Label(panel).text = "Promedio último partido =>"
		new Label(panel).bindValueToProperty("promedioUltimoPartido")
		new Label(panel).text = "Promedio total =>"
		new Label(panel).bindValueToProperty("promedio")
		new Label(panel).text = "Fecha de nacimiento =>"
		new Label(panel).bindValueToProperty("fechaNacimientoString")
		new Label(panel).text = "Cantidad de partidos jugados =>"
		new Label(panel).bindValueToProperty("cantidadPartidos")
	}
	
	def verTablas(Panel panel){
		new Label(panel) =>[text="Amigos" setFontSize(12) setForeground(Color.DARK_GRAY)]
		new Label(panel)=>[text="Infracciones" setFontSize(12) setForeground(Color.DARK_GRAY)]
		
		grilla.generar(panel, modelObject,modelObject.amigos,"","amigos")
	
		var tablaInfracciones = new Table<Infraccion>(panel, Infraccion) => [
			heigth = 130
			width = 280
			bindItemsToProperty("infracciones")]
			
		new Column<Infraccion>(tablaInfracciones).setTitle("Fecha")
		.bindContentsToTransformer([ infraccion | new SimpleDateFormat("dd/MM/YYYY").format(infraccion.fecha)])
		.setFixedSize(75)
		
		new Column<Infraccion>(tablaInfracciones).setTitle("Hora")
		.bindContentsToTransformer([ infraccion | new SimpleDateFormat("HH:mm:ss").format(infraccion.fecha)])
		.setFixedSize(75)
		
		new Column<Infraccion>(tablaInfracciones).setTitle("Motivo")
		.bindContentsToProperty("motivo")
	}
	
override protected void addActions(Panel actions) {
		new Button(actions) => [
			setCaption("Volver")
			onClick [|this.cancel] ]
	}

	def homeJugadores() {
		ApplicationContext::instance.getSingleton(typeof(Jugador)) as HomeJugadores
	}
	
}