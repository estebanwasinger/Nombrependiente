package materias.runnable

import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import org.uqbar.commons.utils.ApplicationContext
import materias.domain.Materia
import materias.home.HomeMaterias
import materias.ui.SeguidorCarreraWindow

class SeguidorCarreraApp extends Application {
	
	static def void main(String[] args) { 
		new SeguidorCarreraApp().start()
	}

	override protected Window<?> createMainWindow() {
		ApplicationContext::instance.configureSingleton(typeof(Materia), new HomeMaterias)
		
		return new SeguidorCarreraWindow(this)
	}
}
