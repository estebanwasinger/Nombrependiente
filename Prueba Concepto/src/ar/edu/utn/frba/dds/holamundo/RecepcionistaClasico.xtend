package ar.edu.utn.frba.dds.holamundo

class RecepcionistaClasico extends Recepcionista {
	override armarSaludo(Nombrable nombrable){
		"Hola " + nombrable.getNombre()
	}
	
}