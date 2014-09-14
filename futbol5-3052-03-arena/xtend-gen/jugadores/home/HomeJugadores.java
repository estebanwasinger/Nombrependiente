package jugadores.home;

import calificaciones.Calificacion;
import com.google.common.base.Objects;
import futbol5.Jugador;
import infracciones.Infraccion;
import inscripciones.TipoInscripcion;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class HomeJugadores extends CollectionBasedHome<Jugador> {
  public HomeJugadores() {
    this.init();
  }
  
  public void init() {
  }
  
  public void create(final String nombre, final TipoInscripcion tipoInscripcion, final int edad, final List<Infraccion> infracciones, final List<Jugador> amigos, final List<Calificacion> calificaciones, final float nivelDeJuego, final int criterioComparacion) {
    Jugador jugador = new Jugador();
    jugador.setNombre(nombre);
    jugador.setTipoInscripcion(tipoInscripcion);
    jugador.setEdad(edad);
    jugador.setInfracciones(infracciones);
    jugador.setAmigos(amigos);
    jugador.setCalificaciones(calificaciones);
    jugador.setNivelDeJuego(nivelDeJuego);
    jugador.setCriterioComparacion(criterioComparacion);
    this.create(jugador);
  }
  
  public void validateCreate(final Jugador jugador) {
    jugador.validarNombre();
    this.validarMateriasDuplicadas(jugador);
  }
  
  public void validarMateriasDuplicadas(final Jugador jugador) {
    final String nombre = jugador.getNombre();
    List<Jugador> _search = this.search(nombre);
    boolean _isEmpty = _search.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      throw new UserException(("Ya existe una materia con el nombre " + nombre));
    }
  }
  
  public List<Jugador> getJugadores() {
    return this.allInstances();
  }
  
  public List<Jugador> search(final String nombre) {
    List<Jugador> _allInstances = this.allInstances();
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador jugador) {
        String _nombre = jugador.getNombre();
        return Boolean.valueOf(HomeJugadores.this.match(nombre, _nombre));
      }
    };
    Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(_allInstances, _function);
    return IterableExtensions.<Jugador>toList(_filter);
  }
  
  public boolean match(final Object expectedValue, final Object realValue) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(expectedValue, null);
      if (_equals) {
        return true;
      }
      boolean _equals_1 = Objects.equal(realValue, null);
      if (_equals_1) {
        return false;
      }
      String _string = realValue.toString();
      String _lowerCase = _string.toLowerCase();
      String _string_1 = expectedValue.toString();
      String _lowerCase_1 = _string_1.toLowerCase();
      _xblockexpression = _lowerCase.contains(_lowerCase_1);
    }
    return _xblockexpression;
  }
  
  public Class<Jugador> getEntityType() {
    return Jugador.class;
  }
  
  public Jugador createExample() {
    return new Jugador();
  }
  
  public Predicate getCriterio(final Jugador example) {
    return null;
  }
}