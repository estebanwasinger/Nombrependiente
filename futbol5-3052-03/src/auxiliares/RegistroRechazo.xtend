package auxiliares

import java.util.Dateimport futbol5.Jugador

class RegistroRechazo {
	@Property Date fechaDelDia
	@Property String motivoRechazo
	@Property Jugador jugadorRechazado
	
	new(Jugador jugador, String motivo){
		fechaDelDia = new Date
		motivoRechazo = motivo
		jugadorRechazado = jugador
	}
	
		
}