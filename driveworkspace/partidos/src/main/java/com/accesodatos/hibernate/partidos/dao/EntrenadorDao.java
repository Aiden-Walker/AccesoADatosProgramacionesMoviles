package com.accesodatos.hibernate.partidos.dao;

import com.accesodatos.hibernate.partidos.dominio.Entrenador;

public class EntrenadorDao extends AbstractDao<Entrenador> {
    public EntrenadorDao() {
        setClazz(Entrenador.class);
    }
}