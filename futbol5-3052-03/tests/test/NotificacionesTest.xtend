package test

import futbol5.Jugador
import futbol5.Partido
import inscripciones.Estandar
import org.junit.Before
import org.junit.Test
import org.junit.Assert
import static org.mockito.Matchers.*
import static org.mockito.Mockito.*
import decoradores.NotificarAmigosDecorator
import helper.StubNotificationSender
import decoradores.Son10Decorator
import decoradores.PartidoDecorator
import decoradores.YaNoSon10Decorator
import decoradores.InfraccionDecorator

class NotificacionesTest {
	Jugador jugador
	Partido partido
	StubNotificationSender notificador
	NotificarAmigosDecorator partidoConNotificarAmigosDecorator
	Son10Decorator partidoYaSon10Decorator
	YaNoSon10Decorator partidoYaNoSon10Decorator
	InfraccionDecorator jugadorConInfraccion

	@Before
	def void setUP() {
		jugador = new Jugador(new Estandar, "Jorge")
		partido = new Partido("Berazategui")
		notificador = new StubNotificationSender
		partidoConNotificarAmigosDecorator = new NotificarAmigosDecorator(partido, notificador)
		partidoYaSon10Decorator = new Son10Decorator(partido, notificador)
		partidoYaNoSon10Decorator = new YaNoSon10Decorator(partido, notificador)
		jugadorConInfraccion = new InfraccionDecorator(partido)
	}

	def agregarAmigos(int max) {
		var int a = 0
		while (a < max) {
			jugador.amigos.add(new Jugador(new Estandar, "NombreJugador"))
			a = a + 1
		}
	}

	def agregarUnAmigoConNombre(Jugador pjugador, String nombre) {
		pjugador.amigos.add(new Jugador(new Estandar, nombre))
	}

	def agregarJugadores(PartidoDecorator partidoDecorator, int cantidad) {
		var int a = 0
		while (a < cantidad) {
			partidoDecorator.inscribir(new Jugador(new Estandar, "nombreJugador"))
			a = a + 1
		}
	}

	def agregarLosAmigosDelFutbol(Jugador jugador) {
		agregarUnAmigoConNombre(jugador, "Luis")
		agregarUnAmigoConNombre(jugador, "Claudio")
		agregarUnAmigoConNombre(jugador, "Arturo")
		agregarUnAmigoConNombre(jugador, "Julio Cesar")
	}

	@Test
	def void agregar4Amigos() {
		agregarAmigos(4)
		Assert.assertEquals(4, jugador.amigos.size)
	}

	@Test
	def void mandarNotificacionesAAmigos() {
		agregarLosAmigosDelFutbol(jugador)
		partidoConNotificarAmigosDecorator.inscribir(jugador)
		Assert.assertEquals(jugador.amigos.size, notificador.notificacionsDe("Jorge").size)
	}

	@Test
	def void mandarNotificacionAdminPartidoLleno() {
		agregarJugadores(partidoYaSon10Decorator, 10)
		Assert.assertEquals(notificador.notificacionsPara("Admin").size, 1)
	}

	@Test
	def void mandarNotificacionAdminPartidoIncompleto() {
		agregarJugadores(partidoYaNoSon10Decorator, 9)
		partidoYaNoSon10Decorator.inscribir(jugador)
		partidoYaNoSon10Decorator.bajaSinReemplazo(jugador)
		Assert.assertEquals(notificador.notificacionsPara("Admin").size, 1)
	}

	@Test
	def void generarInfraccion() {
		jugadorConInfraccion.inscribir(jugador)
		jugadorConInfraccion.bajaSinReemplazo(jugador)
		Assert.assertEquals(jugador.diasDeInfraccion, 10)
	}

	@Test
	def void decoratorCombinado() {
		var partidoConNotAmigosYPartidoCompletoDecorator = new Son10Decorator(
		new NotificarAmigosDecorator(partido, notificador), notificador)
		agregarJugadores(partidoConNotAmigosYPartidoCompletoDecorator, 9)
		agregarLosAmigosDelFutbol(jugador)
		partidoConNotAmigosYPartidoCompletoDecorator.inscribir(jugador)
		Assert.assertEquals(notificador.notificacionsPara("Admin").size, 1)
		Assert.assertEquals(jugador.amigos.size, notificador.notificacionsDe("Jorge").size)
	}
}
