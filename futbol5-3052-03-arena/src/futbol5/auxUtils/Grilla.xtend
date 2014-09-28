package futbol5.auxUtils

import futbol5.domain.Jugador
import java.util.List
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table

class Grilla {
	
	new(){}
	
	 def Table<Jugador> generar(Panel panelResultados, Jugador jugadorSeleccionado, List<Jugador> jugadores, String valor, String items){
		var grilla = new Table<Jugador>(panelResultados, typeof(Jugador)) =>[
			heigth = 220
			width = 590
			if (valor != ""){bindValueToProperty(valor)}
			bindItemsToProperty(items)]
		
		new Column<Jugador>(grilla) =>[
			setTitle("Nombre")
			setFixedSize(150)
			bindContentsToProperty("nombre")]
		new Column<Jugador>(grilla) =>[
			setTitle("Apodo")
			setFixedSize(150)
			bindContentsToProperty("apodo")]
		new Column<Jugador>(grilla) =>[
			setTitle("Handicap")
			setFixedSize(150)
			bindContentsToProperty("nivelDeJuego")]
		new Column<Jugador>(grilla) =>[
			setTitle("Promedio")
			setFixedSize(150)
			bindContentsToProperty("promedio")]
	
	return grilla
	}

}