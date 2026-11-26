package com.accesodatos.hibernate.partidos.dao;

import com.accesodatos.hibernate.partidos.dominio.Jugador;

public class JugadorDao extends AbstractDao<Jugador> {
    public JugadorDao() {
        setClazz(Jugador.class);
    }
}