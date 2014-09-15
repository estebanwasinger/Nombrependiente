package futbol5.ui;

import commands.AlgoritmoImparPar;
import commands.AlgoritmoLoco;
import commands.CriterioCalifiUltimoPartido;
import commands.CriterioHandicap;
import commands.CriterioNCalificaciones;
import commands.CriteriosCommand;
import commands.DivisionDeEquiposCommand;
import futbol5.domain.Jugador;
import futbol5.domain.Partido;
import futbol5.ui.RunnableTest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@Observable
@SuppressWarnings("all")
public class GenerarEquiposWindow extends SimpleWindow<Partido> {
  private Table<Jugador> tableListaEquipoA;
  
  private List<DivisionDeEquiposCommand> _listaCommand;
  
  public List<DivisionDeEquiposCommand> getListaCommand() {
    return this._listaCommand;
  }
  
  public void setListaCommand(final List<DivisionDeEquiposCommand> listaCommand) {
    this._listaCommand = listaCommand;
  }
  
  private List<CriteriosCommand> _listaCommand2;
  
  public List<CriteriosCommand> getListaCommand2() {
    return this._listaCommand2;
  }
  
  public void setListaCommand2(final List<CriteriosCommand> listaCommand2) {
    this._listaCommand2 = listaCommand2;
  }
  
  private Partido model;
  
