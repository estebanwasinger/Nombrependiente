package auxiliares

import futbol5.domain.Jugador
import java.util.Date

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