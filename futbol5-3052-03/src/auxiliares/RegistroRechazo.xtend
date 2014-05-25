package auxiliares

import java.util.Date

class RegistroRechazo {
	@Property Date fechaDelDia
	@Property String motivoRechazo
	
	def void generar(String motivo){
		this.fechaDelDia = new Date
		this.motivoRechazo = motivo
	}
}