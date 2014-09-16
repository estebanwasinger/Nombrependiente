package futbol5.ui;

import com.google.common.collect.Lists;
import futbol5.applicationModel.Futbol5;
import futbol5.domain.Jugador;
import futbol5.ui.DateTextFilter;
import futbol5.ui.RunnableBusquedaJugadores;
import futbol5.ui.VerDatosJugadorWindow;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.DateAdapter;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Link;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.SkinnableControl;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@Observable
@SuppressWarnings("all")
public class BusquedaJugadoresWindow extends Dialog<Futbol5> {
  public BusquedaJugadoresWindow(final WindowOwner parent, final Futbol5 modelObject) {
    super(parent, modelObject);
  }
  
  public BusquedaJugadoresWindow(final RunnableBusquedaJugadores parent) {
    super(parent, new Futbol5());
  }
  
  private Jugador jugador = new Jugador();
  
  public void createContents(final Panel mainPanel) {
    this.setTitle("Busqueda de Jugadores");
    Panel panel2Columnas = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    panel2Columnas.setLayout(_columnLayout);
    Panel panelIzquierda = new Panel(panel2Columnas);
    Panel panelDerecha = new Panel(panel2Columnas);
    Label _label = new Label(panelIzquierda);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Busqueda");
        it.setFontSize(20);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    Label _label_1 = new Label(panelDerecha);
    final Procedure1<Label> _function_1 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Resultados");
        it.setFontSize(20);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function_1);
    this.addActions(mainPanel);
    this.createFormPanel(panelIzquierda);
    this.grillaBasicaJugadores(panelDerecha);
  }
  
  protected void addActions(final Panel actionPanel) {
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    actionPanel.setLayout(_horizontalLayout);
    Button _button = new Button(actionPanel);
    _button.setCaption("Regresar");
  }
  
  public void createFormPanel(final Panel panelIzquierda) {
    this.setTitle("Busqueda Jugador");
    VerticalLayout _verticalLayout = new VerticalLayout();
    panelIzquierda.setLayout(_verticalLayout);
    final Panel busquedaSuperior = new Panel(panelIzquierda);
    VerticalLayout _verticalLayout_1 = new VerticalLayout();
    busquedaSuperior.setLayout(_verticalLayout_1);
    this.criteriosDeBusqueda(busquedaSuperior);
  }
  
  public void criteriosDeBusqueda(final Panel busquedaSuperior) {
    Label labelNombre = new Label(busquedaSuperior);
    labelNombre.setText("Nombre Jugador");
    TextBox _textBox = new TextBox(busquedaSuperior);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<ControlBuilder>bindValueToProperty("jugador.nombre");
        it.setWidth(200);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    Label labelApodo = new Label(busquedaSuperior);
    labelApodo.setText("Apodo Jugador");
    TextBox _textBox_1 = new TextBox(busquedaSuperior);
    final Procedure1<TextBox> _function_1 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<ControlBuilder>bindValueToProperty("jugador.apodo");
        it.setWidth(200);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_1);
    Label _label = new Label(busquedaSuperior);
    _label.setText("Fecha de nacimiento menor a:");
    final TextBox textBoxFecha = new TextBox(busquedaSuperior);
    DateTextFilter _dateTextFilter = new DateTextFilter();
    textBoxFecha.withFilter(_dateTextFilter);
    final Binding<ControlBuilder> binding = textBoxFecha.<ControlBuilder>bindValueToProperty("fechaNacimiento");
    DateAdapter _dateAdapter = new DateAdapter();
    binding.setTransformer(_dateAdapter);
    Panel searchFormPanel = new Panel(busquedaSuperior);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    searchFormPanel.setLayout(_columnLayout);
    this.crearTextBox(busquedaSuperior, "Handicap desde", "busquedaJugadores.handicapDesde");
    this.crearTextBox(busquedaSuperior, "Handicap hasta", "busquedaJugadores.handicapHasta");
    Label labelInfraccion = new Label(busquedaSuperior);
    labelInfraccion.setText("Infracciones");
    Selector<Object> _selector = new Selector<Object>(busquedaSuperior);
    final Procedure1<Selector<Object>> _function_2 = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        it.allowNull(false);
        ObservableProperty _observableProperty = new ObservableProperty(BusquedaJugadoresWindow.this, "eligeInfracciones");
        it.bindItems(_observableProperty);
        it.<ControlBuilder>bindValueToProperty("infracciones");
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function_2);
    Button _button = new Button(busquedaSuperior);
    Button _setCaption = _button.setCaption("Buscar");
    final Action _function_3 = new Action() {
      public void execute() {
        Futbol5 _modelObject = BusquedaJugadoresWindow.this.getModelObject();
        _modelObject.search(BusquedaJugadoresWindow.this.jugador);
      }
    };
    Button _onClick = _setCaption.onClick(_function_3);
    SkinnableControl _setFontSize = _onClick.setFontSize(12);
    _setFontSize.setWidth(200);
    Button _button_1 = new Button(busquedaSuperior);
    Button _setCaption_1 = _button_1.setCaption("Limpiar");
    final Action _function_4 = new Action() {
      public void execute() {
        Futbol5 _modelObject = BusquedaJugadoresWindow.this.getModelObject();
        _modelObject.clear();
      }
    };
    Button _onClick_1 = _setCaption_1.onClick(_function_4);
    SkinnableControl _setFontSize_1 = _onClick_1.setFontSize(12);
    _setFontSize_1.setWidth(200);
  }
  
  public Binding<ControlBuilder> crearTextBox(final Panel searchFormPanel, final String label, final String binding) {
    Binding<ControlBuilder> _xblockexpression = null;
    {
      Label labelNumero = new Label(searchFormPanel);
      labelNumero.setText(label);
      final TextBox textBox = new TextBox(searchFormPanel);
      _xblockexpression = textBox.<ControlBuilder>bindValueToProperty(binding);
    }
    return _xblockexpression;
  }
  
  public void grillaBasicaJugadores(final Panel panelJugadores) {
    Table<Jugador> table = new Table<Jugador>(panelJugadores, Jugador.class);
    table.setHeigth(200);
    table.setWidth(590);
    table.<ControlBuilder>bindValueToProperty("seleccionJugador");
    Column<Jugador> _column = new Column<Jugador>(table);
    Column<Jugador> _setTitle = _column.setTitle("Nombre");
    Column<Jugador> _setFixedSize = _setTitle.setFixedSize(150);
    _setFixedSize.bindContentsToProperty("nombre");
    Column<Jugador> _column_1 = new Column<Jugador>(table);
    Column<Jugador> _setTitle_1 = _column_1.setTitle("Apodo");
    Column<Jugador> _setFixedSize_1 = _setTitle_1.setFixedSize(150);
    _setFixedSize_1.bindContentsToProperty("apodo");
    Column<Jugador> _column_2 = new Column<Jugador>(table);
    Column<Jugador> _setTitle_2 = _column_2.setTitle("Handicap");
    Column<Jugador> _setFixedSize_2 = _setTitle_2.setFixedSize(150);
    _setFixedSize_2.bindContentsToProperty("nivelDeJuego");
    Column<Jugador> _column_3 = new Column<Jugador>(table);
    Column<Jugador> _setTitle_3 = _column_3.setTitle("Promedio");
    _setTitle_3.setFixedSize(150);
    Button _button = new Button(panelJugadores);
    Button _setCaption = _button.setCaption("Ver Datos Completos");
    final Action _function = new Action() {
      public void execute() {
        BusquedaJugadoresWindow.this.grillaCompletaJugador();
      }
    };
    Button _onClick = _setCaption.onClick(_function);
    Button _setAsDefault = _onClick.setAsDefault();
    Link _disableOnError = _setAsDefault.disableOnError();
    Control verDatos = _disableOnError.setWidth(200);
    NotNullObservable jugadorMarcado = new NotNullObservable("seleccionJugador");
    verDatos.<ControlBuilder>bindEnabled(jugadorMarcado);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        Futbol5 _modelObject = BusquedaJugadoresWindow.this.getModelObject();
        _modelObject.search(BusquedaJugadoresWindow.this.jugador);
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
  
  public void grillaCompletaJugador() {
    Futbol5 _modelObject = this.getModelObject();
    Jugador _seleccionJugador = _modelObject.getSeleccionJugador();
    VerDatosJugadorWindow _verDatosJugadorWindow = new VerDatosJugadorWindow(this, _seleccionJugador);
    this.openDialog(_verDatosJugadorWindow);
  }
  
  public List<String> getEligeInfracciones() {
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList("Solo Infracciones", "Solo No Infracciones", "Todos"));
  }
}
