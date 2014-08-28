package ar.edu.materias.homes

import ar.edu.materias.domain.Materia
import java.util.List

interface HomeMaterias {
	
	def void agregarMateria(Materia materia)
	def void actualizarMateria(Materia materia)
	def void eliminarMateria(Materia materia)
	def Materia getMateria(Long id)
	def List<Materia> getMaterias(Materia materiaBusqueda)
	
}