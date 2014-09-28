package futbol5.auxUtils;

import com.google.common.base.Objects;
import futbol5.domain.Jugador;
import java.util.List;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class Grilla {
  public Grilla() {
  }
  
  public Table<Jugador> generar(final Panel panelResultados, final Jugador jugadorSeleccionado, final List<Jugador> jugadores, final String valor, final String items) {
    Table<Jugador> _table = new Table<Jugador>(panelResultados, Jugador.class);
    final Procedure1<Table<Jugador>> _function = new Procedure1<Table<Jugador>>() {
      public void apply(final Table<Jugador> it) {
        it.setHeigth(220);
        it.setWidth(360);
        boolean _notEquals = (!Objects.equal(valor, ""));
        if (_notEquals) {
          it.<ControlBuilder>bindValueToProperty(valor);
        }
        it.bindItemsToProperty(items);
        Column<Jugador> _column = new Column<Jugador>(it);
        final Procedure1<Column<Jugador>> _function = new Procedure1<Column<Jugador>>() {
          public void apply(final Column<Jugador> it) {
            it.setTitle("Nombre");
            it.setFixedSize(100);
            it.bindContentsToProperty("nombre");
          }
        };
        ObjectExtensions.<Column<Jugador>>operator_doubleArrow(_column, _function);
        Column<Jugador> _column_1 = new Column<Jugador>(it);
        final Procedure1<Column<Jugador>> _function_1 = new Procedure1<Column<Jugador>>() {
          public void apply(final Column<Jugador> it) {
            it.setTitle("Apodo");
            it.setFixedSize(100);
            it.bindContentsToProperty("apodo");
          }
        };
        ObjectExtensions.<Column<Jugador>>operator_doubleArrow(_column_1, _function_1);
        Column<Jugador> _column_2 = new Column<Jugador>(it);
        final Procedure1<Column<Jugador>> _function_2 = new Procedure1<Column<Jugador>>() {
          public void apply(final Column<Jugador> it) {
            it.setTitle("Handicap");
            it.setFixedSize(80);
            it.bindContentsToProperty("nivelDeJuego");
          }
        };
        ObjectExtensions.<Column<Jugador>>operator_doubleArrow(_column_2, _function_2);
        Column<Jugador> _column_3 = new Column<Jugador>(it);
        final Procedure1<Column<Jugador>> _function_3 = new Procedure1<Column<Jugador>>() {
          public void apply(final Column<Jugador> it) {
            it.setTitle("Promedio");
            it.setFixedSize(80);
            it.bindContentsToProperty("promedio");
          }
        };
        ObjectExtensions.<Column<Jugador>>operator_doubleArrow(_column_3, _function_3);
      }
    };
    return ObjectExtensions.<Table<Jugador>>operator_doubleArrow(_table, _function);
  }
}
