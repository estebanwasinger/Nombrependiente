package materias.ui;

import com.google.common.collect.Lists;
import com.uqbar.commons.collections.Transformer;
import java.util.Collections;
import java.util.List;
import materias.applicationModel.SeguidorCarrera;
import materias.domain.Materia;
import materias.domain.Nota;
import materias.home.HomeMaterias;
import materias.ui.CrearMateriaWindow;
import materias.ui.CrearNotaWindow;
import materias.ui.EditarNotaWindow;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
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
import org.uqbar.arena.windows.ErrorsPanel;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@Observable
@SuppressWarnings("all")
public class SeguidorCarreraWindow extends MainWindow<SeguidorCarrera> {
  private final List<String> posiblesUbicaciones = Collections.<String>unmodifiableList(Lists.<String>newArrayList("Nivel 1 - 1er. Cuatrimestre", "Nivel 1 - 2do. Cuatrimestre", "Nivel 1 - Anual", "Nivel 2 - 1er. Cuatrimestre", "Nivel 2 - 2do. Cuatrimestre", "Nivel 2 - Anual", "Nivel 3 - 1er. Cuatrimestre", "Nivel 3 - 2do. Cuatrimestre", "Nivel 3 - Anual", "Nivel 4 - 1er. Cuatrimestre", "Nivel 4 - 2do. Cuatrimestre", "Nivel 4 - Anual", "Nivel 5 - 1er. Cuatrimestre", "Nivel 5 - 2do. Cuatrimestre", "Nivel 5 - Anual"));
  
  @Observable
  public void createContents(final Panel mainPanel) {
    this.setTitle("Seguidor de carrera");
    new ErrorsPanel(mainPanel, "Seguidor OK");
    Panel panel2Columnas = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    panel2Columnas.setLayout(_columnLayout);
    Panel panelIzquierda = new Panel(panel2Columnas);
    Panel panelDerecha = new Panel(panel2Columnas);
    Label _label = new Label(panelIzquierda);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Seguidor de Carreras");
        it.setFontSize(20);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    Panel _panel = new Panel(panelIzquierda);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    Panel panelBotones = _panel.setLayout(_horizontalLayout);
    this.addActions(panelBotones);
    this.createFormPanel(panelIzquierda);
    this.grillaDeMaterias(panelIzquierda);
    this.panelEdicionMateria(panelDerecha);
    this.grillaDeNotas(panelDerecha);
  }
  
  public static void main(final String[] args) {
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomeMaterias _homeMaterias = new HomeMaterias();
    _instance.<HomeMaterias>configureSingleton(Materia.class, _homeMaterias);
    SeguidorCarreraWindow _seguidorCarreraWindow = new SeguidorCarreraWindow();
    _seguidorCarreraWindow.startApplication();
  }
  
  public List<Object> asObjects(final List<?> list) {
    final Function1<Object,Object> _function = new Function1<Object,Object>() {
      public Object apply(final Object it) {
        return ((Object) it);
      }
    };
    return ListExtensions.map(list, _function);
  }
  
  public List<Object> getUbicacionesPosibles() {
    return this.asObjects(this.posiblesUbicaciones);
  }
  
  public SeguidorCarreraWindow() {
    super(new SeguidorCarrera());
    SeguidorCarrera _modelObject = this.getModelObject();
    _modelObject.search();
  }
  
