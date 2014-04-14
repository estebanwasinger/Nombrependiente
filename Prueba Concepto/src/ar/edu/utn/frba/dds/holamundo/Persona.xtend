package ar.edu.utn.frba.dds.holamundo

@Data class Persona implements Nombrable { //@Data crea los getters
	String nombre	
		
	def setNombre(String nombre) {
		this.nombre = nombre
	}

}