  public GenerarEquiposWindow(final WindowOwner parent, final Partido model) {
    super(parent, model);
    this.model = model;
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
    ColumnLayout _columnLayout = new ColumnLayout(3);
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
    Selector<DivisionDeEquiposCommand> _selector = new Selector<DivisionDeEquiposCommand>(selector1);
    final Procedure1<Selector<DivisionDeEquiposCommand>> _function = new Procedure1<Selector<DivisionDeEquiposCommand>>() {
      public void apply(final Selector<DivisionDeEquiposCommand> it) {
        it.setWidth(200);
        GenerarEquiposWindow.this.setTitle("Generar equipos tentativos");
      }
    };
    final Selector<DivisionDeEquiposCommand> selectorOrdenamiento = ObjectExtensions.<Selector<DivisionDeEquiposCommand>>operator_doubleArrow(_selector, _function);
    LinkedList<DivisionDeEquiposCommand> _linkedList = new LinkedList<DivisionDeEquiposCommand>();
    this.setListaCommand(_linkedList);
    List<DivisionDeEquiposCommand> _listaCommand = this.getListaCommand();
    AlgoritmoImparPar _algoritmoImparPar = new AlgoritmoImparPar();
    _listaCommand.add(_algoritmoImparPar);
    List<DivisionDeEquiposCommand> _listaCommand_1 = this.getListaCommand();
    AlgoritmoLoco _algoritmoLoco = new AlgoritmoLoco();
    _listaCommand_1.add(_algoritmoLoco);
    selectorOrdenamiento.allowNull(false);
    selectorOrdenamiento.<ControlBuilder>bindValueToProperty("algoritmoDivision");
    ObservableProperty _observableProperty = new ObservableProperty(this, "listaCommand");
    Binding<ListBuilder<DivisionDeEquiposCommand>> propiedadOrdenamiento = selectorOrdenamiento.bindItems(_observableProperty);
    PropertyAdapter _propertyAdapter = new PropertyAdapter(DivisionDeEquiposCommand.class, "nombre");
    propiedadOrdenamiento.setAdapter(_propertyAdapter);
    Label _label_1 = new Label(selector2);
    _label_1.setText("Criterio de Ordenamiento");
    Selector<CriteriosCommand> _selector_1 = new Selector<CriteriosCommand>(selector2);
    final Procedure1<Selector<CriteriosCommand>> _function_1 = new Procedure1<Selector<CriteriosCommand>>() {
      public void apply(final Selector<CriteriosCommand> it) {
        it.allowNull(false);
        it.setWidth(200);
      }
    };
    final Selector<CriteriosCommand> selectorOrdenamiento2 = ObjectExtensions.<Selector<CriteriosCommand>>operator_doubleArrow(_selector_1, _function_1);
    LinkedList<CriteriosCommand> _linkedList_1 = new LinkedList<CriteriosCommand>();
    this.setListaCommand2(_linkedList_1);
    List<CriteriosCommand> _listaCommand2 = this.getListaCommand2();
    CriterioCalifiUltimoPartido _criterioCalifiUltimoPartido = new CriterioCalifiUltimoPartido();
    _listaCommand2.add(_criterioCalifiUltimoPartido);
    List<CriteriosCommand> _listaCommand2_1 = this.getListaCommand2();
    CriterioHandicap _criterioHandicap = new CriterioHandicap();
    _listaCommand2_1.add(_criterioHandicap);
    List<CriteriosCommand> _listaCommand2_2 = this.getListaCommand2();
    CriterioNCalificaciones _criterioNCalificaciones = new CriterioNCalificaciones();
    _listaCommand2_2.add(_criterioNCalificaciones);
    selectorOrdenamiento2.allowNull(false);
    selectorOrdenamiento2.<ControlBuilder>bindValueToProperty("algoritmoOrdenamiento");
    ObservableProperty _observableProperty_1 = new ObservableProperty(this, "listaCommand2");
    Binding<ListBuilder<CriteriosCommand>> propiedadOrdenamiento2 = selectorOrdenamiento2.bindItems(_observableProperty_1);
    PropertyAdapter _propertyAdapter_1 = new PropertyAdapter(CriteriosCommand.class, "nombre");
    propiedadOrdenamiento2.setAdapter(_propertyAdapter_1);
    Button _button = new Button(selector3);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setWidth(200);
        it.setHeigth(45);
        it.setCaption("Generar Equipos");
        final Action _function = new Action() {
          public void execute() {
            Partido _modelObject = GenerarEquiposWindow.this.getModelObject();
            ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
            _modelObject.setEquipoA(_arrayList);
            Partido _modelObject_1 = GenerarEquiposWindow.this.getModelObject();
            Partido _modelObject_2 = GenerarEquiposWindow.this.getModelObject();
            CriteriosCommand _algoritmoOrdenamiento = _modelObject_2.getAlgoritmoOrdenamiento();
            _modelObject_1.ordenarJugadores(_algoritmoOrdenamiento);
            Partido _modelObject_3 = GenerarEquiposWindow.this.getModelObject();
            Partido _modelObject_4 = GenerarEquiposWindow.this.getModelObject();
            DivisionDeEquiposCommand _algoritmoDivision = _modelObject_4.getAlgoritmoDivision();
            _modelObject_3.dividirEquipos(_algoritmoDivision);
            Partido _modelObject_5 = GenerarEquiposWindow.this.getModelObject();
            List<Jugador> _jugadores = _modelObject_5.getJugadores();
            Jugador _jugador = new Jugador("hola");
            _jugadores.add(_jugador);
            Partido _modelObject_6 = GenerarEquiposWindow.this.getModelObject();
            Partido _modelObject_7 = GenerarEquiposWindow.this.getModelObject();
            List<Jugador> _equipoA = _modelObject_7.getEquipoA();
            ObservableUtils.firePropertyChanged(_modelObject_6, "equipoA", _equipoA);
            Partido _modelObject_8 = GenerarEquiposWindow.this.getModelObject();
            Partido _modelObject_9 = GenerarEquiposWindow.this.getModelObject();
            List<Jugador> _equipoB = _modelObject_9.getEquipoB();
            ObservableUtils.firePropertyChanged(_modelObject_8, "equipoB", _equipoB);
          }
        };
        it.onClick(_function);
      }
    };
    final Button botonGenerar = ObjectExtensions.<Button>operator_doubleArrow(_button, _function_2);
    this.createListaJugadores(panelListaJugadores);
  }
  
  public void createListaJugadores(final Panel panelJugadores) {
    Label _label = new Label(panelJugadores);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Jugadores");
        it.setFontSize(20);
      }
    };
    Label labelJugadores = ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    Label _label_1 = new Label(panelJugadores);
    final Procedure1<Label> _function_1 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Equipo A");
        it.setFontSize(20);
      }
    };
    Label labelEquipo1 = ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function_1);
    Label _label_2 = new Label(panelJugadores);
    final Procedure1<Label> _function_2 = new Procedure1<Label>() {
      public void apply(final Label it) {
        it.setText("Equipo B");
        it.setFontSize(20);
      }
    };
    Label labelEquipo2 = ObjectExtensions.<Label>operator_doubleArrow(_label_2, _function_2);
    Table<Jugador> tableListaInscriptos = new Table<Jugador>(panelJugadores, Jugador.class);
    tableListaInscriptos.setHeigth(200);
    tableListaInscriptos.setWidth(285);
    tableListaInscriptos.bindItemsToProperty("jugadores");
    Column<Jugador> _column = new Column<Jugador>(tableListaInscriptos);
    Column<Jugador> _setTitle = _column.setTitle("Nombre");
    _setTitle.bindContentsToProperty("nombre");
    Table<Jugador> _table = new Table<Jugador>(panelJugadores, Jugador.class);
    this.tableListaEquipoA = _table;
    this.tableListaEquipoA.setHeigth(200);
    this.tableListaEquipoA.setWidth(285);
    this.tableListaEquipoA.bindItemsToProperty("equipoA");
    Column<Jugador> _column_1 = new Column<Jugador>(this.tableListaEquipoA);
    Column<Jugador> _setTitle_1 = _column_1.setTitle("Nombre");
    _setTitle_1.bindContentsToProperty("nombre");
    Table<Jugador> tableListaEquipoB = new Table<Jugador>(panelJugadores, Jugador.class);
    tableListaEquipoB.setHeigth(200);
    tableListaEquipoB.setWidth(285);
    tableListaEquipoB.bindItemsToProperty("equipoB");
    Column<Jugador> _column_2 = new Column<Jugador>(tableListaEquipoB);
    Column<Jugador> _setTitle_2 = _column_2.setTitle("Nombre");
    _setTitle_2.bindContentsToProperty("nombre");
  }
}
