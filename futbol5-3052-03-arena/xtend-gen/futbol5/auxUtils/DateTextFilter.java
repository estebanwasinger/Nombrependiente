package futbol5.auxUtils;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.uqbar.arena.widgets.TextFilter;
import org.uqbar.arena.widgets.TextInputEvent;

@SuppressWarnings("all")
public class DateTextFilter implements TextFilter {
  public boolean accept(final TextInputEvent event) {
    boolean _xblockexpression = false;
    {
      final ArrayList<String> expected = new ArrayList<String>(Collections.<String>unmodifiableList(Lists.<String>newArrayList("\\d", "\\d?", "/", "\\d", "\\d?", "/", "\\d{0,4}")));
      List<String> _reverse = ListExtensions.<String>reverse(expected);
      final Function2<String,String,String> _function = new Function2<String,String,String>() {
        public String apply(final String result, final String element) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("(");
          _builder.append(element, "");
          _builder.append(result, "");
          _builder.append(")?");
          return _builder.toString();
        }
      };
      final String regex = IterableExtensions.<String, String>fold(_reverse, "", _function);
      String _potentialTextResult = event.getPotentialTextResult();
      _xblockexpression = _potentialTextResult.matches(regex);
    }
    return _xblockexpression;
  }
}
