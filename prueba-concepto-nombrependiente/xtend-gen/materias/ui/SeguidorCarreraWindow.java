package materias.ui;

import java.awt.Color;
import materias.applicationModel.SeguidorCarrera;
import materias.domain.Materia;
import materias.ui.CrearMateriaWindow;
import materias.ui.EditarMateriaWindow;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class SeguidorCarreraWindow extends SimpleWindow<SeguidorCarrera> {
  public SeguidorCarreraWindow(final WindowOwner parent) {
    super(parent, new SeguidorCarrera());
    SeguidorCarrera _modelObject = this.getModelObject();
    _modelObject.search();
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Seguidor de carrera");
    this.setTaskDescription("Ingrese los parámetros de búsqueda");
    super.createMainTemplate(mainPanel);
    this.createResultsGrid(mainPanel);
    this.panelEdicionMateria(mainPanel);
  }
  
  public void panelEdicionMateria(final Panel mainPanel) {
    Label _label = new Label(mainPanel);
    _label.setText("Materia:");
    Label _label_1 = new Label(mainPanel);
    _label_1.<ControlBuilder>bindValueToProperty("materiaSeleccionada.nombre");
    Label _label_2 = new Label(mainPanel);
    _label_2.setText("Profesor");
    TextBox _textBox = new TextBox(mainPanel);
    _textBox.<ControlBuilder>bindValueToProperty("materiaSeleccionada.profesor");
    Label _label_3 = new Label(mainPanel);
    _label_3.setText("Año de cursada");
    TextBox _textBox_1 = new TextBox(mainPanel);
    _textBox_1.<ControlBuilder>bindValueToProperty("materiaSeleccionada.anioCursada");
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
    labelNombre.setForeground(Color.RED);
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
    _setAsDefault.disableOnError();
    Button _button_1 = new Button(actionsPanel);
    Button _setCaption_1 = _button_1.setCaption("Limpiar");
    final Action _function_1 = new Action() {
      public void execute() {
        SeguidorCarrera _modelObject = SeguidorCarreraWindow.this.getModelObject();
        _modelObject.clear();
      }
    };
    _setCaption_1.onClick(_function_1);
    Button _button_2 = new Button(actionsPanel);
    Button _setCaption_2 = _button_2.setCaption("Nueva Materia");
    final Action _function_2 = new Action() {
      public void execute() {
        SeguidorCarreraWindow.this.crearMateria();
      }
    };
    _setCaption_2.onClick(_function_2);
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
    Column<Materia> _setFixedSize = _setTitle.setFixedSize(150);
    _setFixedSize.bindContentsToProperty("nombre");
  }
  
  public void createGridActions(final Panel mainPanel) {
    Panel actionsPanel = new Panel(mainPanel);
    VerticalLayout _verticalLayout = new VerticalLayout();
    actionsPanel.setLayout(_verticalLayout);
    Button _button = new Button(actionsPanel);
    Button _setCaption = _button.setCaption("Editar Materia");
    final Action _function = new Action() {
      public void execute() {
        SeguidorCarreraWindow.this.editarMateriaSeleccionada();
      }
    };
    Button botonEditar = _setCaption.onClick(_function);
    Button _button_1 = new Button(actionsPanel);
    Button _setCaption_1 = _button_1.setCaption("Borrar Materia");
    final Action _function_1 = new Action() {
      public void execute() {
        SeguidorCarrera _modelObject = SeguidorCarreraWindow.this.getModelObject();
        _modelObject.eliminarMateriaSeleccionada();
      }
    };
    Button botonBorrar = _setCaption_1.onClick(_function_1);
    NotNullObservable materiaSeleccionada = new NotNullObservable("materiaSeleccionada");
    botonEditar.<ControlBuilder>bindEnabled(materiaSeleccionada);
    botonBorrar.<ControlBuilder>bindEnabled(materiaSeleccionada);
  }
  
  public void crearMateria() {
    CrearMateriaWindow _crearMateriaWindow = new CrearMateriaWindow(this);
    this.openDialog(_crearMateriaWindow);
  }
  
  public void editarMateriaSeleccionada() {
    SeguidorCarrera _modelObject = this.getModelObject();
    Materia _materiaSeleccionada = _modelObject.getMateriaSeleccionada();
    EditarMateriaWindow _editarMateriaWindow = new EditarMateriaWindow(this, _materiaSeleccionada);
    this.openDialog(_editarMateriaWindow);
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
}
