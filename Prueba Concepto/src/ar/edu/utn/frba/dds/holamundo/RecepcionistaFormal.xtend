package ar.edu.utn.frba.dds.holamundo

class RecepcionistaFormal extends Recepcionista{
	override armarSaludo(Nombrable nombrable){
		"Buen dia, estimado " + nombrable.getNombre()
	}
}