DROP FUNCTION IF EXISTS infraccionesUltimoMes;
DELIMITER //
CREATE FUNCTION infraccionesUltimoMes(P_Id_Jugador int)
RETURNS INT
BEGIN
RETURN (SELECT COUNT(*) FROM Infracciones where Id_Jugador = P_Id_Jugador and (DATEDIFF(CURDATE(),Fecha)) < 30);
END//
