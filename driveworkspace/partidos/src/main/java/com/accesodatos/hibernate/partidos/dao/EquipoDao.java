package com.accesodatos.hibernate.partidos.dao;

import com.accesodatos.hibernate.partidos.dominio.Equipo;

public class EquipoDao extends AbstractDao<Equipo> {
    public EquipoDao() {
        setClazz(Equipo.class);
    }
}