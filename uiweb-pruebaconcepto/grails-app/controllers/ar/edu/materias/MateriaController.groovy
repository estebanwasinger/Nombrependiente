package ar.edu.materias

import ar.edu.materias.domain.Materia
import ar.edu.materias.exceptions.SystemException
import ar.edu.materias.exceptions.BusinessException
import ar.edu.materias.homes.HomeMaterias
import ar.edu.materias.homes.HomeMateriasImpl;

class MateriaController {
	
	HomeMaterias homeMaterias = HomeMateriasImpl.instance
	
		static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
		def index() {
			redirect(action: "list", params: params)
		}
	
		def list(Integer max) {
			def Materia materiaBusqueda = mapear(new Materia(), params)
			def materias = homeMaterias.getMaterias(materiaBusqueda)
			[materiaInstanceList: materias, materiaInstanceTotal: materias.size(), materiaBusqueda: materiaBusqueda ]
		}
	
		def create() {
			render(view: "edit", model: [materiaInstance: mapear(new Materia(), params), alta: true])
		}
	
		def save() {
			def materiaInstance = null
			def defaultMessage = null
			def id = params.id ? params.id as Long : null
			if (id) {
				materiaInstance = homeMaterias.getMateria(id)
				defaultMessage = "La materia se actualizó correctamente"
			} else {
				materiaInstance = new Materia()
				defaultMessage = "La materia se generó correctamente"
			}
			try {
				mapear(materiaInstance, params)
				homeMaterias.actualizarMateria(materiaInstance)
				flash.message = defaultMessage
				redirect(action: "list")
			} catch (BusinessException e) {
				this.handleEditionError(materiaInstance, e)
			} catch (Exception e) {
				this.handleEditionError(materiaInstance, new SystemException("Ha ocurrido un error. Consulte al administrador"))
			}
		}
	
		def handleEditionError(materia, exception) {
			render(view: "edit", model: [materiaInstance: materia, alta: materia.id == null, exception: exception])
		}
	
		def show(Long id) {
			edit(id)
		}
	
		def edit(Long id) {
			def materiaInstance = homeMaterias.getMateria(id)
			if (!materiaInstance) {
				flash.message = "Materia " + id + " no encontrada"
				redirect(action: "list")
			}
			else {
				[materiaInstance: materiaInstance]
			}
		}
	
		def delete(Long id) {
			def materiaInstance = homeMaterias.getMateria(id)
			try {
				homeMaterias.eliminarMateria(materiaInstance)
				flash.message = "Materia eliminada"
				redirect(action: "list")
			} catch (Exception e) {
				flash.message = "Hubo un error al eliminar la materia"
				redirect(action: "show", id: id)
			}
		}
	
		def mapear(materia, params) {
			if (params.profesor) {
				materia.profesor = params.profesor
			} else {
				materia.profesor = null
			}
			if (params.nombre) {
				materia.nombre = params.nombre
			} else {
				materia.nombre = null
			}
			if (params.ubicacion) {
				materia.ubicacion = params.ubicacion
			} else {
				materia.ubicacion = null
			}
			if (params.anioCursada) {
				materia.anioCursada = new Integer(params.anioCursada)
			} else {
				materia.anioCursada = null
			}
			if (params.finalAprobado) {
				materia.finalAprobado = params.finalAprobado
			}
			materia
		}

}
