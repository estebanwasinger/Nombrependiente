package futbol5.ui;

import futbol5.applicationModel.BusquedaJugadoresAppModel;
import futbol5.applicationModel.PartidosAppModel;
import futbol5.domain.Partido;
import futbol5.ui.BusquedaJugadoresWindow;
import futbol5.ui.GenerarEquiposWindow;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@Observable
@SuppressWarnings("all")
public class PartidosView extends Dialog<PartidosAppModel> {
  public PartidosView(final WindowOwner parent, final PartidosAppModel model) {
    super(parent, model);
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
    final Panel columnPanel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    columnPanel.setLayout(_columnLayout);
    Panel _panel = new Panel(columnPanel);
    VerticalLayout _verticalLayout_1 = new VerticalLayout();
    final Panel panelIzq = _panel.setLayout(_verticalLayout_1);
    Panel _panel_1 = new Panel(columnPanel);
    VerticalLayout _verticalLayout_2 = new VerticalLayout();
    _panel_1.setLayout(_verticalLayout_2);
    Label _label = new Label(panelIzq);
    _label.setText("Futbol 5");
    Label _label_1 = new Label(panelIzq);
    _label_1.setText("Ultimos Partidos");
    Table<Partido> _table = new Table<Partido>(panelIzq, Partido.class);
    final Procedure1<Table<Partido>> _function = new Procedure1<Table<Partido>>() {
      public void apply(final Table<Partido> it) {
        it.setHeigth(200);
        it.setWidth(150);
        it.bindItemsToProperty("partidos");
        it.<ControlBuilder>bindValueToProperty("partidoSeleccionado");
        Column<Partido> _column = new Column<Partido>(it);
        Column<Partido> _setTitle = _column.setTitle("Localidad");
        _setTitle.bindContentsToProperty("localidad");
      }
    };
    ObjectExtensions.<Table<Partido>>operator_doubleArrow(_table, _function);
  }
  
  public void generarEquipo() {
    PartidosAppModel _modelObject = this.getModelObject();
    Partido _partidoSeleccionado = _modelObject.getPartidoSeleccionado();
    GenerarEquiposWindow _generarEquiposWindow = new GenerarEquiposWindow(this, _partidoSeleccionado);
    this.openDialog(_generarEquiposWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        PartidosAppModel _modelObject = PartidosView.this.getModelObject();
        _modelObject.searchPartido();
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
  
  public void buscarJugador() {
    BusquedaJugadoresAppModel _busquedaJugadoresAppModel = new BusquedaJugadoresAppModel();
    BusquedaJugadoresWindow _busquedaJugadoresWindow = new BusquedaJugadoresWindow(this, _busquedaJugadoresAppModel);
    this.openDialog(_busquedaJugadoresWindow);
  }
}
