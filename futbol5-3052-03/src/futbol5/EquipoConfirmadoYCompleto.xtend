package futbol5
class EquipoConfirmadoYCompleto extends RuntimeException{
		
	private String message
	
	new(String msg) {
		this.message = msg
	}

}