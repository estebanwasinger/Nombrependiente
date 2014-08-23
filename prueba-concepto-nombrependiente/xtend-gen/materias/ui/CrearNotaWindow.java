package materias.ui;

import java.util.List;
import materias.domain.Materia;
import materias.domain.Nota;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class CrearNotaWindow extends Dialog<Nota> {
  private TextBox fechaBox;
  
  private Materia materiaSeleccionada;
  
  private Nota notaNueva;
  
  public CrearNotaWindow(final WindowOwner owner, final Nota nota, final Materia materia) {
    super(owner, nota);
    this.notaNueva = nota;
    this.materiaSeleccionada = materia;
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Editar nota");
    final Panel form = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    form.setLayout(_columnLayout);
    String _nombre = this.materiaSeleccionada.getNombre();
    InputOutput.<String>println(_nombre);
    Label _label = new Label(form);
    _label.setText("Fecha");
    TextBox _textBox = new TextBox(form);
    this.fechaBox = _textBox;
    this.fechaBox.<ControlBuilder>bindValueToProperty("fecha");
    Label _label_1 = new Label(form);
    _label_1.setText("Descripción");
    TextBox _textBox_1 = new TextBox(form);
    _textBox_1.<ControlBuilder>bindValueToProperty("descripcion");
    CheckBox _checkBox = new CheckBox(form);
    _checkBox.<ControlBuilder>bindValueToProperty("aprobado");
    Label _label_2 = new Label(form);
    _label_2.setText("Aprobado");
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    Button _setCaption = _button.setCaption("Aceptar");
    final Action _function = new Action() {
      public void execute() {
        CrearNotaWindow.this.accept();
        CrearNotaWindow.this.guardarNota();
      }
    };
    Button _onClick = _setCaption.onClick(_function);
    Button _setAsDefault = _onClick.setAsDefault();
    _setAsDefault.disableOnError();
    Button _button_1 = new Button(actions);
    Button _setCaption_1 = _button_1.setCaption("Cancelar");
    final Action _function_1 = new Action() {
      public void execute() {
        CrearNotaWindow.this.cancel();
      }
    };
    _setCaption_1.onClick(_function_1);
  }
  
  public void guardarNota() {
    boolean _isAprobado = this.notaNueva.isAprobado();
    boolean _notEquals = (_isAprobado != true);
    if (_notEquals) {
      this.notaNueva.setAprobado(false);
    }
    List<Nota> _notas = this.materiaSeleccionada.getNotas();
    _notas.add(this.notaNueva);
  }
}
