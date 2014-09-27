package futbol5.ui;

import com.google.common.collect.Lists;
import com.uqbar.commons.StringUtils;
import futbol5.applicationModel.BusquedaJugadoresAppModel;
import futbol5.auxUtils.DateTextFilter;
import futbol5.domain.Jugador;
import futbol5.ui.VerDatosJugadorWindow;
import java.awt.Color;
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
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.TextFilter;
import org.uqbar.arena.widgets.TextInputEvent;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.ErrorsPanel;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.WindowBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@Observable
@SuppressWarnings("all")
public class BusquedaJugadoresWindow extends Dialog<BusquedaJugadoresAppModel> {
  public BusquedaJugadoresWindow(final WindowOwner parent, final BusquedaJugadoresAppModel modelObject) {
    super(parent, modelObject);
    WindowBuilder _delegate = this.getDelegate();
    _delegate.setErrorViewer(this);
  }
  
  public void createContents(final Panel mainPanel) {
    this.setTitle("Busqueda de Jugadores");
    new ErrorsPanel(mainPanel, "Busqueda OK");
    Panel _panel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    _panel.setLayout(_columnLayout);
    Panel panelIzquierda = new Panel(mainPanel);
    Panel panelDerecha = new Panel(mainPanel);
    Label _label = new Label(panelIzquierda);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Busqueda");
        it.setFontSize(25);
        it.setForeground(Color.MAGENTA);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    Label _label_1 = new Label(panelIzquierda);
    _label_1.setText("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
    Label _label_2 = new Label(panelDerecha);
    final Procedure1<Label> _function_1 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Resultados");
        it.setFontSize(25);
        it.setForeground(Color.RED);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_2, _function_1);
    this.addActions(mainPanel);
    this.createFormPanel(panelIzquierda);
    this.grillaBasicaJugadores(panelDerecha);
  }
  
