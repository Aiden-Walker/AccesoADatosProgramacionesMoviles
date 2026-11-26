package com.accesodatos.hibernate.partidos.dao;

import com.accesodatos.hibernate.partidos.dominio.Partido;

public class PartidoDao extends AbstractDao<Partido> {
    public PartidoDao() {
        setClazz(Partido.class);
    }
}