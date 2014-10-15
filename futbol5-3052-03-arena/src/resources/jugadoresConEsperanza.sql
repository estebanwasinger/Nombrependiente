create view jugadores_con_esperanza as
SELECT * from jugadores_malos where (DATEDIFF(CURDATE(),Fecha_Nacimiento)/365) < 25;