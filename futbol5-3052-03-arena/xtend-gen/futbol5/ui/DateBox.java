package futbol5.ui;

import futbol5.auxUtils.DateTextFilter;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@SuppressWarnings("all")
public class DateBox extends TextBox {
  public DateBox(final Panel container) {
    super(container);
  }
  
  public Binding<ControlBuilder> bindValueToProperty(final String propertyName) {
    Binding<ControlBuilder> _xblockexpression = null;
    {
      final Binding<ControlBuilder> binding = super.<ControlBuilder>bindValueToProperty(propertyName);
      DateTextFilter _dateTextFilter = new DateTextFilter();
      this.withFilter(_dateTextFilter);
      _xblockexpression = binding;
    }
    return _xblockexpression;
  }
}
