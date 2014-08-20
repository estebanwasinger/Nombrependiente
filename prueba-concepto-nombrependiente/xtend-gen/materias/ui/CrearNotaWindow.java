package materias.ui;

import materias.domain.Materia;
import materias.domain.Nota;
import materias.ui.EditarNotaWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("all")
public class CrearNotaWindow extends EditarNotaWindow {
  public CrearNotaWindow(final WindowOwner owner, final Materia materia) {
    super(owner, new Nota());
  }
  
  public void executeTask() {
    super.executeTask();
  }
}
