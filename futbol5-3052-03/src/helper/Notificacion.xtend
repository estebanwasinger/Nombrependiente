package helper

class Notificacion {

	@Property String de
	@Property String a
	@Property String asunto
	@Property String contenido
	
	new(String NDe,String NA,String NAsunto,String NContenido ){
		de = NDe
		a = NA
		asunto = NAsunto
		contenido = NContenido
	}
}