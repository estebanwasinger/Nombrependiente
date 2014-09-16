package futbol5.ui;

import futbol5.domain.Jugador;
import futbol5.homes.HomeJugadores;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@SuppressWarnings("all")
public class VerDatosJugadorWindow extends Dialog<Jugador> {
  public VerDatosJugadorWindow(final WindowOwner owner, final Jugador model) {
    super(owner, model);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Datos del Jugador");
    final Panel columnPanel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    columnPanel.setLayout(_columnLayout);
    Panel _panel = new Panel(columnPanel);
    ColumnLayout _columnLayout_1 = new ColumnLayout(2);
    final Panel panelIzq = _panel.setLayout(_columnLayout_1);
    Panel _panel_1 = new Panel(columnPanel);
    VerticalLayout _verticalLayout = new VerticalLayout();
    final Panel panelDer = _panel_1.setLayout(_verticalLayout);
    this.mostrarDatos(panelIzq);
    this.verTablas(panelDer);
  }
  
  public Binding<ControlBuilder> mostrarDatos(final Panel panel) {
    Binding<ControlBuilder> _xblockexpression = null;
    {
      Label _label = new Label(panel);
      _label.setText("Nombre del Jugador");
      Label _label_1 = new Label(panel);
      _label_1.<ControlBuilder>bindValueToProperty("nombre");
      Label _label_2 = new Label(panel);
      _label_2.setText("Apodo");
      Label _label_3 = new Label(panel);
      _label_3.<ControlBuilder>bindValueToProperty("apodo");
      Label _label_4 = new Label(panel);
      _label_4.setText("Edad");
      Label _label_5 = new Label(panel);
      _label_5.<ControlBuilder>bindValueToProperty("edad");
      Label _label_6 = new Label(panel);
      _label_6.setText("Cantidad De Partidos:");
      Label _label_7 = new Label(panel);
      _label_7.<ControlBuilder>bindValueToProperty("cantidadPartidos");
      Label _label_8 = new Label(panel);
      _label_8.setText("Handicap:");
      Label _label_9 = new Label(panel);
      _label_9.<ControlBuilder>bindValueToProperty("nivelDeJuego");
      Label _label_10 = new Label(panel);
      _label_10.setText("Calificaciones:");
      Label _label_11 = new Label(panel);
      _label_11.<ControlBuilder>bindValueToProperty("calificaciones.size");
      Label _label_12 = new Label(panel);
      _label_12.setText("Amigos:");
      Label _label_13 = new Label(panel);
      _label_13.<ControlBuilder>bindValueToProperty("amigos.size");
      Label _label_14 = new Label(panel);
      _label_14.setText("Nacicmiento:");
      Label _label_15 = new Label(panel);
      _xblockexpression = _label_15.<ControlBuilder>bindValueToProperty("fechaNacimiento");
    }
    return _xblockexpression;
  }
  
  public Control verTablas(final Panel panel) {
    Control _xblockexpression = null;
    {
      Table tableListaAmigos = new Table<Jugador>(panel, Jugador.class);
      tableListaAmigos.setHeigth(200);
      tableListaAmigos.setWidth(285);
      tableListaAmigos.bindItemsToProperty("amigos");
      Column<Jugador> _column = new Column<Jugador>(tableListaAmigos);
      Column<Jugador> _setTitle = _column.setTitle("Nombre");
      _setTitle.bindContentsToProperty("nombre");
      Table tableListaInfracciones = new Table<Jugador>(panel, Jugador.class);
      tableListaInfracciones.setHeigth(200);
      _xblockexpression = tableListaInfracciones.setWidth(285);
    }
    return _xblockexpression;
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    Button _setCaption = _button.setCaption("Volver");
    final Action _function = new Action() {
      public void execute() {
        VerDatosJugadorWindow.this.cancel();
      }
    };
    _setCaption.onClick(_function);
  }
  
  public HomeJugadores homeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Jugador.class);
    return ((HomeJugadores) _singleton);
  }
}
