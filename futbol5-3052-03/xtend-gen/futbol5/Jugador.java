package futbol5;

import calificaciones.Calificacion;
import com.google.common.base.Objects;
import excepciones.BusinessException;
import futbol5.Partido;
import infracciones.Infraccion;
import inscripciones.Estandar;
import inscripciones.TipoInscripcion;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Jugador {
  private TipoInscripcion _tipoInscripcion;
  
  public TipoInscripcion getTipoInscripcion() {
    return this._tipoInscripcion;
  }
  
  public void setTipoInscripcion(final TipoInscripcion tipoInscripcion) {
    this._tipoInscripcion = tipoInscripcion;
  }
  
  private int _edad;
  
  public int getEdad() {
    return this._edad;
  }
  
  public void setEdad(final int edad) {
    this._edad = edad;
  }
  
  private String _email;
  
  public String getEmail() {
    return this._email;
  }
  
  public void setEmail(final String email) {
    this._email = email;
  }
  
  private List<Infraccion> _infracciones;
  
  public List<Infraccion> getInfracciones() {
    return this._infracciones;
  }
  
  public void setInfracciones(final List<Infraccion> infracciones) {
    this._infracciones = infracciones;
  }
  
  private List<Jugador> _amigos;
  
  public List<Jugador> getAmigos() {
    return this._amigos;
  }
  
  public void setAmigos(final List<Jugador> amigos) {
    this._amigos = amigos;
  }
  
  private List<Calificacion> _calificaciones;
  
  public List<Calificacion> getCalificaciones() {
    return this._calificaciones;
  }
  
  public void setCalificaciones(final List<Calificacion> calificaciones) {
    this._calificaciones = calificaciones;
  }
  
  private int _nivelDeJuego;
  
  public int getNivelDeJuego() {
    return this._nivelDeJuego;
  }
  
  public void setNivelDeJuego(final int nivelDeJuego) {
    this._nivelDeJuego = nivelDeJuego;
  }
  
  private int _criterioComparacion;
  
  public int getCriterioComparacion() {
    return this._criterioComparacion;
  }
  
  public void setCriterioComparacion(final int criterioComparacion) {
    this._criterioComparacion = criterioComparacion;
  }
  
  public Jugador() {
    Estandar _estandar = new Estandar();
    this.setTipoInscripcion(_estandar);
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setAmigos(_arrayList);
    ArrayList<Infraccion> _arrayList_1 = new ArrayList<Infraccion>();
    this.setInfracciones(_arrayList_1);
    LinkedList<Calificacion> _linkedList = new LinkedList<Calificacion>();
    this.setCalificaciones(_linkedList);
  }
  
  public boolean agregarAmigo(final Jugador jugador) {
    List<Jugador> _amigos = this.getAmigos();
    return _amigos.add(jugador);
  }
  
  public boolean menorA(final int edad) {
    int _edad = this.getEdad();
    return (_edad < edad);
  }
  
  public boolean tieneMasPrioridadQue(final Jugador jugador) {
    int _prioridad = this.prioridad();
    int _prioridad_1 = jugador.prioridad();
    return (_prioridad < _prioridad_1);
  }
  
  public int prioridad() {
    TipoInscripcion _tipoInscripcion = this.getTipoInscripcion();
    return _tipoInscripcion.prioridad();
  }
  
  public int promedioCalificacionesUltimoPartido() {
    try {
      int sumaCalificaciones = 0;
      List<Calificacion> _calificaciones = this.getCalificaciones();
      int _size = _calificaciones.size();
      boolean _equals = (_size == 0);
      if (_equals) {
        throw new BusinessException("El jugador no fue calificado aun");
      }
      List<Calificacion> _calificaciones_1 = this.getCalificaciones();
      final Function1<Calificacion,Boolean> _function = new Function1<Calificacion,Boolean>() {
        public Boolean apply(final Calificacion calificacion) {
          Partido _partido = calificacion.getPartido();
          List<Calificacion> _calificaciones = Jugador.this.getCalificaciones();
          Calificacion _last = IterableExtensions.<Calificacion>last(_calificaciones);
          Partido _partido_1 = _last.getPartido();
          return Boolean.valueOf(Objects.equal(_partido, _partido_1));
        }
      };
      Iterable<Calificacion> calificacionesUltimoPartido = IterableExtensions.<Calificacion>filter(_calificaciones_1, _function);
      final Function1<Calificacion,Integer> _function_1 = new Function1<Calificacion,Integer>() {
        public Integer apply(final Calificacion calificacion) {
          return Integer.valueOf(calificacion.getNota());
        }
      };
      Iterable<Integer> _map = IterableExtensions.<Calificacion, Integer>map(calificacionesUltimoPartido, _function_1);
      final Function2<Integer,Integer,Integer> _function_2 = new Function2<Integer,Integer,Integer>() {
        public Integer apply(final Integer a, final Integer b) {
          return Integer.valueOf(((a).intValue() + (b).intValue()));
        }
      };
      Integer _reduce = IterableExtensions.<Integer>reduce(_map, _function_2);
      sumaCalificaciones = (_reduce).intValue();
      int _size_1 = IterableExtensions.size(calificacionesUltimoPartido);
      return (sumaCalificaciones / _size_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Object promedioNCalificaciones(final int n) {
    return null;
  }
  
  public Set<Partido> buscarNPartidos(final int n) {
    Set<Partido> partidos = null;
    int _size = partidos.size();
    boolean _lessEqualsThan = (_size <= n);
    boolean _while = _lessEqualsThan;
    while (_while) {
      int _size_1 = partidos.size();
      boolean _lessEqualsThan_1 = (_size_1 <= n);
      _while = _lessEqualsThan_1;
    }
    return partidos;
  }
  
  public boolean calificar(final Partido partido, final int nota, final String critica) {
    try {
      boolean _xblockexpression = false;
      {
        boolean _estaInscripto = partido.estaInscripto(this);
        boolean _not = (!_estaInscripto);
        if (_not) {
          throw new BusinessException("El jugador que se quiere calificar no jugo el partido indicado");
        }
        List<Calificacion> _calificaciones = this.getCalificaciones();
        Calificacion _calificacion = new Calificacion(this, partido, Integer.valueOf(nota), critica);
        _xblockexpression = _calificaciones.add(_calificacion);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
