CREATE DEFINER=`root`@`localhost` PROCEDURE `Jugadores_Malos`()
BEGIN
	select * from nombrependiente.jugadores where Handicap <= 5;
END