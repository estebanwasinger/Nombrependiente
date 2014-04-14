package ar.edu.utn.frba.dds.holamundo

abstract class Recepcionista {
	def saludar(Nombrable unNombrable){
		System::out.println(armarSaludo(unNombrable))
	}
	
	def String armarSaludo(Nombrable unNombrable)
}