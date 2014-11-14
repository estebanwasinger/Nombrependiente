package futbol5.homes

import calificaciones.Calificacion
import uqbar.arena.persistence.PersistentHome
import infracciones.Infraccion

class RepositorioInfracciones extends PersistentHome<Infraccion>  {
	
	override def getEntityType() {
		typeof(Infraccion)
	}

	override def createExample() {
	}
	
	def get(int id){
		var infracciones = this.allInstances;
		for (Infraccion cal : infracciones){
			if(cal.id == id){
				return cal
			}
		}
	}
	
	def createInfraccion(Infraccion infraccion){
		this.create(infraccion)
		infraccion
	}
	
}