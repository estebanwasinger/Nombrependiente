package infracciones

import java.util.Date;

class Infraccion {
		@Property var Date fecha 
		@Property var String motivo
		
		new(){
			fecha = new Date
		}
		
}