package futbol5.auxUtils;

import com.google.common.base.Objects;
import com.uqbar.commons.collections.Transformer;
import futbol5.domain.Jugador;
import java.awt.Color;
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
        Grilla.this.createColumn(it, "Nombre", "nombre");
        Grilla.this.createColumn(it, "Apodo", "apodo");
        Grilla.this.createColumn(it, "Handicap", "nivelDeJuego");
        Grilla.this.createColumn(it, "Promedio", "promedio");
      }
    };
    return ObjectExtensions.<Table<Jugador>>operator_doubleArrow(_table, _function);
  }
  
  public Column<Jugador> createColumn(final Table<Jugador> it, final String columnTitle, final String contentToBind) {
    Column<Jugador> _column = new Column<Jugador>(it);
    final Procedure1<Column<Jugador>> _function = new Procedure1<Column<Jugador>>() {
      public void apply(final Column<Jugador> it) {
        it.setTitle(columnTitle);
        it.setFixedSize(80);
        it.bindContentsToProperty(contentToBind);
        final Transformer<Comparable<? super Float>,Color> _function = new Transformer<Comparable<? super Float>,Color>() {
          public Color transform(final Comparable<? super Float> prom) {
            Color _xifexpression = null;
            boolean _greaterEqualsThan = (prom.compareTo(Float.valueOf(8.0f)) >= 0);
            if (_greaterEqualsThan) {
              _xifexpression = new Color(151, 175, 255);
            } else {
              _xifexpression = Color.WHITE;
            }
            return _xifexpression;
          }
        };
        it.<Comparable<? super Float>>bindBackground("nivelDeJuego", _function);
      }
    };
    return ObjectExtensions.<Column<Jugador>>operator_doubleArrow(_column, _function);
  }
}
