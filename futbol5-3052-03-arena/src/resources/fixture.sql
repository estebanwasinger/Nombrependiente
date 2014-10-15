INSERT INTO tiposinscripcion
(PRIORIDAD, DESCRIPCION)
VALUES (1, 'Estandar');

INSERT INTO tiposinscripcion
(PRIORIDAD, DESCRIPCION)
VALUES (2, 'Solidario');

INSERT INTO tiposinscripcion
(PRIORIDAD, DESCRIPCION)
VALUES (3, 'Condicional');



SELECT ID_TIPO_INSCRIPCION
  INTO @Tipoinscripcion1
  FROM tiposinscripcion
 WHERE PRIORIDAD = 1
 LIMIT 1;

SELECT ID_TIPO_INSCRIPCION
  INTO @Tipoinscripcion2
  FROM tiposinscripcion
 WHERE PRIORIDAD = 2
 LIMIT 1;

 SELECT ID_TIPO_INSCRIPCION
  INTO @Tipoinscripcion3
  FROM tiposinscripcion
 WHERE PRIORIDAD = 3
 LIMIT 1;



INSERT INTO jugadores
(NOMBRE, APODO, HANDICAP, EDAD, FECHA_NACIMIENTO, ID_TIPO_INSCRIPCION_DEFAULT)
VALUES ('Paula', 'Pau', 3, 24, '1990-08-27', @Tipoinscripcion1);

INSERT INTO jugadores
(NOMBRE, APODO, HANDICAP, EDAD, FECHA_NACIMIENTO, ID_TIPO_INSCRIPCION_DEFAULT)
VALUES ('Esteban', 'Estebanquito', 4, 22, '1992-08-27', @Tipoinscripcion2);

INSERT INTO jugadores
(NOMBRE, APODO, HANDICAP, EDAD, FECHA_NACIMIENTO, ID_TIPO_INSCRIPCION_DEFAULT)
VALUES ('Carolina', 'Caro', 7, 26, '1998-08-27', @Tipoinscripcion2);

INSERT INTO jugadores
(NOMBRE, APODO, HANDICAP, EDAD, FECHA_NACIMIENTO, ID_TIPO_INSCRIPCION_DEFAULT)
VALUES ('Fernando', 'Fer', 8, 28, '1986-01-01', @Tipoinscripcion3);

INSERT INTO jugadores
(NOMBRE, APODO, HANDICAP, EDAD, FECHA_NACIMIENTO, ID_TIPO_INSCRIPCION_DEFAULT)
VALUES ('Amigo1', 'Amiguito1', 1, 30, '1984-06-12', @Tipoinscripcion2);

INSERT INTO jugadores
(NOMBRE, APODO, HANDICAP, EDAD, FECHA_NACIMIENTO, ID_TIPO_INSCRIPCION_DEFAULT)
VALUES ('Amigo2', 'Amiguito2', 6, 32, '1982-08-27', @Tipoinscripcion3);



 SELECT ID_JUGADOR
  INTO @Jugador1
  FROM jugadores
 WHERE nombre = 'Paula'
 LIMIT 1;

 SELECT ID_JUGADOR
  INTO @Amigo1
  FROM jugadores
 WHERE nombre = 'Carolina'
 LIMIT 1;

  SELECT ID_JUGADOR
  INTO @Amigo2
  FROM jugadores
 WHERE nombre = 'Esteban'
 LIMIT 1;



INSERT INTO amigos
(ID_JUGADOR, ID_AMIGO)
VALUES(@Jugador1, @Amigo1);

INSERT INTO amigos
(ID_JUGADOR, ID_AMIGO)
VALUES(@Jugador1, @Amigo2);



INSERT INTO partidos
(LOCALIDAD, CONFIRMADO)
VALUES('Berazategui', TRUE);

INSERT INTO partidos
(LOCALIDAD, CONFIRMADO)
VALUES('Capital Federal', TRUE);

INSERT INTO partidos
(LOCALIDAD, CONFIRMADO)
VALUES('San Martin', FALSE);

INSERT INTO partidos
(LOCALIDAD, CONFIRMADO)
VALUES('Zarate', FALSE);



  SELECT ID_PARTIDO
  INTO @Partido1
  FROM partidos
 WHERE LOCALIDAD = 'Berazategui'
 LIMIT 1;

   SELECT ID_PARTIDO
  INTO @Partido2
  FROM partidos
 WHERE LOCALIDAD = 'Capital Federal'
 LIMIT 1;

   SELECT ID_PARTIDO
  INTO @Partido3
  FROM partidos
 WHERE LOCALIDAD = 'San Martin'
 LIMIT 1;

   SELECT ID_PARTIDO
  INTO @Partido4
  FROM partidos
 WHERE LOCALIDAD = 'Zarate'
 LIMIT 1;



    SELECT ID_TIPO_INSCRIPCION_DEFAULT
  INTO @Inscripjugador
  FROM jugadores
 WHERE ID_JUGADOR = @Jugador1
 LIMIT 1;

    SELECT ID_TIPO_INSCRIPCION_DEFAULT
  INTO @Inscripamigo1
  FROM jugadores
 WHERE ID_JUGADOR = @Amigo1
 LIMIT 1;

     SELECT ID_TIPO_INSCRIPCION_DEFAULT
  INTO @Inscripamigo2
  FROM jugadores
 WHERE ID_JUGADOR = @Amigo1
 LIMIT 1;



INSERT INTO inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Jugador1, @Partido1, @Inscripjugador);

INSERT INTO inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Jugador1, @Partido2, @Inscripjugador);

INSERT INTO inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Jugador1, @Partido4, @Inscripjugador);

INSERT INTO inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Amigo1, @Partido1, @Inscripamigo1);

INSERT INTO inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Amigo1, @Partido2, @Inscripamigo1);

INSERT INTO inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Amigo1, @Partido3, @Inscripamigo1);

INSERT INTO inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Amigo2, @Partido3,  @Inscripamigo2);

INSERT INTO inscripciones
(ID_JUGADOR, ID_PARTIDO, ID_TIPO_INSCRIPCION)
VALUES(@Amigo2, @Partido1,  @Inscripamigo2);



INSERT INTO bajas
(ID_JUGADOR, ID_PARTIDO, ID_REEMPLAZO)
VALUES(@Jugador1, @Partido2,  @Amigo2);

INSERT INTO bajas
(ID_JUGADOR, ID_PARTIDO)
VALUES(@Jugador1, @Partido4);



INSERT INTO infracciones
(ID_JUGADOR, FECHA, MOTIVO)
VALUES(@Jugador1, 12/06/2014,'Pateo a un compañero');

INSERT INTO infracciones
(ID_JUGADOR, FECHA, MOTIVO)
VALUES(@Jugador1, 11/08/2014,'Falto al partido');

INSERT INTO infracciones
(ID_JUGADOR, FECHA, MOTIVO)
VALUES(@Jugador1, 04/01/2014,'Ingreso a la cancha sin remera');

INSERT INTO infracciones
(ID_JUGADOR, FECHA, MOTIVO)
VALUES(@Amigo1, 10/06/2014,'Insulto al arbitro');



INSERT INTO calificaciones
(ID_JUGADOR,ID_PARTIDO, NOTA, CRITICA)
VALUES(@Jugador1, @Partido1, 3, 'Jugo muy flojito');

INSERT INTO calificaciones
(ID_JUGADOR,ID_PARTIDO, NOTA, CRITICA)
VALUES(@Amigo1, @Partido2, 10, 'Excelentisimo');
