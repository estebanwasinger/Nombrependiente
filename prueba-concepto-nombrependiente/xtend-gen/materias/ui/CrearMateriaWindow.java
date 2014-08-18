package materias.ui;

import materias.domain.Materia;
import materias.home.HomeMaterias;
import materias.ui.EditarMateriaWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("all")
public class CrearMateriaWindow extends EditarMateriaWindow {
  public CrearMateriaWindow(final WindowOwner owner) {
    super(owner, new Materia());
  }
  
  public void executeTask() {
    HomeMaterias _homeMaterias = this.homeMaterias();
    Materia _modelObject = this.getModelObject();
    _homeMaterias.create(_modelObject);
    super.executeTask();
  }
}