  protected void addActions(final Panel actionPanel) {
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    actionPanel.setLayout(_horizontalLayout);
    Button _button = new Button(actionPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Regresar");
        final Action _function = new Action() {
          public void execute() {
            BusquedaJugadoresWindow.this.close();
          }
        };
        it.onClick(_function);
        it.setFontSize(11);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  public void createFormPanel(final Panel panelIzquierda) {
    this.setTitle("Busqueda Jugador");
    Panel _panel = new Panel(panelIzquierda);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    Panel panelBusqueda = _panel.setLayout(_columnLayout);
    Panel izquierda = new Panel(panelBusqueda);
    Panel derecha = new Panel(panelBusqueda);
    Label _label = new Label(izquierda);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Nombre comienza con..");
        it.setFontSize(11);
        it.setForeground(Color.DARK_GRAY);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    TextBox _textBox = new TextBox(derecha);
    final TextFilter _function_1 = new TextFilter() {
      public boolean accept(final TextInputEvent event) {
        String _potentialTextResult = event.getPotentialTextResult();
        return StringUtils.isAlpha(_potentialTextResult);
      }
    };
    TextBox _withFilter = _textBox.withFilter(_function_1);
    _withFilter.<ControlBuilder>bindValueToProperty("jugadorEjemplo.nombre");
    Label _label_1 = new Label(panelIzquierda);
    _label_1.setText("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
    Label _label_2 = new Label(izquierda);
    final Procedure1<Label> _function_2 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Apodo contiene...");
        it.setFontSize(11);
        it.setForeground(Color.DARK_GRAY);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_2, _function_2);
    TextBox _textBox_1 = new TextBox(derecha);
    final TextFilter _function_3 = new TextFilter() {
      public boolean accept(final TextInputEvent event) {
        String _potentialTextResult = event.getPotentialTextResult();
        return StringUtils.isAlpha(_potentialTextResult);
      }
    };
    TextBox _withFilter_1 = _textBox_1.withFilter(_function_3);
    _withFilter_1.<ControlBuilder>bindValueToProperty("jugadorEjemplo.apodo");
    Label _label_3 = new Label(izquierda);
    final Procedure1<Label> _function_4 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Fecha de nacimiento menor a:");
        it.setFontSize(11);
        it.setForeground(Color.DARK_GRAY);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_3, _function_4);
    TextBox _textBox_2 = new TextBox(derecha);
    DateTextFilter _dateTextFilter = new DateTextFilter();
    TextBox _withFilter_2 = _textBox_2.withFilter(_dateTextFilter);
    Binding<ControlBuilder> _bindValueToProperty = _withFilter_2.<ControlBuilder>bindValueToProperty("jugadorEjemplo.fechaNacimiento");
    DateAdapter _dateAdapter = new DateAdapter();
    _bindValueToProperty.setTransformer(_dateAdapter);
    Label _label_4 = new Label(izquierda);
    final Procedure1<Label> _function_5 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Handicap desde:");
        it.setFontSize(11);
        it.setForeground(Color.DARK_GRAY);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_4, _function_5);
    TextBox _textBox_3 = new TextBox(derecha);
    final TextFilter _function_6 = new TextFilter() {
      public boolean accept(final TextInputEvent event) {
        String _potentialTextResult = event.getPotentialTextResult();
        return StringUtils.isNumeric(_potentialTextResult);
      }
    };
    TextBox _withFilter_3 = _textBox_3.withFilter(_function_6);
    _withFilter_3.<ControlBuilder>bindValueToProperty("handicapDesde");
    Label _label_5 = new Label(izquierda);
    final Procedure1<Label> _function_7 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Handicap hasta:");
        it.setFontSize(11);
        it.setForeground(Color.DARK_GRAY);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_5, _function_7);
    TextBox _textBox_4 = new TextBox(derecha);
    final TextFilter _function_8 = new TextFilter() {
      public boolean accept(final TextInputEvent event) {
        String _potentialTextResult = event.getPotentialTextResult();
        return StringUtils.isNumeric(_potentialTextResult);
      }
    };
    TextBox _withFilter_4 = _textBox_4.withFilter(_function_8);
    _withFilter_4.<ControlBuilder>bindValueToProperty("handicapHasta");
    Label _label_6 = new Label(izquierda);
    final Procedure1<Label> _function_9 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Promedio desde:");
        it.setFontSize(11);
        it.setForeground(Color.DARK_GRAY);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_6, _function_9);
    TextBox _textBox_5 = new TextBox(derecha);
    final TextFilter _function_10 = new TextFilter() {
      public boolean accept(final TextInputEvent event) {
        String _potentialTextResult = event.getPotentialTextResult();
        return StringUtils.isNumeric(_potentialTextResult);
      }
    };
    TextBox _withFilter_5 = _textBox_5.withFilter(_function_10);
    _withFilter_5.<ControlBuilder>bindValueToProperty("promedioDesde");
    Label _label_7 = new Label(izquierda);
    final Procedure1<Label> _function_11 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Promedio hasta:");
        it.setFontSize(11);
        it.setForeground(Color.DARK_GRAY);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_7, _function_11);
    TextBox _textBox_6 = new TextBox(derecha);
    final TextFilter _function_12 = new TextFilter() {
      public boolean accept(final TextInputEvent event) {
        String _potentialTextResult = event.getPotentialTextResult();
        return StringUtils.isNumeric(_potentialTextResult);
      }
    };
    TextBox _withFilter_6 = _textBox_6.withFilter(_function_12);
    _withFilter_6.<ControlBuilder>bindValueToProperty("promedioHasta");
    Label _label_8 = new Label(izquierda);
    final Procedure1<Label> _function_13 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Infracciones");
        it.setFontSize(11);
        it.setForeground(Color.DARK_GRAY);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_8, _function_13);
    Selector<Object> _selector = new Selector<Object>(derecha);
    final Procedure1<Selector<Object>> _function_14 = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        ObservableProperty _observableProperty = new ObservableProperty(BusquedaJugadoresWindow.this, "eligeInfracciones");
        it.bindItems(_observableProperty);
        it.<ControlBuilder>bindValueToProperty("infracciones");
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function_14);
    Button _button = new Button(panelBusqueda);
    final Procedure1<Button> _function_15 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Buscar");
        final Action _function = new Action() {
          public void execute() {
            BusquedaJugadoresAppModel _modelObject = BusquedaJugadoresWindow.this.getModelObject();
            _modelObject.search();
          }
        };
        it.onClick(_function);
        it.setFontSize(12);
        it.setWidth(200);
        it.setAsDefault();
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_15);
    Button _button_1 = new Button(panelBusqueda);
    final Procedure1<Button> _function_16 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Limpiar");
        final Action _function = new Action() {
          public void execute() {
            BusquedaJugadoresAppModel _modelObject = BusquedaJugadoresWindow.this.getModelObject();
            _modelObject.clear();
          }
        };
        it.onClick(_function);
        it.setFontSize(12);
        it.setWidth(200);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_16);
  }
  
  public Binding<ControlBuilder> crearTextBox(final Panel searchFormPanel, final String label, final String binding) {
    Binding<ControlBuilder> _xblockexpression = null;
    {
      Label _label = new Label(searchFormPanel);
      _label.setText(label);
      TextBox _textBox = new TextBox(searchFormPanel);
      _xblockexpression = _textBox.<ControlBuilder>bindValueToProperty(binding);
    }
    return _xblockexpression;
  }
  
  public void grillaBasicaJugadores(final Panel panelResultados) {
    Table<Jugador> _table = new Table<Jugador>(panelResultados, Jugador.class);
    final Procedure1<Table<Jugador>> _function = new Procedure1<Table<Jugador>>() {
      public void apply(final Table<Jugador> it) {
        it.setHeigth(220);
        it.setWidth(590);
        it.<ControlBuilder>bindValueToProperty("jugadorSeleccionado");
        it.bindItemsToProperty("jugadores");
      }
    };
    Table<Jugador> grilla = ObjectExtensions.<Table<Jugador>>operator_doubleArrow(_table, _function);
    Column<Jugador> _column = new Column<Jugador>(grilla);
    final Procedure1<Column<Jugador>> _function_1 = new Procedure1<Column<Jugador>>() {
      public void apply(final Column<Jugador> it) {
        it.setTitle("Nombre");
        it.setFixedSize(150);
        it.bindContentsToProperty("nombre");
      }
    };
    ObjectExtensions.<Column<Jugador>>operator_doubleArrow(_column, _function_1);
    Column<Jugador> _column_1 = new Column<Jugador>(grilla);
    final Procedure1<Column<Jugador>> _function_2 = new Procedure1<Column<Jugador>>() {
      public void apply(final Column<Jugador> it) {
        it.setTitle("Apodo");
        it.setFixedSize(150);
        it.bindContentsToProperty("apodo");
      }
    };
    ObjectExtensions.<Column<Jugador>>operator_doubleArrow(_column_1, _function_2);
    Column<Jugador> _column_2 = new Column<Jugador>(grilla);
    final Procedure1<Column<Jugador>> _function_3 = new Procedure1<Column<Jugador>>() {
      public void apply(final Column<Jugador> it) {
        it.setTitle("Handicap");
        it.setFixedSize(150);
        it.bindContentsToProperty("nivelDeJuego");
      }
    };
    ObjectExtensions.<Column<Jugador>>operator_doubleArrow(_column_2, _function_3);
    Column<Jugador> _column_3 = new Column<Jugador>(grilla);
    final Procedure1<Column<Jugador>> _function_4 = new Procedure1<Column<Jugador>>() {
      public void apply(final Column<Jugador> it) {
        it.setTitle("Promedio");
        it.setFixedSize(150);
        it.bindContentsToProperty("promedio");
      }
    };
    ObjectExtensions.<Column<Jugador>>operator_doubleArrow(_column_3, _function_4);
    Button _button = new Button(panelResultados);
    final Procedure1<Button> _function_5 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Ver Datos Completos");
        final Action _function = new Action() {
          public void execute() {
            BusquedaJugadoresWindow.this.grillaCompletaJugador();
          }
        };
        it.onClick(_function);
        it.setAsDefault();
        it.disableOnError();
        it.setFontSize(14);
        it.setWidth(200);
        NotNullObservable _notNullObservable = new NotNullObservable("jugadorSeleccionado");
        it.<ControlBuilder>bindEnabled(_notNullObservable);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_5);
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
}
