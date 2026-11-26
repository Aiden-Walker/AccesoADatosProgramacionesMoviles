package com.accesodatos.hibernate.libros.dao;

import com.accesodatos.hibernate.libros.dominio.Autor;

public class AutorDao extends AbstractDao<Autor> {
    public AutorDao() {
        setClazz(Autor.class);
    }
}