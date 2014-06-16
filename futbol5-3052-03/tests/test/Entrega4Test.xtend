package test

import futbol5.Jugador
import futbol5.Partido
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import excepciones.BusinessException
import futbol5.Sistema
import comandos.CriterioHandicap
import java.util.LinkedList
import java.util.List

class Entrega4Test {
	
	Jugador jugador1
	Jugador jugador2
	Jugador jugador3
	Jugador jugador4
	Jugador jugador5
	Jugador jugador6
	Jugador jugador7
	Jugador jugador8
	Jugador jugador9
	Jugador jugador10
	Partido partido
	CriterioHandicap handicap
	
	
@Before
	def void setUP() {
	jugador1 = new Jugador;
	jugador2 = new Jugador;	
	jugador3 = new Jugador;
	jugador4 = new Jugador;
	jugador5 = new Jugador;
	jugador6 = new Jugador;
	jugador7 = new Jugador;
	jugador8 = new Jugador;
	jugador9 = new Jugador;
	jugador10 = new Jugador;

	jugador1.nivelDeJuego = 5;
	jugador2.nivelDeJuego = 9;	
	jugador3.nivelDeJuego = 10;
	jugador4.nivelDeJuego = 7; 
	jugador5.nivelDeJuego = 8; 
	jugador6.nivelDeJuego =6;
	jugador7.nivelDeJuego = 7;
	jugador8.nivelDeJuego = 4;
	jugador9.nivelDeJuego = 8;
	jugador10.nivelDeJuego = 3;

	partido = new Partido("CABA");
	
	handicap = new CriterioHandicap;
	
	partido.inscribir(jugador1);
	partido.inscribir(jugador2);
	partido.inscribir(jugador3);
	partido.inscribir(jugador4);
	partido.inscribir(jugador5);
	partido.inscribir(jugador6);
	partido.inscribir(jugador7);
	partido.inscribir(jugador8);
	partido.inscribir(jugador9);
	partido.inscribir(jugador10);
	
	}


@Test
def void testPartidoOrdenaPorHandicap(){
	
	partido.ordenarJugadores(handicap);
	partido.jugadoresOrdenados.forEach[jugador | println(jugador.nivelDeJuego)];

	}
}



