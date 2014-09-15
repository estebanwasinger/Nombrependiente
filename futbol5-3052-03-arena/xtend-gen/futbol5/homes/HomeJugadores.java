package futbol5.homes;

import auxiliares.RegistroRechazo;
import calificaciones.Calificacion;
import com.google.common.base.Objects;
import futbol5.domain.Jugador;
import infracciones.Infraccion;
import inscripciones.TipoInscripcion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class HomeJugadores extends CollectionBasedHome<Jugador> {
  private List<Jugador> _jugadoresAceptados;
  
  public List<Jugador> getJugadoresAceptados() {
    return this._jugadoresAceptados;
  }
  
  public void setJugadoresAceptados(final List<Jugador> jugadoresAceptados) {
    this._jugadoresAceptados = jugadoresAceptados;
  }
  
  private List<RegistroRechazo> _jugadoresRechazados;
  
  public List<RegistroRechazo> getJugadoresRechazados() {
    return this._jugadoresRechazados;
  }
  
  public void setJugadoresRechazados(final List<RegistroRechazo> jugadoresRechazados) {
    this._jugadoresRechazados = jugadoresRechazados;
  }
  
  private LinkedList<Jugador> _jugadoresRecomendados;
  
  public LinkedList<Jugador> getJugadoresRecomendados() {
    return this._jugadoresRecomendados;
  }
  
  public void setJugadoresRecomendados(final LinkedList<Jugador> jugadoresRecomendados) {
    this._jugadoresRecomendados = jugadoresRecomendados;
  }
  
  private SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
  
  public HomeJugadores() {
    this.init();
  }
  
  public void init() {
    LinkedList<Jugador> _linkedList = new LinkedList<Jugador>();
    this.setJugadoresAceptados(_linkedList);
    LinkedList<RegistroRechazo> _linkedList_1 = new LinkedList<RegistroRechazo>();
    this.setJugadoresRechazados(_linkedList_1);
    LinkedList<Jugador> _linkedList_2 = new LinkedList<Jugador>();
    this.setJugadoresRecomendados(_linkedList_2);
    this.create("Juan", "Juani", 22, "14-04-1992");
    this.create("Maria", "Juani", 23, "02-05-1991");
    this.create("Julian", "Juani", 21, "19-09-1993");
    this.create("Julieta", "Juani", 25, "14-04-1989");
    this.create("Jose", "Juani", 19, "23-01-1995");
    this.create("Delfina", "Juani", 22, "19-07-1992");
    this.create("Candelaria", "Juani", 22, "20-07-1992");
    this.create("Martin", "Juani", 17, "01-02-1997");
  }
  
  public void createJugadorCompleto(final String nombre, final TipoInscripcion tipoInscripcion, final int edad, final List<Infraccion> infracciones, final List<Jugador> amigos, final List<Calificacion> calificaciones, final float nivelDeJuego, final int criterioComparacion, final String apodo, final Date fechaDeNacimiento) {
    Jugador jugador = new Jugador();
    jugador.setNombre(nombre);
    jugador.setTipoInscripcion(tipoInscripcion);
    jugador.setEdad(edad);
    jugador.setInfracciones(infracciones);
    jugador.setAmigos(amigos);
    jugador.setCalificaciones(calificaciones);
    jugador.setNivelDeJuego(nivelDeJuego);
    jugador.setCriterioComparacion(criterioComparacion);
    jugador.setApodo(apodo);
    jugador.setFechaNacimiento(fechaDeNacimiento);
    List<Jugador> _jugadoresAceptados = this.getJugadoresAceptados();
    _jugadoresAceptados.add(jugador);
  }
  
  public void create(final String nombre, final String apodo, final int edad, final String fechaDeNacimientoStr) {
    try {
      Jugador jugador = new Jugador();
      jugador.setNombre(nombre);
      jugador.setApodo(apodo);
      jugador.setEdad(edad);
      Date _parse = this.formateador.parse(fechaDeNacimientoStr);
      jugador.setFechaNacimiento(_parse);
      List<Jugador> _jugadoresAceptados = this.getJugadoresAceptados();
      _jugadoresAceptados.add(jugador);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void agregarAceptado(final Jugador jugador) {
    List<Jugador> _jugadoresAceptados = this.getJugadoresAceptados();
    _jugadoresAceptados.add(jugador);
  }
  
  public List<Jugador> getJugadores() {
    return this.getJugadoresAceptados();
  }
  
  public List<Jugador> search(final Jugador jugadorBuscado) {
    List<Jugador> _jugadoresAceptados = this.getJugadoresAceptados();
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador jugador) {
        return Boolean.valueOf(HomeJugadores.this.match(jugador, jugadorBuscado));
      }
    };
    Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(_jugadoresAceptados, _function);
    return IterableExtensions.<Jugador>toList(_filter);
  }
  
  public boolean match(final Jugador jugadorEnLista, final Jugador jugadorBuscado) {
    String _nombre = jugadorBuscado.getNombre();
    boolean _equals = Objects.equal(_nombre, null);
    if (_equals) {
    } else {
      String _nombre_1 = jugadorEnLista.getNombre();
      String _lowerCase = _nombre_1.toLowerCase();
      String _nombre_2 = jugadorBuscado.getNombre();
      String _lowerCase_1 = _nombre_2.toLowerCase();
      boolean _startsWith = _lowerCase.startsWith(_lowerCase_1);
      boolean _not = (!_startsWith);
      if (_not) {
        return false;
      }
    }
    String _apodo = jugadorBuscado.getApodo();
    boolean _equals_1 = Objects.equal(_apodo, null);
    if (_equals_1) {
    } else {
      String _apodo_1 = jugadorEnLista.getApodo();
      String _lowerCase_2 = _apodo_1.toLowerCase();
      String _apodo_2 = jugadorBuscado.getApodo();
      String _lowerCase_3 = _apodo_2.toLowerCase();
      boolean _contains = _lowerCase_2.contains(_lowerCase_3);
      boolean _not_1 = (!_contains);
      if (_not_1) {
        return false;
      }
    }
    Date _fechaNacimiento = jugadorBuscado.getFechaNacimiento();
    boolean _equals_2 = Objects.equal(_fechaNacimiento, null);
    if (_equals_2) {
    } else {
      Date _fechaNacimiento_1 = jugadorBuscado.getFechaNacimiento();
      Date _fechaNacimiento_2 = jugadorEnLista.getFechaNacimiento();
      boolean _lessThan = (_fechaNacimiento_1.compareTo(_fechaNacimiento_2) < 0);
      if (_lessThan) {
        return false;
      }
    }
    return true;
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
