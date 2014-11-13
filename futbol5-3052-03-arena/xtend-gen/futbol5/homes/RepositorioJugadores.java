package futbol5.homes;

import calificaciones.Calificacion;
import com.google.common.base.Objects;
import futbol5.domain.Jugador;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.utils.Observable;
import uqbar.arena.persistence.PersistentHome;

@Observable
@SuppressWarnings("all")
public class RepositorioJugadores extends PersistentHome<Jugador> {
  public RepositorioJugadores() {
    this.init();
  }
  
  public void init() {
    ArrayList<Calificacion> _arrayList = new ArrayList<Calificacion>();
    this.createIfNotExists(Integer.valueOf(1), "Esteban", "El champ", 5, _arrayList);
    ArrayList<Calificacion> _arrayList_1 = new ArrayList<Calificacion>();
    this.createIfNotExists(Integer.valueOf(2), "Carolina", "Caro", 8, _arrayList_1);
    ArrayList<Calificacion> _arrayList_2 = new ArrayList<Calificacion>();
    this.createIfNotExists(Integer.valueOf(3), "Paula", "Pau", 2, _arrayList_2);
    ArrayList<Calificacion> _arrayList_3 = new ArrayList<Calificacion>();
    this.createIfNotExists(Integer.valueOf(4), "Juan", "Fantasma", 1, _arrayList_3);
    ArrayList<Calificacion> _arrayList_4 = new ArrayList<Calificacion>();
    this.createIfNotExists(Integer.valueOf(5), "Alejandro", "Ale", 9, _arrayList_4);
    ArrayList<Calificacion> _arrayList_5 = new ArrayList<Calificacion>();
    this.createIfNotExists(Integer.valueOf(6), "Juan", "L", 1, _arrayList_5);
    ArrayList<Calificacion> _arrayList_6 = new ArrayList<Calificacion>();
    this.createIfNotExists(Integer.valueOf(7), "Alejandro", "Pepep", 9, _arrayList_6);
    ArrayList<Calificacion> _arrayList_7 = new ArrayList<Calificacion>();
    this.createIfNotExists(Integer.valueOf(8), "Pedro", "El loco", 1, _arrayList_7);
    ArrayList<Calificacion> _arrayList_8 = new ArrayList<Calificacion>();
    this.createIfNotExists(Integer.valueOf(9), "Maria", "La Mary", 9, _arrayList_8);
    ArrayList<Calificacion> _arrayList_9 = new ArrayList<Calificacion>();
    this.createIfNotExists(Integer.valueOf(10), "Alberto", "Perro", 1, _arrayList_9);
    ArrayList<Calificacion> _arrayList_10 = new ArrayList<Calificacion>();
    this.createIfNotExists(Integer.valueOf(11), "Santiago", "Santi", 9, _arrayList_10);
    ArrayList<Calificacion> _arrayList_11 = new ArrayList<Calificacion>();
    this.createIfNotExists(Integer.valueOf(12), "Florencia", "Florcita", 1, _arrayList_11);
    ArrayList<Calificacion> _arrayList_12 = new ArrayList<Calificacion>();
    this.createIfNotExists(Integer.valueOf(13), "Martin", "Tin", 9, _arrayList_12);
  }
  
  public Jugador createIfNotExists(final Integer idJ, final String nombreJ, final String apodoJ, final float nivelDeJuegoJ, final ArrayList<Calificacion> calificacionesJ) {
    Jugador _xblockexpression = null;
    {
      InputOutput.<String>println(("Creando si no existe jugador con id: " + idJ));
      Jugador jugador = new Jugador(idJ, nombreJ, apodoJ, nivelDeJuegoJ, calificacionesJ);
      Jugador jugadorDB = this.get(idJ);
      boolean _equals = Objects.equal(jugadorDB, null);
      if (_equals) {
        this.create(jugador);
        jugadorDB = jugador;
        InputOutput.<String>println((("Jugador con id " + idJ) + " fue creado"));
      } else {
        InputOutput.<String>println("Jugador ya existente");
      }
      _xblockexpression = jugadorDB;
    }
    return _xblockexpression;
  }
  
  public List<Jugador> getJugadores() {
    return this.allInstances();
  }
  
  public Jugador get(final Integer id) {
    List<Jugador> _allInstances = this.allInstances();
    for (final Jugador jugadorDB : _allInstances) {
      Integer _id = jugadorDB.getId();
      boolean _equals = _id.equals(id);
      if (_equals) {
        return jugadorDB;
      }
    }
    return null;
  }
  
  public List<Jugador> search(final Integer unId) {
    Jugador _jugador = new Jugador();
    final Procedure1<Jugador> _function = new Procedure1<Jugador>() {
      public void apply(final Jugador it) {
        it.setId(unId);
      }
    };
    Jugador _doubleArrow = ObjectExtensions.<Jugador>operator_doubleArrow(_jugador, _function);
    return this.searchByExample(_doubleArrow);
  }
  
  public Class<Jugador> getEntityType() {
    return Jugador.class;
  }
  
  public Jugador createExample() {
    return new Jugador();
  }
}
