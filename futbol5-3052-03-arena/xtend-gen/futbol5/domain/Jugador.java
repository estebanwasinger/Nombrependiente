package futbol5.domain;

import calificaciones.Calificacion;
import com.google.common.base.Objects;
import excepciones.BusinessException;
import futbol5.domain.Partido;
import infracciones.Infraccion;
import inscripciones.Estandar;
import inscripciones.TipoInscripcion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Jugador extends Entity {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private String _apodo;
  
  public String getApodo() {
    return this._apodo;
  }
  
  public void setApodo(final String apodo) {
    this._apodo = apodo;
  }
  
  private int _edad;
  
  public int getEdad() {
    return this._edad;
  }
  
  public void setEdad(final int edad) {
    this._edad = edad;
  }
  
  private Date _fechaNacimiento;
  
  public Date getFechaNacimiento() {
    return this._fechaNacimiento;
  }
  
  public void setFechaNacimiento(final Date fechaNacimiento) {
    this._fechaNacimiento = fechaNacimiento;
  }
  
  private String _email;
  
  public String getEmail() {
    return this._email;
  }
  
  public void setEmail(final String email) {
    this._email = email;
  }
  
  private TipoInscripcion _tipoInscripcion;
  
  public TipoInscripcion getTipoInscripcion() {
    return this._tipoInscripcion;
  }
  
  public void setTipoInscripcion(final TipoInscripcion tipoInscripcion) {
    this._tipoInscripcion = tipoInscripcion;
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
  
  private float _nivelDeJuego;
  
  public float getNivelDeJuego() {
    return this._nivelDeJuego;
  }
  
  public void setNivelDeJuego(final float nivelDeJuego) {
    this._nivelDeJuego = nivelDeJuego;
  }
  
  private int _criterioComparacion;
  
  public int getCriterioComparacion() {
    return this._criterioComparacion;
  }
  
  public void setCriterioComparacion(final int criterioComparacion) {
    this._criterioComparacion = criterioComparacion;
  }
  
  private int _cantidadPartidos;
  
  public int getCantidadPartidos() {
    return this._cantidadPartidos;
  }
  
  public void setCantidadPartidos(final int cantidadPartidos) {
    this._cantidadPartidos = cantidadPartidos;
  }
  
  private SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
  
  public Jugador() {
    this.init();
  }
  
  public Jugador(final String nombre) {
    this.setNombre(nombre);
    this.init();
  }
  
  public Jugador(final String nombre, final String apodo, final int edad, final String fechaDeNacimientoStr, final int nivelDeJuego, final List<Jugador> amigos, final ArrayList<Calificacion> calificaciones, final int cantidadPartidos) {
    try {
      this.init();
      this.setNombre(nombre);
      this.setApodo(apodo);
      this.setEdad(edad);
      boolean _notEquals = (!Objects.equal(fechaDeNacimientoStr, null));
      if (_notEquals) {
        Date _parse = this.formateador.parse(fechaDeNacimientoStr);
        this.setFechaNacimiento(_parse);
      }
      this.setNivelDeJuego(nivelDeJuego);
      this.setAmigos(amigos);
      this.setCalificaciones(calificaciones);
      this.setCantidadPartidos(cantidadPartidos);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Jugador(final String nombre, final String apodo, final int edad, final String fechaDeNacimientoStr) {
    try {
      this.init();
      this.setNombre(nombre);
      this.setApodo(apodo);
      this.setEdad(edad);
      boolean _notEquals = (!Objects.equal(fechaDeNacimientoStr, null));
      if (_notEquals) {
        Date _parse = this.formateador.parse(fechaDeNacimientoStr);
        this.setFechaNacimiento(_parse);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void init() {
    Estandar _estandar = new Estandar();
    this.setTipoInscripcion(_estandar);
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setAmigos(_arrayList);
    ArrayList<Infraccion> _arrayList_1 = new ArrayList<Infraccion>();
    this.setInfracciones(_arrayList_1);
    LinkedList<Calificacion> _linkedList = new LinkedList<Calificacion>();
    this.setCalificaciones(_linkedList);
  }
  
  public void validarNombre() {
    String _nombre = this.getNombre();
    boolean _equals = Objects.equal(_nombre, null);
    if (_equals) {
      throw new UserException("El jugador no puede tener nombre nulo");
    }
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
  
  public float promedioCalificacionesUltimoPartido() {
    return this.promedioNPartidos(1);
  }
  
  public void agregarInfraccion(final Infraccion infraccion) {
    List<Infraccion> _infracciones = this.getInfracciones();
    _infracciones.add(infraccion);
  }
  
  public float promedioNPartidos(final int n) {
    List<Calificacion> _calificaciones = this.getCalificaciones();
    int _size = _calificaciones.size();
    boolean _notEquals = (_size != 0);
    if (_notEquals) {
      int calificacionTotal = 0;
      Set<Partido> partidos = new HashSet<Partido>();
      int pos = 0;
      boolean _and = false;
      int _size_1 = partidos.size();
      boolean _lessEqualsThan = (_size_1 <= n);
      if (!_lessEqualsThan) {
        _and = false;
      } else {
        List<Calificacion> _calificaciones_1 = this.getCalificaciones();
        int _size_2 = _calificaciones_1.size();
        boolean _lessThan = (pos < _size_2);
        _and = _lessThan;
      }
      boolean _while = _and;
      while (_while) {
        {
          List<Calificacion> _calificaciones_2 = this.getCalificaciones();
          Calificacion _get = _calificaciones_2.get(pos);
          Partido _partido = _get.getPartido();
          partidos.add(_partido);
          pos = (pos + 1);
        }
        boolean _and_1 = false;
        int _size_3 = partidos.size();
        boolean _lessEqualsThan_1 = (_size_3 <= n);
        if (!_lessEqualsThan_1) {
          _and_1 = false;
        } else {
          List<Calificacion> _calificaciones_2 = this.getCalificaciones();
          int _size_4 = _calificaciones_2.size();
          boolean _lessThan_1 = (pos < _size_4);
          _and_1 = _lessThan_1;
        }
        _while = _and_1;
      }
      pos = 0;
      int _size_3 = partidos.size();
      boolean _lessThan_1 = (pos < _size_3);
      boolean _while_1 = _lessThan_1;
      while (_while_1) {
        {
          final Set<Partido> _converted_partidos = (Set<Partido>)partidos;
          Partido _get = ((Partido[])Conversions.unwrapArray(_converted_partidos, Partido.class))[pos];
          int _promedioDeUnPartido = this.promedioDeUnPartido(_get);
          int _plus = (calificacionTotal + _promedioDeUnPartido);
          calificacionTotal = _plus;
          pos = (pos + 1);
        }
        int _size_4 = partidos.size();
        boolean _lessThan_2 = (pos < _size_4);
        _while_1 = _lessThan_2;
      }
      int _size_4 = partidos.size();
      return (calificacionTotal / _size_4);
    }
    return 0;
  }
  
  public int promedioDeUnPartido(final Partido partido) {
    List<Calificacion> _calificaciones = this.getCalificaciones();
    final Function1<Calificacion,Boolean> _function = new Function1<Calificacion,Boolean>() {
      public Boolean apply(final Calificacion calificacion) {
        Partido _partido = calificacion.getPartido();
        return Boolean.valueOf(Objects.equal(_partido, partido));
      }
    };
    Iterable<Calificacion> calificacionesUltimoPartido = IterableExtensions.<Calificacion>filter(_calificaciones, _function);
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
    Integer sumaCalificaciones = IterableExtensions.<Integer>reduce(_map, _function_2);
    int _size = IterableExtensions.size(calificacionesUltimoPartido);
    return ((sumaCalificaciones).intValue() / _size);
  }
  
  public int getPromedio() {
    int _xblockexpression = (int) 0;
    {
      int promedio = 0;
      int i = 0;
      List<Calificacion> _calificaciones = this.getCalificaciones();
      int _size = _calificaciones.size();
      boolean _lessThan = (i < _size);
      boolean _while = _lessThan;
      while (_while) {
        {
          List<Calificacion> _calificaciones_1 = this.getCalificaciones();
          Calificacion _get = _calificaciones_1.get(0);
          int _nota = _get.getNota();
          promedio = _nota;
          i = (i + 1);
        }
        List<Calificacion> _calificaciones_1 = this.getCalificaciones();
        int _size_1 = _calificaciones_1.size();
        boolean _lessThan_1 = (i < _size_1);
        _while = _lessThan_1;
      }
      List<Calificacion> _calificaciones_1 = this.getCalificaciones();
      int _size_1 = _calificaciones_1.size();
      int _divide = (promedio / _size_1);
      _xblockexpression = promedio = _divide;
    }
    return _xblockexpression;
  }
  
  public String getFechaNacimientoString() {
    Date _fechaNacimiento = this.getFechaNacimiento();
    return this.formateador.format(_fechaNacimiento);
  }
  
  public void setFechaNacimientoString(final String fecha) {
    try {
      Date _parse = this.formateador.parse(fecha);
      this.setFechaNacimiento(_parse);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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
