package materias.applicationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import materias.domain.Materia;
import materias.home.HomeMaterias;
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
  
  private Materia _materiaSeleccionada;
  
  public Materia getMateriaSeleccionada() {
    return this._materiaSeleccionada;
  }
  
  public void setMateriaSeleccionada(final Materia materiaSeleccionada) {
    this._materiaSeleccionada = materiaSeleccionada;
  }
  
  public void search() {
    ArrayList<Materia> _arrayList = new ArrayList<Materia>();
    this.setResultados(_arrayList);
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    String _nombre = this.getNombre();
    List<Materia> _search = _homeMaterias.search(_nombre);
    this.setResultados(_search);
  }
  
  public void clear() {
    this.setNombre(null);
  }
  
  public void eliminarMateriaSeleccionada() {
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    Materia _materiaSeleccionada = this.getMateriaSeleccionada();
    _homeMaterias.delete(_materiaSeleccionada);
    this.search();
    this.setMateriaSeleccionada(null);
  }
  
  public HomeMaterias getHomeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeMaterias>getSingleton(Materia.class);
  }
}
