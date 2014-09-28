package futbol5.auxUtils;

import calificaciones.Calificacion;
import futbol5.domain.Jugador;
import infracciones.Infraccion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Exceptions;

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
        int _handicapRandom = InicializadorJugador.handicapRandom();
        ArrayList<Jugador> _listaAmigos = InicializadorJugador.listaAmigos(8);
        int _nRan = InicializadorJugador.nRan(2, 9);
        ArrayList<Calificacion> _listaCalificaciones = InicializadorJugador.listaCalificaciones(_nRan);
        int _nRan_1 = InicializadorJugador.nRan(2, 6);
        Jugador _jugador = new Jugador(_nombreRandom, _apodoRandom, 21, _fechaRandom, _handicapRandom, _listaAmigos, _listaCalificaciones, _nRan_1);
        jugadores.add(_jugador);
        Jugador _get = jugadores.get(a);
        InicializadorJugador.crearListaNotificacioens(_get);
        a = (a + 1);
      }
      _while = (a < max);
    }
    return jugadores;
  }
  
  public static void crearListaNotificacioens(final Jugador jugador) {
    try {
      int a = 0;
      SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      String[] arrayFechas = { "12/11/2013 13:00:20", "12/02/2014 15:21:29", "12/09/2014 09:07:59", "18/12/2013 12:00:09", "09/01/2014 19:32:16", "24/11/2013 21:08:20" };
      String[] arrayMotivos = { "Agresivo", "Tramposo", "Insulto a un compañero", "Golpeo a un compañero", "Llego tarde", "Ausente - Sin aviso", "Ausente - Con aviso" };
      boolean _while = (a < 5);
      while (_while) {
        {
          int _nRan = InicializadorJugador.nRan(0, 7);
          String unMotivo = arrayMotivos[_nRan];
          int _nRan_1 = InicializadorJugador.nRan(0, 6);
          String _get = arrayFechas[_nRan_1];
          Date unaFecha = formateador.parse(_get);
          Infraccion _infraccion = new Infraccion(unMotivo, unaFecha);
          jugador.agregarInfraccion(_infraccion);
          a = (a + 1);
        }
        _while = (a < 5);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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
      String[] arrayApodos = { "Carolinita", "Estabnquito", "Saeta", "Hacha", "Durex", "El Mago", "El messi", "Fantasma", "Sanguche", "Sin piernas", "Tronco", "Estaca", "El 10", "Correcaminos", "Saca corchos", "Barriga", "Colorado", "Negro" };
      int _nRan = InicializadorJugador.nRan(0, 18);
      _xblockexpression = arrayApodos[_nRan];
    }
    return _xblockexpression;
  }
  
  public static String fechaRandom() {
    String _xblockexpression = null;
    {
      String[] arrayFechas = { "09-01-1991", "09-01-1993", "09-01-1999", "09-01-2000", "09-01-2003", "09-01-1997", "09-01-1987", "09-01-2006", "09-01-2007", "09-01-2009" };
      int _nRan = InicializadorJugador.nRan(0, 10);
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
  
  public static int handicapRandom() {
    return InicializadorJugador.nRan(1, 10);
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
