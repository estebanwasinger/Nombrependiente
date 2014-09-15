package futbol5.ui;

import futbol5.applicationModel.Futbol5;
import futbol5.domain.Partido;
import org.uqbar.arena.layout.ColumnLayout;
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

@Observable
@SuppressWarnings("all")
public class VistaPrincipal extends SimpleWindow<Futbol5> {
  public VistaPrincipal(final WindowOwner parent, final Futbol5 model) {
    super(parent, model);
  }
  
  public Column<Partido> ccreateContents(final Panel mainPanel) {
    Column<Partido> _xblockexpression = null;
    {
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
      Column<Partido> _column = new Column<Partido>(tableListaPartidos);
      Column<Partido> _setTitle = _column.setTitle("Localidad");
      _xblockexpression = _setTitle.bindContentsToProperty("localidad");
    }
    return _xblockexpression;
  }
  
  protected void addActions(final Panel panel) {
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    panel.setLayout(_horizontalLayout);
    Button _button = new Button(panel);
    _button.setCaption("Generar Equipo");
    Button _button_1 = new Button(panel);
    _button_1.setCaption("Buscar Jugador");
  }
  
  protected void createFormPanel(final Panel arg0) {
    this.ccreateContents(arg0);
  }
}
