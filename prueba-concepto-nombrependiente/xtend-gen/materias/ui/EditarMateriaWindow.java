package materias.ui;

import materias.domain.Materia;
import materias.home.HomeMaterias;
import org.apache.commons.lang.StringUtils;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.TextFilter;
import org.uqbar.arena.widgets.TextInputEvent;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class EditarMateriaWindow extends Dialog<Materia> {
  public EditarMateriaWindow(final WindowOwner owner, final Materia model) {
    super(owner, model);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Nueva Materia");
    final Panel form = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    form.setLayout(_columnLayout);
    Label _label = new Label(form);
    _label.setText("Nombre de Materia");
    TextBox _textBox = new TextBox(form);
    final TextFilter _function = new TextFilter() {
      public boolean accept(final TextInputEvent event) {
        String _potentialTextResult = event.getPotentialTextResult();
        return StringUtils.isAlphaSpace(_potentialTextResult);
      }
    };
    TextBox _withFilter = _textBox.withFilter(_function);
    _withFilter.<ControlBuilder>bindValueToProperty("nombre");
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    Button _setCaption = _button.setCaption("Aceptar");
    final Action _function = new Action() {
      public void execute() {
        EditarMateriaWindow.this.accept();
      }
    };
    Button _onClick = _setCaption.onClick(_function);
    Button _setAsDefault = _onClick.setAsDefault();
    _setAsDefault.disableOnError();
    Button _button_1 = new Button(actions);
    Button _setCaption_1 = _button_1.setCaption("Cancelar");
    final Action _function_1 = new Action() {
      public void execute() {
        EditarMateriaWindow.this.cancel();
      }
    };
    _setCaption_1.onClick(_function_1);
  }
  
  public HomeMaterias homeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Materia.class);
    return ((HomeMaterias) _singleton);
  }
}
