package materias.ui;

import materias.domain.Nota;
import materias.home.HomeNotas;
import materias.ui.EditarNotaWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("all")
public class CrearNotaWindow extends EditarNotaWindow {
  public CrearNotaWindow(final WindowOwner owner) {
    super(owner, new Nota());
  }
  
  public void executeTask() {
    HomeNotas _homeNotas = this.homeNotas();
    Nota _modelObject = this.getModelObject();
    _homeNotas.create(_modelObject);
    super.executeTask();
  }
}
