package futbol5.ui;

import futbol5.domain.Jugador;
import futbol5.homes.HomeJugadores;
import infracciones.Infraccion;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
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
    Panel _panel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    Panel principal = _panel.setLayout(_columnLayout);
    Panel _panel_1 = new Panel(principal);
    ColumnLayout _columnLayout_1 = new ColumnLayout(2);
    Panel panelIzq = _panel_1.setLayout(_columnLayout_1);
    Panel _panel_2 = new Panel(principal);
    VerticalLayout _verticalLayout = new VerticalLayout();
    Panel panelDer = _panel_2.setLayout(_verticalLayout);
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
      _label_10.setText("Nacicmiento:");
      Label _label_11 = new Label(panel);
      _xblockexpression = _label_11.<ControlBuilder>bindValueToProperty("fechaNacimientoString");
    }
    return _xblockexpression;
  }
  
  public Column<Infraccion> verTablas(final Panel panel) {
    Column<Infraccion> _xblockexpression = null;
    {
      Table<Jugador> _table = new Table<Jugador>(panel, Jugador.class);
      final Procedure1<Table<Jugador>> _function = new Procedure1<Table<Jugador>>() {
        public void apply(final Table<Jugador> it) {
          it.setHeigth(200);
          it.setWidth(285);
          it.bindItemsToProperty("amigos");
        }
      };
      Table<Jugador> tablaListaAmigos = ObjectExtensions.<Table<Jugador>>operator_doubleArrow(_table, _function);
      Column<Jugador> _column = new Column<Jugador>(tablaListaAmigos);
      Column<Jugador> _setTitle = _column.setTitle("Nombre");
      _setTitle.bindContentsToProperty("nombre");
      Table<Infraccion> _table_1 = new Table<Infraccion>(panel, Infraccion.class);
      final Procedure1<Table<Infraccion>> _function_1 = new Procedure1<Table<Infraccion>>() {
        public void apply(final Table<Infraccion> it) {
          it.setHeigth(200);
          it.setWidth(285);
          it.bindItemsToProperty("infracciones");
        }
      };
      Table<Infraccion> tablaListaInfracciones = ObjectExtensions.<Table<Infraccion>>operator_doubleArrow(_table_1, _function_1);
      Column<Infraccion> _column_1 = new Column<Infraccion>(tablaListaInfracciones);
      Column<Infraccion> _setTitle_1 = _column_1.setTitle("Infracciones");
      _xblockexpression = _setTitle_1.bindContentsToProperty("motivo");
    }
    return _xblockexpression;
  }
  
  protected void addActions(final Panel actions) {
    Button _button = new Button(actions);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Volver");
        final Action _function = new Action() {
          public void execute() {
            VerDatosJugadorWindow.this.cancel();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  public HomeJugadores homeJugadores() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Jugador.class);
    return ((HomeJugadores) _singleton);
  }
}
