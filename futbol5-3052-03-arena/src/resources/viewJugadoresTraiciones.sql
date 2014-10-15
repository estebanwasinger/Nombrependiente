create view jugadores_traicioneros as
    select * from nombrependiente.jugadores where nombrependiente.infraccionesUltimoMes(Id_Jugador) >= 3;