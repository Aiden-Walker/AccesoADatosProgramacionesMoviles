package com.accesodatos.hibernate.libros.dao;

import java.util.List;

import javax.persistence.Query;

import com.accesodatos.hibernate.libros.dominio.Ejemplar;
import com.accesodatos.hibernate.libros.dominio.Prestamo;

public class PrestamoDao extends AbstractDao<Prestamo> {

    public PrestamoDao() {
        setClazz(Prestamo.class);
    }
    
    public List<Prestamo> getPrestamosNoDevueltos() {
        String qlString = " FROM " + Prestamo.class.getName() + " WHERE fechaDevolucion IS NULL";
        Query query = getEntityManager().createQuery(qlString);
        return query.getResultList();
    }
}