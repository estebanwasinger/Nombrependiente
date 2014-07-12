package ar.edu.futbol5.ordenamiento;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.Partido;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public interface CriterioOrdenamiento {
  public abstract List<Jugador> ordenar(final Partido partido);
  
  public abstract Function1<? super Jugador, ? extends Double> calcularValor();
}
