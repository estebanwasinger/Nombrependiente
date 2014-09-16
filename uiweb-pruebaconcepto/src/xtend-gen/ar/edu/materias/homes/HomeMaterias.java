package ar.edu.materias.homes;

import ar.edu.materias.domain.Materia;
import java.util.List;

@SuppressWarnings("all")
public interface HomeMaterias {
  public abstract void agregarMateria(final Materia materia);
  
  public abstract void actualizarMateria(final Materia materia);
  
  public abstract void eliminarMateria(final Materia materia);
  
  public abstract Materia getMateria(final Long id);
  
  public abstract List<Materia> getMaterias(final Materia materiaBusqueda);
}
