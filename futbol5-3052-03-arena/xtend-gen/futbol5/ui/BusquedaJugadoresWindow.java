package futbol5.ui;

import com.google.common.collect.Lists;
import futbol5.applicationModel.BusquedaJugadoresAppModel;
import futbol5.auxUtils.DateTextFilter;
import futbol5.domain.Jugador;
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
public class BusquedaJugadoresWindow extends Dialog<BusquedaJugadoresAppModel> {
  public BusquedaJugadoresWindow(final WindowOwner parent, final BusquedaJugadoresAppModel modelObject) {
    super(parent, modelObject);
  }
  
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
        it.setFontSize(30);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    Label _label_1 = new Label(panelDerecha);
    final Procedure1<Label> _function_1 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Resultados");
        it.setFontSize(30);
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
    Button _setCaption = _button.setCaption("Regresar");
    final Action _function = new Action() {
      public void execute() {
        BusquedaJugadoresWindow.this.close();
      }
    };
    _setCaption.onClick(_function);
  }
  
  public void createFormPanel(final Panel panelIzquierda) {
    this.setTitle("Busqueda Jugador");
    Panel panelBusqueda = new Panel(panelIzquierda);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    panelBusqueda.setLayout(_columnLayout);
    Panel izquierda = new Panel(panelBusqueda);
    Panel derecha = new Panel(panelBusqueda);
    Label labelNombre = new Label(izquierda);
    labelNombre.setFontSize(10);
    labelNombre.setText("Nombre comienza con..");
    TextBox _textBox = new TextBox(derecha);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<ControlBuilder>bindValueToProperty("jugadorEjemplo.nombre");
        it.setWidth(200);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    Label labelApodo = new Label(izquierda);
    labelApodo.setFontSize(10);
    labelApodo.setText("Apodo contiene...");
    TextBox _textBox_1 = new TextBox(derecha);
    final Procedure1<TextBox> _function_1 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<ControlBuilder>bindValueToProperty("jugadorEjemplo.apodo");
        it.setWidth(200);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_1);
    Label labelFecha = new Label(izquierda);
    labelFecha.setText("Fecha de nacimiento menor a:");
    labelFecha.setFontSize(10);
    final TextBox textBoxFecha = new TextBox(derecha);
    DateTextFilter _dateTextFilter = new DateTextFilter();
    textBoxFecha.withFilter(_dateTextFilter);
    final Binding<ControlBuilder> binding = textBoxFecha.<ControlBuilder>bindValueToProperty("jugadorEjemplo.fechaNacimiento");
    DateAdapter _dateAdapter = new DateAdapter();
    binding.setTransformer(_dateAdapter);
    Label labelHandicapD = new Label(izquierda);
    labelHandicapD.setText("Handicap desde:");
    Label labelHandicapH = new Label(derecha);
    labelHandicapH.setText("Handicap hasta:");
    TextBox _textBox_2 = new TextBox(izquierda);
    final Procedure1<TextBox> _function_2 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<ControlBuilder>bindValueToProperty("handicapDesde");
        it.setWidth(100);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_2, _function_2);
    TextBox _textBox_3 = new TextBox(derecha);
    final Procedure1<TextBox> _function_3 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<ControlBuilder>bindValueToProperty("handicapHasta");
        it.setWidth(100);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_3, _function_3);
    Label labelInfraccion = new Label(izquierda);
    labelInfraccion.setFontSize(10);
    labelInfraccion.setText("Infracciones");
    Selector<Object> _selector = new Selector<Object>(derecha);
    final Procedure1<Selector<Object>> _function_4 = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        ObservableProperty _observableProperty = new ObservableProperty(BusquedaJugadoresWindow.this, "eligeInfracciones");
        it.bindItems(_observableProperty);
        it.<ControlBuilder>bindValueToProperty("jugadorEjemplo.infracciones");
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function_4);
    Button _button = new Button(panelBusqueda);
    Button _setCaption = _button.setCaption("Buscar");
    final Action _function_5 = new Action() {
      public void execute() {
        BusquedaJugadoresAppModel _modelObject = BusquedaJugadoresWindow.this.getModelObject();
        _modelObject.search();
      }
    };
    Button _onClick = _setCaption.onClick(_function_5);
    SkinnableControl _setFontSize = _onClick.setFontSize(12);
    _setFontSize.setWidth(200);
    Button _button_1 = new Button(panelBusqueda);
    Button _setCaption_1 = _button_1.setCaption("Limpiar");
    final Action _function_6 = new Action() {
      public void execute() {
        BusquedaJugadoresAppModel _modelObject = BusquedaJugadoresWindow.this.getModelObject();
        _modelObject.clear();
      }
    };
    Button _onClick_1 = _setCaption_1.onClick(_function_6);
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
  
  public void grillaBasicaJugadores(final Panel panelResultados) {
    Table<Jugador> table = new Table<Jugador>(panelResultados, Jugador.class);
    table.setHeigth(360);
    table.setWidth(590);
    table.<ControlBuilder>bindValueToProperty("jugadorSeleccionado");
    table.bindItemsToProperty("jugadores");
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
    Column<Jugador> _setFixedSize_3 = _setTitle_3.setFixedSize(150);
    _setFixedSize_3.bindContentsToProperty("promedio");
    Button _button = new Button(panelResultados);
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
    NotNullObservable jugadorMarcado = new NotNullObservable("jugadorSeleccionado");
    verDatos.<ControlBuilder>bindEnabled(jugadorMarcado);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
  
  public void grillaCompletaJugador() {
    BusquedaJugadoresAppModel _modelObject = this.getModelObject();
    Jugador _jugadorSeleccionado = _modelObject.getJugadorSeleccionado();
    VerDatosJugadorWindow _verDatosJugadorWindow = new VerDatosJugadorWindow(this, _jugadorSeleccionado);
    this.openDialog(_verDatosJugadorWindow);
  }
  
  public List<String> getEligeInfracciones() {
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList("Con Infracciones", "Sin Infracciones", "Todos"));
  }
  
  public List<String> getEligeHandicap() {
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList("Handicap desde", "Handicap hasta"));
  }
}
