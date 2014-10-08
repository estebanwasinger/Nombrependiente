package futbol5.ui;

import com.google.common.collect.Lists;
import com.uqbar.commons.StringUtils;
import futbol5.applicationModel.BusquedaJugadoresAppModel;
import futbol5.auxUtils.DateTextFilter;
import futbol5.auxUtils.Grilla;
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
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.TextFilter;
import org.uqbar.arena.widgets.TextInputEvent;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import strategyHandicap.HandicapDesde;
import strategyHandicap.HandicapHasta;
import strategyHandicap.HandicapStrategy;

@Observable
@SuppressWarnings("all")
public class BusquedaJugadoresWindow extends SimpleWindow<BusquedaJugadoresAppModel> {
  private Grilla _grilla;
  
  public Grilla getGrilla() {
    return this._grilla;
  }
  
  public void setGrilla(final Grilla grilla) {
    this._grilla = grilla;
  }
  
  public BusquedaJugadoresWindow(final WindowOwner parent, final BusquedaJugadoresAppModel modelObject) {
    super(parent, modelObject);
    Grilla _grilla = new Grilla();
    this.setGrilla(_grilla);
  }
  
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Busqueda de Jugadores");
    this.setTaskDescription("Ingrese los parámetros de búsqueda");
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
    BusquedaJugadoresAppModel _modelObject = this.getModelObject();
    Jugador _jugadorSeleccionado = _modelObject.getJugadorSeleccionado();
    BusquedaJugadoresAppModel _modelObject_1 = this.getModelObject();
    List<Jugador> _jugadores = _modelObject_1.getJugadores();
    this.grillaBasicaJugadores(panelDerecha, _jugadorSeleccionado, _jugadores);
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
  
  public List<? extends HandicapStrategy> getHandicaps() {
    HandicapHasta _handicapHasta = new HandicapHasta();
    HandicapDesde _handicapDesde = new HandicapDesde();
    return Collections.<HandicapStrategy>unmodifiableList(Lists.<HandicapStrategy>newArrayList(_handicapHasta, _handicapDesde));
  }
  
  public void createFormPanel(final Panel panelIzquierda) {
    this.setTitle("Busqueda Jugador");
    Panel _panel = new Panel(panelIzquierda);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    Panel panelBusqueda = _panel.setLayout(_columnLayout);
    this.createLabel("Nombre comienza con:", panelBusqueda);
    this.createTextBoxForNames(panelBusqueda, "jugadorEjemplo.nombre");
    Label _label = new Label(panelIzquierda);
    _label.setText("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
    this.createLabel("Apodo contiene:", panelBusqueda);
    this.createTextBoxForNames(panelBusqueda, "jugadorEjemplo.apodo");
    this.createLabel("Fecha de nacimiento menor a:", panelBusqueda);
    TextBox _textBox = new TextBox(panelBusqueda);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        DateTextFilter _dateTextFilter = new DateTextFilter();
        it.withFilter(_dateTextFilter);
        it.setWidth(250);
        Binding<ControlBuilder> _bindValueToProperty = it.<ControlBuilder>bindValueToProperty("jugadorEjemplo.fechaNacimiento");
        DateAdapter _dateAdapter = new DateAdapter();
        _bindValueToProperty.setTransformer(_dateAdapter);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    RadioSelector<Object> _radioSelector = new RadioSelector<Object>(panelBusqueda);
    final Procedure1<RadioSelector<Object>> _function_1 = new Procedure1<RadioSelector<Object>>() {
      public void apply(final RadioSelector<Object> it) {
        it.bindItemsToProperty("handicaps");
        it.<ControlBuilder>bindValueToProperty("metodoHandicap");
        it.allowNull(true);
      }
    };
    ObjectExtensions.<RadioSelector<Object>>operator_doubleArrow(_radioSelector, _function_1);
    this.createTextBoxForNumerics(panelBusqueda, "handicap");
    this.createLabel("Promedio desde:", panelBusqueda);
    this.createTextBoxForNumerics(panelBusqueda, "promedioDesde");
    this.createLabel("Promedio hasta:", panelBusqueda);
    this.createTextBoxForNumerics(panelBusqueda, "promedioHasta");
    this.createLabel("Infracciones:", panelBusqueda);
    Selector<Object> _selector = new Selector<Object>(panelBusqueda);
    final Procedure1<Selector<Object>> _function_2 = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        ObservableProperty _observableProperty = new ObservableProperty(BusquedaJugadoresWindow.this, "eligeInfracciones");
        it.bindItems(_observableProperty);
        it.<ControlBuilder>bindValueToProperty("infracciones");
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function_2);
    Button _button = new Button(panelBusqueda);
    final Procedure1<Button> _function_3 = new Procedure1<Button>() {
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
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_3);
    Button _button_1 = new Button(panelBusqueda);
    final Procedure1<Button> _function_4 = new Procedure1<Button>() {
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
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_4);
  }
  
  public TextBox createTextBoxForNumerics(final Panel panel, final String propertyName) {
    TextBox _createTextBox = this.createTextBox(panel, propertyName);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        final TextFilter _function = new TextFilter() {
          public boolean accept(final TextInputEvent event) {
            String _potentialTextResult = event.getPotentialTextResult();
            return StringUtils.isNumeric(_potentialTextResult);
          }
        };
        it.withFilter(_function);
      }
    };
    return ObjectExtensions.<TextBox>operator_doubleArrow(_createTextBox, _function);
  }
  
  public TextBox createTextBoxForNames(final Panel panel, final String propertyName) {
    TextBox _createTextBox = this.createTextBox(panel, propertyName);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        final TextFilter _function = new TextFilter() {
          public boolean accept(final TextInputEvent event) {
            String _potentialTextResult = event.getPotentialTextResult();
            return StringUtils.isAlpha(_potentialTextResult);
          }
        };
        it.withFilter(_function);
      }
    };
    return ObjectExtensions.<TextBox>operator_doubleArrow(_createTextBox, _function);
  }
  
  public TextBox createTextBox(final Panel panel, final String propertyName) {
    TextBox _textBox = new TextBox(panel);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<ControlBuilder>bindValueToProperty(propertyName);
        it.setWidth(250);
      }
    };
    return ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
  }
  
  public void createLabel(final String labelText, final Panel panel) {
    Label _label = new Label(panel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText(labelText);
        it.setFontSize(13);
        it.setForeground(Color.DARK_GRAY);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
  }
  
  public void grillaBasicaJugadores(final Panel panelResultados, final Jugador jugadorSeleccionado, final List<Jugador> jugadores) {
    Grilla _grilla = this.getGrilla();
    _grilla.generar(panelResultados, jugadorSeleccionado, jugadores, "jugadorSeleccionado", "jugadores");
    Button _button = new Button(panelResultados);
    final Procedure1<Button> _function = new Procedure1<Button>() {
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
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
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
