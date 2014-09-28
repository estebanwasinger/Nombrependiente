package futbol5.ui;

import com.uqbar.commons.collections.Transformer;
import futbol5.auxUtils.Grilla;
import futbol5.domain.Jugador;
import futbol5.homes.HomeJugadores;
import infracciones.Infraccion;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@Observable
@SuppressWarnings("all")
public class VerDatosJugadorWindow extends Dialog<Jugador> {
  private Grilla _grilla;
  
  public Grilla getGrilla() {
    return this._grilla;
  }
  
  public void setGrilla(final Grilla grilla) {
    this._grilla = grilla;
  }
  
  public VerDatosJugadorWindow(final WindowOwner owner, final Jugador model) {
    super(owner, model);
    Grilla _grilla = new Grilla();
    this.setGrilla(_grilla);
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
    ColumnLayout _columnLayout_2 = new ColumnLayout(2);
    Panel panelDer = _panel_2.setLayout(_columnLayout_2);
    this.mostrarDatos(panelIzq);
    this.verTablas(panelDer);
  }
  
  public Binding<ControlBuilder> mostrarDatos(final Panel panel) {
    Binding<ControlBuilder> _xblockexpression = null;
    {
      Label _label = new Label(panel);
      _label.setText("Nombre");
      Label _label_1 = new Label(panel);
      _label_1.<ControlBuilder>bindValueToProperty("nombre");
      Label _label_2 = new Label(panel);
      _label_2.setText("Apodo");
      Label _label_3 = new Label(panel);
      _label_3.<ControlBuilder>bindValueToProperty("apodo");
      Label _label_4 = new Label(panel);
      _label_4.setText("Handicap");
      Label _label_5 = new Label(panel);
      _label_5.<ControlBuilder>bindValueToProperty("nivelDeJuego");
      Label _label_6 = new Label(panel);
      _label_6.setText("Promedio último partido");
      Label _label_7 = new Label(panel);
      _label_7.<ControlBuilder>bindValueToProperty("promedioUltimoPartido");
      Label _label_8 = new Label(panel);
      _label_8.setText("Promedio total");
      Label _label_9 = new Label(panel);
      _label_9.<ControlBuilder>bindValueToProperty("promedio");
      Label _label_10 = new Label(panel);
      _label_10.setText("Fecha de nacimiento");
      Label _label_11 = new Label(panel);
      _label_11.<ControlBuilder>bindValueToProperty("fechaNacimientoString");
      Label _label_12 = new Label(panel);
      _label_12.setText("Cantidad de partidos jugados");
      Label _label_13 = new Label(panel);
      _xblockexpression = _label_13.<ControlBuilder>bindValueToProperty("cantidadPartidos");
    }
    return _xblockexpression;
  }
  
  public Column<Infraccion> verTablas(final Panel panel) {
    Column<Infraccion> _xblockexpression = null;
    {
      Label _label = new Label(panel);
      _label.setText("Amigos");
      Label _label_1 = new Label(panel);
      _label_1.setText("Infracciones");
      Grilla _grilla = this.getGrilla();
      Jugador _modelObject = this.getModelObject();
      _grilla.generar(panel, _modelObject, "amigos");
      Table<Infraccion> _table = new Table<Infraccion>(panel, Infraccion.class);
      final Procedure1<Table<Infraccion>> _function = new Procedure1<Table<Infraccion>>() {
        public void apply(final Table<Infraccion> it) {
          it.setHeigth(130);
          it.setWidth(280);
          it.bindItemsToProperty("infracciones");
        }
      };
      Table<Infraccion> tablaInfracciones = ObjectExtensions.<Table<Infraccion>>operator_doubleArrow(_table, _function);
      Column<Infraccion> _column = new Column<Infraccion>(tablaInfracciones);
      Column<Infraccion> _setTitle = _column.setTitle("Fecha");
      final Transformer<Infraccion,String> _function_1 = new Transformer<Infraccion,String>() {
        public String transform(final Infraccion infraccion) {
          SimpleDateFormat _simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
          Date _fecha = infraccion.getFecha();
          return _simpleDateFormat.format(_fecha);
        }
      };
      Column<Infraccion> _bindContentsToTransformer = _setTitle.<String>bindContentsToTransformer(_function_1);
      _bindContentsToTransformer.setFixedSize(75);
      Column<Infraccion> _column_1 = new Column<Infraccion>(tablaInfracciones);
      Column<Infraccion> _setTitle_1 = _column_1.setTitle("Hora");
      final Transformer<Infraccion,String> _function_2 = new Transformer<Infraccion,String>() {
        public String transform(final Infraccion infraccion) {
          SimpleDateFormat _simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
          Date _fecha = infraccion.getFecha();
          return _simpleDateFormat.format(_fecha);
        }
      };
      Column<Infraccion> _bindContentsToTransformer_1 = _setTitle_1.<String>bindContentsToTransformer(_function_2);
      _bindContentsToTransformer_1.setFixedSize(75);
      Column<Infraccion> _column_2 = new Column<Infraccion>(tablaInfracciones);
      Column<Infraccion> _setTitle_2 = _column_2.setTitle("Motivo");
      _xblockexpression = _setTitle_2.bindContentsToProperty("motivo");
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
