package auxiliares

import java.util.Date

class RegistroRechazo {
	@Property Date fechaDelDia
	@Property String motivoRechazo
	
	def void generarNuevoRechazo(String motivo){
		fechaDelDia = new Date
		motivoRechazo = motivo
	}
}