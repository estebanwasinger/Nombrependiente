package ar.edu.futbol5;

import ar.edu.futbol5.Equipo;
import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.excepciones.BusinessException;
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento;
import ar.edu.futbol5.ordenamiento.OrdenamientoPorHandicap;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Partido {
  private List<Jugador> _inscriptos;
  
  public List<Jugador> getInscriptos() {
    return this._inscriptos;
  }
  
  public void setInscriptos(final List<Jugador> inscriptos) {
    this._inscriptos = inscriptos;
  }
  
  private Equipo _equipo1;
  
  public Equipo getEquipo1() {
    return this._equipo1;
  }
  
  public void setEquipo1(final Equipo equipo1) {
    this._equipo1 = equipo1;
  }
  
  private Equipo _equipo2;
  
  public Equipo getEquipo2() {
    return this._equipo2;
  }
  
  public void setEquipo2(final Equipo equipo2) {
    this._equipo2 = equipo2;
  }
  
  private String estado;
  
  private CriterioOrdenamiento _criterioOrdenamiento;
  
  public CriterioOrdenamiento getCriterioOrdenamiento() {
    return this._criterioOrdenamiento;
  }
  
  public void setCriterioOrdenamiento(final CriterioOrdenamiento criterioOrdenamiento) {
    this._criterioOrdenamiento = criterioOrdenamiento;
  }
  
  private int _distribucionEquipos;
  
  public int getDistribucionEquipos() {
    return this._distribucionEquipos;
  }
  
  public void setDistribucionEquipos(final int distribucionEquipos) {
    this._distribucionEquipos = distribucionEquipos;
  }
  
  public Partido() {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setInscriptos(_arrayList);
    this.estado = "A";
    this.setDistribucionEquipos(5);
    OrdenamientoPorHandicap _ordenamientoPorHandicap = new OrdenamientoPorHandicap();
    this.setCriterioOrdenamiento(_ordenamientoPorHandicap);
  }
  
  public String generarEquipos() {
    String _xblockexpression = null;
    {
      int _validarInscripcion = this.validarInscripcion();
      boolean _equals = (_validarInscripcion == (-1));
      if (_equals) {
        throw new BusinessException("Hubo un error");
      }
      List<Jugador> _ordenarEquipos = this.ordenarEquipos();
      this.distribuirEquipos(_ordenarEquipos);
      _xblockexpression = this.estado = "G";
    }
    return _xblockexpression;
  }
  
  public int validarInscripcion() {
    List<Jugador> _inscriptos = this.getInscriptos();
    int _size = _inscriptos.size();
    boolean _lessThan = (_size < 10);
    if (_lessThan) {
      return (-1);
    }
    boolean _equalsIgnoreCase = this.estado.equalsIgnoreCase("A");
    if (_equalsIgnoreCase) {
      return (-1);
    }
    boolean _equalsIgnoreCase_1 = this.estado.equalsIgnoreCase("G");
    if (_equalsIgnoreCase_1) {
      return (-1);
    }
    return 0;
  }
  
  public void distribuirEquipos(final List<Jugador> jugadores) {
    throw new Error("Unresolved compilation problems:"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (Jugador,Jugador,Jugador,Jugador,Jugador)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (Jugador,Jugador,Jugador,Jugador,Jugador)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (Jugador,Jugador,Jugador,Jugador,Jugador)"
      + "\nInvalid number of arguments. The method newArrayList(T[]) is not applicable for the arguments (Jugador,Jugador,Jugador,Jugador,Jugador)"
      + "\nType mismatch: cannot convert from Jugador to Object[]"
      + "\nType mismatch: cannot convert from Jugador to Object[]"
      + "\nType mismatch: cannot convert from Jugador to Object[]"
      + "\nType mismatch: cannot convert from Jugador to Object[]");
  }
  
  public List<Jugador> ordenarEquipos() {
    CriterioOrdenamiento _criterioOrdenamiento = this.getCriterioOrdenamiento();
    return _criterioOrdenamiento.ordenar(this);
  }
  
  public void inscribir(final Jugador jugador) {
    List<Jugador> _inscriptos = this.getInscriptos();
    int _size = _inscriptos.size();
    boolean _lessThan = (_size < 10);
    if (_lessThan) {
      List<Jugador> _inscriptos_1 = this.getInscriptos();
      _inscriptos_1.add(jugador);
    } else {
      boolean _hayAlgunJugadorQueCedaLugar = this.hayAlgunJugadorQueCedaLugar();
      if (_hayAlgunJugadorQueCedaLugar) {
        List<Jugador> _inscriptos_2 = this.getInscriptos();
        Jugador _jugadorQueCedeLugar = this.jugadorQueCedeLugar();
        _inscriptos_2.remove(_jugadorQueCedeLugar);
        List<Jugador> _inscriptos_3 = this.getInscriptos();
        _inscriptos_3.add(jugador);
      } else {
        throw new BusinessException("No hay más lugar");
      }
    }
  }
  
  public boolean hayAlgunJugadorQueCedaLugar() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method dejaLugarAOtro is undefined for the type Partido");
  }
  
  public Jugador jugadorQueCedeLugar() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method dejaLugarAOtro is undefined for the type Partido"
      + "\nType mismatch: cannot convert from Iterable to Jugador[]");
  }
  
  public void cerrar() {
    this.estado = "C";
  }
}
