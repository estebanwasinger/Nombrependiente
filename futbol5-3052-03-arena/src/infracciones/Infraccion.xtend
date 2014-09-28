package infracciones

import java.util.Date
import org.uqbar.commons.utils.Observable

@Observable
class Infraccion {
		@Property Date fecha 
		@Property String motivo
		
		new(){
			fecha = new Date
		}
		new(String motivo){
			this.motivo = motivo
			fecha = new Date
		}
		
		new(String motivo, Date fecha){
			this.motivo = motivo
			this.fecha = fecha
		}
		
}