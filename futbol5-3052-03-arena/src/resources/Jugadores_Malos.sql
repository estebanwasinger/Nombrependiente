create view jugadores_malos as
	select * from nombrependiente.jugadores where Handicap <= 5;