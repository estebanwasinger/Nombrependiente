package futbol5.auxUtils

import futbol5.domain.Jugador
import java.awt.Color
import java.util.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table

class Grilla {

	new() {
	}

	def Table<Jugador> generar(Panel panelResultados, Jugador jugadorSeleccionado, List<Jugador> jugadores, String valor,
		String items) {
		new Table<Jugador>(panelResultados, typeof(Jugador)) => [
			heigth = 220
			width = 360
			if (valor != "") {
				bindValueToProperty(valor)
			}
			bindItemsToProperty(items)
			createColumn(it, "Nombre", "nombre")
			createColumn(it, "Apodo", "apodo")
			createColumn(it, "Handicap", "nivelDeJuego")
			createColumn(it, "Promedio", "promedio")
		]

	}

	def createColumn(Table<Jugador> it, String columnTitle, String contentToBind) {
		new Column<Jugador>(it) => [
			setTitle(columnTitle) 
			setFixedSize(80) 
			bindContentsToProperty(contentToBind)
			bindBackground("nivelDeJuego",[prom| if(prom >= 8.0f) new Color(151,175,255) else Color.WHITE])
		]
	}

}