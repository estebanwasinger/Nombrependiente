package materias.ui;

import com.google.common.collect.Lists;
import com.uqbar.commons.collections.Transformer;
import java.awt.Color;
import java.util.Collections;
import java.util.List;
import materias.applicationModel.SeguidorCarrera;
import materias.domain.Materia;
import materias.domain.Nota;
import materias.ui.CrearMateriaWindow;
import materias.ui.EditarNotaWindow;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Link;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.SkinnableControl;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@Observable
@SuppressWarnings("all")
public class SeguidorCarreraWindow extends SimpleWindow<SeguidorCarrera> {
  private final List<String> posiblesUbicaciones = Collections.<String>unmodifiableList(Lists.<String>newArrayList("Nivel 1 - 1er. Cuatrimestre", "Nivel 1 - 2do. Cuatrimestre", "Nivel 1 - Anual", "Nivel 2 - 1er. Cuatrimestre", "Nivel 2 - 2do. Cuatrimestre", "Nivel 2 - Anual", "Nivel 3 - 1er. Cuatrimestre", "Nivel 3 - 2do. Cuatrimestre", "Nivel 3 - Anual", "Nivel 4 - 1er. Cuatrimestre", "Nivel 4 - 2do. Cuatrimestre", "Nivel 4 - Anual", "Nivel 5 - 1er. Cuatrimestre", "Nivel 5 - 2do. Cuatrimestre", "Nivel 5 - Anual"));
  
  public List<Object> asObjects(final List<?> list) {
    final Function1<Object, Object> _function = new Function1<Object, Object>() {
      public Object apply(final Object it) {
        return ((Object) it);
      }
    };
    return ListExtensions.map(list, _function);
  }
  
  public List<Object> getUbicacionesPosibles() {
    return this.asObjects(this.posiblesUbicaciones);
  }
  
  public SeguidorCarreraWindow(final WindowOwner parent) {
    super(parent, new SeguidorCarrera());
    SeguidorCarrera _modelObject = this.getModelObject();
    _modelObject.search();
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Seguidor de carrera");
    this.setTaskDescription("Ingrese los parámetros de búsqueda");
    super.createMainTemplate(mainPanel);
    this.grillaDeMaterias(mainPanel);
    this.panelEdicionMateria(mainPanel);
    this.grillaDeNotas(mainPanel);
  }
  
  public void grillaDeMaterias(final Panel mainPanel) {
    this.createResultsGrid(mainPanel);
  }
  
  public void grillaDeNotas(final Panel mainPanel) {
    Table<Nota> table = new Table<Nota>(mainPanel, Nota.class);
    table.setHeigth(150);
    table.setWidth(600);
    table.bindItemsToProperty("notas");
    table.<ControlBuilder>bindValueToProperty("notaSeleccionada");
    Column<Nota> _column = new Column<Nota>(table);
    Column<Nota> _setTitle = _column.setTitle("Fecha");
    Column<Nota> _setFixedSize = _setTitle.setFixedSize(200);
    _setFixedSize.bindContentsToProperty("fecha");
    Column<Nota> _column_1 = new Column<Nota>(table);
    Column<Nota> _setTitle_1 = _column_1.setTitle("Descripcion");
    Column<Nota> _setFixedSize_1 = _setTitle_1.setFixedSize(200);
    _setFixedSize_1.bindContentsToProperty("descripcion");
    Column<Nota> _column_2 = new Column<Nota>(table);
    Column<Nota> _setTitle_2 = _column_2.setTitle("Aprobado");
    Column<Nota> _setFixedSize_2 = _setTitle_2.setFixedSize(200);
    final Transformer<Nota, String> _function = new Transformer<Nota, String>() {
      public String transform(final Nota nota) {
        String _xifexpression = null;
        Boolean _aprobado = nota.getAprobado();
        if ((_aprobado).booleanValue()) {
          _xifexpression = "SI";
        } else {
          _xifexpression = "NO";
        }
        return _xifexpression;
      }
    };
    _setFixedSize_2.<String>bindContentsToTransformer(_function);
  }
  
