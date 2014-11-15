package futbol5.homes

import calificaciones.Calificacion
import uqbar.arena.persistence.PersistentHome

class RepositorioCalificaciones extends PersistentHome<Calificacion>  {
	
	override def getEntityType() {
		typeof(Calificacion)
	}

	override def createExample() {
	}
	
	def get(int id){
		var calificaciones = this.allInstances;
		for (Calificacion cal : calificaciones){
			if(cal.id == id){
				return cal
			}
		}
	}
	
	def createCal(Calificacion cal){
		this.create(cal)
		cal
	}
	
}