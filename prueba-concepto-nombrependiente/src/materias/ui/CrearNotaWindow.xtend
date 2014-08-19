package materias.ui

import org.uqbar.arena.windows.WindowOwner
import materias.domain.Nota

class CrearNotaWindow extends EditarNotaWindow {
	
		new(WindowOwner owner) {
		super(owner, new Nota)
	}
	override def executeTask() {
		homeNotas.create(modelObject)
		super.executeTask()
	}
	
}