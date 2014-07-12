package ar.edu.futbol5.ordenamiento;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.Partido;
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class OrdenamientoMix implements CriterioOrdenamiento {
  private List<CriterioOrdenamiento> criterios;
  
  public OrdenamientoMix() {
    ArrayList<CriterioOrdenamiento> _arrayList = new ArrayList<CriterioOrdenamiento>();
    this.criterios = _arrayList;
  }
  
  public List<Jugador> ordenar(final Partido partido) {
    List<Jugador> _inscriptos = partido.getInscriptos();
    Function1<? super Jugador, ? extends Double> _calcularValor = this.calcularValor();
    List _sortBy = IterableExtensions.<Object, Comparable>sortBy(_inscriptos, _calcularValor);
    Object[] _clone = ((Object[])Conversions.unwrapArray(_sortBy, Object.class)).clone();
    return ListExtensions.<Object>reverse(((List)Conversions.doWrapArray(_clone)));
  }
  
  public boolean addCriterio(final CriterioOrdenamiento criterio) {
    return this.criterios.add(criterio);
  }
  
  public Function1<? super Jugador, ? extends Double> calcularValor() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method calcularValor is undefined for the type OrdenamientoMix"
      + "\napply cannot be resolved");
  }
}
