package materias.applicationModel;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import materias.domain.Materia;
import materias.domain.Nota;
import materias.home.HomeMaterias;
import materias.home.HomeNotas;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class SeguidorCarrera implements Serializable {
  private Integer _numero;
  
  public Integer getNumero() {
    return this._numero;
  }
  
  public void setNumero(final Integer numero) {
    this._numero = numero;
  }
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private List<Materia> _resultados;
  
  public List<Materia> getResultados() {
    return this._resultados;
  }
  
  public void setResultados(final List<Materia> resultados) {
    this._resultados = resultados;
  }
  
  private List<Nota> _notas;
  
  public List<Nota> getNotas() {
    return this._notas;
  }
  
  public void setNotas(final List<Nota> notas) {
    this._notas = notas;
  }
  
  private Materia _materiaSeleccionada;
  
  public Materia getMateriaSeleccionada() {
    return this._materiaSeleccionada;
  }
  
  public void setMateriaSeleccionada(final Materia materiaSeleccionada) {
    this._materiaSeleccionada = materiaSeleccionada;
  }
  
  private Nota _notaSeleccionada;
  
  public Nota getNotaSeleccionada() {
    return this._notaSeleccionada;
  }
  
  public void setNotaSeleccionada(final Nota notaSeleccionada) {
    this._notaSeleccionada = notaSeleccionada;
  }
  
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
  
  public HomeNotas getHomeNotas() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeNotas>getSingleton(Nota.class);
  }
}