  public void grillaDeNotas(final Panel mainPanel) {
    Table<Nota> table = new Table<Nota>(mainPanel, Nota.class);
    table.setHeigth(150);
    table.setWidth(400);
    table.bindItemsToProperty("materiaSeleccionada.notas");
    table.<ControlBuilder>bindValueToProperty("notaSeleccionada");
    Column<Nota> _column = new Column<Nota>(table);
    Column<Nota> _setTitle = _column.setTitle("Fecha");
    _setTitle.bindContentsToProperty("fecha");
    Column<Nota> _column_1 = new Column<Nota>(table);
    Column<Nota> _setTitle_1 = _column_1.setTitle("Descripcion");
    _setTitle_1.bindContentsToProperty("descripcion");
    Column<Nota> _column_2 = new Column<Nota>(table);
    Column<Nota> _setTitle_2 = _column_2.setTitle("Aprobado");
    final Transformer<Nota,String> _function = new Transformer<Nota,String>() {
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
    _setTitle_2.<String>bindContentsToTransformer(_function);
  }
  
  public void panelEdicionMateria(final Panel mainPanel) {
    Panel panelEdicionColumnas = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    panelEdicionColumnas.setLayout(_columnLayout);
    Label _label = new Label(panelEdicionColumnas);
    _label.setText("Materia:");
    Label _label_1 = new Label(panelEdicionColumnas);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.<ControlBuilder>bindValueToProperty("materiaSeleccionada.nombre");
        it.setWidth(200);
        it.setFontSize(15);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function);
    Label _label_2 = new Label(panelEdicionColumnas);
    _label_2.setText("Profesor");
    TextBox _textBox = new TextBox(panelEdicionColumnas);
    final Procedure1<TextBox> _function_1 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<ControlBuilder>bindValueToProperty("materiaSeleccionada.profesor");
        it.setWidth(200);
        it.setFontSize(10);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function_1);
    Label _label_3 = new Label(panelEdicionColumnas);
    _label_3.setText("Año de cursada");
    TextBox _textBox_1 = new TextBox(panelEdicionColumnas);
    final Procedure1<TextBox> _function_2 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<ControlBuilder>bindValueToProperty("materiaSeleccionada.anioCursada");
        it.setWidth(200);
        it.setFontSize(10);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_2);
    Label _label_4 = new Label(panelEdicionColumnas);
    _label_4.setText("Final Aprobado");
    CheckBox checkAprobado = new CheckBox(panelEdicionColumnas);
    checkAprobado.<ControlBuilder>bindValueToProperty("materiaSeleccionada.finalAprobado");
    Label _label_5 = new Label(panelEdicionColumnas);
    _label_5.setText("Ubicacion Materia");
    Selector<Object> _selector = new Selector<Object>(panelEdicionColumnas);
    final Procedure1<Selector<Object>> _function_3 = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        it.allowNull(false);
        ObservableProperty _observableProperty = new ObservableProperty(SeguidorCarreraWindow.this, "ubicacionesPosibles");
        it.bindItems(_observableProperty);
        it.<ControlBuilder>bindValueToProperty("materiaSeleccionada.ubicacion");
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function_3);
    Panel _panel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    Panel panelBotonesNotas = _panel.setLayout(_horizontalLayout);
    Button _button = new Button(panelBotonesNotas);
    Button _setCaption = _button.setCaption("Editar Nota");
    final Action _function_4 = new Action() {
      public void execute() {
        SeguidorCarreraWindow.this.editarNota();
      }
    };
    Button _onClick = _setCaption.onClick(_function_4);
    Button _setAsDefault = _onClick.setAsDefault();
    Link _disableOnError = _setAsDefault.disableOnError();
    SkinnableControl edicionNota = _disableOnError.setFontSize(9);
    Button _button_1 = new Button(panelBotonesNotas);
    Button _setCaption_1 = _button_1.setCaption("Agregar Nota");
    final Action _function_5 = new Action() {
      public void execute() {
        SeguidorCarreraWindow.this.cargarNota();
      }
    };
    Button _onClick_1 = _setCaption_1.onClick(_function_5);
    Button _setAsDefault_1 = _onClick_1.setAsDefault();
    Link _disableOnError_1 = _setAsDefault_1.disableOnError();
    SkinnableControl nuevaNota = _disableOnError_1.setFontSize(9);
    NotNullObservable notaMarcada = new NotNullObservable("notaSeleccionada");
    edicionNota.<ControlBuilder>bindEnabled(notaMarcada);
    NotNullObservable materiaMarcada = new NotNullObservable("materiaSeleccionada");
    nuevaNota.<ControlBuilder>bindEnabled(materiaMarcada);
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
    TextBox _textBox = new TextBox(searchFormPanel);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<ControlBuilder>bindValueToProperty("nombre");
        it.setWidth(200);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
  }
  
  public SkinnableControl addActions(final Panel actionsPanel) {
    SkinnableControl _xblockexpression = null;
    {
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
      _disableOnError.setFontSize(12);
      Button _button_1 = new Button(actionsPanel);
      Button _setCaption_1 = _button_1.setCaption("Limpiar");
      final Action _function_1 = new Action() {
        public void execute() {
          SeguidorCarrera _modelObject = SeguidorCarreraWindow.this.getModelObject();
          _modelObject.clear();
        }
      };
      Button _onClick_1 = _setCaption_1.onClick(_function_1);
      _onClick_1.setFontSize(12);
      Button _button_2 = new Button(actionsPanel);
      Button _setCaption_2 = _button_2.setCaption("Nueva Materia");
      final Action _function_2 = new Action() {
        public void execute() {
          SeguidorCarreraWindow.this.crearMateria();
        }
      };
      Button _onClick_2 = _setCaption_2.onClick(_function_2);
      _xblockexpression = _onClick_2.setFontSize(12);
    }
    return _xblockexpression;
  }
  
  protected void grillaDeMaterias(final Panel mainPanel) {
    Table<Materia> table = new Table<Materia>(mainPanel, Materia.class);
    table.setHeigth(230);
    table.setWidth(300);
    table.bindItemsToProperty("resultados");
    table.<ControlBuilder>bindValueToProperty("materiaSeleccionada");
    this.describeResultsGrid(table);
  }
  
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
  
  public void cargarNota() {
    Nota _nota = new Nota();
    SeguidorCarrera _modelObject = this.getModelObject();
    Materia _materiaSeleccionada = _modelObject.getMateriaSeleccionada();
    CrearNotaWindow _crearNotaWindow = new CrearNotaWindow(this, _nota, _materiaSeleccionada);
    this.openDialogNota(_crearNotaWindow);
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
