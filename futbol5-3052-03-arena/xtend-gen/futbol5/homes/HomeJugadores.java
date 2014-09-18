package futbol5.homes;

import auxiliares.RegistroRechazo;
import calificaciones.Calificacion;
import futbol5.auxUtils.InicializadorJugador;
import futbol5.domain.Jugador;
import infracciones.Infraccion;
import inscripciones.TipoInscripcion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    ArrayList<Jugador> _crearListaDejugadores = InicializadorJugador.crearListaDejugadores(10);
    this.setJugadoresAceptados(_crearListaDejugadores);
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
    final Function1<Jugador, Boolean> _function = new Function1<Jugador, Boolean>() {
      public Boolean apply(final Jugador jugador) {
        return Boolean.valueOf(jugador.matchea(jugadorBuscado));
      }
    };
    Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(_jugadoresAceptados, _function);
    return IterableExtensions.<Jugador>toList(_filter);
  }
  
  /**
   * def match(Jugador jugadorEnLista, Jugador jugadorBuscado) {
   * matcheaNombre(jugadorEnLista,jugadorBuscado) &&
   * matcheaApodo(jugadorEnLista,jugadorBuscado) &&
   * !esMenorAnioNacimiento(jugadorEnLista,jugadorBuscado)
   * }
   * 
   * def matcheaNombre( Jugador jugadorEnLista, Jugador jugadorBuscado){
   * jugadorBuscado.nombre == null || jugadorEnLista.nombre.toLowerCase.startsWith(jugadorBuscado.nombre.toLowerCase)
   * }
   * def matcheaApodo( Jugador jugadorEnLista, Jugador jugadorBuscado){
   * jugadorBuscado.apodo == null || jugadorEnLista.apodo.toLowerCase.contains(jugadorBuscado.apodo.toLowerCase)
   * }
   * def esMenorAnioNacimiento( Jugador jugadorEnLista, Jugador jugadorBuscado){
   * jugadorBuscado.fechaNacimiento == null || jugadorBuscado.fechaNacimiento < jugadorEnLista.fechaNacimiento
   * }
   */
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
