package infracciones

import java.util.Date;
import org.uqbar.commons.utils.Observable

@Observable
class Infraccion {
		@Property var Date fecha 
		@Property var String motivo
		
		new(){
			fecha = new Date
		}
		new(String motivo){
			this.motivo = motivo
			fecha = new Date
		}
		
}