package materias.ui

import materias.domain.Materia
import org.uqbar.arena.windows.WindowOwner

class CrearMateriaWindow extends EditarMateriaWindow {
	
	new(WindowOwner owner) {
		super(owner, new Materia)
	}
	override def executeTask() {
		homeMaterias.create(modelObject)
		super.executeTask()
	}

}