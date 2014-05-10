package futbol5

class Administrador {
/* Por ahora, solo necesito al Administrador para notificarlo */	
	@Property String email
	/*Es un Singleton (Unica instancia) */
	static Administrador unico
	
	def static Administrador getInstance() {
		if (unico == null) {
			unico = new Administrador
		}
		unico
	}
	
}