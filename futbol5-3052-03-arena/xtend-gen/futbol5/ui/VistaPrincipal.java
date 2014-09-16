package futbol5.ui;

import futbol5.applicationModel.Futbol5;
import futbol5.domain.Partido;
import futbol5.ui.BusquedaJugadoresWindow;
import futbol5.ui.GenerarEquiposWindow;
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
public class VistaPrincipal extends Dialog<Futbol5> {
  public VistaPrincipal(final WindowOwner parent, final Futbol5 model) {
    super(parent, model);
  }
  
  protected void addActions(final Panel panel) {
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    panel.setLayout(_horizontalLayout);
    Button _button = new Button(panel);
    Button _setCaption = _button.setCaption("Generar Equipo");
    final Action _function = new Action() {
      public void execute() {
        VistaPrincipal.this.generarEquipo();
      }
    };
    Button generar = _setCaption.onClick(_function);
    Button _button_1 = new Button(panel);
    Button _setCaption_1 = _button_1.setCaption("Buscar Jugador");
    final Action _function_1 = new Action() {
      public void execute() {
        VistaPrincipal.this.buscarEquipo();
      }
    };
    Button buscar = _setCaption_1.onClick(_function_1);
    NotNullObservable elementSelected = new NotNullObservable("partido");
    generar.<ControlBuilder>bindEnabled(elementSelected);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
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
    final Panel panelDer = _panel_1.setLayout(_verticalLayout_2);
    Label _label = new Label(panelIzq);
    final Label titulo = _label.setText("Futbol 5");
    Label _label_1 = new Label(panelIzq);
    Label ultimosPartidos = _label_1.setText("Ultimos Partidos");
    Table tableListaPartidos = new Table<Partido>(panelIzq, Partido.class);
    tableListaPartidos.setHeigth(200);
    tableListaPartidos.setWidth(285);
    tableListaPartidos.bindItemsToProperty("partidos");
    tableListaPartidos.<ControlBuilder>bindValueToProperty("partido");
    Column<Partido> _column = new Column<Partido>(tableListaPartidos);
    Column<Partido> _setTitle = _column.setTitle("Localidad");
    _setTitle.bindContentsToProperty("localidad");
  }
  
  public void generarEquipo() {
    Futbol5 _modelObject = this.getModelObject();
    Partido _partido = _modelObject.getPartido();
    GenerarEquiposWindow _generarEquiposWindow = new GenerarEquiposWindow(this, _partido);
    this.openDialog(_generarEquiposWindow);
  }
  
  public void openDialog(final Dialog<?> dialog) {
    final Action _function = new Action() {
      public void execute() {
        Futbol5 _modelObject = VistaPrincipal.this.getModelObject();
        _modelObject.searchPartido();
      }
    };
    dialog.onAccept(_function);
    dialog.open();
  }
  
  public void buscarEquipo() {
    Futbol5 _modelObject = this.getModelObject();
    BusquedaJugadoresWindow _busquedaJugadoresWindow = new BusquedaJugadoresWindow(this, _modelObject);
    this.openDialog(_busquedaJugadoresWindow);
  }
}
