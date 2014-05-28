package auxiliares

import java.util.Dateimport futbol5.Jugador

class RegistroRechazo {
	@Property Date fechaDelDia
	@Property String motivoRechazo
	@Property Jugador jugador
	
	new(String motivo){
		fechaDelDia = new Date
		motivoRechazo = motivo
	}
	
	new(Jugador jugadorRechazado, String motivo) {
		fechaDelDia = new Date
		motivoRechazo = motivo
		jugador = jugadorRechazado
	}
	
		
}