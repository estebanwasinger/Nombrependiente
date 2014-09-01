import ar.edu.materias.domain.Materia
import ar.edu.materias.homes.HomeMateriasImpl

class BootStrap {

	def init = { servletContext ->

		println "Generamos juego de datos de materias"
		// Genero el juego de datos
		HomeMateriasImpl.instance.agregarMateria(new Materia("Algoritmos", "Bruno", "1er Cuatrimestre", 2009,false))
		HomeMateriasImpl.instance.agregarMateria(new Materia("Matematica Discreta",  "Ottaviano", "1er Cuatrimestre", 2010,false))
		HomeMateriasImpl.instance.agregarMateria(new Materia("Analisis de Sistemas",  "Garbarini", "Anual", 2010,false))
		HomeMateriasImpl.instance.agregarMateria(new Materia("Dise&ntilde;o de Sistemas",  "Dodain", "Anual", 2011,false))
		HomeMateriasImpl.instance.agregarMateria(new Materia("Sistemas Operativos",  "De Luca", "2do Cuatrimestre", 2012,false))
		HomeMateriasImpl.instance.agregarMateria(new Materia("Gestion de Datos",  "Garcia", "2do Cuatrimestre", 2014,false))

	}
	def destroy = {
	}
}
