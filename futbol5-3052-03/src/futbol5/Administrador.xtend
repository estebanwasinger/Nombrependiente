package futbol5

class Administrador {

	@Property String email
	@Property Boolean aceptar
	@Property Sistema sistema
	@Property String motivo
		
	static Administrador unico
			
	def static Administrador getInstance() {
		if (unico == null) {
			unico = new Administrador
		}
		unico
	}
	
	new(){
	}
		
	
	
}
	

  

	
