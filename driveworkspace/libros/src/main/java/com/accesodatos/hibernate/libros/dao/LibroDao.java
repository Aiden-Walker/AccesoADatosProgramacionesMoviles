package com.accesodatos.hibernate.libros.dao;

import com.accesodatos.hibernate.libros.dominio.Libro;

public class LibroDao extends AbstractDao<Libro> {
    public LibroDao() {
        setClazz(Libro.class);
    }
}