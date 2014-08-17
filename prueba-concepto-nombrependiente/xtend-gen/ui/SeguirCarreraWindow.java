package ui;

import applicationModel.SeguidorCarrera;
import domain.Materia;
import home.HomeMaterias;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Link;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.lacar.ui.model.Action;

/**
 * Ejemplo de conversor millas -> kilometros en xtend
 */
@SuppressWarnings("all")
public class SeguirCarreraWindow extends MainWindow<SeguidorCarrera> {
  public SeguirCarreraWindow() {
    super(new SeguidorCarrera());
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomeMaterias _homeMaterias = new HomeMaterias();
    _instance.<HomeMaterias>configureSingleton(Materia.class, _homeMaterias);
  }
  
  public void createContents(final Panel mainPanel) {
    this.createResultsGrid(mainPanel);
    this.createActionPanel(mainPanel);
  }
  
  public Link createActionPanel(final Panel panel) {
    Button _button = new Button(panel);
    Button _setCaption = _button.setCaption("Buscar");
    final Action _function = new Action() {
      public void execute() {
        SeguidorCarrera _modelObject = SeguirCarreraWindow.this.getModelObject();
        _modelObject.search();
      }
    };
    Button _onClick = _setCaption.onClick(_function);
    Button _setAsDefault = _onClick.setAsDefault();
    return _setAsDefault.disableOnError();
  }
  
  protected void createResultsGrid(final Panel mainPanel) {
    Table<Materia> table = new Table<Materia>(mainPanel, Materia.class);
    table.setHeigth(200);
    table.setWidth(450);
    this.describeResultsGrid(table);
  }
  
  /**
   * Define las columnas de la grilla Cada columna se puede bindear 1) contra una propiedad del model, como
   * en el caso del número o el nombre 2) contra un transformer que recibe el model y devuelve un tipo
   * (generalmente String), como en el caso de Recibe Resumen de Cuenta
   * 
   * @param table
   */
  public void describeResultsGrid(final Table<Materia> table) {
    Column<Materia> _column = new Column<Materia>(table);
    Column<Materia> _setTitle = _column.setTitle("Materias");
    Column<Materia> _setFixedSize = _setTitle.setFixedSize(150);
    _setFixedSize.bindContentsToProperty("nombre");
  }
  
  public static void main(final String[] args) {
    SeguirCarreraWindow _seguirCarreraWindow = new SeguirCarreraWindow();
    _seguirCarreraWindow.startApplication();
  }
}
