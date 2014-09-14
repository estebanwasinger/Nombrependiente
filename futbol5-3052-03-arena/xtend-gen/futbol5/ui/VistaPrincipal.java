package futbol5.ui;

import futbol5.applicationModel.Futbol5;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Link;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.SkinnableControl;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.ErrorsPanel;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@Observable
@SuppressWarnings("all")
public class VistaPrincipal extends MainWindow<Futbol5> {
  @Observable
  public void createContents(final Panel mainPanel) {
    this.setTitle("Futbol5");
    new ErrorsPanel(mainPanel, "FutbolOK");
    Panel panel2Columnas = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    panel2Columnas.setLayout(_columnLayout);
    Panel panelIzquierda = new Panel(panel2Columnas);
    Panel panelDerecha = new Panel(panel2Columnas);
    Label _label = new Label(panelIzquierda);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Futbol5");
        it.setFontSize(20);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
  }
  
  public static void main(final String[] args) {
    VistaPrincipal _vistaPrincipal = new VistaPrincipal();
    _vistaPrincipal.startApplication();
  }
  
  public List<Object> asObjects(final List<?> list) {
    final Function1<Object,Object> _function = new Function1<Object,Object>() {
      public Object apply(final Object it) {
        return ((Object) it);
      }
    };
    return ListExtensions.map(list, _function);
  }
  
  /**
   * def getUbicacionesPosibles(){
   * posiblesUbicaciones.asObjects
   * }
   */
  public VistaPrincipal() {
    super(new Futbol5());
    Futbol5 _modelObject = this.getModelObject();
    _modelObject.search();
  }
  
  /**
   * def protected grillaDeNotas(Panel mainPanel){
   * var table = new Table<Nota>(mainPanel, typeof(Nota))
   * table.heigth = 150
   * table.width = 400
   * table.bindItemsToProperty("materiaSeleccionada.notas")
   * table.bindValueToProperty("notaSeleccionada")
   * new Column<Nota>(table)
   * .setTitle("Fecha")
   * .bindContentsToProperty("fecha")
   * 
   * new Column<Nota>(table)
   * .setTitle("Descripcion")
   * .bindContentsToProperty("descripcion")
   * 
   * new Column<Nota>(table)
   * .setTitle("Aprobado")
   * .bindContentsToTransformer([nota | if (nota.isAprobado) "SI" else "NO"])
   * }
   */
  public void panelEdicionMateria(final Panel mainPanel) {
    Panel panelEdicionColumnas = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    panelEdicionColumnas.setLayout(_columnLayout);
    Label _label = new Label(panelEdicionColumnas);
    _label.setText("Materia:");
    Label _label_1 = new Label(panelEdicionColumnas);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.<ControlBuilder>bindValueToProperty("materiaSeleccionada.nombre");
        it.setWidth(200);
        it.setFontSize(15);
      }
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function);
    Label _label_2 = new Label(panelEdicionColumnas);
    _label_2.setText("Profesor");
    TextBox _textBox = new TextBox(panelEdicionColumnas);
    final Procedure1<TextBox> _function_1 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<ControlBuilder>bindValueToProperty("materiaSeleccionada.profesor");
        it.setWidth(200);
        it.setFontSize(10);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function_1);
    Label _label_3 = new Label(panelEdicionColumnas);
    _label_3.setText("Año de cursada");
    TextBox _textBox_1 = new TextBox(panelEdicionColumnas);
    final Procedure1<TextBox> _function_2 = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<ControlBuilder>bindValueToProperty("materiaSeleccionada.anioCursada");
        it.setWidth(200);
        it.setFontSize(10);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_2);
    Label _label_4 = new Label(panelEdicionColumnas);
    _label_4.setText("Final Aprobado");
    CheckBox checkAprobado = new CheckBox(panelEdicionColumnas);
    checkAprobado.<ControlBuilder>bindValueToProperty("materiaSeleccionada.finalAprobado");
    Label _label_5 = new Label(panelEdicionColumnas);
    _label_5.setText("Ubicacion Materia");
    Selector<Object> _selector = new Selector<Object>(panelEdicionColumnas);
    final Procedure1<Selector<Object>> _function_3 = new Procedure1<Selector<Object>>() {
      public void apply(final Selector<Object> it) {
        ObservableProperty _observableProperty = new ObservableProperty(VistaPrincipal.this, "ubicacionesPosibles");
        it.bindItems(_observableProperty);
        it.<ControlBuilder>bindValueToProperty("materiaSeleccionada.ubicacion");
      }
    };
    ObjectExtensions.<Selector<Object>>operator_doubleArrow(_selector, _function_3);
    Panel _panel = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    Panel panelBotones = _panel.setLayout(_horizontalLayout);
    Button _button = new Button(panelBotones);
    Button _setCaption = _button.setCaption("Generar Equipos");
    final Action _function_4 = new Action() {
      public void execute() {
        VistaPrincipal.this.generarElEquipo();
      }
    };
    Button _onClick = _setCaption.onClick(_function_4);
    Button _setAsDefault = _onClick.setAsDefault();
    Link _disableOnError = _setAsDefault.disableOnError();
    SkinnableControl generarEquipo = _disableOnError.setFontSize(9);
    Button _button_1 = new Button(panelBotones);
    Button _setCaption_1 = _button_1.setCaption("Busqueda de Jugadores");
    final Action _function_5 = new Action() {
      public void execute() {
        VistaPrincipal.this.busquedaJugador();
      }
    };
    Button _onClick_1 = _setCaption_1.onClick(_function_5);
    Button _setAsDefault_1 = _onClick_1.setAsDefault();
    Link _disableOnError_1 = _setAsDefault_1.disableOnError();
    SkinnableControl busquedaJugador = _disableOnError_1.setFontSize(9);
  }
  
  /**
   * def openDialog(Dialog<?> dialog) {
   * dialog.onAccept[|modelObject.search]
   * dialog.open
   * }
   */
  public void generarElEquipo() {
  }
  
  public void busquedaJugador() {
  }
}
