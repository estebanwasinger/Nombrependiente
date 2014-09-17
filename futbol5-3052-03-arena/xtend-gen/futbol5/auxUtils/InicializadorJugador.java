package futbol5.auxUtils;

import calificaciones.Calificacion;
import futbol5.domain.Jugador;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InicializadorJugador {
  public static ArrayList<Jugador> crearListaDejugadores(final int max) {
    ArrayList<Jugador> jugadores = null;
    int a = 0;
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    jugadores = _arrayList;
    boolean _while = (a < max);
    while (_while) {
      {
        String _nombreRandom = InicializadorJugador.nombreRandom();
        String _apodoRandom = InicializadorJugador.apodoRandom();
        String _fechaRandom = InicializadorJugador.fechaRandom();
        ArrayList<Jugador> _listaAmigos = InicializadorJugador.listaAmigos(8);
        int _nRan = InicializadorJugador.nRan(2, 9);
        ArrayList<Calificacion> _listaCalificaciones = InicializadorJugador.listaCalificaciones(_nRan);
        int _nRan_1 = InicializadorJugador.nRan(2, 6);
        Jugador _jugador = new Jugador(_nombreRandom, _apodoRandom, 21, _fechaRandom, 2, _listaAmigos, _listaCalificaciones, _nRan_1);
        jugadores.add(_jugador);
        a = (a + 1);
      }
      _while = (a < max);
    }
    return jugadores;
  }
  
  public static String nombreRandom() {
    String _xblockexpression = null;
    {
      String[] arrayNombres = { "Caro", "Esteban", "Vero", "Pau", "Jorge", "Rodrigo", "Jose", "Catalina", "Luisa", "Carlo", "Ronaldo", "Jean Carlos", "Pepe", "El Willy", "Marcos" };
      _xblockexpression = arrayNombres[(0 + ((int) (Math.random() * 10)))];
    }
    return _xblockexpression;
  }
  
  public static String apodoRandom() {
    String _xblockexpression = null;
    {
      String[] arrayApodos = { "Carolinita", "Estabnquito", "Saeta", "Hacha", "Durex", "El Mago", "El messi", "Fantasma", "Sanguche", "Sin piernas", "Correcaminos", "Saca corchos", "Barriga", "Colorado", "Negro" };
      int _nRan = InicializadorJugador.nRan(0, 15);
      _xblockexpression = arrayApodos[_nRan];
    }
    return _xblockexpression;
  }
  
  public static String fechaRandom() {
    String _xblockexpression = null;
    {
      String[] arrayFechas = { "09-01-1991", "09-01-1993", "09-01-1999", "09-01-2000", "09-01-2003", "09-01-1993" };
      int _nRan = InicializadorJugador.nRan(0, 6);
      _xblockexpression = arrayFechas[_nRan];
    }
    return _xblockexpression;
  }
  
  public static ArrayList<Jugador> listaAmigos(final int max) {
    int a = 0;
    ArrayList<Jugador> amigos = new ArrayList<Jugador>();
    boolean _while = (a < max);
    while (_while) {
      {
        String _nombreRandom = InicializadorJugador.nombreRandom();
        Jugador _jugador = new Jugador(_nombreRandom);
        amigos.add(_jugador);
        a = (a + 1);
      }
      _while = (a < max);
    }
    return amigos;
  }
  
  public static int nRan(final int min, final int max) {
    double _random = Math.random();
    double _multiply = (_random * max);
    return (min + ((int) _multiply));
  }
  
  public static ArrayList<Calificacion> listaCalificaciones(final int max) {
    int a = 0;
    ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();
    boolean _while = (a < max);
    while (_while) {
      {
        int _nRan = InicializadorJugador.nRan(1, 9);
        Calificacion _calificacion = new Calificacion(_nRan);
        calificaciones.add(_calificacion);
        a = (a + 1);
      }
      _while = (a < max);
    }
    return calificaciones;
  }
}
