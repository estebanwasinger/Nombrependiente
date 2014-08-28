package ar.edu.materias.homes;

import ar.edu.materias.domain.Materia;
import ar.edu.materias.homes.HomeMaterias;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

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
    boolean _isEmpty = this.materias.isEmpty();
    if (_isEmpty) {
      return 1;
    }
    final Function1<Materia, Long> _function = new Function1<Materia, Long>() {
      public Long apply(final Materia it) {
        Long _id = it.getId();
        return Long.valueOf((-(_id).longValue()));
      }
    };
    List<Materia> _sortBy = IterableExtensions.<Materia, Long>sortBy(this.materias, _function);
    List<Materia> _list = IterableExtensions.<Materia>toList(_sortBy);
    Materia _get = _list.get(0);
    Long _id = _get.getId();
    return _id.intValue();
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
    final Function1<Materia, Boolean> _function = new Function1<Materia, Boolean>() {
      public Boolean apply(final Materia materia) {
        Long _id = materia.getId();
        return Boolean.valueOf(_id.equals(id));
      }
    };
    return IterableExtensions.<Materia>findFirst(this.materias, _function);
  }
  
  public List<Materia> getMaterias(final Materia materiaBusqueda) {
    final Function1<Materia, Boolean> _function = new Function1<Materia, Boolean>() {
      public Boolean apply(final Materia materia) {
        return Boolean.valueOf(materia.matchea(materiaBusqueda));
      }
    };
    Iterable<Materia> _filter = IterableExtensions.<Materia>filter(this.materias, _function);
    List<Materia> _list = IterableExtensions.<Materia>toList(_filter);
    final Function1<Materia, Materia> _function_1 = new Function1<Materia, Materia>() {
      public Materia apply(final Materia it) {
        return it.copy();
      }
    };
    return ListExtensions.<Materia, Materia>map(_list, _function_1);
  }
}
