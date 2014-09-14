package test

import commands.AlgoritmoImparPar
import commands.AlgoritmoLoco
import commands.CriterioCalifiUltimoPartido
import commands.CriterioHandicap
import commands.CriterioMix
import commands.CriterioNCalificaciones
import commands.CriteriosCommand
import excepciones.BusinessException
import futbol5.domain.Jugador
import futbol5.domain.Partido
import java.util.ArrayList
import java.util.List
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class Entrega4Test {
	Jugador jugador1
	Jugador jugadorEstrella
	Jugador jugadorCalificado
	Partido partido
	Partido partido2
	Partido partido3
	CriterioHandicap handicap
	AlgoritmoImparPar algoritmoImparPar
	AlgoritmoLoco algoritmoLoco
	CriterioCalifiUltimoPartido criterioCalificacionUltimoPartido
	CriterioNCalificaciones criterioNCalificaciones
	Jugador jugadorQueso

	@Before def void setUP() {
		jugador1 = new Jugador
		partido = new Partido("CABA")
		handicap = new CriterioHandicap
		partido2 = new Partido("CABA")
		partido3 = new Partido("Burzaco")
		algoritmoImparPar = new AlgoritmoImparPar
		algoritmoLoco = new AlgoritmoLoco
		criterioCalificacionUltimoPartido = new CriterioCalifiUltimoPartido
		criterioNCalificaciones = new CriterioNCalificaciones(3)
	}

	def armarPartido(int max, Partido partido) {
		var int a = 0
		var int mail = 0
		while (a < max) {
			jugadorCalificado = new Jugador
			jugadorCalificado.email = mail.toString
			jugadorCalificado.nivelDeJuego = 7
			partido.inscribir(jugadorCalificado)
			jugadorCalificado.calificar(partido, 8, "muy bueno")
			a = a + 1
			mail = mail + 1
		}
	}

	def armarPartido2(int max, Partido partido) {
		var int a = 0
		while (a < max) {
			partido.inscribir(new Jugador)
			a = a + 1
		}
	}

	@Test
	def void testPartidoOrdenaPorHandicap() {
		armarPartido(9, partido)
		partido.inscribir(jugador1)
		jugador1.nivelDeJuego = 1
		partido.ordenarJugadores(handicap)
		Assert.assertEquals(jugador1, partido.jugadoresOrdenados.head)
	}

	@Test(expected=typeof(BusinessException))
	def void testPartidoOrdenaPorHandicapExcepcion() {
		jugadorCalificado = new Jugador
		jugadorCalificado.nivelDeJuego = 0
		partido.inscribir(jugadorCalificado)
		partido.ordenarJugadores(handicap)

	}

	@Test
	def void testPartidoMixDeCriterios() {
		armarPartido(9, partido2)
		jugadorEstrella = new Jugador
		partido2.inscribir(jugadorEstrella)
		jugadorEstrella.calificar(partido2, 10, "excelente")
		jugadorEstrella.nivelDeJuego = 10
		armarPartido(9, partido)
		partido.inscribir(jugadorEstrella)
		var List<CriteriosCommand> criterios = new ArrayList()
		criterios.add(handicap)
		criterios.add(criterioCalificacionUltimoPartido)
		partido.ordenarJugadores(new CriterioMix(criterios))
		partido.jugadoresOrdenados.forEach[jugador|println(jugador.nivelDeJuego)]
	}

	@Test(expected=typeof(BusinessException))
	def void testOrdenarJugadoresMenoresADiez() {
		armarPartido(9, partido2)
		partido2.ordenarJugadores(handicap)

	}

	@Test
	def void testDividirGrupo() {
		armarPartido(10, partido2)
		partido2.ordenarJugadores(handicap)
		partido2.dividirEquipos(algoritmoImparPar)
		Assert.assertEquals(5, partido2.equipoA.size)
		Assert.assertEquals(5, partido2.equipoB.size)
		Assert.assertEquals(partido2.jugadoresOrdenados.get(0), partido2.equipoB.get(0))
		Assert.assertEquals(partido2.jugadoresOrdenados.get(1), partido2.equipoA.get(0))
		Assert.assertEquals(partido2.jugadoresOrdenados.get(2), partido2.equipoB.get(1))
		Assert.assertEquals(partido2.jugadoresOrdenados.get(3), partido2.equipoA.get(1))
		Assert.assertEquals(partido2.jugadoresOrdenados.get(4), partido2.equipoB.get(2))
		Assert.assertEquals(partido2.jugadoresOrdenados.get(5), partido2.equipoA.get(2))
		Assert.assertEquals(partido2.jugadoresOrdenados.get(6), partido2.equipoB.get(3))
		Assert.assertEquals(partido2.jugadoresOrdenados.get(7), partido2.equipoA.get(3))
		Assert.assertEquals(partido2.jugadoresOrdenados.get(8), partido2.equipoB.get(4))
		Assert.assertEquals(partido2.jugadoresOrdenados.get(9), partido2.equipoA.get(4))
	}

	@Test
	def void testDividirGrupoCasoLoco() {
		armarPartido(10, partido3)
		partido3.ordenarJugadores(criterioCalificacionUltimoPartido)
		partido3.dividirEquipos(algoritmoLoco)
		Assert.assertEquals(5, partido3.equipoA.size)
		Assert.assertEquals(5, partido3.equipoB.size)
	}

	@Test(expected=typeof(BusinessException))
	def void testDividirGrupoMenor10() {
		armarPartido(9, partido2)
		partido2.dividirEquipos(algoritmoImparPar)
	}

	@Test(expected=typeof(BusinessException))
	def void testDividirGrupoMenor10CasoLoco() {
		armarPartido(9, partido2)
		partido2.dividirEquipos(algoritmoLoco)
	}

	@Test
	def void testOrdenarJugadoresPorUltimoPromedio() {
		armarPartido(8, partido2)
		jugadorEstrella = new Jugador()
		partido2.inscribir(jugadorEstrella)
		jugadorEstrella.calificar(partido2, 10, "excelente!")

		jugadorQueso = new Jugador
		partido2.inscribir(jugadorQueso)
		jugadorQueso.calificar(partido2, 0, "malisimo")
		partido2.ordenarJugadores(criterioCalificacionUltimoPartido)
		Assert.assertEquals(jugadorEstrella, partido2.jugadoresOrdenados.last)
		Assert.assertEquals(jugadorQueso, partido2.jugadoresOrdenados.head)
	}

	@Test
	def void testOrdenarJugadoresPorPromedioNPartidos() {
		armarPartido(9, partido3)
		jugadorEstrella = new Jugador
		partido3.inscribir(jugadorEstrella)
		jugadorEstrella.calificar(partido3, 10, "excelente")
		partido3.ordenarJugadores(criterioNCalificaciones)
		Assert.assertEquals(jugadorEstrella, partido3.jugadoresOrdenados.last)
	}

	@Test(expected=typeof(BusinessException))
	def void testOrdenarJugadoresPorPromedioNPartidosSinCalificacion() {
		armarPartido2(10, partido3)
		partido3.ordenarJugadores(criterioNCalificaciones)
	}

	@Test(expected=typeof(BusinessException))
	def void testSeConfirmaEquipoYJugadorSeQuiereInsribir() {
		var Boolean confirmacion = true
		armarPartido(10, partido3)
		partido3.ordenarJugadores(criterioCalificacionUltimoPartido)
		partido3.dividirEquipos(algoritmoLoco)
		partido3.confirmarEquipos(confirmacion)
		partido3.inscribir(jugador1)
	}

	@Test(expected=typeof(BusinessException))
	def void testSeConfirmaEquipoYJugadorSeQuiereDarDeBaja() {
		var Boolean confirmacion = true
		armarPartido(10, partido3)
		partido3.ordenarJugadores(criterioCalificacionUltimoPartido)
		partido3.dividirEquipos(algoritmoLoco)
		partido3.confirmarEquipos(confirmacion)
		partido3.baja(jugador1, null)
	}

	@Test(expected=typeof(BusinessException))
	def void testSeConfirmaEquipoYSeQuiereOrdenarNuevamenteLaLista() {
		var Boolean confirmacion = true
		armarPartido(10, partido3)
		partido3.ordenarJugadores(criterioCalificacionUltimoPartido)
		partido3.dividirEquipos(algoritmoLoco)
		partido3.confirmarEquipos(confirmacion)
		partido3.ordenarJugadores(criterioCalificacionUltimoPartido)
	}

	@Test(expected=typeof(BusinessException))
	def void testSeConfirmaEquipoYSeQuiereDividirNuevamenteLaLista() {
		var Boolean confirmacion = true
		armarPartido(10, partido3)
		partido3.ordenarJugadores(criterioCalificacionUltimoPartido)
		partido3.dividirEquipos(algoritmoLoco)
		partido3.confirmarEquipos(confirmacion)
		partido3.dividirEquipos(algoritmoLoco)
	}

}
