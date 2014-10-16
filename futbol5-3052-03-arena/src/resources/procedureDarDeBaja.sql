DROP PROCEDURE IF EXISTS DarDeBaja;
DELIMITER //
CREATE procedure DarDeBaja(P_Id_Jugador int, P_Id_Partido int)
BEGIN
DELETE FROM nombrependiente.Inscripciones WHERE Id_Jugador = P_Id_Jugador and Id_Partido = P_Id_Partido;
END//
