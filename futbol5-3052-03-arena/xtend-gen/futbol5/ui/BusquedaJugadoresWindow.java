package futbol5.ui;

import futbol5.domain.Jugador;
import futbol5.ui.RunnableTest;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("all")
public class BusquedaJugadoresWindow extends SimpleWindow<Jugador> {
  public BusquedaJugadoresWindow(final WindowOwner parent, final Jugador model) {
    super(parent, model);
  }
  
  public BusquedaJugadoresWindow(final RunnableTest parent) {
    super(parent, new Jugador());
  }
  
  protected void addActions(final Panel actionPanel) {
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    actionPanel.setLayout(_horizontalLayout);
    Button _button = new Button(actionPanel);
    _button.setCaption("Cancelar");
    Button _button_1 = new Button(actionPanel);
    _button_1.setCaption("Aceptar");
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Busqueda Jugador");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    final Panel busquedaSuperior = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    busquedaSuperior.setLayout(_horizontalLayout);
    final Panel panelListaJugadores = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    panelListaJugadores.setLayout(_columnLayout);
    this.createMetodoBusqueda(busquedaSuperior);
    this.createListaJugadores(panelListaJugadores);
  }
  
  public void createMetodoBusqueda(final Panel busquedaSuperior) {
    TextBox _textBox = new TextBox(busquedaSuperior);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.setWidth(200);
        BusquedaJugadoresWindow.this.setTitle("Busqueda de Equipos");
      }
    };
    final TextBox campoBusqueda = ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    TextBox _textBox_1 = new TextBox(busquedaSuperior);
    final Control campoBusqueda2 = _textBox_1.setWidth(200);
    TextBox _textBox_2 = new TextBox(busquedaSuperior);
    final Control campoBusqueda3 = _textBox_2.setWidth(200);
    TextBox _textBox_3 = new TextBox(busquedaSuperior);
    final Control campoBusqueda4 = _textBox_3.setWidth(200);
    Button _button = new Button(busquedaSuperior);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setWidth(200);
        it.setCaption("Buscar Jugadores");
      }
    };
    final Button botonBuscar = ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
  }
  
  public void createListaJugadores(final Panel panelJugadores) {
    Table<Jugador> table = new Table<Jugador>(panelJugadores, Jugador.class);
    table.setHeigth(200);
    table.setWidth(450);
    Column<Jugador> _column = new Column<Jugador>(table);
    Column<Jugador> _setTitle = _column.setTitle("Nombre");
    _setTitle.setFixedSize(150);
    Column<Jugador> _column_1 = new Column<Jugador>(table);
    Column<Jugador> _setTitle_1 = _column_1.setTitle("Apodo");
    _setTitle_1.setFixedSize(150);
    Column<Jugador> _column_2 = new Column<Jugador>(table);
    Column<Jugador> _setTitle_2 = _column_2.setTitle("Handicap");
    _setTitle_2.setFixedSize(150);
    Column<Jugador> _column_3 = new Column<Jugador>(table);
    Column<Jugador> _setTitle_3 = _column_3.setTitle("Promedio");
    _setTitle_3.setFixedSize(150);
  }
}
