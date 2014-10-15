use nombrependiente;

INSERT INTO TiposInscripcion
(PRIORIDAD, DESCRIPCION)
VALUES (1, 'Estandar');

INSERT INTO TiposInscripcion
(PRIORIDAD, DESCRIPCION)
VALUES (2, 'Solidario');

INSERT INTO TiposInscripcion
(PRIORIDAD, DESCRIPCION)
VALUES (3, 'Condicional');



SELECT ID_TIPO_INSCRIPCION
  INTO @Tipoinscripcion1
  FROM TiposInscripcion
 WHERE PRIORIDAD = 1
 LIMIT 1;

SELECT ID_TIPO_INSCRIPCION
  INTO @Tipoinscripcion2
  FROM TiposInscripcion
 WHERE PRIORIDAD = 2
 LIMIT 1;

 SELECT ID_TIPO_INSCRIPCION
  INTO @Tipoinscripcion3
  FROM TiposInscripcion
 WHERE PRIORIDAD = 3
 LIMIT 1;



INSERT INTO Jugadores
(NOMBRE, APODO, HANDICAP, EDAD, FECHA_NACIMIENTO, ID_TIPO_INSCRIPCION_DEFAULT)
VALUES ('Paula', 'Pau', 3, 24, '1990-08-27', @Tipoinscripcion1);

INSERT INTO Jugadores
(NOMBRE, APODO, HANDICAP, EDAD, FECHA_NACIMIENTO, ID_TIPO_INSCRIPCION_DEFAULT)
VALUES ('Esteban', 'Estebanquito', 4, 22, '1992-08-27', @Tipoinscripcion2);

INSERT INTO Jugadores
(NOMBRE, APODO, HANDICAP, EDAD, FECHA_NACIMIENTO, ID_TIPO_INSCRIPCION_DEFAULT)
VALUES ('Carolina', 'Caro', 7, 26, '1998-08-27', @Tipoinscripcion2);

INSERT INTO Jugadores
(NOMBRE, APODO, HANDICAP, EDAD, FECHA_NACIMIENTO, ID_TIPO_INSCRIPCION_DEFAULT)
VALUES ('Fernando', 'Fer', 8, 28, '1986-01-01', @Tipoinscripcion3);

INSERT INTO Jugadores
(NOMBRE, APODO, HANDICAP, EDAD, FECHA_NACIMIENTO, ID_TIPO_INSCRIPCION_DEFAULT)
VALUES ('Amigo1', 'Amiguito1', 1, 30, '1984-06-12', @Tipoinscripcion2);

INSERT INTO Jugadores
(NOMBRE, APODO, HANDICAP, EDAD, FECHA_NACIMIENTO, ID_TIPO_INSCRIPCION_DEFAULT)
VALUES ('Amigo2', 'Amiguito2', 6, 32, '1982-08-27', @Tipoinscripcion3);



 SELECT ID_JUGADOR
  INTO @Jugador1
  FROM Jugadores
 WHERE nombre = 'Paula'
 LIMIT 1;

 SELECT ID_JUGADOR
  INTO @Amigo1
  FROM Jugadores
 WHERE nombre = 'Carolina'
 LIMIT 1;

  SELECT ID_JUGADOR
  INTO @Amigo2
  FROM Jugadores
 WHERE nombre = 'Esteban'
 LIMIT 1;



INSERT INTO Amigos
(ID_JUGADOR, ID_AMIGO)
VALUES(@Jugador1, @Amigo1);

INSERT INTO Amigos
(ID_JUGADOR, ID_AMIGO)
VALUES(@Jugador1, @Amigo2);



INSERT INTO Partidos
(LOCALIDAD, CONFIRMADO)
VALUES('Berazategui', TRUE);

INSERT INTO Partidos
(LOCALIDAD, CONFIRMADO)
VALUES('Capital Federal', TRUE);

INSERT INTO Partidos
(LOCALIDAD, CONFIRMADO)
VALUES('San Martin', FALSE);

INSERT INTO Partidos
(LOCALIDAD, CONFIRMADO)
VALUES('Zarate', FALSE);



  SELECT ID_PARTIDO
  INTO @Partido1
  FROM Partidos
 WHERE LOCALIDAD = 'Berazategui'
 LIMIT 1;

   SELECT ID_PARTIDO
  INTO @Partido2
  FROM Partidos
 WHERE LOCALIDAD = 'Capital Federal'
 LIMIT 1;

   SELECT ID_PARTIDO
  INTO @Partido3
  FROM Partidos
 WHERE LOCALIDAD = 'San Martin'
 LIMIT 1;

   SELECT ID_PARTIDO
  INTO @Partido4
  FROM Partidos
 WHERE LOCALIDAD = 'Zarate'
 LIMIT 1;



    SELECT ID_TIPO_INSCRIPCION_DEFAULT
  INTO @Inscripjugador
  FROM Jugadores
 WHERE ID_JUGADOR = @Jugador1
 LIMIT 1;

    SELECT ID_TIPO_INSCRIPCION_DEFAULT
  INTO @Inscripamigo1
  FROM Jugadores
 WHERE ID_JUGADOR = @Amigo1
 LIMIT 1;

     SELECT ID_TIPO_INSCRIPCION_DEFAULT
  INTO @Inscripamigo2
  FROM Jugadores
 WHERE ID_JUGADOR = @Amigo1
 LIMIT 1;



INSERT INTO Inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Jugador1, @Partido1, @Inscripjugador);

INSERT INTO Inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Jugador1, @Partido2, @Inscripjugador);

INSERT INTO Inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Jugador1, @Partido4, @Inscripjugador);

INSERT INTO Inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Amigo1, @Partido1, @Inscripamigo1);

INSERT INTO Inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Amigo1, @Partido2, @Inscripamigo1);

INSERT INTO Inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Amigo1, @Partido3, @Inscripamigo1);

INSERT INTO Inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Amigo2, @Partido3,  @Inscripamigo2);

INSERT INTO Inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Amigo2, @Partido1,  @Inscripamigo2);



INSERT INTO Bajas
(ID_JUGADOR, ID_PARTIDO, ID_REEMPLAZO)
VALUES(@Jugador1, @Partido2,  @Amigo2);

INSERT INTO Bajas
(ID_JUGADOR, ID_PARTIDO)
VALUES(@Jugador1, @Partido4);



INSERT INTO Infracciones
(ID_JUGADOR, FECHA, MOTIVO)
VALUES(@Jugador1, '2014-08-03','Pateo a un compañero');

INSERT INTO Infracciones
(ID_JUGADOR, FECHA, MOTIVO)
VALUES(@Jugador1, '2014-08-02','Falto al partido');

INSERT INTO Infracciones
(ID_JUGADOR, FECHA, MOTIVO)
VALUES(@Jugador1, '2014-08-01','Ingreso a la cancha sin remera');

INSERT INTO Infracciones
(ID_JUGADOR, FECHA, MOTIVO)
VALUES(@Amigo1, '2014-08-02','Insulto al arbitro');



INSERT INTO Calificaciones
(ID_JUGADOR,ID_PARTIDO, NOTA, CRITICA)
VALUES(@Jugador1, @Partido1, 3, 'Jugo muy flojito');

INSERT INTO Calificaciones
(ID_JUGADOR,ID_PARTIDO, NOTA, CRITICA)
VALUES(@Amigo1, @Partido2, 10, 'Excelentisimo');
