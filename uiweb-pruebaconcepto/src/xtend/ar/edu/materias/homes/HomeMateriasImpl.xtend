package ar.edu.materias.homes

import ar.edu.materias.domain.Materia
import java.util.List
import java.util.ArrayList

class HomeMateriasImpl implements HomeMaterias {

	List<Materia> materias

	/** singleton **/
	static HomeMateriasImpl instance

	private new() {
		materias = new ArrayList<Materia>
	}

	static def getInstance() {
		if(instance == null) {
			instance = new HomeMateriasImpl()
		}
		instance
	}

	/** fin singleton **/
	
	override agregarMateria(Materia materia) {
		materia.id = new Long(this.ultimoIdUtilizado.longValue + 1)
		materias.add(materia)
	}
	
	def int getUltimoIdUtilizado() {
		if (materias.isEmpty) {
			return 1
		}
		return materias.sortBy [ -it.id ].toList.get(0).id.intValue
	}

	override actualizarMateria(Materia materiaActualizado) {
		materiaActualizado.validar
		if (materiaActualizado.id == null) {
			this.agregarMateria(materiaActualizado)
		} else {
			this.doActualizarMateria(materiaActualizado)
		}
	}

	def doActualizarMateria(Materia materiaActualizado) {
		val unMateria = this.getMateria(materiaActualizado.id).copy
		unMateria.actualizarCon(materiaActualizado)
	}

	override eliminarMateria(Materia materia) {
		materias.remove(this.getMateria(materia.id))
	}

	override getMateria(Long id) {
		materias.findFirst[materia|materia.id.equals(id)]
	}

	override getMaterias(Materia materiaBusqueda) {
		materias.filter[materia|materia.matchea(materiaBusqueda)].toList.map [ it.copy ]
	}

}
