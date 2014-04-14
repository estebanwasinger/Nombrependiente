package ar.edu.utn.frba.dds.holamundoTest

import ar.edu.utn.frba.dds.holamundo.Mundo
import ar.edu.utn.frba.dds.holamundo.Recepcionista
import ar.edu.utn.frba.dds.holamundo.RecepcionistaClasico
import ar.edu.utn.frba.dds.holamundo.RecepcionistaFormal
import ar.edu.utn.frba.dds.holamundo.Persona
import ar.edu.utn.frba.dds.holamundo.Nombrable

class Test {
	def static void main ( String [] args ) {

	newArrayList ("Jose","Juana","Pedro")
		. map ( nombre | new Persona ( nombre ))
		. filter ( persona | persona . nombre . startsWith ("J"))
		. forEach ( persona |
			makeRecepcionista (). saludar ( persona )
		)

	}

	def static Recepcionista makeRecepcionista (){
		new RecepcionistaClasico ()
	}
}