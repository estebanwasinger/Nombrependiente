package ar.edu.materias.domain

import ar.edu.materias.exceptions.BusinessException
import java.util.Date

class Materia implements Cloneable{
	
	@Property Long id
	@Property String profesor
	@Property String nombre
	@Property String ubicacion
	@Property Integer anioCursada
	@Property boolean finalAprobado = true

	new() {
		profesor = "" 
		nombre = ""
		ubicacion = ""
	}

	new(String nombre,String profesor,  String ubicacion, Integer anioCursada, Boolean finalAprobado) {
		this.profesor = profesor
		this.nombre = nombre
		this.ubicacion = ubicacion
		this.anioCursada = anioCursada
		this.finalAprobado = finalAprobado
	}

	override toString() {
		nombre
	}

	def void validar() {
		if (profesor == null || profesor.equals("")) {
			throw new BusinessException("profesor", "Debe completar el profesor")
		}
		if (nombre == null || nombre.equals("")) {
			throw new BusinessException("nombre", "Debe completar el nombre")
		}
		if (ubicacion == null || ubicacion.equals("")) {
			throw new BusinessException("ubicacion", "Debe completar la ubicacion")
		}
		if (anioCursada == null) {
			throw new BusinessException("anioCursada", "Debe completar el año de cursada")
		} else {
			if (anioCursada > new Date().year + 1900) {
				throw new BusinessException("anioCursada", "El año de cursada no puede ser posterior al a�o actual")
			}
		}
		
	}

	def actualizarCon(Materia materia) {
		this.profesor = materia.profesor
		this.nombre = materia.nombre
		this.ubicacion = materia.ubicacion
		this.anioCursada = materia.anioCursada
		this.finalAprobado = materia.finalAprobado
	}

	def matchea(Materia materia) {
		materia.nombre == null || nombre.contains(materia.nombre)
	}
	
	def Materia copy() {
		super.clone as Materia
	}
	
	
}