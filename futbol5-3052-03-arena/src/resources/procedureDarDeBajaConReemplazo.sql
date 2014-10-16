DROP PROCEDURE IF EXISTS DarDeBajaConReemplazo;
DELIMITER //
CREATE procedure DarDeBajaConReemplazo(P_Id_Jugador int, P_Id_Partido int, P_Id_Jugador_Reemplazante int)
BEGIN
call DarDeBaja(P_Id_Jugador,P_Id_Partido);
INSERT INTO nombrependiente.Bajas 
(ID_JUGADOR, ID_PARTIDO)
VALUES(P_Id_Jugador, P_Id_Partido);

CASE when P_Id_Jugador_Reemplazante is NULL then 
begin 
INSERT INTO nombrependiente.Infracciones
(Id_Jugador, Fecha, Motivo)
VALUES(P_Id_Jugador,CURDATE(),"Baja sin reemplazo");
end;
end case; 
END//
+