package auxiliares

import java.util.Date

class RegistroRechazo {
	@Property Date fechaDelDia
	@Property String motivoRechazo
	
	new(String motivo){
		fechaDelDia = new Date
		motivoRechazo = motivo
	}
}