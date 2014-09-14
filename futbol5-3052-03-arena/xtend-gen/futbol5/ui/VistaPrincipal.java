package futbol5.ui;

import futbol5.applicationModel.Futbol5;
import futbol5.domain.Partido;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class VistaPrincipal extends MainWindow<Futbol5> {
  public VistaPrincipal(final Futbol5 model) {
    super(model);
  }
  
  public void createContents(final Panel mainPanel) {
    ColumnLayout _columnLayout = new ColumnLayout(2);
    mainPanel.setLayout(_columnLayout);
    Panel _panel = new Panel(mainPanel);
    VerticalLayout _verticalLayout = new VerticalLayout();
    final Panel panelIzq = _panel.setLayout(_verticalLayout);
    Panel _panel_1 = new Panel(mainPanel);
    VerticalLayout _verticalLayout_1 = new VerticalLayout();
    final Panel panelDer = _panel_1.setLayout(_verticalLayout_1);
    Label _label = new Label(panelIzq);
    final Label titulo = _label.setText("Futbol 5");
    Label _label_1 = new Label(panelIzq);
    Label ultimosPartidos = _label_1.setText("Ultimos Partidos");
    Table listaPartidos = new Table<Partido>(panelIzq, Partido.class);
  }
}
