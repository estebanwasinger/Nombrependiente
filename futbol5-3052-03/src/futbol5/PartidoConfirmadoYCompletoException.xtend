package futbol5
class PartidoConfirmadoYCompletoException extends RuntimeException{
		
	private String message
	
	new(String msg) {
		this.message = msg
	}

}