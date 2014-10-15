use nombrependiente;

CREATE TABLE Jugadores (
	Id_Jugador int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Nombre varchar (20) NOT NULL,
    Apodo varchar (20) NOT NULL,
    Handicap int NOT NULL,
    Edad int NOT NULL,
    Fecha_Nacimiento date NOT NULL,
    Id_Tipo_Inscripcion_Default int NOT NULL
) ;

CREATE TABLE Partidos (
	Id_Partido int AUTO_INCREMENT NOT NULL PRIMARY KEY,
	Localidad varchar (30) NOT NULL,
    Confirmado boolean NOT NULL
) ;

CREATE TABLE Inscripciones (
	Id_Jugador int NOT NULL,
    Id_Partido int NOT NULL,
    Id_Tipo_Inscripcion int NOT NULL
) ;

CREATE TABLE Bajas (
	Id_Jugador int NOT NULL,
    Id_Partido int NOT NULL,
    Id_Reemplazo int
) ;

CREATE TABLE Calificaciones (
	Id_Calificacion int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Id_Jugador int NOT NULL,
    Id_Partido int NOT NULL,
    Nota float NOT NULL,
    Critica varchar (150) NOT NULL
) ;

CREATE TABLE Amigos (
	Id_Jugador int NOT NULL,
    Id_Amigo int NOT NULL
) ;

CREATE TABLE Infracciones (
	Id_Infraccion int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Id_Jugador int NOT NULL,
    Fecha date NOT NULL,
    Motivo varchar (150) NOT NULL
) ;

CREATE TABLE TiposInscripcion (
	Id_Tipo_Inscripcion int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Prioridad int NOT NULL ,
    Descripcion varchar (150) NOT NULL
) ;


/****************************************************************/
/****************************************************************/
/****************************************************************/
/****************************************************************/

ALTER TABLE Inscripciones ADD
	CONSTRAINT PK_JugadorPartido PRIMARY KEY
	(	Id_Jugador,
		Id_Partido
	) ;

 ALTER TABLE Inscripciones ADD
	CONSTRAINT FK_Inscripcion_Jugador FOREIGN KEY
	(
		Id_Jugador
	) REFERENCES Jugadores (
		Id_Jugador
	), ADD
    CONSTRAINT FK_Inscripcion_Tipo_Inscripcion FOREIGN KEY
	(
		Id_Tipo_Inscripcion
	) REFERENCES TiposInscripcion (
		Id_Tipo_Inscripcion
	), ADD
	CONSTRAINT FK_Inscripcion_Partido FOREIGN KEY
	(
		Id_Partido
	) REFERENCES Partidos (
		Id_Partido
	);

ALTER TABLE Bajas ADD
	CONSTRAINT PK_Jugador_Partido PRIMARY KEY
	(	Id_Jugador,
		Id_Partido
	) ;

 ALTER TABLE Bajas ADD
	CONSTRAINT FK_Baja_Jugador FOREIGN KEY
	(
		Id_Jugador
	) REFERENCES Jugadores (
		Id_Jugador
	), ADD
	CONSTRAINT FK_Baja_Partido FOREIGN KEY
	(
		Id_Partido
	) REFERENCES Partidos (
		Id_Partido
	);

ALTER TABLE Amigos ADD
	CONSTRAINT PK_Jugador_Amigos PRIMARY KEY
	(	Id_Jugador,
		Id_Amigo
	) ;

ALTER TABLE Amigos ADD
	CONSTRAINT FK_Amigos_Jugador FOREIGN KEY
	(
		Id_Jugador
	) REFERENCES Jugadores (
		Id_Jugador
	), ADD
	CONSTRAINT FK_Amigos_Amigo FOREIGN KEY
	(
		Id_Amigo
	) REFERENCES Jugadores (
		Id_Jugador
	);

 ALTER TABLE Infracciones ADD
	CONSTRAINT FK_Jugador_Inscripcion FOREIGN KEY
	(
		Id_Jugador
	) REFERENCES Jugadores (
		Id_Jugador
	);

 ALTER TABLE Calificaciones ADD
	CONSTRAINT FK_Calificacion_Jugador FOREIGN KEY
	(
		Id_Jugador
	) REFERENCES Jugadores (
		Id_Jugador
	), ADD
	CONSTRAINT FK_Calificacion_Partido FOREIGN KEY
	(
		Id_Partido
	) REFERENCES Partidos (
		Id_Partido
	);

ALTER TABLE Jugadores ADD
	CONSTRAINT FK_TipoInscripcion_Jugador FOREIGN KEY
	(
		Id_Tipo_Inscripcion_Default
	) REFERENCES TiposInscripcion (
		Id_Tipo_Inscripcion
	)
