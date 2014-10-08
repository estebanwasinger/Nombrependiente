package futbol5.ui;

import futbol5.applicationModel.BusquedaJugadoresAppModel;
import futbol5.applicationModel.PartidosAppModel;
import futbol5.domain.Partido;
import futbol5.ui.BusquedaJugadoresWindow;
import futbol5.ui.GenerarEquiposWindow;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@Observable
@SuppressWarnings("all")
public class PartidosView extends SimpleWindow<PartidosAppModel> {
  public PartidosView(final WindowOwner parent) {
    super(parent, new PartidosAppModel());
  }
  
  protected void addActions(final Panel panel) {
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    panel.setLayout(_horizontalLayout);
    Button _button = new Button(panel);
    Button _setCaption = _button.setCaption("Generar Equipo");
    final Action _function = new Action() {
      public void execute() {
        PartidosView.this.generarEquipo();
      }
    };
    Button generar = _setCaption.onClick(_function);
    Button _button_1 = new Button(panel);
    Button _setCaption_1 = _button_1.setCaption("Buscar Jugador");
    final Action _function_1 = new Action() {
      public void execute() {
        PartidosView.this.buscarJugador();
      }
    };
    _setCaption_1.onClick(_function_1);
    NotNullObservable elementSelected = new NotNullObservable("partidoSeleccionado");
    generar.<ControlBuilder>bindEnabled(elementSelected);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Organizador de Futbol5");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Futbol 5");
        it.setFontSize(20);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    Label _label_1 = new Label(mainPanel);
    _label_1.setText("Ultimos Partidos");
    Table<Partido> _table = new Table<Partido>(mainPanel, Partido.class);
    final Procedure1<Table<Partido>> _function_1 = new Procedure1<Table<Partido>>() {
      public void apply(final Table<Partido> it) {
        it.setHeigth(200);
        it.bindItemsToProperty("partidos");
        it.<ControlBuilder>bindValueToProperty("partidoSeleccionado");
        Column<Partido> _column = new Column<Partido>(it);
        Column<Partido> _setTitle = _column.setTitle("Localidad");
        _setTitle.bindContentsToProperty("localidad");
      }
    };
    ObjectExtensions.<Table<Partido>>operator_doubleArrow(_table, _function_1);
  }
  
  public void generarEquipo() {
    PartidosAppModel _modelObject = this.getModelObject();
    Partido _partidoSeleccionado = _modelObject.getPartidoSeleccionado();
    GenerarEquiposWindow _generarEquiposWindow = new GenerarEquiposWindow(this, _partidoSeleccionado);
    this.openWindow(_generarEquiposWindow);
  }
  
  public void openWindow(final SimpleWindow<?> ventana) {
    ventana.open();
  }
  
  public void buscarJugador() {
    BusquedaJugadoresAppModel _busquedaJugadoresAppModel = new BusquedaJugadoresAppModel();
    BusquedaJugadoresWindow _busquedaJugadoresWindow = new BusquedaJugadoresWindow(this, _busquedaJugadoresAppModel);
    this.openWindow(_busquedaJugadoresWindow);
  }
}
