package futbol5

class Administrador {

	@Property String email
	static Administrador unico
	
	def static Administrador getInstance() {
		if (unico == null) {
			unico = new Administrador
		}
		unico
	}
	
	/*def decisionATomar(decision)*/
	
}