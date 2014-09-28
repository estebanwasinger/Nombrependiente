package futbol5.auxUtils

import futbol5.domain.Jugador
import java.util.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table

class Grilla {
	
	new(){}
	
	 def Table<Jugador> generar(Panel panelResultados, Jugador jugadorSeleccionado, List<Jugador> jugadores, String valor, String items){
		new Table<Jugador>(panelResultados, typeof(Jugador)) =>[
			heigth = 220
			width = 360
			if (valor != ""){bindValueToProperty(valor)}
			bindItemsToProperty(items)
		
		new Column<Jugador>(it) =>[
			setTitle("Nombre")
			setFixedSize(100)
			bindContentsToProperty("nombre")]
		new Column<Jugador>(it) =>[
			setTitle("Apodo")
			setFixedSize(100)
			bindContentsToProperty("apodo")]
		new Column<Jugador>(it) =>[
			setTitle("Handicap")
			setFixedSize(80)
			bindContentsToProperty("nivelDeJuego")]
		new Column<Jugador>(it) =>[
			setTitle("Promedio")
			setFixedSize(80)
			bindContentsToProperty("promedio")]
		]
	
	}

}