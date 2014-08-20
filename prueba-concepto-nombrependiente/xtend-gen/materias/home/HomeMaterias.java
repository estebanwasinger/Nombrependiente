package materias.home;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import materias.domain.Materia;
import materias.domain.Nota;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class HomeMaterias extends CollectionBasedHome<Materia> {
  public HomeMaterias() {
    this.init();
  }
  
  public void init() {
    ArrayList<Nota> notasAM = new ArrayList<Nota>();
    Nota notaParcial = new Nota();
    final Procedure1<Nota> _function = new Procedure1<Nota>() {
      public void apply(final Nota it) {
        it.setDescripcion("Parcial");
        it.setFecha("20/12/2014");
        it.setAprobado(Boolean.valueOf(true));
        it.setNombreMateria("Analisis Matematico I");
      }
    };
    ObjectExtensions.<Nota>operator_doubleArrow(notaParcial, _function);
    Nota notaTP = new Nota();
    final Procedure1<Nota> _function_1 = new Procedure1<Nota>() {
      public void apply(final Nota it) {
        it.setDescripcion("TP");
        it.setFecha("20/11/2014");
        it.setAprobado(Boolean.valueOf(true));
        it.setNombreMateria("Analisis Matematico I");
      }
    };
    ObjectExtensions.<Nota>operator_doubleArrow(notaTP, _function_1);
    notasAM.add(notaParcial);
    notasAM.add(notaTP);
    ArrayList<Nota> notasAYED = new ArrayList<Nota>();
    Nota notaParcial1 = new Nota();
    final Procedure1<Nota> _function_2 = new Procedure1<Nota>() {
      public void apply(final Nota it) {
        it.setDescripcion("Parcial 2");
        it.setFecha("20/12/2013");
        it.setAprobado(Boolean.valueOf(true));
        it.setNombreMateria("Algoritmos");
      }
    };
    ObjectExtensions.<Nota>operator_doubleArrow(notaParcial1, _function_2);
    notasAYED.add(notaParcial1);
    ArrayList<Nota> notasADS = new ArrayList<Nota>();
    Nota notaParcial2 = new Nota();
    final Procedure1<Nota> _function_3 = new Procedure1<Nota>() {
      public void apply(final Nota it) {
        it.setDescripcion("Parcial");
        it.setFecha("12/08/2012");
        it.setAprobado(Boolean.valueOf(true));
        it.setNombreMateria("Analisis de Sistemas");
      }
    };
    ObjectExtensions.<Nota>operator_doubleArrow(notaParcial2, _function_3);
    notasADS.add(notaParcial2);
    ArrayList<Nota> notasDDS = new ArrayList<Nota>();
    Nota notaTP2 = new Nota();
    final Procedure1<Nota> _function_4 = new Procedure1<Nota>() {
      public void apply(final Nota it) {
        it.setDescripcion("TP");
        it.setFecha("01/06/2012");
        it.setAprobado(Boolean.valueOf(true));
        it.setNombreMateria("Diseño de Sistemas");
      }
    };
    ObjectExtensions.<Nota>operator_doubleArrow(notaTP2, _function_4);
    notasDDS.add(notaTP2);
    ArrayList<Nota> notasSO = new ArrayList<Nota>();
    Nota notaTP3 = new Nota();
    final Procedure1<Nota> _function_5 = new Procedure1<Nota>() {
      public void apply(final Nota it) {
        it.setDescripcion("TP");
        it.setFecha("01/05/2014");
        it.setAprobado(Boolean.valueOf(true));
        it.setNombreMateria("Sistemas Operativos");
      }
    };
    ObjectExtensions.<Nota>operator_doubleArrow(notaTP3, _function_5);
    notasSO.add(notaTP3);
    this.create("Analisis Matematico I", "2011", false, "Cafferata", "Nivel 1 - Anual", notasAM);
    this.create("Algoritmos", "2011", true, "Bruno", "Nivel 1 - 1er. Cuatrimestre", notasAYED);
    this.create("Analisis de Sistemas", "2012", true, "Garbarini", "Nivel 2 - Anual", notasADS);
    this.create("Diseño de Sistemas", "2013", false, "Dodino", "Nivel 3 - 1er. Cuatrimestre", notasDDS);
    this.create("Sistemas Operativos", "2012", true, "Bruno", "Nivel 3 - 2do. Cuatrimestre", notasSO);
  }
  
  public void create(final String nombre, final String anioCursada, final boolean finalAprobado, final String profesor, final String ubicacion, final List<Nota> notas) {
    Materia materia = new Materia();
    materia.setNombre(nombre);
    materia.setFinalAprobado(Boolean.valueOf(finalAprobado));
    materia.setAnioCursada(anioCursada);
    materia.setProfesor(profesor);
    materia.setUbicacion(ubicacion);
    materia.setNotas(notas);
    this.create(materia);
  }
  
  public void validateCreate(final Materia materia) {
    materia.validarNombre();
    this.validarMateriasDuplicadas(materia);
  }
  
  public void validarMateriasDuplicadas(final Materia materia) {
    final String nombre = materia.getNombre();
    List<Materia> _search = this.search(nombre);
    boolean _isEmpty = _search.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      throw new UserException(("Ya existe una materia con el nombre " + nombre));
    }
  }
  
  public List<Materia> getMaterias() {
    return this.allInstances();
  }
  
  public List<Materia> search(final String nombre) {
    List<Materia> _allInstances = this.allInstances();
    final Function1<Materia,Boolean> _function = new Function1<Materia,Boolean>() {
      public Boolean apply(final Materia materia) {
        String _nombre = materia.getNombre();
        return Boolean.valueOf(HomeMaterias.this.match(nombre, _nombre));
      }
    };
    Iterable<Materia> _filter = IterableExtensions.<Materia>filter(_allInstances, _function);
    return IterableExtensions.<Materia>toList(_filter);
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
  
  public Class<Materia> getEntityType() {
    return Materia.class;
  }
  
  public Materia createExample() {
    return new Materia();
  }
  
  public Predicate getCriterio(final Materia example) {
    return null;
  }
}
