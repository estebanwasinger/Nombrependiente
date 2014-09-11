package materias.applicationModel;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import materias.domain.Materia;
import materias.domain.Nota;
import materias.home.HomeMaterias;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class SeguidorCarrera implements Serializable {
  @Property
  private Integer _numero;
  
  @Property
  private String _nombre;
  
  @Property
  private List<Materia> _resultados;
  
  @Property
  private List<Nota> _notas;
  
  @Property
  private Materia _materiaSeleccionada;
  
  @Property
  private Nota _notaSeleccionada;
  
  public void search() {
    ArrayList<Materia> _arrayList = new ArrayList<Materia>();
    this.setResultados(_arrayList);
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    String _nombre = this.getNombre();
    List<Materia> _search = _homeMaterias.search(_nombre);
    this.setResultados(_search);
  }
  
  public void buscar() {
    ArrayList<Nota> _arrayList = new ArrayList<Nota>();
    this.setNotas(_arrayList);
    Materia _materiaSeleccionada = this.getMateriaSeleccionada();
    boolean _notEquals = (!Objects.equal(_materiaSeleccionada, null));
    if (_notEquals) {
      Materia _materiaSeleccionada_1 = this.getMateriaSeleccionada();
      List<Nota> _notas = _materiaSeleccionada_1.getNotas();
      this.setNotas(_notas);
    }
  }
  
  public void clear() {
    this.setNombre(null);
  }
  
  public HomeMaterias getHomeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeMaterias>getSingleton(Materia.class);
  }
  
  @Pure
  public Integer getNumero() {
    return this._numero;
  }
  
  public void setNumero(final Integer numero) {
    this._numero = numero;
  }
  
  @Pure
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  @Pure
  public List<Materia> getResultados() {
    return this._resultados;
  }
  
  public void setResultados(final List<Materia> resultados) {
    this._resultados = resultados;
  }
  
  @Pure
  public List<Nota> getNotas() {
    return this._notas;
  }
  
  public void setNotas(final List<Nota> notas) {
    this._notas = notas;
  }
  
  @Pure
  public Materia getMateriaSeleccionada() {
    return this._materiaSeleccionada;
  }
  
  public void setMateriaSeleccionada(final Materia materiaSeleccionada) {
    this._materiaSeleccionada = materiaSeleccionada;
  }
  
  @Pure
  public Nota getNotaSeleccionada() {
    return this._notaSeleccionada;
  }
  
  public void setNotaSeleccionada(final Nota notaSeleccionada) {
    this._notaSeleccionada = notaSeleccionada;
  }
}