  public void panelEdicionMateria(final Panel mainPanel) {
    Label _label = new Label(mainPanel);
    Label _setText = _label.setText("Materia:");
    _setText.setForeground(Color.RED);
    Label _label_1 = new Label(mainPanel);
    _label_1.<ControlBuilder>bindValueToProperty("materiaSeleccionada.nombre");
    Label _label_2 = new Label(mainPanel);
    Label _setText_1 = _label_2.setText("Profesor");
    _setText_1.setForeground(Color.RED);
    TextBox _textBox = new TextBox(mainPanel);
    _textBox.<ControlBuilder>bindValueToProperty("materiaSeleccionada.profesor");
    Label _label_3 = new Label(mainPanel);
    Label _setText_2 = _label_3.setText("Año de cursada");
    _setText_2.setForeground(Color.RED);
    TextBox _textBox_1 = new TextBox(mainPanel);
    _textBox_1.<ControlBuilder>bindValueToProperty("materiaSeleccionada.anioCursada");
    Label _label_4 = new Label(mainPanel);
    _label_4.setText("Final Aprobado");
    CheckBox checkAprobado = new CheckBox(mainPanel);
    checkAprobado.<ControlBuilder>bindValueToProperty("materiaSeleccionada.finalAprobado");
    Label _label_5 = new Label(mainPanel);
    _label_5.setText("Ubicacion Materia");
    Selector<Object> _selector = new Selector<Object>(mainPanel);
    final Procedure1<Selector<Object>> _function = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        it.allowNull(false);
        ObservableProperty _observableProperty = new ObservableProperty(SeguidorCarreraWindow.this, "ubicacionesPosibles");
        it.bindItems(_observableProperty);
        it.<ControlBuilder>bindValueToProperty("materiaSeleccionada.ubicacion");
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function);
    Label _label_6 = new Label(mainPanel);
    _label_6.setText("Notas de Cursada");
  }
  
  /**
   * El panel principal de búsuqeda permite filtrar por número o nombre
   */
  public void createFormPanel(final Panel mainPanel) {
    Panel searchFormPanel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    searchFormPanel.setLayout(_columnLayout);
    Label labelNombre = new Label(searchFormPanel);
    labelNombre.setText("Nombre de materia");
    Color _darker = Color.RED.darker();
    labelNombre.setForeground(_darker);
    TextBox _textBox = new TextBox(searchFormPanel);
    _textBox.<ControlBuilder>bindValueToProperty("nombre");
  }
  
  /**
   * Acciones asociadas de la pantalla principal. Interesante para ver es cómo funciona el binding que mapea
   * la acción que se dispara cuando el usuario presiona click Para que el binding sea flexible necesito
   * decirle objeto al que disparo la acción y el mensaje a enviarle Contra: estoy atado a tener métodos sin
   * parámetros. Eso me impide poder pasarle parámetros como en el caso del alta/modificación.
   * Buscar/Limpiar -> son acciones que resuelve el modelo (BuscadorCelular) Nuevo -> necesita disparar una
   * pantalla de alta, entonces lo resuelve la vista (this)
   */
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    Button _setCaption = _button.setCaption("Buscar");
    final Action _function = new Action() {
      public void execute() {
        SeguidorCarrera _modelObject = SeguidorCarreraWindow.this.getModelObject();
        _modelObject.search();
      }
    };
    Button _onClick = _setCaption.onClick(_function);
    Button _setAsDefault = _onClick.setAsDefault();
    Link _disableOnError = _setAsDefault.disableOnError();
    SkinnableControl _setFontSize = _disableOnError.setFontSize(12);
    _setFontSize.setForeground(Color.BLUE);
    Button _button_1 = new Button(actionsPanel);
    Button _setCaption_1 = _button_1.setCaption("Limpiar");
    final Action _function_1 = new Action() {
      public void execute() {
        SeguidorCarrera _modelObject = SeguidorCarreraWindow.this.getModelObject();
        _modelObject.clear();
      }
    };
    Button _onClick_1 = _setCaption_1.onClick(_function_1);
    SkinnableControl _setFontSize_1 = _onClick_1.setFontSize(12);
    _setFontSize_1.setForeground(Color.BLUE);
    Button _button_2 = new Button(actionsPanel);
    Button _setCaption_2 = _button_2.setCaption("Nueva Materia");
    final Action _function_2 = new Action() {
      public void execute() {
        SeguidorCarreraWindow.this.crearMateria();
      }
    };
    Button _onClick_2 = _setCaption_2.onClick(_function_2);
    SkinnableControl _setFontSize_2 = _onClick_2.setFontSize(12);
    _setFontSize_2.setForeground(Color.BLUE);
    Button _button_3 = new Button(actionsPanel);
    Button _setCaption_3 = _button_3.setCaption("Cargar notas");
    final Action _function_3 = new Action() {
      public void execute() {
        SeguidorCarrera _modelObject = SeguidorCarreraWindow.this.getModelObject();
        _modelObject.buscar();
      }
    };
    Button _onClick_3 = _setCaption_3.onClick(_function_3);
    Button _setAsDefault_1 = _onClick_3.setAsDefault();
    Link _disableOnError_1 = _setAsDefault_1.disableOnError();
    SkinnableControl _setFontSize_3 = _disableOnError_1.setFontSize(12);
    _setFontSize_3.setForeground(Color.BLUE);
    Button _button_4 = new Button(actionsPanel);
    Button _setCaption_4 = _button_4.setCaption("Editar Nota");
    final Action _function_4 = new Action() {
      public void execute() {
        SeguidorCarreraWindow.this.editarNota();
      }
    };
    Button _onClick_4 = _setCaption_4.onClick(_function_4);
    Button _setAsDefault_2 = _onClick_4.setAsDefault();
    Link _disableOnError_2 = _setAsDefault_2.disableOnError();
    SkinnableControl _setFontSize_4 = _disableOnError_2.setFontSize(12);
    _setFontSize_4.setForeground(Color.BLUE);
  }
  
  /**
   * Se crea la grilla en el panel de abajo El binding es: el contenido de la grilla en base a los
   * resultados de la búsqueda Cuando el usuario presiona Buscar, se actualiza el model, y éste a su vez
   * dispara la notificación a la grilla que funciona como Observer
   */
  protected void createResultsGrid(final Panel mainPanel) {
    Table<Materia> table = new Table<Materia>(mainPanel, Materia.class);
    table.setHeigth(150);
    table.setWidth(450);
    table.bindItemsToProperty("resultados");
    table.<ControlBuilder>bindValueToProperty("materiaSeleccionada");
    this.describeResultsGrid(table);
  }
  
  /**
   * Define las columnas de la grilla Cada columna se puede bindear 1) contra una propiedad del model, como
   * en el caso del número o el nombre 2) contra un transformer que recibe el model y devuelve un tipo
   * (generalmente String), como en el caso de Recibe Resumen de Cuenta
   * 
   * @param table
   */
  public void describeResultsGrid(final Table<Materia> table) {
    Column<Materia> _column = new Column<Materia>(table);
    Column<Materia> _setTitle = _column.setTitle("Nombre");
    Column<Materia> _setFixedSize = _setTitle.setFixedSize(450);
    _setFixedSize.bindContentsToProperty("nombre");
  }
  
  public void crearMateria() {
    CrearMateriaWindow _crearMateriaWindow = new CrearMateriaWindow(this);
    this.openDialog(_crearMateriaWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        SeguidorCarrera _modelObject = SeguidorCarreraWindow.this.getModelObject();
        _modelObject.search();
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
  
  public void editarNota() {
    SeguidorCarrera _modelObject = this.getModelObject();
    Nota _notaSeleccionada = _modelObject.getNotaSeleccionada();
    EditarNotaWindow _editarNotaWindow = new EditarNotaWindow(this, _notaSeleccionada);
    this.openDialogNota(_editarNotaWindow);
  }
  
  public void openDialogNota(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        SeguidorCarrera _modelObject = SeguidorCarreraWindow.this.getModelObject();
        _modelObject.buscar();
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
}
