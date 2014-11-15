package ar.edu.materias.homes;

import ar.edu.materias.domain.Materia;
import ar.edu.materias.homes.HomeMaterias;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class HomeMateriasImpl implements HomeMaterias {
  private List<Materia> materias;
  
  /**
   * singleton
   */
  private static HomeMateriasImpl instance;
  
  private HomeMateriasImpl() {
    ArrayList<Materia> _arrayList = new ArrayList<Materia>();
    this.materias = _arrayList;
  }
  
  public static HomeMateriasImpl getInstance() {
    HomeMateriasImpl _xblockexpression = null;
    {
      boolean _equals = Objects.equal(HomeMateriasImpl.instance, null);
      if (_equals) {
        HomeMateriasImpl _homeMateriasImpl = new HomeMateriasImpl();
        HomeMateriasImpl.instance = _homeMateriasImpl;
      }
      _xblockexpression = HomeMateriasImpl.instance;
    }
    return _xblockexpression;
  }
  
  /**
   * fin singleton
   */
  public void agregarMateria(final Materia materia) {
    int _ultimoIdUtilizado = this.getUltimoIdUtilizado();
    long _longValue = Integer.valueOf(_ultimoIdUtilizado).longValue();
    long _plus = (_longValue + 1);
    Long _long = new Long(_plus);
    materia.setId(_long);
    this.materias.add(materia);
  }
  
  public int getUltimoIdUtilizado() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method id is undefined for the type HomeMateriasImpl"
      + "\nThe method id is undefined for the type HomeMateriasImpl"
      + "\n- cannot be resolved"
      + "\nintValue cannot be resolved");
  }
  
  public void actualizarMateria(final Materia materiaActualizado) {
    materiaActualizado.validar();
    Long _id = materiaActualizado.getId();
    boolean _equals = Objects.equal(_id, null);
    if (_equals) {
      this.agregarMateria(materiaActualizado);
    } else {
      this.doActualizarMateria(materiaActualizado);
    }
  }
  
  public void doActualizarMateria(final Materia materiaActualizado) {
    Long _id = materiaActualizado.getId();
    Materia _materia = this.getMateria(_id);
    final Materia unMateria = _materia.copy();
    unMateria.actualizarCon(materiaActualizado);
  }
  
  public void eliminarMateria(final Materia materia) {
    Long _id = materia.getId();
    Materia _materia = this.getMateria(_id);
    this.materias.remove(_materia);
  }
  
  public Materia getMateria(final Long id) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method id is undefined for the type HomeMateriasImpl"
      + "\nequals cannot be resolved");
  }
  
  public List<Materia> getMaterias(final Materia materiaBusqueda) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method matchea is undefined for the type HomeMateriasImpl"
      + "\nThe method copy is undefined for the type HomeMateriasImpl");
  }
}
