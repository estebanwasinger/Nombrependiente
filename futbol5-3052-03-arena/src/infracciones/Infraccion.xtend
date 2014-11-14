package infracciones

import java.util.Date
import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable
import uqbar.arena.persistence.annotations.PersistentClass
import uqbar.arena.persistence.annotations.PersistentField

@Observable
@PersistentClass
class Infraccion extends Entity {
		@Property Date fecha 
		@Property String motivo
		
		@PersistentField
		def getFecha(){
			_fecha
		}
		
		def void setFecha(Date fecha){
			_fecha = fecha
		}
		
		@PersistentField
		def getMotivo(){
			_motivo
		}
		
		def void setMotivo(String motivo){
			_motivo = motivo
		}
		
		
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