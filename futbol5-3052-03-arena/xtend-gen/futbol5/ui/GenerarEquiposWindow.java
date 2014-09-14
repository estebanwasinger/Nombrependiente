package futbol5.ui;

import futbol5.domain.Jugador;
import futbol5.domain.Partido;
import futbol5.ui.RunnableTest;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class GenerarEquiposWindow extends SimpleWindow<Partido> {
  public GenerarEquiposWindow(final WindowOwner parent, final Partido model) {
    super(parent, model);
  }
  
  public GenerarEquiposWindow(final RunnableTest parent) {
    super(parent, new Partido());
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
    this.setTitle("Generar Equipo");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    final Panel botoneraSuperior = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    botoneraSuperior.setLayout(_horizontalLayout);
    final Panel panelListaJugadores = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    panelListaJugadores.setLayout(_columnLayout);
    final Panel selector1 = new Panel(botoneraSuperior);
    VerticalLayout _verticalLayout_1 = new VerticalLayout();
    selector1.setLayout(_verticalLayout_1);
    final Panel selector2 = new Panel(botoneraSuperior);
    VerticalLayout _verticalLayout_2 = new VerticalLayout();
    selector2.setLayout(_verticalLayout_2);
    final Panel selector3 = new Panel(botoneraSuperior);
    VerticalLayout _verticalLayout_3 = new VerticalLayout();
    selector3.setLayout(_verticalLayout_3);
    Label _label = new Label(selector1);
    _label.setText("Criterio de Selección");
    Selector<Object> _selector = new Selector<Object>(selector1);
    final Procedure1<Selector<Object>> _function = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        it.setWidth(200);
        GenerarEquiposWindow.this.setTitle("Generar equipos tentativos");
      }
    };
    final Selector<Object> selectorOrdenamiento = ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function);
    Label _label_1 = new Label(selector2);
    _label_1.setText("Criterio de Ordenamiento");
    Selector<Object> _selector_1 = new Selector<Object>(selector2);
    final Control selectorOrdenamiento2 = _selector_1.setWidth(200);
    Button _button = new Button(selector3);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setWidth(200);
        it.setHeigth(45);
        it.setCaption("Generar Equipos");
      }
    };
    final Button botonGenerar = ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
    this.createListaJugadores(panelListaJugadores);
  }
  
  public void createListaJugadores(final Panel panelJugadores) {
    Label _label = new Label(panelJugadores);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Equipo A");
        it.setFontSize(20);
      }
    };
    Label labelEquipo1 = ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    Label _label_1 = new Label(panelJugadores);
    final Procedure1<Label> _function_1 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Equipo B");
        it.setFontSize(20);
      }
    };
    Label labelEquipo2 = ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function_1);
    Table<Jugador> table = new Table<Jugador>(panelJugadores, Jugador.class);
    table.setHeigth(200);
    table.setWidth(285);
    Column<Jugador> _column = new Column<Jugador>(table);
    _column.setTitle("Nombre");
    Table<Jugador> table2 = new Table<Jugador>(panelJugadores, Jugador.class);
    table2.setHeigth(200);
    table2.setWidth(285);
    Column<Jugador> _column_1 = new Column<Jugador>(table2);
    _column_1.setTitle("Nombre");
  }
}
