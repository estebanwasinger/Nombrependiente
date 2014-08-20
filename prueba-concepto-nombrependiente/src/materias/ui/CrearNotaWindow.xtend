package materias.ui

import org.uqbar.arena.windows.WindowOwner
import materias.domain.Nota
import materias.domain.Materia

class CrearNotaWindow extends EditarNotaWindow {
	
	new(WindowOwner owner,Materia materia) {
		super(owner, new Nota)
	}
	override def executeTask() {
		
		super.executeTask()
	}
	
}